package Controller.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTextController {
@FXML
private Button sure;
@FXML
private Button cancel;
@FXML
private TextField sid;
@FXML
private TextField tdate;
@FXML
private TextField age;
@FXML
private TextField height;
@FXML
private TextField weight;
@FXML
private TextField fvc;
@FXML
private TextField run;
@FXML
private TextField jump;

private String ssid = "";
private String stdate= "";
private String sage = "";
private String sheight = "";
private String sweight= "";
private String sfvc= "";
private String srun= "";
private String sjump= "";

private Stage dialogStage;
public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
}
@FXML
private void SureButton() throws ParseException {
	 ssid = sid.getText();
	 stdate = tdate.getText();
	 sage = age.getText();
	 sheight = height.getText();
	 sweight = weight.getText();
	 sfvc = fvc.getText();
	 srun = run.getText();
	 sjump = jump.getText();
	 String url="jdbc:mysql://localhost:3306/stuhealthy";
     Connection conn;
     try {
         conn = DriverManager.getConnection(url,"root","123456");
         Statement stmt = conn.createStatement(); 
         String sql = "";        
System.out.println(sql);
         stmt.executeUpdate(sql);
         stmt.close();
         conn.close();
     } catch (SQLException e){
         e.printStackTrace();
     }
    //mainApp.sAdd();
}
@FXML
private void cancelButton(){
    dialogStage.close();
}
}
