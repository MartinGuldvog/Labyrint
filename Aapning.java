class Aapning extends HvitRute{

    public Aapning(int rad, int kolonne, Labyrint l){
        super(rad,kolonne, l);
    }

    @Override
    public char tilTegn(){
        return '.';
    }

    public String toString() {
        return ".";
    }

    @Override
    public boolean erAapning(){
        return true;
    }

    @Override
    public void gaa(String s){
        s +=  "(" + Integer.toString(rad) + ", " + Integer.toString(kolonne) + ")";
        utveier.leggTil(s);
    }
}
