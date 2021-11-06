package UserInterface;

import Controleurs.archiver_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.suppression_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_archiver extends Stage {
    public fenetre_archiver(){
        this.setTitle("Archiver un Bien");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("archiver.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            archiver_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
