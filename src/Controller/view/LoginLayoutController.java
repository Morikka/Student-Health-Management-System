package Controller.view;

import Controller.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginLayoutController {
	@FXML
	private Label text;
	@FXML
	private Button student;
	@FXML
	private Button teacher;
	private MainApp mainApp;
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
	@FXML
	private void OpenSLogin() {
		mainApp.SLogin();
	}
	@FXML
	private void OpenTLogin() {
		mainApp.TLogin();
	}
}
