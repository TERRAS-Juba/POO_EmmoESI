package Noyau;
import java.io.Serializable;
import java.util.Scanner;
public class Message implements Serializable{
    private String Message;
    private String Nom;
    private String Prenom;
    private Date date;
    private String adresse;
    Bien bien;
/**************************************************************************************************************************************************************/
public Message(String Nom,String Prenom,String adresse,String Message) {
	this.Nom=Nom;
	this.Prenom=Prenom;
	this.adresse=adresse;
	this.Message=Message;
}
/**************************************************************************************************************************************************************/
public String getmessage(){return Message;}
public String getnom(){return Nom;}
    public String getprenom(){return Prenom;}
    public String getadresse() {
    	return adresse;
    }
}