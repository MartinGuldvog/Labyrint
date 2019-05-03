public class HvitRute extends Rute {


    public HvitRute(int rad, int kolonne){
        super(rad,kolonne);
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
