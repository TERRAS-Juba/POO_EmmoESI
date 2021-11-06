package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.insertion_controleurs;
import Controleurs.proprio_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_insertion extends Stage {
    public fenetre_insertion(){
        this.setTitle("Insertion d'un bien");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("menu_insert.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            insertion_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
