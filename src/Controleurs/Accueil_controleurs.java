package Controleurs;
import Noyau.Administrateur;
import Noyau.Gestion;
import Noyau.essai;
import UserInterface.fenetre_agence;
import UserInterface.fenetre_invite;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Noyau.Erreur_mot_de_passe;
import javafx.stage.Stage;

import java.io.*;

public class Accueil_controleurs {
    @FXML
    private TextField nomutilisateur;
    @FXML
    private PasswordField motdepasse;
    @FXML
    private Button bouttonquitter;
    @FXML
    private Button bouttonconnexion;
    @FXML
    private Button bouttoninvité;

    @FXML
    void connexion(ActionEvent event) throws IOException {
    	 Administrateur admin=new Administrateur("Juba","2020","Terras","Juba");
    	 if(admin.authentifier(nomutilisateur.getText(), motdepasse.getText())==false) {
    		 new Erreur_mot_de_passe();
    		 nomutilisateur.clear();
    		 motdepasse.clear();
    	 }
    	 else{
    	    essai agence =new essai();
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Gestion.dat"))));
    	    out.writeObject(agence);
    	    out.close();
          fenetre_agence fenetre=new fenetre_agence();
             nomutilisateur.clear();
             motdepasse.clear();
    	    fenetre.show();
      }

    }
    @FXML
    void invitation(ActionEvent event) {
    	fenetre_invite fenetre=new fenetre_invite();
    	fenetre.show();
    	

    }

    @FXML
    void quitter(ActionEvent event) {
    	Platform.exit();

    }
}
