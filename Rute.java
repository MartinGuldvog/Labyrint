import java.util.ArrayList;

public abstract class Rute{

    protected int rad, kolonne;
    protected Labyrint lab;
    protected Rute nord, syd, ost, vest;
    protected boolean ubrukt = true;
    protected Rute[] naboer = new Rute[4];
    protected static Lenkeliste<String> utveier = new Lenkeliste<String>();
    protected String utvei;


    public Rute(int rad, int kolonne, Labyrint l){
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = l;
    }

    public void gaa(String s){
        settNaboer();
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";
        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            return;
        }
        if (this.tilTegn() == '#'){
            return;
        }
        for (Rute r : this.naboer){
            if (r != null && r.tilTegn() == '.' && r.ubrukt()){
                r.gaa(utvei);
            }
        }
        ubrukt = true;
    }

    public void settNaboer(){
        this.naboer[0] = this.nord;
        this.naboer[1] = this.syd;
        this.naboer[2] = this.ost;
        this.naboer[3] = this.vest;
    }

    public void finnUtvei(){
        this.gaa(utvei);
    }

    public Lenkeliste<String> hentUtveier(){
        return this.utveier;
    }

    public void settUbrukt(){
        this.ubrukt = true;
    }

    public void nullStill(){
        this.ubrukt = true;
        this.utvei = new String();
    }

    public void nullStillHelt(){
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

    public abstract char tilTegn();

    public boolean erAapning(){
        return false;
    }
}
