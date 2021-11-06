package Controleurs;

import Noyau.Bien;
import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;

public class proprio_controleurs {

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private Button bouttonconsulter;

    @FXML
    private Button bouttonquitter;

    @FXML
    private ListView<String> ensemble;
    private Stage stage;

    @FXML
    void quitter(ActionEvent event) {
        stage.close();
    }

    @FXML
    void consulter(ActionEvent event) {
        ObjectInputStream in = null;
        Boolean trouve=false;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            essai agence = (essai)in.readObject();
            int i=0;
            ensemble.getItems().clear();
            for(i=0;i<agence.liste.size();i++) {
                if ((((Bien) agence.liste.get(i)).getproprio().getnom().compareTo(nom.getText()) == 0) && (((Bien) agence.liste.get(i)).getproprio().getprenom().compareTo(prenom.getText()) == 0)) {
                    trouve=true;
                    ensemble.getItems().removeAll();
                    ensemble.getItems().add("----------------------------------------------------------------------------------------------------------------------");
                    ensemble.getItems().add("                                                            Bien numero " + Integer.toString(i));
                    ensemble.getItems().add("-----------------------------------------------------------------------------------------------------------------------");
                    ensemble.getItems().add("Adresse          :  " + agence.liste.get(i).getadresse());
                    ensemble.getItems().add("Superficie       :  " + agence.liste.get(i).getsuperficie());
                    ensemble.getItems().add("Descriptif       :  " + agence.liste.get(i).getdescriptif());
                    ensemble.getItems().add("prix Negociable  :  " + agence.liste.get(i).getnegociable());
                    ensemble.getItems().add("Transaction      :  " + agence.liste.get(i).getransaction());
                }
            }
            if(trouve==false){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Statut de la recherche");
                alert.setHeaderText(null);
                alert.setContentText("Aucun bien ne correspond a votre recherche");
                alert.showAndWait();
                nom.clear();
                prenom.clear();
                trouve=false;
            }
            nom.clear();
            prenom.clear();
            trouve=false;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
public void setStage(Stage stage){
        this.stage=stage;
}
}
