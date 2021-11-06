package Noyau;
import java.util.Scanner;
public class Appartement extends Habitable{
    private int numero_etage;
    private Boolean simplex;
    private Boolean duplex;
    private Boolean ascenceur;
    /**************************************************************************************************************************************************************/
    /*Les constructeurs*/
    public Appartement(Proprietaire P,Wilaya W,String adresse,Date D,double superficie,double prix,Boolean negociable,String descriptif,String url,Transaction T, Wilaya wilaya_echange,int nbpieces
            ,Boolean meuble,int numero_etage,Boolean simplex,Boolean duplex,Boolean ascenceur)
    {
        super(P,W,adresse,D,superficie,prix,negociable,descriptif,url,T,wilaya_echange,nbpieces,meuble);
        this.numero_etage=numero_etage;
        this.simplex=simplex;
        this.duplex=duplex;
        this.ascenceur=ascenceur;

    }
    /**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher() {
        super.afficher_habitable();
        System.out.println("-----------------------------------------------Informations relatives a l'apparetment--------------------------------------------");
        System.out.println("Numero etage : " +numero_etage);
        System.out.println("C'est un simplex ? " +simplex);
        System.out.println("Cet apparttement contient un ascenceur : "+ascenceur);
        System.out.println("------------------------------------------------------------ fin ---------------------------------------------------------------\n");

    }
    /**************************************************************************************************************************************************************/
    /*Methodes de calcul de prix*/
    public double calcul_prix_vente() {
        double nvprix;
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
                    nvprix= (getprix()*2.5)/100 +getprix();

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
        if(numero_etage <= 2)
        {
            nvprix= 50000 +nvprix;
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
                if(getprixmettrecarre()<70000)
                {
                    nvprix=(getprix() *3)/100 +getprix();
                }
                else
                {
                    nvprix= (getprix()*3.5)/100 +getprix();

                }


            }
        }
        if(numero_etage <= 2)
        {
            nvprix= 5000 +nvprix;

        }
        else
        {
            if( (numero_etage>=6) && (ascenceur==false))
            {
                nvprix=nvprix-(500*getsuperficie());
            }
        }

        return nvprix;
    }
    public double calcul_prix_echange() {
        double prix_echange;
 
        prix_echange=calcul_prix_vente();
        if(getwilayaechange().getnumwilaya()!=getwilaya().getnumwilaya()) {
        	prix_echange=prix_echange+((getprix()*0.25)/100);
        }
        return prix_echange;
    }
    /**************************************************************************************************************************************************************/
    /*Methode de modification*/
    public void modifier() {
        super.modifier();
        Scanner var=new Scanner(System.in);
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier la disponibilite de l'assenseur | repondez par oui ou non  :  ");
        String reponse =var.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("Assenceur  : ");
            boolean asc =affect_booleen(var.nextLine());
            setassenceur(asc);
        }
    }

    /**************************************************************************************************************************************************************/
    /*UN setteur*/
    public void setassenceur( Boolean asc) { ascenceur=asc; }
    public Boolean getAscenceur(){
        return ascenceur;
    }
    public int getnumero_etage(){
        return numero_etage;
    }
    public Boolean getsimplex() {
    	return simplex;
    }
    /**************************************************************************************************************************************************************/
}
