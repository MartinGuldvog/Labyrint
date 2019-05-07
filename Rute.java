import java.util.ArrayList;

public abstract class Rute{

    private int rad, kolonne;
    private Labyrint lab;
    private Rute nord, syd, ost, vest;
    private boolean ubrukt = true;
    private static Lenkeliste<String> utveier = new Lenkeliste<String>();
    private static String utvei;


    public Rute(int rad, int kolonne){
        this.rad = rad;
        this.kolonne = kolonne;
    }

    public void gaa(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";

        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            utvei = "";
        }

        if (this.tilTegn() == '#'){
            return;
        }

        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaa(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaa(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaa(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaa(utvei);
        }

        ubrukt = true;
    }

    public void finnUtvei(){
        this.gaa(utvei);
    }

    public Lenkeliste<String> hentUtveier(){
        return this.utveier;
    }

    public void nullStill(){
        this.ubrukt = true;
        this.utvei = new String();
        this.utveier = new Lenkeliste<String>();
    }

    public int hentRad(){
        return this.rad;
    }
    public int hentKolonne(){
        return this.kolonne;
    }


    public boolean ubrukt(){
        return this.ubrukt;
    }
    public void leggTilNord(Rute nabo){
        this.nord = nabo;
    }
    public void leggTilSyd(Rute nabo){
        this.syd = nabo;
    }
    public void leggTilOst(Rute nabo){
        this.ost = nabo;
    }
    public void leggTilVest(Rute nabo){
        this.vest = nabo;
    }

    public Rute hentNaboNord(){
        return this.nord;
    }
    public Rute hentNaboSyd(){
        return this.syd;
    }
    public Rute hentNaboOst(){
        return this.ost;
    }
    public Rute hentNaboVest(){
        return this.vest;
    }

    public abstract char tilTegn();

    public boolean erAapning(){
        return false;
    }
}
