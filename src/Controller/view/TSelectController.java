package Controller.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
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
	private String tdate[];
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
	private ListView<String> tlist;
	@FXML
	private Button tfind;
	@FXML
	private Button tadd;
	@FXML
	private Button tmodify;
	@FXML
	private Button tdelete;
	@FXML
	private AnchorPane uptest;
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
		tlist = new ListView<String>();
		tsid = mainApp.tSid;
		findlist();
		tfindlist();
		upstud.getChildren().add(list);
		uptest.getChildren().add(tlist);
	}
	@FXML
	private void findButton() {
    	String str = list.getSelectionModel().getSelectedItem();
        mainApp.sFind(str);
	}
	@FXML
	private void modifyButton(){
		deleteButton();
		addButton();
	}
    @FXML
    private void addButton() {
        mainApp.sAdd();
        findlist();
    }
    @FXML
    private void deleteButton(){
    	String str = list.getSelectionModel().getSelectedItem();
    	//System.out.println(str);
		 String url="jdbc:mysql://localhost:3306/stuhealthy";
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection(url,"root","123456");
	            Statement stmt = conn.createStatement();
	            String sql = "delete from student where sid = '"+ str+"'";
	            stmt.executeUpdate(sql);
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        findlist();
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
	@FXML
	private void tFindButton(){
    	String str = tlist.getSelectionModel().getSelectedItem();
        mainApp.tFind(str);
	}
	@FXML
	private void tAddButton(){
		mainApp.sAdd();
        findlist();
	}
	@FXML
	private void tModifyButton() throws ParseException{
		tDeleteButton();
		tAddButton();
	}
	@FXML
	private void tDeleteButton() throws ParseException{
		String str = tlist.getSelectionModel().getSelectedItem();
		String sstr;
		tdate = str.split(" ");
		//java.text.SimpleDateFormat timeformat = new java.text.SimpleDateFormat("yyyy-MM-dd"); 
		//java.util.Date Sbirth = timeformat.parse(tdate[1]); 
    	//System.out.println(str);
		 String url="jdbc:mysql://localhost:3306/stuhealthy";
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection(url,"root","123456");
	            Statement stmt = conn.createStatement();
	            sstr=tdate[1].substring(0,4)+tdate[1].substring(5,7)+tdate[1].substring(8,10);
	            String sql = "delete from test_information "
	            +"where sid = '"+ tdate[0] +"'";
System.out.println(sql);
	            stmt.executeUpdate(sql);
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	        tfindlist();
	}
	private void tfindlist(){
		ObservableList<String> items =FXCollections.observableArrayList ();
		 String str;
		 SimpleDateFormat sdf =   new SimpleDateFormat("yyyy-MM-dd"); 
		 String url="jdbc:mysql://localhost:3306/stuhealthy";
	        Connection conn;
	        try {
	            conn = DriverManager.getConnection(url,"root","123456");
	            Statement stmt = conn.createStatement();
	            String sql = "SELECT S.sid,Te.tdate "
	            		+ "FROM student S,major_information M,faculty_information F,teacher T,test_information Te "
	            		+ "WHERE S.major = M.mid and M.belong = F.fid and F.tid = T.tid and S.sid = Te.sid";
	            ResultSet rs = stmt.executeQuery(sql);
	            while(rs.next()){
	            	str = sdf.format(rs.getDate(2));
            		items.add(rs.getString(1)+" "+str);  
//	            	if(tsid.equals(rs.getString(2))){
//	            		items.add(rs.getString(1));    	
//System.out.println(rs.getString(1)+" "+rs.getString(2));	            	
//	            }
	         }      
	            rs.close();
	            stmt.close();
	            conn.close();
	        } catch (SQLException e){
	            e.printStackTrace();
	        }
	    tlist.setItems(items);
	}
}
