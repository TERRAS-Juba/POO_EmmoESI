package UserInterface;

import Controleurs.insertion_appartement;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_appartement extends Stage {
    public fenetre_appartement(){
        this.setTitle("Insertion d'un appartement");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("insert_appart.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            insertion_appartement controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
