package controller;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Joueur;
import model.Partie;

public class PageAccueilController {

	
	@FXML
	private Pane paneAccueil1;
	@FXML 
	private Button JvJ;
	@FXML 
	private Button JvO;
	@FXML 
	private Button DM;
	
	
	@FXML
    public void JoueurVsJoueur(ActionEvent actEv)  throws IOException {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PageAccueilController.class.getClassLoader().getResource("view/ChoixModeJeu.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) JvJ.getScene().getWindow();
            // Set person overview into the center of root layout.

                Scene scene = JvJ.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
                Joueur j1= new Joueur(true);
                Joueur j2= new Joueur(true);
                Partie p = new Partie(j1,j2);
                
      
                

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
	
	@FXML
    public void JoueurVsOrdi(ActionEvent actEv)  throws IOException {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PageAccueilController.class.getClassLoader().getResource("view/ChoixModeJeu.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) JvJ.getScene().getWindow();
            // Set person overview into the center of root layout.

                Scene scene = JvJ.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
                
                Joueur j1= new Joueur(true);
                Joueur j2= new Joueur(false);
                Partie p = new Partie(j1,j2);
                

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
	
	@FXML
    public void Demo(ActionEvent actEv)  throws IOException {

        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(PageAccueilController.class.getClassLoader().getResource("view/ChoixModeJeu.fxml"));
           Pane Connexion  = (Pane) loader.load();
                Stage stage =  (Stage) JvJ.getScene().getWindow();
            // Set person overview into the center of root layout.

                Scene scene = JvJ.getScene();
                scene.setRoot(Connexion);
                stage.setScene(scene);
                
                
                

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

	
}
