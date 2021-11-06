package Noyau;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Erreur_mot_de_passe{
	public Erreur_mot_de_passe() {
	Alert alert = new Alert(AlertType.INFORMATION);
	alert.setTitle("Mot de Passe erroné");
	alert.setHeaderText(null);
	alert.setContentText("le mot de passe ou nom d'utilisateur invalid");
	alert.showAndWait();
	}

}
