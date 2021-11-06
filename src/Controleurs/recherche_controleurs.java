package Controleurs;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Noyau.essai;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class recherche_controleurs implements Initializable {
    public TextField adr;
    public  Button quitter;
    public Label zon;
    public Button rech;

    @Override

    public void initialize(URL location, ResourceBundle resources) {


        quitter.setOnAction (e-> {

            try {
                Parent home_page_parent = FXMLLoader.load(getClass().getResource("suppression.fxml"));
                Scene home_page_scene = new Scene(home_page_parent);
                Stage app_stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                app_stage.hide(); //optional
                app_stage.setScene(home_page_scene);
                app_stage.show();


            }
            catch ( IOException s)
            {
                s.printStackTrace();
            }


        });





        rech.setOnAction(e -> {

            try {
                ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
                essai agence = (essai)in.readObject();
                int chang =agence.recherche(adr.getText());
                if (chang == -1) {
                    adr.clear();
                    zon.setText("bien inexistant ");
                }
                else
                {
                    zon.setText("recherche  effectuée avec succes ");
                }

            } catch (IOException | ClassNotFoundException ex) {
                ex.printStackTrace();
            }




        });


    }
}
