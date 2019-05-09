public class HvitRute extends Rute {


    public HvitRute(int rad, int kolonne, Labyrint l){
        super(rad,kolonne, l);
    }

    @Override
    public char tilTegn(){
        return '.';
    }

    public String toString() {
        return ".";
    }

    public boolean erAapning(){
        return false;
    }
}
