package testdata;

import models.SalesForceAccountModel;
import utilities.GenerateFakeMessage;

public class GetNewAccountModel {

    public static SalesForceAccountModel getAccountWithAllFields() {
        return SalesForceAccountModel
                .builder()
                .accountName(GenerateFakeMessage.getAccountName())
                .phone(GenerateFakeMessage.getPhone())
                .type("Analyst")
                .build();
    }
}
