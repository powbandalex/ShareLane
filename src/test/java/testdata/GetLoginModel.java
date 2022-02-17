package testdata;

import models.LoginModel;
import sun.rmi.runtime.Log;

public class GetLoginModel {

    public static LoginModel getLoginWithAllValues() {
        LoginModel login = new LoginModel.Builder()
                .setEmail("super@rmail.com")
                .setPassword("1111")
                .build();
        return login;
    }
}
