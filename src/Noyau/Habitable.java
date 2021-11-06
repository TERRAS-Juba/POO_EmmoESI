package Noyau;
import java.util.Scanner;
public class Habitable extends Bien{
    private int nbpieces;
    private Boolean meuble;
    /**************************************************************************************************************************************************************/
    /*Les constructeurs*/
    public Habitable(Proprietaire P,Wilaya W,String adresse,Date D,double superficie,double prix,Boolean negociable,String descriptif,String url,Transaction T,Wilaya wilaya_echange,int nbpieces,Boolean meuble) {
        super(P,W,adresse,D,superficie,prix,negociable,descriptif,url,T,wilaya_echange);
        this.nbpieces=nbpieces;
        this.meuble=meuble;

    }
    /**************************************************************************************************************************************************************/
    /*Methode d'affichage*/
    public void afficher_habitable() {
        System.out.println("-----------------------------------------------Information sur l'habitation------------------------------------------------------");
        System.out.println("Nombre de pieces:  "+nbpieces);
        System.out.println("meuble :  "+ meuble);

    }
    /*****************************************************************************************************************************************************************/
    /*Methode de modification*/
    public void modifier() {
        Scanner var=new Scanner(System.in);
        System.out.println("+===============================================================================================================================+");
        System.out.print("Voulez modifier si le bien est meuble ou pas ? | repondez par oui ou non  :  ");
        String reponse =var.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("Meublé  : ");
            boolean mbl =affect_booleen(var.nextLine());
            setmeuble(mbl);
        }
    }
    /*****************************************************************************************************************************************************************/
    /*Un setteur*/
    public void setmeuble( Boolean mbl) { meuble=mbl; }
    public int getnbpieces(){ return nbpieces; }
    public Boolean getmeuble(){
        return(meuble);
    }
    /*****************************************************************************************************************************************************************/
}