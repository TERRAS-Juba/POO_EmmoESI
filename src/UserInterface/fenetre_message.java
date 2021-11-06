package UserInterface;

import Controleurs.agence_controleurs;
import Controleurs.bien_controleurs;
import Controleurs.insertion_maison;
import Controleurs.liste_controleurs;
import Controleurs.message_controleurs;
import Controleurs.proprio_controleurs;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Noyau.Gestion;
import java.io.IOException;

public class fenetre_message extends Stage {
    public fenetre_message() {
        this.setTitle("Ecriture d'un nouveau message ");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("message.fxml"));
        Parent root;
        try {
            root = loader.load();
            Scene scene = new Scene(root);
         // Dans cet exemple on créer une nouvelle fenêtre:
            this.setScene(scene);
            message_controleurs controller =loader.getController();
            controller.setStage(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}