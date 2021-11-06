package UserInterface;

import Controleurs.Accueil_controleurs;
import Controleurs.agence_controleurs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Noyau.Gestion;
import java.io.IOException;

public class fenetre_recherche extends Stage {
    private Gestion agence;
    public fenetre_recherche() {
        this.setTitle("Bienvenu dans ImmoESI");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("recherche.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
// Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
// donnez au controller accès à la fenêtre.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
