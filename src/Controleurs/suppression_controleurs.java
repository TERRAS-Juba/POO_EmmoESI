package Controleurs;

import Noyau.essai;
import UserInterface.fenetre_suppression;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Noyau.essai;
import javafx.stage.WindowEvent;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.WeakHashMap;

public class suppression_controleurs implements Initializable {
    public TextField adr;
    public  Button quit;
    public Label zon;
    public Button sup;
    private Stage stage;

    public void initialize(URL location, ResourceBundle resources) {


        quit.setOnAction (e-> {
           stage.close();

        });





        sup.setOnAction(e -> {
            Boolean chang = null;
            essai agence= null;
            try {
                ObjectInputStream   in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
                agence = (essai)in.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }
            try {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Statut de la suppression");
                alert.setHeaderText("Voulez vous supprimer definitivement le bien concerné ?");
                Optional <ButtonType>result=alert.showAndWait();;
                if(result.get()==ButtonType.OK) {
                	chang = agence.supprimer(adr.getText());
                	if (!chang) {
                        adr.clear();
                         alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Statut de la suppression");
                        alert.setHeaderText(null);
                        alert.setContentText("Erreur!Echec de la suppression");
                        alert.showAndWait();
                    }
                    else
                    {
                        adr.clear();
                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Statut de la suppression");
                        alert.setHeaderText(null);
                        alert.setContentText("Suppression effectué avec succé");
                        alert.showAndWait();
                    }
                }
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



        });
    }
    public void setStage(Stage stage){
        this.stage=stage;
    }

}
