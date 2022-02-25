package com.example.javafx_database.contoller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.zip.InflaterInputStream;

public class MainMenuController implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button departmentButton;

    @FXML
    private Button employeeButton;

    public void employeeButtonOnAction(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/com/example/javafx_database/employee-view.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage window = (Stage) departmentButton.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }

    public void departmentButtonOnAction(ActionEvent event) throws IOException {
        URL url = new File("src/main/resources/com/example/javafx_database/department-view.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage window = (Stage) departmentButton.getScene().getWindow();
        window.setScene(new Scene(root,600,400));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
