package Noyau;
import java.io.Serializable;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Proprietaire implements Serializable {
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private String adresse;
/**************************************************************************************************************************************************************/
    /*Les constructeurs*/
    public Proprietaire() {
            System.out.println("----------------------------------------------------------Proprietaire-----------------------------------------------------------");
            Scanner var=new Scanner(System.in);
            System.out.print("Nom :  ");
            nom=var.nextLine();
            System.out.print("Prenom:  ");
            prenom=var.nextLine();
            System.out.print("Email :  ");
            email=var.nextLine();
            System.out.print("Telephone : ");
            telephone=var.nextLine();
            System.out.print("adresse :  ");
            adresse=var.nextLine();
    }
    public Proprietaire(String nom,String prenom,String email,String telephone,String adresse) {
        this.nom=nom;
        this.prenom=prenom;
        this.email=email;
        this.telephone=telephone;
        this.adresse=adresse;
    }
/**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher_prop() {
        System.out.println("---------------------------------------------------------Proprietaire------------------------------------------------------------");
        System.out.println("Nom :  " +nom);
        System.out.println("Prenom:  "+prenom);
        System.out.println("Email :  "+ email);
        System.out.println("Telephone : " +telephone);
        System.out.println("adresse :  " + adresse);
    }
/**************************************************************************************************************************************************************/
    /*Les getteurs*/
    public String getnom() { return nom; }
    public String getprenom(){ return prenom; }
    public String getemail(){ return email; }
    public String getTelephone(){ return telephone; }
    public String getadresse(){ return adresse; }
/**************************************************************************************************************************************************************/

}