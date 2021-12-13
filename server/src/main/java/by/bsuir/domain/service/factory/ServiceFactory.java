package by.bsuir.domain.service.factory;

import by.bsuir.domain.service.SegmentService;
import by.bsuir.domain.service.CompanyService;
import by.bsuir.domain.service.UserService;
import by.bsuir.domain.service.impl.SegmentServiceImpl;
import by.bsuir.domain.service.impl.CompanyServiceImpl;
import by.bsuir.domain.service.impl.UserServiceImpl;

public final class ServiceFactory {

    private static ServiceFactory instance = new ServiceFactory();

    public static ServiceFactory getInstance() {
        return instance;
    }

    private ServiceFactory() {
    }


    private UserService userService = new UserServiceImpl();
    private SegmentService segmentService = new SegmentServiceImpl();
    private CompanyService companyService = new CompanyServiceImpl();

    public UserService getUserService() {
        return userService;
    }

    public SegmentService getSegmentService() {
        return segmentService;
    }

    public CompanyService getCompanyService() {
        return companyService;
    }
}
