package com.example.guiex1;

import com.example.guiex1.controller.LoginPageController;
import com.example.guiex1.controller.UtilizatorController;
import com.example.guiex1.domain.Utilizator;
import com.example.guiex1.domain.UtilizatorValidator;
import com.example.guiex1.repository.Repository;
import com.example.guiex1.repository.dbrepo.UtilizatorDbRepository;
import com.example.guiex1.services.UtilizatorService;
import com.example.guiex1.services.config.ApplicationContext;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


import java.io.IOException;

//public class HelloApplication extends Application {
//    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
//        stage.show();
//    }
//
//    public static void main(String[] args) {
//        launch();
//    }
//}

public class HelloApplication extends Application {

    Repository<Long, Utilizator> utilizatorRepository;
    UtilizatorService service;

    private static Stage stg;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
//        String fileN = ApplicationContext.getPROPERTIES().getProperty("data.tasks.messageTask");
//        messageTaskRepository = new InFileMessageTaskRepository
//                (fileN, new MessageTaskValidator());
//        messageTaskService = new MessageTaskService(messageTaskRepository);
        //messageTaskService.getAll().forEach(System.out::println);

        System.out.println("Reading data from file");
        String username="postgres";
        String pasword="Theoriginals12";
        String url="jdbc:postgresql://localhost:5432/socialbook";
        Repository<Long, Utilizator> utilizatorRepository =
                new UtilizatorDbRepository(url,username, pasword,  new UtilizatorValidator());

        utilizatorRepository.findAll().forEach(x-> System.out.println(x));
        service =new UtilizatorService(utilizatorRepository);
        initView(primaryStage);
        primaryStage.setWidth(800);
        primaryStage.show();

    }

    private void initView(Stage primaryStage) throws IOException {

       // FXMLLoader fxmlLoader = new FXMLLoader();
        //fxmlLoader.setLocation(getClass().getResource("com/example/guiex1/views/UtilizatorView.fxml"));
        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("views/hello-view.fxml"));

        BorderPane userLayout = fxmlLoader.load();
        primaryStage.setScene(new Scene(userLayout));
        LoginPageController loginPageController = fxmlLoader.getController();
       // UtilizatorController userController = fxmlLoader.getController();
        //userController.setUtilizatorService(service);
        //loginPageController.onLoginButtonClick();

    }
    public void changeScene(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader();
        UtilizatorController userController = fxmlLoader.getController();
        userController.setUtilizatorService(service);
        Parent pane = FXMLLoader.load(getClass().getResource(fxml));
        stg.getScene().setRoot(pane);
        stg.show();
    }
}