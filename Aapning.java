class Aapning extends HvitRute{

    public Aapning(int rad, int kolonne){
        super(rad,kolonne);
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
}
