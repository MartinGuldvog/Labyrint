import java.util.*;
import java.io.*;

public class Test{

    public static void main(String[] args) {
        File fil = new File("4.in");
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra fil\n");
            System.exit(1);
        }
        l.skrivUt();

        Liste<String> utveier = l.finnUtveiFra(1, 17);
        if (utveier.stoerrelse() > 0){
            int teller = 1;
            for (String s : utveier){
                System.out.println("\nUtvei " + teller + ": " + s + "\n");
                teller++;
            }
        }else {
            System.out.println("Ingen utveier.");
        }
    }
}
