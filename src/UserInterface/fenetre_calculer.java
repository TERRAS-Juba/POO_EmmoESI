package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.calculer_controleurs;
import Noyau.Gestion;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class fenetre_calculer extends Stage {
    public fenetre_calculer(){
        this.setTitle("Calcul du prix d'un bien");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("CalculerPrix.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            calculer_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
