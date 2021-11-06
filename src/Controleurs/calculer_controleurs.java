package Controleurs;
import Noyau.Transaction;
import UserInterface.fenetre_agence;
import UserInterface.fenetre_bien;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import Noyau.Bien;
import Noyau.essai;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import Noyau.Transaction;
public class calculer_controleurs implements Initializable{
    @FXML
    private Label prixfinal;

    @FXML
    private Label prix;

    @FXML
    private Label negociable;

    @FXML
    private Label superficie;

    @FXML
    private Label descriptif;

    @FXML
    private Label transaction;

    @FXML
    private Label adresse;

    public  Button retourner;
    public  Button consulter;
    public TextField indice;
    private Stage stage;

    @Override

    public void initialize(URL location, ResourceBundle resources) {


        retourner.setOnAction (e-> {
           stage.close();

        });





        consulter.setOnAction(e -> {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
                essai agence = null;
                try {
                    agence = (essai) in.readObject();
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
                int i = Integer.parseInt(indice.getText());
                if (i < agence.liste.size()&& i>=0) {
                    Bien a = agence.liste.get(i);

                    adresse.setText(a.getadresse());
                    descriptif.setText(a.getdescriptif());
                    superficie.setText(String.valueOf(a.getsuperficie()));
                    prix.setText(String.valueOf(a.getprix()));
                    negociable.setText(String.valueOf(a.getnegociable()));
                    transaction.setText(String.valueOf(a.getransaction()));
                    if (a.getransaction().equals(Transaction.vente) == true) {
                        prixfinal.setText(String.valueOf(a.calcul_prix_vente()));
                    } else if (a.getransaction().equals(Transaction.location) == true) {
                        prixfinal.setText(String.valueOf(a.calcul_prix_location()));
                    } else {
                        prixfinal.setText(String.valueOf(a.calcul_prix_echange()));
                    }
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Statut de la recherche");
                    alert.setHeaderText(null);
                    alert.setContentText("le bien que vous recherchez est introuvable");
                    alert.showAndWait();
                    indice.clear();
                }
            });


    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}
