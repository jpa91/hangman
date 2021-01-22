import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Hirsipuu {
/*
sana = Arvattava sana
sanaTaulu = Arvattavan sanan kirjaimet taulukossa
sanaStatus = Oikein arvattujen kirjainten indeksi (1 jos arvattu, 0 muuten)
arvMaara = Jäljellä olevien arvausten määrä
 */

    private ArrayList<Character> arvaukset;
    private char[] sanaTaulu;
    private int[] sanaStatus;
    private int arvMaara;
    private Sanalista sanat;
    private String sana;

    public Hirsipuu(String osoite, int arvMaara) {
        this.arvaukset = new ArrayList<Character>();
        this.sanat = new Sanalista(osoite);
        Random rand = new Random();
        this.sana = sanat.annaSanat().get(rand.nextInt(sanat.annaSanat().size()));
        this.sanaTaulu = sana.toCharArray();
        this.sanaStatus = new int[sanaTaulu.length];
        this.arvMaara = arvMaara;
    }

    public Hirsipuu() {
        this.arvaukset = new ArrayList<Character>();
        this.sanat = null;
        this.sana = null;
        this.sanaTaulu = null;
        this.sanaStatus = null;
        this.arvMaara = 1;
    }

    public boolean arvaa(Character merkki) {
        int oikein = 0;
        for(int i = 0; i < sanaTaulu.length; i++) {
            // Onko merkki jo arvattu oikein?
            if(sanaStatus[i] != 1 && oikein == 0) {
                if(merkki == sanaTaulu[i]) {
                    sanaStatus[i] = 1;
                    oikein = 1;
                    System.out.println("Oikein!");
                }
            }
        }
        arvaukset.add(merkki);
        if(oikein == 0) {
            arvMaara--;
            System.out.println("Väärin!");
        }
        return true;
    }

    public boolean onLoppu() {
        boolean loppu = true;
        for (int i = 0; i < sanaTaulu.length; i++) {
            if (sanaStatus[i] == 0) {loppu = false;}
        }
        return loppu;
    }

    public int arvauksiaOnJaljella() {
        return arvMaara;
    }

    public String sana() {
        return sana;
    }

    public List<Character> arvaukset() {
        return arvaukset;
    }

    // Getterit ---------------------------------
    public ArrayList<Character> getArvaukset() {
        return arvaukset;
    }

    public char[] getSanaTaulu() {
        return sanaTaulu;
    }

    public int[] getSanaStatus() {
        return sanaStatus;
    }

    public int getArvMaara() {
        return arvMaara;
    }

    public Sanalista getSanat() {
        return sanat;
    }

    public String getSana() {
        return sana;
    }

    // Setterit ---------------------------------

    public void setArvaukset(ArrayList<Character> arvaukset) {
        this.arvaukset = arvaukset;
    }

    public void setSanaTaulu(char[] sanaTaulu) {
        this.sanaTaulu = sanaTaulu;
    }

    public void setSanaStatus(int[] sanaStatus) {
        this.sanaStatus = sanaStatus;
    }

    public void setArvMaara(int arvMaara) {
        this.arvMaara = arvMaara;
    }

    public void setSanat(Sanalista sanat) {
        this.sanat = sanat;
    }

    public void setSana(String sana) {
        this.sana = sana;
    }

}
