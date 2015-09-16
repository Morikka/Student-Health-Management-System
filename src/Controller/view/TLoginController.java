package Controller.view;

import java.sql.*;

import Controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TLoginController {
	@FXML
	private Label text1;
	@FXML
	private Label text2;
	@FXML
	private Label text3;
	@FXML
	private TextField tid;
	@FXML
	private PasswordField password;
	@FXML
	private Button sure;
	@FXML
	private Button cancel;
	
    private String ssid;
    private String spw;
    private Stage dialogStage;
	private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
	@FXML
    private void initialize() {
        // Initialize the person table with the two columns.

    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    @FXML
    private void cancelButton() {
        dialogStage.close();
    }
	@FXML
    public void sureButton(){
//    	if(isInputValid()){
    	ssid = tid.getText();
    	spw = password.getText();
    	if(hasssid()){
System.out.println("YES");
	mainApp.TSelect();
    	}
    	else{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("请输入正确的用户名或密码!");
    		alert.showAndWait();
    	}
    	//okClicked = true;
    	dialogStage.close();
//    	}
    }
/*	private boolean isInputValid(){
    	String errorMessage = "";
    	if(sid.getText()==null||sid.getText().length()==0)
    		errorMessage += "sid is not null";
    	if(password.getText()==null||password.getText().length()==0)
    		errorMessage += "password is not null";    	
    	if(errorMessage.length()==0){
    		return true;
    	}else{
    		return false;
    	}
    }*/
	private boolean hasssid() {
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
            String sql = "select * from teacher";
            ResultSet rs = stmt.executeQuery(sql);//创建数据对象
            while (rs.next()){
            	if(ssid.equals(rs.getString(1))&&spw.equals(rs.getString(2)))
            		return true;
            }
            rs.close();            
            stmt.close();
            conn.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
		return false;
	}
}
