import java.util.*;
import java.io.*;

public class Labyrint{

    private Rute[][] labyrint;
    private int rader;
    private int kolonner;
    private Lenkeliste<String> utveier;


    private Labyrint(Rute[][] labyrint, int rader, int kolonner){
        this.labyrint = labyrint;
        this.rader = rader;
        this.kolonner = kolonner;
    }

    public Rute[][] hentLabyrint(){
        return this.labyrint;
    }

    public int antallRader(){
        return this.rader;
    }

    public int antallKolonner(){
        return this.kolonner;
    }

    public static Labyrint lesFraFil(File fil) throws FileNotFoundException{
        Scanner inndata = new Scanner(fil);

        int rader = inndata.nextInt();
        int kolonner = inndata.nextInt();

        String linje = inndata.nextLine();

        Rute[][] labyrinten = new Rute[rader][kolonner];

        Labyrint ny = new Labyrint(labyrinten, rader, kolonner);

        for(int i=0; i < labyrinten.length; i++) {
            linje = inndata.nextLine();
            char[] biter = linje.toCharArray();

            for(int j=0; j < labyrinten[i].length; j++){
                    char tegn = biter[j];

                    if (tegn == '#'){
                        SortRute rute = new SortRute(i,j, ny);
                        labyrinten[i][j] = rute;
                    }
                    else if (tegn == '.'){
                        if (i == 0 || j== 0 || i == rader -1 || j == kolonner -1){
                            Aapning rute = new Aapning(i,j, ny);
                            labyrinten[i][j] = rute;
                        }else{
                            HvitRute rute = new HvitRute(i,j, ny);
                            labyrinten[i][j] = rute;
                        }
                    }
            }
        }
        sjekkOgSettInnNaboer(labyrinten, rader, kolonner);
        return ny;
    }

    public Liste<String> finnUtveiFra(int rad, int kolonne){
        nullStill();
        Rute r = labyrint[rad][kolonne];
        r.finnUtveiN();
        nullStill();
        r.finnUtveiS();
        nullStill();
        r.finnUtveiV();
        nullStill();
        r.finnUtveiO();
        nullStill();
        this.utveier = r.hentUtveier();
        return this.utveier;
    }

    public String finnKortesteUtvei(){
        String korteste = this.utveier.hent(0);
        for (String s : this.utveier){
            if (s.split(" ").length < korteste.split(" ").length){
                korteste = s;
            }
        }
        return korteste;
    }

    public void nullStill(){
        // this.utveier = new Lenkeliste<String>();

        for(int i=0; i < labyrint.length; i++) {
            for(int j=0; j < labyrint[i].length; j++) {
                Rute denne = labyrint[i][j];
                denne.nullStill();
            }
        }
    }

    public void nullStillHelt(){
        this.utveier = new Lenkeliste<String>();

        for(int i=0; i < labyrint.length; i++) {
            for(int j=0; j < labyrint[i].length; j++) {
                Rute denne = labyrint[i][j];
                denne.nullStillHelt();
            }
        }
    }

    public Labyrint hent(){
        return this;
    }

    public Rute hentRute(int x, int y){
        return labyrint[x][y];
    }

    public static void sjekkOgSettInnNaboer(Rute[][] liste, int rader, int kolonner){
        for(int i=0; i < liste.length; i++) {
            for(int j=0; j < liste[i].length; j++){
                Rute denne = liste[i][j];

                if (i > 0){
                    denne.leggTilNord(liste[i-1][j]);
                }
                if (j > 0){
                    denne.leggTilVest(liste[i][j-1]);
                }
                if (j < kolonner -1){
                    denne.leggTilOst(liste[i][j+1]);
                }
                if (i < rader -1){
                    denne.leggTilSyd(liste[i+1][j]);
                }
            }
        }
    }

    public void skrivUt(){
        for(int i=0; i < labyrint.length; i++) {
            System.out.println("");
            for(int j=0; j < labyrint[i].length; j++) {
                System.out.print(labyrint[i][j] + " ");
            }
        }System.out.println("\n");
    }

}
