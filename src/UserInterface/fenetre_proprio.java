package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.proprio_controleurs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Noyau.Gestion;
import java.io.IOException;

public class fenetre_proprio extends Stage {
    private Gestion agence;
    public fenetre_proprio() {
        this.setTitle("Recherche des biens d'un proprietaire");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("proprio.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            proprio_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
