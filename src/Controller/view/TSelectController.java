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
            //����Class.forName()����������������
            Class.forName("com.mysql.jdbc.Driver");
System.out.println("�ɹ�����MySQL������");
        }catch(ClassNotFoundException e1){
System.out.println("�Ҳ���MySQL����!");
            e1.printStackTrace();
        }
        String url="jdbc:mysql://localhost:3306/stuhealthy";    //JDBC��URL    
        //����DriverManager�����getConnection()���������һ��Connection����
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,"root","123456");
            //����һ��Statement����
            Statement stmt = conn.createStatement(); //����Statement����
System.out.print("�ɹ����ӵ����ݿ⣡");
            String sql = "select * from student";
            ResultSet rs = stmt.executeQuery(sql);//�������ݶ���
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
