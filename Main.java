import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Anna sanat sisaltavan tiedoston nimi >");
        String osoite = in.nextLine();
        System.out.print("Anna arvauksien maara >");
        int maara = readInt();
        Hirsipuu hi = new Hirsipuu(osoite,maara);

        while(hi.getArvMaara() > 0 && !hi.onLoppu()) {
            hi.arvaa(lueChar(hi));
            if (!hi.onLoppu() && hi.getArvMaara() > 0) {
                System.out.println("Arvauksia jäljellä: " + hi.arvauksiaOnJaljella());
            }
        }
        if (hi.onLoppu()) {
            System.out.println("Voitit pelin!");
        } else System.out.println("Hävisit pelin!");
        System.out.println("Arvattava sana oli " + hi.sana());
        System.out.println("Tassa viela arvauksesi:");
        for (int j = 0; j < hi.arvaukset().size(); j++) {
            System.out.println(hi.arvaukset().get(j));
        }
    }

    public static char lueChar(Hirsipuu hi) {
        System.out.print("Sana: ");
        for (int i = 0; i < hi.getSanaTaulu().length; i++) {
            if (hi.getSanaStatus()[i] != 0) {
                System.out.print(hi.getSanaTaulu()[i]);
            } else System.out.print("*");
        }
        System.out.println();
        System.out.print("Syötä arvauksesi >");
        Scanner in = new Scanner(System.in);
        boolean t = false;
        String txt;
        do {
            txt = in.nextLine();
            if (!(txt == null) && !txt.isEmpty() && !(txt.length() > 1) && txt.matches("[a-zA-Z]"))
                t = true;
            else System.out.print("Virheellinen syotto, kokeile uusiksi >");
        }
        while(!t);
        char txtChar = txt.charAt(0);
        txtChar = Character.toUpperCase(txtChar);
        return txtChar;
    }

    public static Integer readInt() {
        Scanner in = new Scanner(System.in);
        boolean t = false;
        String numStr;
        int num = 0;
        do {
            int i = 0;
            try {
                numStr = in.nextLine();
                num = Integer.parseInt(numStr);
                t = true;
            }
            catch(NumberFormatException | NullPointerException nfe){
                System.out.print("Virheellinen syotto, kokeile uusiksi >");
                i = 1;
            }
            if(num < 0 && i == 0)
                System.out.print("Virheellinen syotto, kokeile uusiksi >");
        }
        while(!t || num < 0);
        return num;
    }
}
