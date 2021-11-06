package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.boite_controleurs;
import Controleurs.suppression_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_boite extends Stage {
    public fenetre_boite(){
        this.setTitle("Consultation de la boite de reception");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("boite.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            boite_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
