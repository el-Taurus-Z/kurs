package by.bsuir.dao.impl.company;

import by.bsuir.dao.CompanyRepository;
import by.bsuir.dao.core.InitializerRepository;
import by.bsuir.dao.core.exception.JdbcTemplateException;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.dao.mapper.CompanyRowMapper;
import by.bsuir.domain.entity.Company;

import java.util.List;

import static by.bsuir.dao.impl.company.CompanySqlUtil.*;

public class CompanySqlRepository extends InitializerRepository implements CompanyRepository {


    @Override
    public Company getEntityById(String id) throws DAOException {
        try {
            return jdbcTemplate.queryForObject(GET_COMPANY_BY_ID, new CompanyRowMapper(), id);
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean removeById(String id) throws DAOException {
        try {
            jdbcTemplate.update(REMOVE_COMPANY_BY_ID, id);
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean add(Company company) throws DAOException {
        try {
            jdbcTemplate.update(ADD_NEW_COMPANY,
                    company.getSegment().getId(),
                    company.getStatus().getId(),
                    company.getName(),
                    company.getCountry(),
                    company.getSuccor(),
                    company.getIncomeTax(),
                    company.getFinancialIncome(),
                    company.getDepreciation(),
                    company.getEbitda());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public boolean update(Company company) throws DAOException {
        try {
            jdbcTemplate.update(UPDATE_COMPANY,
                    company.getSegment().getId(),
                    company.getStatus().getId(),
                    company.getName(),
                    company.getCountry(),
                    company.getSuccor(),
                    company.getIncomeTax(),
                    company.getFinancialIncome(),
                    company.getDepreciation(),
                    company.getEbitda(),
                    company.getId());
            return true;
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Company> getAll() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_COMPANIES, new CompanyRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Company> getAllMarkedProducts() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_MARKED_COMPANIES, new CompanyRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Company> getAllNonMarkedProducts() throws DAOException {
        try {
            return jdbcTemplate.query(GET_ALL_NON_MARKED_COMPANIES, new CompanyRowMapper());
        } catch (JdbcTemplateException e) {
            throw new DAOException(e);
        }
    }
}
