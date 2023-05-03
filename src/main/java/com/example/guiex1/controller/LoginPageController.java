package com.example.guiex1.controller;

import com.example.guiex1.HelloApplication;
import com.example.guiex1.Main;
import com.example.guiex1.domain.Utilizator;
import com.example.guiex1.services.UtilizatorService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginPageController {
    UtilizatorService service=UtilizatorService.getInstance();//de facut service,repo singleton
    @FXML
    private Button Login;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    @FXML
    private Button CreateAccount;

    @FXML
    public void onLoginButtonClick() throws IOException {
        try{
        HelloApplication m=new HelloApplication();
        if (username.getText().isEmpty() && password.getText().isEmpty()) {
            wrongLogin.setText("Please enter your data.");
        } else {
            for (Utilizator u : service.getAll()) {
                if (username.getText().toString().equals(u.getUsername()) && password.getText().toString().equals(u.getPassword())) {

                    //m.changeScene("UtilizatorView.fxml");
                    FXMLLoader fxmlLoader= new FXMLLoader(HelloApplication.class.getResource("views/UtilizatorView.fxml"));
                    Scene scene = new Scene(fxmlLoader.load());
                    Stage stage = new Stage();
                    stage.setScene(scene);
                    stage.show();
                    wrongLogin.setText("Succes!");
                }
            }
        }
        wrongLogin.setText("Wrong user ! Enter corect data or create account.");
    }

        catch(Exception e){
            System.out.println(e);
        }
}}
