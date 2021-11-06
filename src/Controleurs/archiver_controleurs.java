package Controleurs;


import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.*;

public class archiver_controleurs {

    @FXML
    private AnchorPane rien;

    @FXML
    private Button bouttonquitter;

    @FXML
    private TextField adr;

    @FXML
    private Label zon;

    @FXML
    private Button bouttonarchiver;
    private Stage stage;

    @FXML
    void archiver(ActionEvent event) {
        Boolean chang = null;
        essai agence= null;
        try {
            ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            agence = (essai)in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {
            chang = agence.archiver(adr.getText());
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }


        try {
            ObjectOutputStream out=new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("Gestion.dat"))));
            out.writeObject(agence);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if (!chang) {
            adr.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Statut de l'archivage");
            alert.setHeaderText(null);
            alert.setContentText("Erreur !Echec de l'archivage du bien. Bien non trouvé");
            alert.showAndWait();
        }
        else
        {
            adr.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Statut de l'archivage");
            alert.setHeaderText(null);
            alert.setContentText("Archivage effectué avec succé");
            alert.showAndWait();
        }

    }

    @FXML
    void quitter(ActionEvent event) {
          stage.close();
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }

}
