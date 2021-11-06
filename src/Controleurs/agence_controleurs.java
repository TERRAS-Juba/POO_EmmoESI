package Controleurs;


import UserInterface.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class agence_controleurs {
    private Stage stage;

    @FXML
    private Button bouttonretour;

    @FXML
    private Button bouttonquitter;

    @FXML
    void archiver(MouseEvent event) {
        fenetre_archiver fenetre1=new fenetre_archiver();
        fenetre1.show();


    }

    @FXML
    void calculer(MouseEvent event) {
        fenetre_calculer fenetre2=new fenetre_calculer();
        fenetre2.show();

    }

    @FXML
    void consulter(MouseEvent event) {
        fenetre_liste fenetre3=new fenetre_liste();
        fenetre3.show();
    }

    @FXML
    void recherche_proprio(MouseEvent event) {
        fenetre_proprio fenetre4=new fenetre_proprio();
        fenetre4.show();

    }

    @FXML
    void rechercher(MouseEvent event) {
        fenetre_bien fenetre5=new fenetre_bien();
        fenetre5.show();


    }

    @FXML
    void supprimer(MouseEvent event) {
        fenetre_suppression fenetre6=new fenetre_suppression();
        fenetre6.show();

    }
    @FXML
    void consulter_boite(MouseEvent event) {
        fenetre_boite fenetre7=new fenetre_boite();
        fenetre7.show();

    }

    @FXML
    void inserer_bien(MouseEvent event) {
        fenetre_insertion fenetre8=new fenetre_insertion();
        fenetre8.show();

    }
    @FXML
    void retour(ActionEvent event) {
          stage.close();
    }
    @FXML
    void quitter(ActionEvent event) {
        stage.close();
    }
public void setStage(Stage stage){
        this.stage=stage;
}
}
