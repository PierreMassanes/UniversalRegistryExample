package services.data;

import protocol.Donnee;

import java.io.Serializable;

/**
 * Created by user on 25/05/16.
 */
public class DonneeCook implements Donnee, Serializable{
    String recette;

    public DonneeCook(String recette){
        this.recette= recette;
    }

    @Override
    public String toString(){
        return recette;
    }
}
