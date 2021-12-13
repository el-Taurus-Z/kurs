package by.bsuir.domain.service;

import by.bsuir.domain.entity.Company;
import by.bsuir.domain.service.exception.ServiceException;

import java.util.List;

public interface CompanyService {

    void addNewCompany(Company company) throws ServiceException;

    void updateCompany(Company company) throws ServiceException;

    void deleteCompany(String companyId) throws ServiceException;

    List<Company> getAllCompanies() throws ServiceException;


    List<Company> getAllMarkedCompanies() throws ServiceException;

    List<Company> getAllNonMarkedCompanies() throws ServiceException;
}
