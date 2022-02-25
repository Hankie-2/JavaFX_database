package com.example.javafx_database.contoller;

import com.example.javafx_database.helper.DBConnection;
import com.example.javafx_database.model.Department;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class DepatmentController implements Initializable {

    @FXML
    private TextField Dname;

    @FXML
    private TextField Mgr_ssn;

    @FXML
    private DatePicker Start_date;

    @FXML
    private TableColumn<Department, String> dNameColumn;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField depName;

    @FXML
    private TextField depNewName;

    @FXML
    private TableView<Department> departmentTable;

    @FXML
    private TextField fieldToDelete;

    @FXML
    private TableColumn<Department, String> mgrSsnColumn;

    @FXML
    private TableColumn<Department, Date> startDateColumn;

    @FXML
    private Button submitButton;

    @FXML
    private Button updateButton;

    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();

    @FXML
    void deleteDepartment(ActionEvent event) {

        try {
            PreparedStatement statement =connection.prepareStatement("DELETE FROM department WHERE Dname LIKE '" + fieldToDelete.getText() + "'");
            statement.execute();
            initializeTableValues();
            System.out.println("Успешно!");
        }catch (SQLException e){
            System.out.println("Wrong!");
        }

    }

    @FXML
    void insertDepartment(ActionEvent event) {
        int a = 5 + (int) ( Math.random() * 50 );
        try {
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO department(Dname,Dnumber,Mgr_ssn,Mgr_start_date) " +
                    "VALUES ('"
                    + Dname.getText() + "','"
                    + a + "','"
                    + Mgr_ssn.getText() + "','"
                    +Start_date.getValue()+"')";
            System.out.println(sql);
            statement.executeUpdate(sql);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    @FXML
    void updateName(ActionEvent event) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE department" +
                    " SET Dname = '" + depNewName.getText() + "' " +
                    " WHERE Dname = '" + depName.getText() + "'");
            statement.executeUpdate();
            initializeTableValues();
            System.out.println("Success!");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    public void initializeTableValues(){
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM department";
            ResultSet resultSet = statement.executeQuery(sql);
            ObservableList<Department> departmentList = FXCollections.observableArrayList();

            if(resultSet.next()){
                while (resultSet.next()){
                    Department department = new Department(
                            resultSet.getString("Dname"),
                            resultSet.getString("Mgr_ssn"),
                            resultSet.getDate("Mgr_start_date")
                    );
                    departmentList.add(department);
                }
                departmentTable.setItems(departmentList);
            }else{
                System.out.println("Do nata!");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dNameColumn.setCellValueFactory(cellData -> cellData.getValue().dnameProperty());
        mgrSsnColumn.setCellValueFactory(cellData->cellData.getValue().mgr_ssnProperty());
        startDateColumn.setCellValueFactory(cellData->cellData.getValue().start_dateProperty());

        initializeTableValues();
    }
}
