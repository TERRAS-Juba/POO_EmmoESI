package UserInterface;
import Controleurs.agence_controleurs;
import Controleurs.boite_controleurs;
import Controleurs.suppression_controleurs;
import Noyau.Gestion;
import Controleurs.Accueil_controleurs;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
public class Main extends Application{
public void start(Stage primaryStage) {
try {
	FXMLLoader loader=new FXMLLoader();
	loader.setLocation(getClass().getResource("Accueil.fxml"));
	Parent root=loader.load();
	primaryStage.setTitle("Accueil");
	primaryStage.setScene(new Scene(root));
	primaryStage.show();
} catch(Exception e) {
e.printStackTrace();
}
}
public static void main(String[] args) {
launch (args);
}
}