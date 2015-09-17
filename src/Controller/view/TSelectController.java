package Controller.view;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import Controller.model.Student;

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
    @FXML
    private TableView<Student> personTable;
	@FXML
	private TableColumn<Student,String> firstColumn;
    
	private Stage dialogStage;
    @FXML
    private void initialize() {
    	AddInformation();
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
            	System.out.println(rs.getString(1));
            	Student stu = new Student();
            	stu.setSid(rs.getString(1));
            	stu.setName(rs.getString(3));
            	stu.setSex(rs.getBoolean(4));
//            	Date input = rs.getDate(5);
//            	LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            	stu.setBirthday(date);
//            	input = rs.getDate(6);
//            	date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//            	stu.setStame(date);
            	stu.setPhone(rs.getString(7));
            	stu.setMajor(rs.getString(8));
            	
            	firstColumn.getCellData(stu);
            	
            	//firstColumn.setCellValueFactory(cellData -> cellData.getValue().SidProperty());
System.out.println(stu.getSid());
            }
            rs.close();            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
		
	}

}
