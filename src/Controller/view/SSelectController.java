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

public class SSelectController {
	@FXML
	private Label sid;
	@FXML
	private Label sname;
	@FXML
	private Label sex;
	@FXML
	private Label birthday;
	@FXML
	private Label stime;
	@FXML
	private Label phone;
	@FXML
	private Label major;	
	@FXML
	private Label text;
    private String ssid;
    private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
    @FXML
    private void initialize() {
//    	ssid = mainApp.sSid;
//System.out.println(ssid);
    }
    public void init(){
	ssid = mainApp.sSid;
System.out.println(ssid);
	try{
        Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e1){
        e1.printStackTrace();
    }
	AddInformation();
    AddText();
    }
    public void setDialogStage(Stage dialogStage) {
    }


	private void AddInformation() {
		// TODO Auto-generated method stub
		boolean jud = false;
		String str;
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 

        String url="jdbc:mysql://localhost:3306/stuhealthy";
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","123456");
            Statement stmt = conn.createStatement(); 
            String sql = "select * from student where sid  = '"+ssid+"'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()){
            	//if(ssid.equals(rs.getString(1))){
            		jud = true;
            		sid.setText(ssid);
            		sname.setText(rs.getString(3));
            		if(rs.getBoolean(4))
            			sex.setText("men");
            		else
            			sex.setText("women");
            		str = sdf.format(rs.getDate(5));
            		birthday.setText(str);
            		str = sdf.format(rs.getDate(6));
            		stime.setText(str);
            		phone.setText(rs.getString(7));
            		major.setText(rs.getString(8));            		
            	//}
            }
            rs.close();            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }	
	}
	private void AddText(){
		String str="",str1;
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
		 String url="jdbc:mysql://localhost:3306/stuhealthy";
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection(url,"root","123456");
	            Statement stmt = conn.createStatement();
	            String sql = "select * from test_information where sid  = '"+ssid+"'";
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	            	str1 = sdf.format(rs.getDate(2));
	            	str+="体侧时间："+str1+"\n年龄（岁）: "+rs.getInt(3)+"\n身高（厘米）: "+rs.getInt(4)+"\n体重（公斤）："+rs.getInt(5)
	            	+"\n肺活量（毫升）:"+rs.getInt(6)+ "\n五十米跑（毫秒）："+rs.getDouble(7)+"\n跳远（米）："+rs.getDouble(8)+"\n\n";
	            }
	            rs.close();            
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }	
	        text.setText(str);
	}
}
