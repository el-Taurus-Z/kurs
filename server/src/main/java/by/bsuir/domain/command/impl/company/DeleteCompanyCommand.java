package by.bsuir.domain.command.impl.company;

import by.bsuir.domain.command.Command;
import by.bsuir.domain.message.Message;
import by.bsuir.domain.service.CompanyService;
import by.bsuir.domain.service.exception.ServiceException;
import by.bsuir.domain.service.factory.ServiceFactory;

public class DeleteCompanyCommand implements Command {

    private CompanyService companyService = ServiceFactory.getInstance().getCompanyService();

    @Override
    public Message execute(Message request) {
        String companyId = (String) request.getByKey("companyId");
        Message response = new Message();
        try {
            companyService.deleteCompany(companyId);
        } catch (ServiceException e) {
            e.printStackTrace();
            response.add("ex", e.getMessage());
        }
        return response;
    }
}
