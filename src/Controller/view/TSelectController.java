package Controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class TSelectController {
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
	
    private Stage dialogStage;
    @FXML
    private void initialize() {
    	//AddInformation();
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	private void AddInformation() {
		// TODO Auto-generated method stub
		try{
            //调用Class.forName()方法加载驱动程序
            Class.forName("com.mysql.jdbc.Driver");
System.out.println("成功加载MySQL驱动！");
        }catch(ClassNotFoundException e1){
System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/stuhealthy";    //JDBC的URL    
        //调用DriverManager对象的getConnection()方法，获得一个Connection对象
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","123456");
            //创建一个Statement对象
            Statement stmt = conn.createStatement(); //创建Statement对象
System.out.print("成功连接到数据库！");
            String sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
            	//if(ssid.equals(rs.getString(1))&&spw.equals(rs.getString(2)))
            }
            rs.close();            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
	}

}
