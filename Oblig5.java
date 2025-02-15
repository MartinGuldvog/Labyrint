import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Oblig5 {
    public static void main(String[] args) {
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
                               +"java Oblig5 <labyrintfil>");
            return;
        }
        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
            l.skrivUt();
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }

        // les start-koordinater fra standard input
        Scanner inn = new Scanner(System.in);
        System.out.println("Skriv inn koordinater <kolonne> <rad> ('a' for aa avslutte)");
        String[] ord = inn.nextLine().split(" ");
        while (!ord[0].equals("a")) {

            try {
                int startKol = Integer.parseInt(ord[1]);
                int startRad = Integer.parseInt(ord[0]);

                Liste<String> utveier = l.finnUtveiFra(startRad, startKol);
                if (utveier.stoerrelse() != 0) {
                    int teller = 1;
                    for (String s : utveier) {
                        System.out.println("\nUtvei " + Integer.toString(teller) + ": " + s + "\n");
                        teller++;
                    }
                    System.out.println(l.finnKortesteUtvei());
                    l.nullStillHelt();
                } else {
                    System.out.println("Ingen utveier.");
                }
                System.out.println();
            } catch (NumberFormatException e) {
                System.out.println("Ugyldig input!");
            }
            System.out.println("Skriv inn nye koordinater ('a' for aa avslutte)");
            ord = inn.nextLine().split(" ");
        }
    }
}
