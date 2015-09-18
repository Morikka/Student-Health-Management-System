package Controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import Controller.MainApp;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TSelectController {
	private Stage dialogStage;
	private MainApp mainApp;
	private String tsid;
	@FXML
	private ListView<String> list;
	@FXML
	private Button find;
	@FXML
	private Button add;
	@FXML
	private Button modify;
	@FXML
	private Button delete;
	@FXML
	private AnchorPane upstud;
    @FXML
    private void initialize() {
    }
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
	public void setMainApp(MainApp mainApp) {
		this.mainApp= mainApp;	
	}
	public void init() {
		list = new ListView<String>();
		tsid = mainApp.tSid;
		findlist();
		upstud.getChildren().add(list);
	}
	@FXML
	private void findButton() {
		
	}
	@FXML
	private void modifyButton(){
		
	}
    @FXML
    private void addButton() {
        mainApp.sAdd();
    }
    @FXML
    private void deleteButton(){
    	
    }
	private void findlist(){
		ObservableList<String> items =FXCollections.observableArrayList ();

		 String url="jdbc:mysql://localhost:3306/stuhealthy";
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection(url,"root","123456");
	            Statement stmt = conn.createStatement();
	            String sql = "SELECT S.sid,T.tid "
//	            		+ "FROM student,major_information";
	            		+ "FROM student S,major_information M,faculty_information F,teacher T "
	            		+ "WHERE S.major = M.mid and M.belong = F.fid and F.tid = T.tid";
//	            String sql = "select sid from student";
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	            	if(tsid.equals(rs.getString(2))){
	            		items.add(rs.getString(1));    	
System.out.println(rs.getString(1)+" "+rs.getString(2));	            	
	            }
	         }      
	            rs.close();            
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	    list.setItems(items);
	}
}
