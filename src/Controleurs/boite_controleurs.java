package Controleurs;

import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.*;

public class boite_controleurs {

    @FXML
    private Button bouttonconsulter;

    @FXML
    private Button bouttonquitter;

    @FXML
    private ListView<String> ensemble;
    private Stage stage;

    @FXML
    void consulter(ActionEvent event) {
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            essai agence = (essai)in.readObject();
            int i=0;
            if(agence.boite.size()==0){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Statut de la boite de reception");
                alert.setHeaderText(null);
                alert.setContentText("Aucun Message ne se trouve dans la boite de reception");
                alert.showAndWait();
            }
            else {
                for (i = 0; i < agence.boite.size(); i++) {
                    ensemble.getItems().add("-----------------------------------------------------------------------------------------------------------------------");
                    ensemble.getItems().add("                                     Message numero " + Integer.toString(i));
                    ensemble.getItems().add("-----------------------------------------------------------------------------------------------------------------------");
                    ensemble.getItems().add("-----------------------------------------     Expediteur  -------------------------------------------------------------");
                    ensemble.getItems().add("Nom                              :  " + agence.boite.get(i).getnom());
                    ensemble.getItems().add("Prenom                           :  " + agence.boite.get(i).getprenom());
                    ensemble.getItems().add("-----------------------------------------     Le contenu  -------------------------------------------------------------");
                    ensemble.getItems().add("Adresse du bien concerné         :  " + agence.boite.get(i).getadresse());
                    ensemble.getItems().add("Message                          :  " + agence.boite.get(i).getmessage());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void quitter(ActionEvent event) {
        stage.close();

    }
    public void setStage(Stage stage ){
        this.stage=stage;
    }

}