package services.data;

/**
 * Created by user on 25/05/16.
 */
public class Cuisinier {
    String nom;
    String prenom;
    String adresse;

    public Cuisinier(String nom, String prenom, String adresse){
        this.nom= nom;
        this.prenom= prenom;
        this.adresse= adresse;
    }

    public String toString(){
        return " -Nom: "+ nom + "- Prénom: "+ prenom+"- Adresse: "+ adresse;
    }
}
