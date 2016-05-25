package services.data;

import protocol.ReponseService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 25/05/16.
 */
public class ReponseServiceCook implements ReponseService, Serializable {
    List<Cuisinier> cuisiniers;

    public ReponseServiceCook(){
        cuisiniers= new ArrayList<>();
    }

    @Override
    public String getInfo() {
        return "Cette application vous permet de trouver des particuliers pouvant cuisiner pour vous à proximité. \n Vous pouvez: -Récupérer la liste des cuisiniers \n -Ajouter un cuisinier.";
    }

    public String getStringCuisiniers(){
        String res = "";
        for (Cuisinier c: cuisiniers){
            res+= "-->"+ cuisiniers;
        }
        return res;
    }

    public List<Cuisinier> getAllCuisiniers(){
        return cuisiniers;
    }

    public void addCuisinier(Cuisinier c){
        cuisiniers.add(c);
    }

}
