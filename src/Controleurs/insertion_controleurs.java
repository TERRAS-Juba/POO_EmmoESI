package Controleurs;


import Noyau.Transaction;
import UserInterface.fenetre_appartement;
import UserInterface.fenetre_maison;
import UserInterface.fenetre_terrain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class insertion_controleurs {
    private Stage stage;

    @FXML
    void appartement(ActionEvent event) {
        fenetre_appartement fenetre = new fenetre_appartement();
        fenetre.show();

    }

    @FXML
    void maison(ActionEvent event) {
    	fenetre_maison fenetre2 = new fenetre_maison();
        fenetre2.show();

    }

    @FXML
    void quitter(ActionEvent event) {
        stage.close();

    }

    @FXML
    void terrain(ActionEvent event) {
    	fenetre_terrain fenetre3 = new fenetre_terrain();
        fenetre3.show();

    }
    public void setStage(Stage stage){
        this.stage=stage;
    }

}
