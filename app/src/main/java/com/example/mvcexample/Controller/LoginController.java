package com.example.mvcexample.Controller;

import com.example.mvcexample.Model.User;
import com.example.mvcexample.View.LoginViewInterFace;

public class LoginController implements LoginControllerInterFace{

    LoginViewInterFace loginViewInterFace;

    public LoginController(LoginViewInterFace loginViewInterFace) {
        this.loginViewInterFace = loginViewInterFace;
    }

    @Override
    public void OnLogin(String email, String Password) {
        User user = new User(email,Password);
        int loginCode = user.isValid();
        if(loginCode == 0)
        {
            loginViewInterFace.OnLoginError("Please enter Email");
        }else  if (loginCode == 1){
            loginViewInterFace.OnLoginError("Please enter A valid Email");
        } else  if (loginCode == 2)
        {
            loginViewInterFace.OnLoginError("Please enter Password");
        }else  if(loginCode == 3){
            loginViewInterFace.OnLoginError("Please enter Password greater the 6 char");
        }
        else {
            loginViewInterFace.OnLoginSuccess("login Successful");
        }
    }
}
