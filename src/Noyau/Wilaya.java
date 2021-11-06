package Noyau;
import java.io.Serializable;
import java.util.Scanner;
public class Wilaya implements Serializable {
    private int num_wilaya;
    private String nom_wilaya;
    private double prix_mettre_carre;
/**************************************************************************************************************************************************************/
   /*Les constructeurs*/
    public Wilaya(int num,String nom,double prix) {
        num_wilaya=num;
        nom_wilaya=nom;
        prix_mettre_carre=prix;
    }
/**************************************************************************************************************************************************************/
    public int getnumwilaya() {return (num_wilaya);}
    public double getprixmettrecarre() {
        return(prix_mettre_carre);
    }
/**************************************************************************************************************************************************************/
}