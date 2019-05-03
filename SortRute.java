public class SortRute extends Rute {


    public SortRute(int rad, int kolonne){
        super(rad,kolonne);
    }

    @Override
    public char tilTegn(){
        return '#';
    }

    public String toString() {
        return "#";
    }

    public boolean erAapning(){
        return false;
    }
}
