package Controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddStuController {
@FXML
private Button sure;
@FXML
private Button cancel;
@FXML
private TextField sid;
@FXML
private TextField sname;
@FXML
private TextField sex;
@FXML
private TextField birthday;
@FXML
private TextField sdate;
@FXML
private TextField phone;
@FXML
private TextField major;
private String ssid = "";
private String ssname = "";
private String ssex = "";
private String sbirthday = "";
private String ssdate = "";
private String sphone = "";
private String smajor = "";
private Stage dialogStage;
public void setDialogStage(Stage dialogStage) {
    this.dialogStage = dialogStage;
}
@FXML
private void SureButton() throws ParseException {
	ssid = sid.getText();
	ssname = sname.getText();
	ssex = sex.getText();
	sbirthday = birthday.getText();
	ssdate = sdate.getText();
	sphone = phone.getText();
	smajor = major.getText();
	 String url="jdbc:mysql://localhost:3306/stuhealthy";
     Connection conn;
     try {
         conn = DriverManager.getConnection(url,"root","123456");
         Statement stmt = conn.createStatement();
//         java.text.SimpleDateFormat timeformat = new java.text.SimpleDateFormat( "yyyy-MM-dd"); 
//         java.util.Date Sbirth = timeformat.parse(sbirthday); 
//         java.util.Date Sdate = timeformat.parse(ssdate); 
         String sql = "insert into student (sid,password,sname,sex,birthday,stime,phone,major) "
        		 +"values ('"+ssid+"','"+ssid+"','"+ssname+"',"+ssex+","+sbirthday+","+ssdate+",'"+sphone+"','"+smajor+"')";         
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
