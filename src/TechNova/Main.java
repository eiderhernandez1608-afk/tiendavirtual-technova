/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TechNova;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * 
 * @author Eider
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) {

        LoginView.mostrar(stage);

    }

    public static void main(String[] args) {
        launch(args);
    }
}