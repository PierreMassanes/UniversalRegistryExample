package data;

/**
 * Created by user on 06/05/16.
 */
public class Test implements ReponseService {
    int i;
    String s;

    public Test(int i, String s){
        this.i=i;
        this.s=s;
    }

    @Override
    public String getInfo() {
        return null;
    }
}
