package Noyau;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.*;
/********************************************************************************************************************************************************************/
public class Gestion implements Serializable {
    public ArrayList<Bien> liste = new ArrayList<Bien>();
    public ArrayList<Bien> archive = new ArrayList<Bien>();
    public ArrayList<Message> Boite = new ArrayList<Message>();
    public Gestion(){
        ArrayList<Bien> liste = new ArrayList<Bien>();
        ArrayList<Bien> archive = new ArrayList<Bien>();
        ArrayList<Message> Boite= new ArrayList<Message>();
        Proprietaire P1 = new Proprietaire("Mister", "white", "misterwhite@gmail.com", "0544251311", "Bouhinoune Tizi-Ouzou");
        Proprietaire P2 = new Proprietaire("Mister", "blue", "misterblue@gmail.com", "0641278932", "Al adjiba Bouira");
        Proprietaire P3 = new Proprietaire("Mister", "red", "misterred@gmail.com", "0541251311", "Tala-Mansour Tizi-Ouzou");
        Proprietaire P4 = new Proprietaire("Mister", "dark", "misterdark@gmail.com", "0645214782", "Draa Ben Khedda Tizi-Ouzou");
        Wilaya W1 = new Wilaya(15, "Tizi-Ouzou", 100000);
        Wilaya W2 = new Wilaya(10, "Bouira", 30000);
        Wilaya W3 = new Wilaya(16, "Alger", 60000 );
        Date D1 = new Date(10, 9, 2019);
        Date D2 = new Date(25, 7, 2014);
        Date D3 = new Date(19, 10, 2015);
        Date D4 = new Date(14, 2, 2013);
        Date D5 = new Date(25, 7, 2019);
        Date D6 = new Date(14, 4, 2016);
        Date D7 = new Date(30, 1, 2017);
        Date D8 = new Date(12, 12, 2014);
        Bien B1=new Appartement(P2,W2,"boulevard 1",D1,120,4000000,true,"Appartement chic","www.amd.com",Transaction.vente,W2,4,true,1,true,false,true);
        Bien B2 = new Maison(P1, W3,"boulevard 2", D2, 200, 10000000, true, "Maison de lux", "www.msi.com", Transaction.vente,W3, 3, true, 4, false, true, false);
        Bien B3 = new Terrain(P1, W1,"boulevard 3" ,D3, 500, 20000000, true, "Terrain litoral", "www.asus.com", Transaction.vente,W1, "en regle", 3);
        Bien B4=new Appartement(P2,W3,"boulevard 4",D4,100,40000,true,"Appartement moderne","www.acer.com",Transaction.location,W3,3,true,1,true,false,true);
        Bien B5 = new Maison(P3, W2,"boulevard 5", D5, 160, 150000, true, "Maison au bord de la mer", "www.dell.com", Transaction.location,W2, 3, true, 4, false, false, true);
        Bien B6=new Appartement(P2,W3,"boulevard 6",D6,50,60000,true,"Appartement modeste","www.hp.com",Transaction.location,W3,1,true,6,true,false,false);
        Bien B7 = new Terrain(P1, W1,"boulevard 7", D7, 650, 18000000, true, "Terrain fertil", "www.saphire.com", Transaction.echange,W3, "en regle", 1);
        Bien B8 = new Maison(P2, W2,"boulevard 8",D8,200, 14000000, true, "Ancienne maison", "www.radeon.com", Transaction.echange,W2, 3, true, 4, true, false, false);
        inserer_bien(B1);
        inserer_bien(B2);
        inserer_bien(B3);
        inserer_bien(B4);
        inserer_bien(B5);
        inserer_bien(B6);
        inserer_bien(B7);
        inserer_bien(B8);
    }
        
/********************************************************************************************************************************************************************/
/*Consultation du catalogue*/
    void consulter_liste_bien(){

        int i=0;
        System.out.println("+===============================================================================================================================+");
        System.out.println("|                                                  catalogue des biens                                                          |");
        for(i=0;i<liste.size();i++) {
            System.out.println("+===============================================================================================================================+");
            System.out.println("|                                                      Bien "+(i+1)+"                                                                   |");
            System.out.println("+===============================================================================================================================+");
        }
    }
/********************************************************************************************************************************************************************/
/*recherche d'un bien donnee*/
    public int recherche(String adresse) {
          int i=0,j=-1;
          Boolean trouve=false;
          while((i<liste.size())&& (trouve==false)){
              if((liste.get(i).getadresse().compareTo(adresse)==0)){
                 trouve=true;
                 j=i;
                }
            i++;
           }
      return j;
}
    public void consulter_bien(int indice){
        System.out.println("+===============================================================================================================================+");
        System.out.println("|                                                  consultation d'un bien                                                       |");
        System.out.println("+===============================================================================================================================+");
        if((indice > liste.size()+1)||(indice==0)) {
            System.out.println("                                       ERREUR ! Le  bien que vous recherchez n'existe pas !");
            System.out.println("+===============================================================================================================================+");
        }
        else {
            Bien B=liste.get(indice-1);
        }
    }
/********************************************************************************************************************************************************************/
/*Consultation des biens d'un proprietaire donné*/
    public void consulter_bien_proprio() {
        System.out.println("+===============================================================================================================================+");
        System.out.println("|                                       Consultation des biens d'un proprietaire                                                |");
        System.out.println("+===============================================================================================================================+");
        Scanner var =new Scanner(System.in);
        String nom,prenom;
        Boolean trouve=false;
        System.out.print("Nom : ");
        nom=var.nextLine();
        System.out.println("=============================");
        System.out.print("Prenom : ");
        prenom=var.nextLine();
        System.out.println("+===============================================================================================================================+");
        int i;
        for(i=0;i<liste.size();i++) {
            if((liste.get(i).getproprio().getnom().compareTo(nom)==0) &&(liste.get(i).getproprio().getprenom().compareTo(prenom)==0 )){
                System.out.println("+===============================================================================================================================+");
                System.out.println("|                                                      Bien "+(i+1)+"                                                                   |");
                System.out.println("+===============================================================================================================================+");
                trouve=true;
            }
        }
        if(trouve==false){
            System.out.println("|                                       ERREUR ! Le proprietaire ne possede aucun bien dans notre catalogue!                    |");
            System.out.println("+===============================================================================================================================+");
        }

    }
/********************************************************************************************************************************************************************/
/*Effectuer un recherche filtrée*/
    void filtre_recherche() {
    int i, j;
    int min, max;
    Boolean trouve = false;
    System.out.println("+===============================================================================================================================+");
    System.out.println("|    1)- Recherche selon le type du bien                                                                                       |");
    System.out.println("|    2)- Recherche selon la wilaya                                                                                             |");
    System.out.println("|    3)- Recherche selon le prix du metre carre                                                                                |");
    System.out.println("|    4)- Recherche selon la superficie                                                                                         |");
    System.out.println("|    5)- Recherche selon le prix                                                                                               |");
    System.out.println("|    6)- Recherche selon le prix negociable                                                                                    |");
    System.out.println("|    7)- Recherche selon le type de transaction                                                                                |");
    System.out.println("|    8)- Recherche selon le nombre minimal de pieces                                                                           |");
    System.out.println("+===============================================================================================================================+");
    System.out.print("     Introduisez votre choix  :  ");
    Scanner var = new Scanner(System.in);
    int choix = var.nextInt();
    System.out.println("+===============================================================================================================================+");
    String mot;
    int monchoix;
    switch (choix) {
        case 1: //recherche selon le type de transaction
            System.out.println("+===============================================================================================================================+");
            System.out.println("|    1)- Maison                                                                                                                 |");
            System.out.println("|    2)- Appartement                                                                                                            |");
            System.out.println("|    3)- Terrain                                                                                                                |");
            System.out.println("+===============================================================================================================================+");
            System.out.print("Choisissez le type de bien que vous desirez recherche : ");
            monchoix = var.nextInt();
            System.out.println("+===============================================================================================================================+");

            switch (monchoix) {
                case 1:
                    for (i = 0; i < liste.size(); i++) {
                        if (liste.get(i) instanceof Maison) {
                            System.out.println("+===============================================================================================================================+");
                            System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                            System.out.println("+===============================================================================================================================+");
                                                        trouve = true;
                        }
                    }
                break;
                case 2:
                    for (i = 0; i < liste.size(); i++) {
                        if (liste.get(i) instanceof Appartement) {
                            System.out.println("+===============================================================================================================================+");
                            System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                            trouve = true;
                        }
                    }
                break;
                case 3:
                    for (i = 0; i < liste.size(); i++) {
                        if (liste.get(i) instanceof Terrain) {
                            System.out.println("+===============================================================================================================================+");
                            System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                            System.out.println("+===============================================================================================================================+");
                            trouve = true;
                        }
                    }
                break;
                default:
                    System.out.println("|                                                  Choix valide !!!                                                             |");
                    System.out.println("+===============================================================================================================================+");
                    break;
            }
            break;

        case 2: //recherche selon la wilaya
            System.out.print("Donnez le numero de la wilaya a rechercher  :  ");
            j = var.nextInt();
            for (i = 0; i < liste.size(); i++) {
                if (liste.get(i).getnumwilaya() == j) {
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                }

            }
            break;
        /*====================================================================================================*/
        case 3: //recherche selon le prix du metre carre
            System.out.println("Donnez le prix maximal du metre carre :  ");
            j = var.nextInt();
            for (i = 0; i < liste.size(); i++) {
                if (liste.get(i).getprixmettrecarre() <= j) {
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                }

            }
            break;
        /*=====================================================================================================*/
        case 4: //recherche selon la superficie
            System.out.println("Donnez la superficie minimale  :  ");
            min = var.nextInt();
            System.out.println("Donnez la superficie maxiamle  :  ");
            max = var.nextInt();
            for (i = 0; i < liste.size(); i++) {
                if ((liste.get(i).getsuperficie() <= max) && (liste.get(i).getsuperficie() >= min)) {
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                    trouve = true;
                }

            }
            break;
        /*====================================================================================================*/
        case 5: //recherche selon le prix
            System.out.println("Donnez le prix minimale  :  ");
            min = var.nextInt();
            System.out.println("Donnez le prix maximale  :   ");
            max = var.nextInt();
            for (i = 0; i < liste.size(); i++) {
                if ((liste.get(i).getprix() <= max) && (liste.get(i).getprix() >= min)) {
                    trouve = true;
                }

            }
            break;

        /*====================================================================================================*/
        case 6: //recherche selon le prix negociable
            for (i = 0; i < liste.size(); i++) {
                if (liste.get(i).getnegociable() == true) {
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                    trouve = true;
                }

            }
            break;
        /*====================================================================================================*/
        case 7: //recherche selon le type de transaction
            System.out.println("+===============================================================================================================================+");
            System.out.println("|    1)- Acheter                                                                                                                |");
            System.out.println("|    2)- Louer                                                                                                                  |");
            System.out.println("|    3)- Echanger                                                                                                               |");
            System.out.println("+===============================================================================================================================+");
            System.out.print("Choisissez le type de transaction que vous voulez effectuer : ");
            monchoix = var.nextInt();
            System.out.println("+===============================================================================================================================+");
            Transaction T = Transaction.aucune;
            if (monchoix <= 3) {

                switch (monchoix) {
                    case 1: {
                        T = Transaction.vente;
                    }
                    break;
                    case 2: {
                        T = Transaction.location;
                    }
                    break;
                    case 3: {
                        T = Transaction.echange;
                    }
                    break;
                }

            } else {
                System.out.println("|                                                  Choix valide !!!                                                             |");
                System.out.println("+===============================================================================================================================+");

            }

            for (i = 0; i < liste.size(); i++) {
                if (liste.get(i).getransaction() == T) {
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                    trouve = true;
                }

            }
            break;
        case 8 :
            System.out.println("Donnez le nombre de pieces minimale  :  ");
            min = var.nextInt();
            for (i = 0; i < liste.size(); i++) {
                if ((liste.get(i) instanceof Terrain !=true)&&(liste.get(i).getnbpieces()>=min) ){
                    System.out.println("+===============================================================================================================================+");
                    System.out.println("|                                                      Bien " + (i + 1) + "                                                                   |");
                    System.out.println("+===============================================================================================================================+");
                    trouve = true;
                }

            }
            break;

        /*====================================================================================================*/
        default:
            System.out.println("|                                                  Choix valide !!!                                                             |");
            System.out.println("+===============================================================================================================================+");
            break;
    }
    if (trouve == false) {
        System.out.println("|                                  Aucun bien ne correspond a vos specification !!!                                             |");
        System.out.println("+===============================================================================================================================+");
    }
}
/********************************************************************************************************************************************************************/
/*modifier les donnees d'un bien donnee*/
    public void modifier_bien() {
    Scanner var=new Scanner(System.in);
    Scanner str=new Scanner(System.in);
    String reponse,adresse_exacte,nvdescription;
    Boolean nvnegociable;
    double superficie,nvprix;
    System.out.print("Donnez l adresse exacte de votre bien  :  ");
    adresse_exacte=str.nextLine();
    System.out.println("+===============================================================================================================================+");
    int pos=recherche(adresse_exacte);
    if(pos==-1) {
        System.out.println("                                       ERREUR ! Le  bien que vous recherchez n'existe pas !");
        System.out.println("+===============================================================================================================================+");
    }
    else {
        System.out.print("Voulez modifier le prix | repondez par oui ou non  :  ");
        reponse=str.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("nouveau prix : ");
            nvprix=var.nextDouble();
            liste.get(pos).setprix(nvprix);
            var.nextLine();
            System.out.println("+===============================================================================================================================+");
        }
        /*==================================================================================================================*/
        System.out.print("Voulez modifier la negociabilité prix | repondez par oui ou non  :  ");
        reponse=str.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("Negociable  : ");
            nvnegociable = affect_booleen(str.nextLine());
            liste.get(pos).setnegociable(nvnegociable);
            System.out.println("+===============================================================================================================================+");
        }
        /*==================================================================================================================*/
        System.out.print("Voulez modifier la description de votre bien | repondez par oui ou non  :  ");
        reponse=str.nextLine();
        if(reponse.compareTo("oui")==0) {
            System.out.print("Descriptif  : ");
            nvdescription=str.nextLine();
            liste.get(pos).setdescriptif(nvdescription);
            System.out.println("+===============================================================================================================================+");
        }
        /*=================================================================================================================*/
        System.out.print("Voulez modifier le type de transaction de votre bien | repondez par oui ou non  :  ");
        reponse=var.nextLine();
        if(reponse.compareTo("oui")==0) {
            int choix;
            System.out.println("+===============================================================================================================================+");
            System.out.println("|    1)- Vente                                                                                                                  |");
            System.out.println("|    2)- Location                                                                                                               |");
            System.out.println("|    3)- Echange                                                                                                                |");
            System.out.println("+===============================================================================================================================+");
            System.out.print("     Introduisez votre choix  :  ");
            choix=var.nextInt();
            Transaction T= liste.get(pos).getransaction();
            if (choix<=3){
                switch(choix)
                {
                    case 1:
                    {
                        T=Transaction.vente;
                    }
                    break;
                    case 2:
                    {
                        T=Transaction.location;
                    }break;
                    case 3:
                    {
                        T=Transaction.echange;
                    }
                    break;
                }
                liste.get(pos).setTransaction(T);
                System.out.println("+===============================================================================================================================+");
            }
            else
            {
                System.out.println("|                                                  Choix valide !!!                                                             |");
                System.out.println("+===============================================================================================================================+");
            }
        }
        /*=================================================================================================================*/
        liste.get(pos).modifier();
    }
}
/********************************************************************************************************************************************************************/
/*Supprimer un bien du catalogue*/
    public void supprimer_bien() {
        Scanner var=new Scanner(System.in);
        System.out.println("+===============================================================================================================================+");
        System.out.print("Donnez l adresse exacte du bien a supprimer  :  ");
        String adresse=var.nextLine();
        System.out.println("+===============================================================================================================================+");
        int pos=recherche(adresse);
        if(pos==-1) {
            System.out.println("                                       ERREUR ! Le  bien que vous recherchez n'existe pas !");
            System.out.println("+===============================================================================================================================+");
        }
        else {
            consulter_bien(pos+1);
            System.out.print("Etes vous sur de supprimer difinitivement le bien | Repondez par oui ou non :  ");
            String reponse=var.nextLine();
            if(affect_booleen(reponse)==true){
                archiver_bien(liste.get(pos));
                liste.remove(pos);
            }
        }
    }
/********************************************************************************************************************************************************************/
/* Inserer un nouveau bien*/
    public Boolean inserer_bien(Bien A) {
        int j=0;
        Boolean inser=false;
        j=recherche(A.getadresse());
        if(j==-1){
            liste.add(A);
            inser=true;
            Collections.sort(liste);
        }
        else {
            System.out.println("+===============================================================================================================================+");
            System.out.println("|                                   ERREUR ! Le bien que vous voulez inserer existe deja !                                      |");
            System.out.println("+===============================================================================================================================+");
        }
        return(inser);
    }
/********************************************************************************************************************************************************************/
 /*Archiver une bien */
    public void archiver_bien(Bien A) { archive.add(A); }
    public void inserer_bien_archive(){
    Scanner var=new Scanner(System.in);
    System.out.println("+===============================================================================================================================+");
    System.out.println(" Veillez consultez d abord le catalogue pour selctionner le bien que vous voulez :  \n");
    consulter_liste_bien();
    System.out.println("+===============================================================================================================================+");
    System.out.print(" Donnez le numero du bien que vous voulez selectionner  : ");
    int indice =var.nextInt();
        Bien B=liste.get(indice-1);
        archiver_bien(B);
        liste.remove(indice-1);
}
/********************************************************************************************************************************************************************/
/*Consulter les archives*/
    public void consulter_archive() {
        int i;
        Boolean trouve=false;
        System.out.println("+===============================================================================================================================+");
        System.out.println("|                                                    Les archives                                                               |");
        if(archive.size()!=0){
            for(i=0;i<archive.size();i++) {
                System.out.println("+===============================================================================================================================+");
                System.out.println("|                                                      Bien "+(i+1)+"                                                                    |");
                System.out.println("+===============================================================================================================================+");
            }
        }
        else{
            System.out.println("+===============================================================================================================================+");
            System.out.println("|                                              ERREUR ! Les archives sont vides !                                               |");
            System.out.println("+===============================================================================================================================+");
        }
    }
/********************************************************************************************************************************************************************/
/*Les methodes de calcul de prix*/
    public void calcul_prix_finaux() {
    int i;
    Transaction T;
    for(i=0;i<liste.size();i++) {

        T=liste.get(i).getransaction();
        if(T==Transaction.vente)
        {
            System.out.println("=========================================================");
            System.out.println("le prix final de vente est :" +liste.get(i).calcul_prix_vente());
            System.out.println("=========================================================");
        }
        else
        {
            if(T==Transaction.location)
            {
                System.out.println("=========================================================");
                System.out.println(" le prix final de location est :" +liste.get(i).calcul_prix_location());
                System.out.println("=========================================================");
            }
            else
            {
                System.out.println("=========================================================");
                System.out.println("le prix final d'echange est :" +liste.get(i).calcul_prix_echange());
                System.out.println("=========================================================");
            }
        }
    }
}
    public void calcul_prix_final_change() throws Erreur_indice_invalid{
    	Scanner var=new Scanner(System.in);
    	Transaction T;
        System.out.println("+===============================================================================================================================+");
        System.out.println(" Veillez consultez d abord le catalogue pour selctionner le bien que vous voulez :  \n");
        consulter_liste_bien();
        System.out.println("+===============================================================================================================================+");
       try {
        System.out.print(" Donnez le numero du bien que vous voulez selectionner  : ");
        int indice =var.nextInt();
        if(indice > liste.size()) {
               throw new Erreur_indice_invalid();
        }
        else {
            Bien B=liste.get(indice-1);
            T=B.getransaction();
            if(T==Transaction.vente)
            {
                System.out.println("=========================================================");
                System.out.println("le prix final de vente est :" +B.calcul_prix_vente());
                System.out.println("=========================================================");
            }
            else
            {
                if(T==Transaction.location)
                {
                    System.out.println("=========================================================");
                    System.out.println(" le prix final de location est :" +B.calcul_prix_location());
                    System.out.println("=========================================================");
                }
                else
                {
                    System.out.println("===========================================================");
                    System.out.println("le prix final d'echange est :" +B.calcul_prix_echange());
                    System.out.println("===========================================================");
                }
            }
       }
       }catch(Erreur_indice_invalid e) {
    	   System.out.println("|                                      ERREUR ! L'indice saisie est invalid !                                                   |");
           System.out.println("+===============================================================================================================================+");
    	   
       }
    }

    public void ajouter_message(Message A) throws Erreur_indice_invalid{
        Boite.add(A);
        System.out.println("+===============================================================================================================================+");
        System.out.println("|                                         Message   bien ajouté dans la boite de reception                                           |");
        System.out.println("+===============================================================================================================================+");
    }
    /*Laisse un message dans la boite de reception*/
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
/********************************************************************************************************************************************************************/
}  