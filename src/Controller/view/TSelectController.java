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
