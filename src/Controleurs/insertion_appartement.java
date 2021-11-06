package Controleurs;

import Noyau.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class insertion_appartement {
    private Stage stage;

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
    private TextField piece;

    @FXML
    private TextField simplex;

    @FXML
    private TextField duplex;

    @FXML
    private TextField asc;

    @FXML
    private TextField etage;

    @FXML
    private TextField meuble;
    @FXML
    private ChoiceBox<Transaction> choix;

    @FXML
    void initialiser(ActionEvent event) {
        choix.getItems().addAll(Transaction.vente, Transaction.location, Transaction.echange);

    }

    @FXML
    void insertion(ActionEvent event) throws IOException, ClassNotFoundException {
        try {
            Proprietaire a = new Proprietaire(nom.getText(), prenom.getText(), email.getText(), tel.getText(), adresse.getText());
            Date b = new Date(Integer.parseInt(jour.getText()), Integer.parseInt(mois.getText()), Integer.parseInt(annee.getText()));
            Wilaya d = new Wilaya(Integer.parseInt(num.getText()), wilaya.getText(), Double.valueOf(metre.getText()));
            Bien c = new Appartement(a, d, adr.getText(), b, Double.valueOf(superficie.getText()), Double.valueOf(prix.getText()), Boolean.valueOf(negociable.getText()), descriptif.getText(), " ", choix.getValue(), d, Integer.parseInt(piece.getText()), Boolean.valueOf(meuble.getText()), Integer.parseInt(etage.getText()), Boolean.valueOf(simplex.getText()), Boolean.valueOf(duplex.getText()), Boolean.valueOf(asc.getText()));
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));

            essai agence = (essai) in.readObject();
            if (agence.recherche(adr.getText()) !=-1) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Statut de l'insertion");
                alert.setHeaderText(null);
                alert.setContentText("Insertion Impossible le bien existe deja dans notre catalogue");
                alert.showAndWait();

            } else {
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

