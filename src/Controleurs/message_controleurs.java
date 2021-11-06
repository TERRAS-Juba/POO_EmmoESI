package Controleurs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Noyau.Message;
import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;

public class message_controleurs {
	private Stage stage;


    @FXML
    private Button bouttonquitter;

    @FXML
    private Button bouttonenvoyer;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField adresse;

    @FXML
    private TextField message;
    @FXML
    void envoyer(ActionEvent event) {
    	try {

            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            essai agence = (essai)in.readObject();
            Message mess=new Message(nom.getText(),prenom.getText(),adresse.getText(),message.getText());
            if((mess.getadresse().compareTo("")==0)||(mess.getnom().compareTo("")==0)||(mess.getprenom().compareTo("")==0)||(mess.getmessage().compareTo("")==0)){
            	throw new IOException();
            }
            agence.boite.add(mess);
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Gestion.dat"))));
            out.writeObject(agence);
            out.close();
            adresse.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Statut de l'envoie");
            alert.setHeaderText(null);
            alert.setContentText("Message envoyé avec succés");
            alert.showAndWait();
            nom.clear();
          	 prenom.clear();
          	 message.clear();
          	adresse.clear();
        } catch (Exception ex) {
        	 
             Alert alert = new Alert(Alert.AlertType.WARNING);
             alert.setTitle("Statut de l'envoie");
             alert.setHeaderText(null);
             alert.setContentText("Veuillez remplir tous les champs ");
             alert.showAndWait();
        }
    	

    }

    @FXML
    void quitter(ActionEvent event) {
    	stage.close();

    }
    public void setStage(Stage stage) {
    	this.stage=stage;
    }

}
