package services.data;

import protocol.ReponseService;

import java.io.Serializable;

/**
 * Created by user on 06/05/16.
 */
public class Test implements ReponseService, Serializable {
    int i;
    String s;

    public Test(int i, String s){
        this.i=i;
        this.s=s;
    }

    @Override
    public String getInfo() {
        return i+s;
    }
}
