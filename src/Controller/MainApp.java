package Controller;

import java.io.IOException;
import java.nio.charset.Charset;

import Controller.view.LoginLayoutController;
import Controller.view.SLoginController;
import Controller.view.SSelectController;
import Controller.view.TLoginController;
import Controller.view.TSelectController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private AnchorPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Login");
		initRootLayout();
	}
	 /**
     * Initializes the root layout.
     */
	private void initRootLayout() {
		// TODO Auto-generated method stub
		 try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/LoginLayout.fxml"));
	            rootLayout = (AnchorPane) loader.load();
	            // Show the scene containing the root layout.
	             Scene scene = new Scene(rootLayout);
	             primaryStage.setScene(scene);
	             primaryStage.show();
	             LoginLayoutController controller = loader.getController();
	             controller.setMainApp(this);
	             
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}

	public static void main(String[] args) {
		launch(args);
	}
	public void SLogin() {
		// TODO Auto-generated method stub
		 try {
	            // Load student login from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            loader.setLocation(MainApp.class.getResource("view/SLogin.fxml"));
	            
	            AnchorPane sLayout = (AnchorPane) loader.load();
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Student Login");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(sLayout);
	            dialogStage.setScene(scene);

				// Set the person into the controller.
				SLoginController controller = loader.getController();
				controller.setDialogStage(dialogStage);  
	            controller.setMainApp(this);
	            dialogStage.showAndWait();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
	}
	public void TLogin() {
		 try {
	            // Load student login from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            
	            loader.setLocation(MainApp.class.getResource("view/TLogin.fxml"));
	            
	            AnchorPane sLayout = (AnchorPane) loader.load();
	            Stage dialogStage = new Stage();
	            dialogStage.setTitle("Teacher Login");
	            dialogStage.initModality(Modality.WINDOW_MODAL);
	            dialogStage.initOwner(primaryStage);
	            Scene scene = new Scene(sLayout);
	            dialogStage.setScene(scene);

				// Set the person into the controller.
				TLoginController controller = loader.getController();
				controller.setDialogStage(dialogStage);
	            controller.setMainApp(this);
	            
	            dialogStage.showAndWait();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }	
	}
	public void SSelect(String ssid){
		try {
		 	FXMLLoader loader = new FXMLLoader();
		 	//loader.setCharset(ssid);
            loader.setLocation(MainApp.class.getResource("view/SSelect.fxml"));     
            
            AnchorPane sLayout = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Student Selection");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(sLayout);
            dialogStage.setScene(scene);

            SSelectController controller = loader.getController();
			controller.setSid(ssid);
			controller.setDialogStage(dialogStage);
	        dialogStage.showAndWait();
//	        controller.getSid();
//			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	public void TSelect() {
		// TODO Auto-generated method stub
		try {
		 	FXMLLoader loader = new FXMLLoader();
		 	//loader.setCharset(ssid);
            loader.setLocation(MainApp.class.getResource("view/TSelect.fxml"));     
            
            AnchorPane sLayout = (AnchorPane) loader.load();
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Student Selection");
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(primaryStage);
            Scene scene = new Scene(sLayout);
            dialogStage.setScene(scene);

            TSelectController controller = loader.getController();
			controller.setDialogStage(dialogStage);
	        dialogStage.showAndWait();
//	        controller.getSid();
//			
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
