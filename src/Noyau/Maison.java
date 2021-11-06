package Noyau;
import java.util.Scanner;
public class Maison extends Habitable{
    private int nbetages;
    private Boolean garage;
    private Boolean jardin;
    private Boolean piscine;
    private double superficie_habitable;
    /**************************************************************************************************************************************************************/
    /*Les constructeurs*/
    public Maison(Proprietaire P,Wilaya W,String adresse,Date D,double superficie,double prix,Boolean negociable,String descriptif,String url,Transaction t,Wilaya wilaya_echange,int nbpieces,
                  Boolean meuble,int nbetages,Boolean garage,Boolean jardin,Boolean piscine){
        super(P,W,adresse,D,superficie,prix,negociable,descriptif,url,t,wilaya_echange,nbpieces,meuble);
        this.nbetages=nbetages;
        this.garage=garage;
        this.jardin=jardin;
        this.piscine=piscine;

    }
    /**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher() {
        super.afficher_habitable();
        System.out.println("-----------------------------------------------Informations relatives a la maison------------------------------------------------");
        System.out.println("Nombre etages:  "+nbetages);
        System.out.println("Contient Garage:  "+garage);
        System.out.println("Contient jardin:  "+jardin);
        System.out.println("Contient piscine:  "+piscine);
        System.out.println("--------------------------------------------------------------fin----------------------------------------------------------------");

    }
    /**************************************************************************************************************************************************************/
    /*Methode de calculs de prix*/
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
                nvprix=(getprix() *3.5)/100 +getprix();
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
        if((jardin==true) || (piscine==true)||(garage==true))
        {
            nvprix= (getprix() *0.5)/100 +nvprix;
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
        if( (piscine==true))
        {
            nvprix= 50000 +nvprix;
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
        super.modifier();
        Scanner var=new Scanner(System.in);
        Scanner str=new Scanner(System.in);
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier le nombre d etages de cette maison| repondez par oui ou non  :  ");
        String reponse =var.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("nbetage  : ");
            int nb =var.nextInt();
            setnbetages(nb);
        }
        /*====================================================================================================*/
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier si la maison contient un garage| repondez par oui ou non ");
        String rep =str.nextLine();
        if(rep.compareTo("oui")==0) {
            System.out.print("garage  : ");
            Boolean garage=affect_booleen(str.nextLine());
            setgarage(garage);
        }
        /*====================================================================================================*/
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier si la maison contient un jardin| repondez par oui ou non  :  ");
        rep =str.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("jardin : ");
            Boolean jard=affect_booleen(str.nextLine());
            setjardin(jard);
        }
        /*====================================================================================================*/
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier si la maison contient un piscine | repondez par oui ou non  :  ");
        rep =str.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("piscicne : ");
            Boolean pis=affect_booleen(str.nextLine());
            setpiscine(pis);
        }
    }
    /**************************************************************************************************************************************************************/
    public void setnbetages(int etage) { nbetages=etage; }
    public void setgarage(Boolean garage) { this.garage=garage; }
    public void setjardin(Boolean jardin) { this.jardin=jardin; }
    public void setpiscine(Boolean piscine) { this.piscine=piscine; }
    public int getnbetages() { return nbetages; }
    public Boolean getgarage() { return garage; }
    public Boolean getjardin() { return jardin; }
    public Boolean getpiscine() { return piscine; }
    /**************************************************************************************************************************************************************/
}