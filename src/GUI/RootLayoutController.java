package GUI;

import Hospital.MainApp;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class RootLayoutController {
	private MainApp mainApp;
	
	@FXML
	private MenuItem logOutItem;
	
	@FXML
	private void logOut() {
		mainApp.showLoginView();
		
	}
	public void setMainApp(MainApp mainapp) {
		this.mainApp = mainapp;
	}

}
