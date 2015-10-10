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

public class SLoginController {
	@FXML
	private Label text1;
	@FXML
	private Label text2;
	@FXML
	private Label text3;
	@FXML
	private TextField sid;
	@FXML
	private PasswordField password;
	@FXML
	private Button sure;
	@FXML
	private Button cancel;
	
//    private boolean okClicked = false;
    private String ssid;
    private String spw;
    private Stage dialogStage;
	private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
	@FXML
    private void initialize() {
//		System.out.println(this.mainApp.sSid);
        // Initialize the person table with the two columns.
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
//    public boolean isOkClicked() {
//        return okClicked;
//    }
    @FXML
    private void cancelButton() {
        dialogStage.close();
    }
	@FXML
    public void sureButton(){
//    	if(isInputValid()){
    	ssid = sid.getText();
    	spw = password.getText();
    	if(hasssid()){
    		System.out.println("YES");
   System.out.println(ssid); 		
        	mainApp.SSelect(ssid);
    	}
    	else{
    		Alert alert = new Alert(AlertType.INFORMATION);
    		alert.setTitle("Information Dialog");
    		alert.setHeaderText(null);
    		alert.setContentText("���������Ƿ���ȷ");
    		alert.showAndWait();
    	}
	    //okClicked = true;
    	//mainApp.TLogin();
    	//dialogStage.SSelect();
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
