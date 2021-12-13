package by.bsuir.domain.service.impl;

import by.bsuir.dao.CompanyRepository;
import by.bsuir.dao.exception.DAOException;
import by.bsuir.dao.factory.RepositoryFactory;
import by.bsuir.domain.entity.Company;
import by.bsuir.domain.service.CompanyService;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository = RepositoryFactory.getInstance().getCompanyRepository();

    @Override
    public void addNewCompany(Company company) throws ServiceException {
        try {
            companyRepository.add(company);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void updateCompany(Company company) throws ServiceException {
        try {
            companyRepository.update(company);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public void deleteCompany(String companyId) throws ServiceException {
        try {
            companyRepository.removeById(companyId);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getAllCompanies() throws ServiceException {
        try {
            return companyRepository.getAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }


    @Override
    public List<Company> getAllMarkedCompanies() throws ServiceException {
        try {
            return companyRepository.getAllMarkedProducts();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public List<Company> getAllNonMarkedCompanies() throws ServiceException {
        try {
            return companyRepository.getAllNonMarkedProducts();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage());
        }
    }
}
