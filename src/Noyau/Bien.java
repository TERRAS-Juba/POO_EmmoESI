package Noyau;
import java.io.Serializable;
import java.util.Scanner;
public class Bien implements Comparable<Bien>, Serializable {/*la classe bien impilement l'interface comparable*/
    private Proprietaire proprio;
    private Wilaya wilaya;
    private String adresse;
    private Date date_ajout;
    private double superficie;
    private double prix;
    private Boolean negociable;
    private String descriptif;
    private String url;
    private Transaction T;
    private Wilaya wilaya_echange;
    /**************************************************************************************************************************************************************/
    /*Les constructeurs */
    public Bien(Proprietaire P,Wilaya W,String adresse,Date D,double superficie,double prix,Boolean negociable,String descriptif,String url,Transaction T,Wilaya wilaya_echange) {
        proprio=P;
        wilaya=W;
        this.adresse=adresse;
        date_ajout=D;
        this.superficie=superficie;
        this.prix=prix;
        this.negociable=negociable;
        this.descriptif=descriptif;
        this.url=url;
        this.date_ajout=D;
        this.T=T;
        this.wilaya_echange=wilaya_echange;

    }
    /**************************************************************************************************************************************************************/

    /**************************************************************************************************************************************************************/
    /*Redifinition de compare to*/
    public int compareTo(Bien A) {
        if(this.date_ajout.getannee()>A.date_ajout.getannee()) {
            return 1;
        }
        else if(this.date_ajout.getannee()<A.date_ajout.getannee()) {
            return -1;
        }
        else {
            if(this.date_ajout.getmois()>A.date_ajout.getmois()) {
                return 1;
            }
            else if(this.date_ajout.getmois()<A.date_ajout.getmois()) {
                return -1;
            }
            else {
                if(this.date_ajout.getjour()>A.date_ajout.getjour()) {
                    return 1;
                }
                else if(this.date_ajout.getjour()<A.date_ajout.getjour()) {
                    return -1;
                }
                else {
                    return 0;
                }
            }
        }
    }
    /**************************************************************************************************************************************************************/
    /*Les getteurs*/
    public double getprixmettrecarre(){ return(wilaya.getprixmettrecarre()); }
    public double getsuperficie() { return superficie; }
    public Transaction getransaction() { return T; }
    public String getdescriptif() { return descriptif; }
    public String geturl() { return url; }
    public int getnumwilaya() { return wilaya.getnumwilaya(); }
    public double getprix() { return prix; }
    public Boolean getnegociable() {return(negociable); }
    public String getadresse() { return adresse; }
    public Proprietaire getproprio() { return proprio; }
    public Wilaya getwilaya(){return wilaya;}
    public Wilaya getwilayaechange(){return wilaya_echange;}
    public Date getdate(){ return date_ajout;}
    /**************************************************************************************************************************************************************/
   /*Les setteurs*/
    public void setsuperficie(double sup) { superficie=sup; }
    public void setprix(double nvprix) { prix=nvprix; }
    public void setdescriptif(String des) { descriptif=des; }
    public void setnegociable(Boolean neg) { negociable=neg; }
    public void seturl(String url) { this.url=url; }
    public void setTransaction(Transaction T) { this.T=T; }
    /**************************************************************************************************************************************************************/
    /*Les methodes de calcul de prix*/
    public double calcul_prix_vente() { return 0; }
    public double calcul_prix_location() { return 0; }
    public double calcul_prix_echange() { return 0; }
    /**************************************************************************************************************************************************************/
    /*surcharge de la methode de modification*/
    public void modifier() { }
    public int getnbpieces(){return 0;}
    /**************************************************************************************************************************************************************/
    public Boolean affect_booleen(String mot) {
        boolean inter=false;
        if(mot.compareTo("oui")==0) {
            inter=true;
        }
        else {
            if(mot.compareTo("non")==0) {
                inter=false;
            }
        }
        return(inter);
    }
    /**************************************************************************************************************************************************************/
}