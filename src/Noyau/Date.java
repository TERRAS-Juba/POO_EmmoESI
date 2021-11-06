package Noyau;
import java.io.Serializable;
import java.util.Scanner;
public class Date implements Serializable {
    private int jour;
    private int mois;
    private int annee;
    /**************************************************************************************************************************************************************/
    /*Les constructeurs*/
    public Date(int jour,int mois,int  annee) {
        this.jour=jour;
        this.mois=mois;
        this.annee=annee;
    }
    /**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher_date() {
        System.out.println("----------------------------------------------------------Date d'ajout-----------------------------------------------------------");
        System.out.println("Jour : "+jour);
        System.out.println("Mois : "+mois);
        System.out.println("Annee : "+annee);
    }
    /**************************************************************************************************************************************************************/
    /*Les getteurs*/
    public int getjour() { return jour; }
    public int getmois() { return mois; }
    public int getannee() { return annee; }
    /**************************************************************************************************************************************************************/

}