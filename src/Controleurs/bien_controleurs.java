package Controleurs;

import Noyau.Bien;
import Noyau.Maison;
import Noyau.essai;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import Noyau.*;
public class bien_controleurs implements Initializable{

    public  Button retourner;
    public  Button consulter;
    public TextField indice;
    private Stage stage;
    @FXML
    private ListView<String> zone;

    @Override

    public void initialize(URL location, ResourceBundle resources) {


        retourner.setOnAction (e-> {
           stage.close();

        });





        consulter.setOnAction(e -> {
            ObjectInputStream in = null;
            try {
                in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
                essai agence = (essai)in.readObject();
                int i=0;
                 i=Integer.parseInt(indice.getText());
                if (i<agence.liste.size()&& i>=0) {
                    Bien a =agence.liste.get(i);
                    zone.getItems().clear();
                    zone.getItems().add("------------------------------------------Information proprietaire-----------------------------------------");
                    zone.getItems().add("Nom           :  "+a.getproprio().getnom());
                    zone.getItems().add("Prenom        :  "+a.getproprio().getprenom());
                    zone.getItems().add("Email         :  "+a.getproprio().getemail());
                    zone.getItems().add("Telephone     :  "+a.getproprio().getTelephone());
                    zone.getItems().add("Adresse       :  "+a.getproprio().getadresse());
                    zone.getItems().add("------------------------------------------Informations date d ajout----------------------------------------");
                    zone.getItems().add("Jour          :  "+a.getdate().getjour());
                    zone.getItems().add("Mois          :  "+a.getdate().getmois());
                    zone.getItems().add("Année         :  "+a.getdate().getannee());
                    zone.getItems().add("------------------------------------Informations sur la wilaya---------------------------------------------");
                    zone.getItems().add("Numero de wilaya          :  "+a.getwilaya().getnumwilaya());
                    zone.getItems().add("Prix du mettre carré      :  "+a.getwilaya().getprixmettrecarre());
                    zone.getItems().add("-----------------------------------Informations generales sur le bien--------------------------------------");
                    zone.getItems().add("Adresse du bien           :  "+a.getadresse());
                    zone.getItems().add("Superficie                :  "+a.getsuperficie());
                    zone.getItems().add("Descriptif                :  "+a.getdescriptif());
                    zone.getItems().add("Prix negociable           :  "+a.getnegociable());
                    zone.getItems().add("Transaction               :  "+a.getransaction());
                    if(a instanceof Maison  || a instanceof Appartement){
                    zone.getItems().add("---------------------------------------Informations specifiques sur le bien--------------------------------");
                    zone.getItems().add("Meublé                    :  "+ ((Habitable) a).getmeuble());
                    zone.getItems().add("Nombre de pieces          :  "+a.getnbpieces());
                        if(a instanceof Maison){
                    zone.getItems().add("-----------------------------------Informations sur la maison----------------------------------------------");
                    zone.getItems().add("Nombre d'etages           :  "+((Maison) a).getnbetages());
                    zone.getItems().add("jardin                    :  "+((Maison) a).getjardin());
                    zone.getItems().add("Piscine                   :  "+((Maison) a).getpiscine());
                    zone.getItems().add("Garage                    :  "+((Maison) a).getgarage());
                        }
                        if(a instanceof Appartement){
                   zone.getItems().add("-----------------------------------Informations sur l'appartement-------------------------------------------");
                   zone.getItems().add("Numero etage               :  "+((Appartement) a).getnumero_etage());
                   zone.getItems().add("Ascenceur                  :  "+((Appartement) a).getAscenceur());
                   zone.getItems().add("Simplex                    :  "+((Appartement) a).getsimplex());

                        }
                    }else{
                   zone.getItems().add("-----------------------------------Informations sur le terrain----------------------------------------------");
                   zone.getItems().add("Statut juridique           :  "+((Terrain) a).getStatut_juridique());
                   zone.getItems().add("Nombre de facades          :  "+((Terrain) a).getnbfacades());

                    }

                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Statut de la recherche");
                    alert.setHeaderText(null);
                    alert.setContentText("Le bien que vous recherchez est introuvable");
                    alert.showAndWait();
                    indice.clear();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }




        });


    }
    public void setStage(Stage stage){
        this.stage=stage;
    }
}