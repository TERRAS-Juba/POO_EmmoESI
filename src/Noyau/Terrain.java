package Noyau;
import java.util.Scanner;
public class Terrain extends Bien{
    private String statut_juridique;
    private int nbfacades;
/**************************************************************************************************************************************************************/
    /*les constructeurs*/
    public Terrain(Proprietaire P,Wilaya W,String adresse,Date D,double superficie,double prix,Boolean negociable,String descriptif,String url,Transaction T,Wilaya wilaya_echange,
                   String statut_juridique,int nbfacades) {
        super(P,W,adresse,D,superficie,prix,negociable,descriptif,url, T,wilaya_echange);
        this.statut_juridique=statut_juridique;
        this.nbfacades=nbfacades;
    }
/**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher() {
        System.out.println("-----------------------------------------------Informations relatives au terrain-------------------------------------------------");
        System.out.println("Statut juridique : "  +statut_juridique);
        System.out.println("Nombre de facades :" + nbfacades);
        System.out.println("--------------------------------------------------------------fin----------------------------------------------------------------");
    }
/**************************************************************************************************************************************************************/
    /*Les methodes de claculs des prix des 3 transactions : vente,location,echange*/
    public double calcul_prix_vente() {
        double nvprix=0;;
        if(getprix() <5000000)
        {
            if(getprixmettrecarre() < 50000)
            {
                nvprix=(getprix() *3)/ 100 + getprix();
            }
            else
            {
                nvprix=(getprix() *35)/100 +getprix();
            }
        }
        else
        {
            if(getprix()>5000000 && getprix() <15000000)
            {
                if(getprixmettrecarre()<50000)
                {
                    nvprix=(getprix() *2)/100 +getprix();
                }
                else
                {
                    nvprix= (getprix()*2.5/100 +getprix());

                }
            }
            else
            {
                if(getprixmettrecarre()<70000)
                {
                    nvprix=(getprix() *1)/100 +getprix();
                }
                else
                {
                    nvprix= (getprix()*2)/100 +getprix();

                }


            }
        }
        if(nbfacades >1)
        {
            nvprix= ((getprix() *0.5)/100 )*nbfacades+nvprix;
        }
        return nvprix;

    }
    public double calcul_prix_location() {
        double nvprix;
        if(getsuperficie()<60)
        {
            if(getwilaya().getprixmettrecarre() < 50000)
            {
                nvprix=(getprix() *1)/ 100 + getprix();
            }
            else
            {
                nvprix=(getprix() *1.5)/100 +getprix();
            }
        }
        else
        {
            if(getsuperficie()>60 && getsuperficie()<150)
            {
                if(getwilaya().getprixmettrecarre()<50000)
                {
                    nvprix=(getprix() *2)/100 +getprix();
                }
                else
                {
                    nvprix= (getprix()*2.5)/100 +getprix();

                }
            }
            else
            {
                if(getwilaya().getprixmettrecarre()<70000)
                {
                    nvprix=(getprix() *3)/100 +getprix();
                }
                else
                {
                    nvprix= (getprix()*3.5)/100 +getprix();

                }


            }
        }

        return nvprix;
    }
    public double calcul_prix_echange() {
        double prix_echange;
        prix_echange=calcul_prix_vente();
        
        if(getwilayaechange().getnumwilaya()!=getwilaya().getnumwilaya()) {
            prix_echange=prix_echange+(getprix()*0.25)/100;
        }
        return prix_echange;
    }
/**************************************************************************************************************************************************************/
    /*Methode de modification*/
    public void modifier() {
        Scanner var=new Scanner(System.in);
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier le statut juridique | repondez par oui ou non  :  ");
        String reponse =var.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("Statut juridique  : ");
            setstatut_juridique(var.nextLine());
        }
    }
/**************************************************************************************************************************************************************/
    /*Un setteur*/
    public void setstatut_juridique(String statut_juridique){ this.statut_juridique=statut_juridique; }
    public String getStatut_juridique(){
        return statut_juridique;
    }
    public int getnbfacades(){
        return nbfacades;
    }
/**************************************************************************************************************************************************************/
}