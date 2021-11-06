package Controleurs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import Noyau.Appartement;
import Noyau.Bien;
import Noyau.Date;
import Noyau.Maison;
import Noyau.Proprietaire;
import Noyau.Transaction;
import Noyau.Wilaya;
import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class insertion_maison {
	private Stage stage;

	 @FXML
	    private Button bouttoninsertion;

	    @FXML
	    private TextField adr;

	    @FXML
	    private TextField superficie;

	    @FXML
	    private TextField prix;

	    @FXML
	    private TextField descriptif;

	    @FXML
	    private TextField negociable;

	    @FXML
	    private TextField jour;

	    @FXML
	    private TextField mois;

	    @FXML
	    private TextField annee;

	    @FXML
	    private TextField nom;

	    @FXML
	    private TextField prenom;

	    @FXML
	    private TextField email;

	    @FXML
	    private TextField adresse;

	    @FXML
	    private TextField tel;

	    @FXML
	    private TextField wilaya;

	    @FXML
	    private TextField num;

	    @FXML
	    private TextField metre;

	    @FXML
	    private TextField nbpieces;

	    @FXML
	    private TextField garage;

	    @FXML
	    private TextField jardin;

	    @FXML
	    private TextField piscine;

	    @FXML
	    private TextField nbetages;

	    @FXML
	    private TextField meuble;

	    @FXML
	    private ChoiceBox<Transaction> choix;

	    @FXML
	    private Button bouttoninitialisation;

	    @FXML
	    private Button bouttonquitter;
	    @FXML
	    private TextField habitable;


    @FXML
    void initialiser(ActionEvent event) {
        choix.getItems().addAll(Transaction.vente, Transaction.location, Transaction.echange);

    }

    @FXML
    void insertion(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            Proprietaire a = new Proprietaire(nom.getText(), prenom.getText(), email.getText(), tel.getText(), adresse.getText());
            Date b = new Date(Integer.parseInt(jour.getText()), Integer.parseInt(mois.getText()), Integer.parseInt(annee.getText()));
            Wilaya d = new Wilaya(Integer.parseInt(num.getText()), wilaya.getText(), Integer.valueOf(metre.getText()));
            Bien c = new Maison(a, d, adr.getText(), b, Double.valueOf(superficie.getText()), Double.valueOf(prix.getText()), Boolean.valueOf(negociable.getText()), descriptif.getText(), " ", choix.getValue(), d, Integer.parseInt(nbpieces.getText()), Boolean.valueOf(meuble.getText()), Integer.parseInt(nbetages.getText()), Boolean.valueOf(garage.getText()), Boolean.valueOf(jardin.getText()), Boolean.valueOf(piscine.getText()));
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));

            essai agence = (essai) in.readObject();
            if(((Boolean.valueOf(jardin.getText())==true)||(Boolean.valueOf(garage.getText())==true)||(Boolean.valueOf(piscine.getText())==true))&&(habitable.isEditable()==false) ) {
            	habitable.setEditable(true);
            	Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Superficie habitable");
                alert.setHeaderText(null);
                alert.setContentText("Vueillez a present remplir la superficie habitable");
                alert.showAndWait();
            	
            }
            else 
            {
            	
            if (agence.recherche(adr.getText()) !=-1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Statut de l'insertion");
                alert.setHeaderText(null);
                alert.setContentText("Insertion Impossible le bien existe deja dans notre catalogue");
                alert.showAndWait();

            } 
            else if(Double.valueOf(habitable.getText())>Double.valueOf(superficie.getText())){
            	 Alert alert = new Alert(Alert.AlertType.WARNING);
                 alert.setTitle("Statut de l'insertion");
                 alert.setHeaderText(null);
                 alert.setContentText("Insertion Impossible la superficie habitable ne peut depasser la superfice generale");
                 alert.showAndWait();
            	
            }
            else {
                agence.liste.add(c);
                ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Gestion.dat"))));
                out.writeObject(agence);
                out.close();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Statut de l'insertion");
                alert.setHeaderText(null);
                alert.setContentText("Insertion effectué avec succée");
                alert.showAndWait();
            }
            }
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Statut de l'insertion");
            alert.setHeaderText(null);
            alert.setContentText("Erreur Veuillez remplir tous les champs s'il vous plait");
            alert.showAndWait();
        }
    }
    @FXML
    void quitter(ActionEvent event) {
        stage.close();

    }
        public void setStage (Stage stage){
        this.stage = stage;
    }

}
