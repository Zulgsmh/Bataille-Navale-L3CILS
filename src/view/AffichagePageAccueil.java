package view;
import java.awt.event.ActionListener;
import java.io.IOException;
import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





public class AffichagePageAccueil extends Application{
	
	private Stage primaryStage ;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage ;
		try {
			FXMLLoader acc = new FXMLLoader() ;
			acc.setLocation(AffichagePageAccueil.class.getClassLoader().getResource("view/PageAccueil.fxml"));
			AnchorPane cnx = (AnchorPane)acc.load();
			Scene scene = new Scene(cnx,700,500);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			this.primaryStage.setTitle("Bonjour");
			this.primaryStage.setScene(scene);
			this.primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		System.out.println("java.runtime.version: " + System.getProperty("java.runtime.version", "(undefined)"));
		System.out.println("javafx.version: " + System.getProperty("javafx.version", "(undefined)"));
		launch(args);
	}

	
}
