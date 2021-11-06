package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.suppression_controleurs;
import Controleurs.terrain_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_terrain extends Stage {
    public fenetre_terrain() {
        this.setTitle("Insertion d'un terrain");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("insert_terrain.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(root);
        terrain_controleurs controller =loader.getController();
        controller.setStage(this);

// Dans cet exemple on créer une nouvelle fenêtre:
        this.setScene(scene);
    }
}