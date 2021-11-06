package Noyau;
import java.util.*;
public class Administrateur {
    private String id  ;
    private  static String mot_de_passe ;
    private String nom ;
    private String prenom;
/**************************************************************************************************************************************************************/
    public  Administrateur(String id,String mot_de_passe,String nom,String prenom)
    {
        this.id=id;
        this.mot_de_passe=mot_de_passe;
        this.nom=nom;
        this.prenom=prenom;
    }
/**************************************************************************************************************************************************************/
    public Boolean authentifier (String id,String mot_de_passe)
    {
        Boolean connect=false;

        if ((this.id.equals( id)==true)&&(this.mot_de_passe.equals(mot_de_passe))==true)
        {
            connect=true;
        }
        return connect;
    }
/**************************************************************************************************************************************************************/
}
