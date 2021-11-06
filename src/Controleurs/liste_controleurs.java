package Controleurs;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Noyau.essai;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class liste_controleurs {
	private Stage stage;
	@FXML
    private Button bouttonconsulter;

    @FXML
    private Button bouttonquitter;

    @FXML
    private ListView<String> ensemble;

    @FXML
    void consulter(ActionEvent event) {
    	ObjectInputStream in = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
            essai agence = (essai)in.readObject();
            ensemble.getItems().clear();
            int i=0;
            for(i=0;i<agence.liste.size();i++){
                ensemble.getItems().add("---------------------------------------------------------------------------------------------------------------------------------");
                ensemble.getItems().add("                                                            Bien numero "+Integer.toString(i));
                ensemble.getItems().add("---------------------------------------------------------------------------------------------------------------------------------");
                ensemble.getItems().add("Adresse          :  "+agence.liste.get(i).getadresse());
                ensemble.getItems().add("Superficie       :  "+Double.toString(agence.liste.get(i).getsuperficie()));
                ensemble.getItems().add("Descriptif       :  "+agence.liste.get(i).getdescriptif());
                ensemble.getItems().add("prix Negociable  :  "+agence.liste.get(i).getnegociable());
                ensemble.getItems().add("Transaction      :  "+agence.liste.get(i).getransaction());
                ensemble.getItems().add("---------------------------------------------------------------------------------------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    @FXML
    void quitter(ActionEvent event) {
           stage.close();
    }
	public void setStage(Stage stage) {
		this.stage=stage;
	}

}
