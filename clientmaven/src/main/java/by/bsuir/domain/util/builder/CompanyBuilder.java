package by.bsuir.domain.util.builder;

import by.bsuir.domain.entity.Company;
import by.bsuir.domain.entity.ProductMarkStatus;
import by.bsuir.domain.entity.Segment;

public interface CompanyBuilder {

    CompanyBuilder withSegment(Segment segment);

    CompanyBuilder withName(String name);

    CompanyBuilder withCountry(String country);

    CompanyBuilder withSuccor(double succor);

    CompanyBuilder withIncomeTax(double incomeTax);

    CompanyBuilder withFinancialIncome(double financialIncome);

    CompanyBuilder withDepreciation(double depreciation);

    CompanyBuilder withEbitda(double ebitda);

    CompanyBuilder withProductStatus(ProductMarkStatus status);

    Company build();
}
