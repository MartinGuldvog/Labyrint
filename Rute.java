import java.util.ArrayList;

public abstract class Rute{

    private int rad, kolonne;
    private Labyrint lab;
    private Rute nord, syd, ost, vest;
    private boolean ubrukt = true;
    private static Lenkeliste<String> utveier = new Lenkeliste<String>();
    private static String utvei;


    public Rute(int rad, int kolonne, Labyrint l){
        this.rad = rad;
        this.kolonne = kolonne;
        this.lab = l;
    }

    public void gaaN(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";

        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }

        if (this.tilTegn() == '#'){
            return;
        }

        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaaN(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaaN(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaaN(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaaN(utvei);
        }

        ubrukt = true;
    }
    public void gaaS(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";

        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }

        if (this.tilTegn() == '#'){
            return;
        }

        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaaS(utvei);
        }
        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaaS(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaaS(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaaS(utvei);
        }

        ubrukt = true;
    }
    public void gaaV(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";

        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }

        if (this.tilTegn() == '#'){
            return;
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaaV(utvei);
        }

        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaaV(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaaV(utvei);
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaaV(utvei);
        }

        ubrukt = true;
    }
    public void gaaO(String s){
        ubrukt = false;
        this.utvei = s;
        utvei +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ") --> ";

        if (this.erAapning()){
            utvei = utvei.substring(0, utvei.length() - 4);
            utveier.leggTil(utvei);
            // utvei = "";
        }

        if (this.tilTegn() == '#'){
            return;
        }
        if (ost != null && ost.tilTegn() == '.' && ost.ubrukt()){
            ost.gaaO(utvei);
        }

        if (nord != null && nord.tilTegn() == '.' && nord.ubrukt()){
            nord.gaaO(utvei);
        }
        if (syd != null && syd.tilTegn() == '.' && syd.ubrukt()){
            syd.gaaO(utvei);
        }
        if (vest != null && vest.tilTegn() == '.' && vest.ubrukt()){
            vest.gaaO(utvei);
        }

        ubrukt = true;
    }

    public void finnUtveiN(){
        this.gaaN(utvei);
    }

    public void finnUtveiS(){
        this.gaaS(utvei);
    }

    public void finnUtveiV(){
        this.gaaV(utvei);
    }

    public void finnUtveiO(){
        this.gaaO(utvei);
    }

    public Lenkeliste<String> hentUtveier(){
        return this.utveier;
    }

    public void nullStill(){
        this.ubrukt = true;
        this.utvei = new String();
        // this.utveier = new Lenkeliste<String>();
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
