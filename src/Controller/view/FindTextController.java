package Controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FindTextController {
@FXML
private Label sid;
@FXML
private Label tdate;
@FXML
private Label age;
@FXML
private Label height;
@FXML
private Label weight;
@FXML
private Label fvc;
@FXML
private Label run;
@FXML
private Label jump;
private String sDate;
private String ssid[];
private MainApp mainApp;
public void setMainApp(MainApp mainApp) {
    this.mainApp = mainApp;
}
@FXML
private void initialize(){
}
public void init(){
	sDate = mainApp.sDate;
System.out.println(sDate);
	ssid = sDate.split(" ");
System.out.println(ssid[0]+" "+ssid[1]);
AddInformation();
}
public void setDialogStage(Stage dialogStage) {
	// TODO Auto-generated method stub
	
}
private void AddInformation(){
	String str,str1;
	SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
    String url="jdbc:mysql://localhost:3306/stuhealthy"; 
    Connection conn;
    try {
        conn = DriverManager.getConnection(url,"root","123456");
        Statement stmt = conn.createStatement(); 
        String sql = "select * from test_information "
        + "where sid  = '"+ssid[0]+"'";
        ResultSet rs = stmt.executeQuery(sql);//创建数据对象
        while (rs.next()){
        	str = sdf.format(rs.getDate(2));
        	if(str.equals(ssid[1])){
        		sid.setText(ssid[0]);
        		tdate.setText(ssid[1]);
        		str1 = Integer.toString(rs.getInt(3));
        		age.setText(str1);
        		str1 = Double.toString(rs.getDouble(4));        		
        		height.setText(str1);
        		str1 = Double.toString(rs.getDouble(5));
        		weight.setText(str1);
        		str1 = Integer.toString(rs.getInt(6)); 
        		fvc.setText(str1);
        		str1 = Double.toString(rs.getDouble(7));        		
        		run.setText(str1);
        		str1 = Double.toString(rs.getDouble(8));
        		jump.setText(str1);
        	} 		
        }
        rs.close();            
        stmt.close();
        conn.close();
    } catch (SQLException e){
        e.printStackTrace();
    }	
}
}
