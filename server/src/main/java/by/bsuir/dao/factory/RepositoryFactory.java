package by.bsuir.dao.factory;

import by.bsuir.dao.SegmentRepository;
import by.bsuir.dao.CompanyRepository;
import by.bsuir.dao.UserRepository;
import by.bsuir.dao.impl.segment.SegmentSqlRepository;
import by.bsuir.dao.impl.company.CompanySqlRepository;
import by.bsuir.dao.impl.user.UserSqlRepository;

public final class RepositoryFactory {
    private static final RepositoryFactory instance = new RepositoryFactory();

    public static RepositoryFactory getInstance() {
        return instance;
    }

    private RepositoryFactory() {

    }


    private UserRepository userRepository = new UserSqlRepository();
    private SegmentRepository segmentRepository = new SegmentSqlRepository();

    private CompanyRepository companyRepository = new CompanySqlRepository();

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public SegmentRepository getSegmentRepository() {
        return segmentRepository;
    }

    public CompanyRepository getCompanyRepository() {
        return companyRepository;
    }
}
