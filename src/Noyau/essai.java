package Noyau;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class essai implements Serializable {
    public ArrayList<Bien> liste=new ArrayList<Bien>();
    public ArrayList<Bien> archive=new ArrayList<Bien>();
    public ArrayList<Message> boite=new ArrayList<Message>();
	public essai(){
	 
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
        liste.add(B1);
        liste.add(B2);
        liste.add(B3);
        liste.add(B4);
        liste.add(B5);
        liste.add(B6);
        liste.add(B7);
        liste.add(B8);
        Collections.sort(liste);
	}
	 public ArrayList rech_proprio(String nom, String prenom) throws IOException, ClassNotFoundException {
          ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
          essai agence=(essai)in.readObject();
	    	ArrayList<Integer> l=new ArrayList <Integer>();
	        int i;
	        for(i=0;i<agence.liste.size();i++) {
	            if((((Bien) agence.liste.get(i)).getproprio().getnom().compareTo(nom)==0) &&(((Bien) agence.liste.get(i)).getproprio().getprenom().compareTo(prenom)==0 )){
	               l.add(i);  
	            }
	        }
	        in.close();
	    return l;
	    }
	 public int recherche(String adresse) throws IOException, ClassNotFoundException {
         int i=0,j=-1;
          ObjectInputStream in=new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("Gestion.dat"))));
          essai agence=(essai)in.readObject();
         Boolean trouve=false;
         while((i<liste.size())&& (trouve==false)){
             if((((Bien) liste.get(i)).getadresse().compareTo(adresse)==0)){
                trouve=true;
                j=i;
               }
           i++;
          }
         in.close();
     return j;
}
	 public Boolean supprimer(String adresse) throws IOException, ClassNotFoundException {
	       Boolean supp;
	        int pos=recherche(adresse);
	        if(pos==-1) {
	           supp=false;
	        }
	        else {
	                liste.remove(pos);
	               supp= true;
	            }
	        return supp;
	    }
    public Boolean archiver(String adresse) throws IOException, ClassNotFoundException {
        Boolean supp;
        int pos=recherche(adresse);
        if(pos==-1) {
            supp=false;
        }
        else {
            Bien a=(Bien)liste.get(pos);
            archive.add(a);
            liste.remove(pos);
            supp= true;
        }
        return supp;
    }
}


