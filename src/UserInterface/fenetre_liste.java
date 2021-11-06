package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.liste_controleurs;
import Controleurs.proprio_controleurs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Noyau.Gestion;
import java.io.IOException;

public class fenetre_liste extends Stage {
    private Gestion agence;
    public fenetre_liste() {
        this.setTitle("Consultation du catalogue de l'agence");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("catalogue.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            liste_controleurs controller =loader.getController();
            controller.setStage(this);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}