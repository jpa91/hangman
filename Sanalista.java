import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class Sanalista {

    private ArrayList<String> sanat;

    public Sanalista(String osoite) {
        this.sanat = new ArrayList<String>();

        Charset utf8 = Charset.forName("UTF-8");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(osoite), utf8))) {
            String rivi;
            while( (rivi = br.readLine()) != null ){
                sanat.add(rivi);
                //System.out.println("Luettiin: " + rivi);
            }
        }
        catch( IOException ioe ){
            System.out.println("Virhe lukemisessa");
            ioe.printStackTrace();
        }
    }

    public Sanalista() {
        this.sanat = new ArrayList<String>();
    }

    public List<String> annaSanat(){
        return sanat;
    }

    public ArrayList<String> getSanat(){
        return sanat;
    }

    void setSanat(ArrayList<String> sanat) {
        this.sanat = sanat;
    }
}
