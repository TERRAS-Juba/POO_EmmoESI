package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.suppression_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_suppression extends Stage {
    public fenetre_suppression() {
        this.setTitle("Suppression d'un bien");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("suppression.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        suppression_controleurs controller =loader.getController();
        controller.setStage(this);

// Dans cet exemple on créer une nouvelle fenêtre:
        this.setScene(scene);
    }
}
