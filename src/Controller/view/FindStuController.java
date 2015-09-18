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

public class FindStuController {
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
	public String ssid;
    private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
	@FXML
	private void initialize(){
	}
	public void init(){
		ssid = mainApp.sSid;
		AddInformation();
	}
	private void AddInformation() {
		boolean jud = false;
		String str;
		SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
        String url="jdbc:mysql://localhost:3306/stuhealthy"; 
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","123456");
            Statement stmt = conn.createStatement(); 
            String sql = "select * from student where sid  = '"+ssid+"'";
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
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
            }
            rs.close();            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }	
    }
	public void setDialogStage(Stage dialogStage) {
		// TODO Auto-generated method stub
		
	}
}
