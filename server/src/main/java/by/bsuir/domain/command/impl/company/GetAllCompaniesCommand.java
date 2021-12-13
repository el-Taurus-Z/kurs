package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.entity.Company;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.CompanyService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

import java.util.List;

public class GetAllCompaniesCommand implements Command {

    private CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Message execute(Message request) {
        Message response = new Message();
        try {
            List<Company> companies = companyService.getAllCompanies();
            response.add("companies", companies);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }

        return response;
    }
}
