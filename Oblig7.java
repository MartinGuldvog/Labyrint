import javafx.application.Application;
import javafx.application.Platform;
import java.io.File;
import java.io.FileNotFoundException;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.scene.control.ScrollPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.util.Random;

public class Oblig7 extends Application {
    public Labyrint labyrint;
    private int rader;
    private int kolonner;
    private Rute[][] temp;
    public Firkant[][] ruter;
    public TextArea tekstfelt = new TextArea();
    public int koordinatR, koordinatK;
    public Liste<String> utveiene;
    private static int nesteTeller;

    public void start(Stage teater){
        this.labyrint = leggTilLabyrint(teater);
        this.rader = labyrint.antallRader();
        this.kolonner = labyrint.antallKolonner();
        this.temp = labyrint.hentLabyrint();

        GridPane rutenett = new GridPane();
        Scene scene = new Scene(rutenett);
        this.ruter = settOppBrett();

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                rutenett.add(ruter[i][j], j, i);
            }
        }

        tekstfelt.setPrefRowCount(1);
        tekstfelt.setPrefSize(130,20);
        tekstfelt.setText("Trykk på en hvit rute for aa starte!");
        rutenett.add(tekstfelt,0,this.rader +1, labyrint.antallKolonner(),1);

        Button knapp1 = new Button("Annen utvei");
        knapp1.setOnAction(e-> finnAnnenUtvei(koordinatR,koordinatK));

        Button knapp2 = new Button("Restart");
        knapp2.setOnAction(e->{
            Oblig7 program = new Oblig7();
            labyrint.nullStillHelt();
            program.start(teater);});

        Button knapp3 = new Button("Stop");
        knapp3.setOnAction(e -> Platform.exit());

        HBox knapper = new HBox(knapp1, knapp2, knapp3);
        knapper.setPrefSize(130,20);
        rutenett.add(knapper, 0,this.rader +2, labyrint.antallKolonner(),1);
        rutenett.setHalignment(knapper, HPos.CENTER);
        // rutenett.setPrefSize(150,130);

        teater.setScene(scene);
        teater.setTitle("Oblig7");
        teater.show();
    }

    private Firkant[][] settOppBrett() {
        Firkant[][] ruter = new Firkant[rader][kolonner];

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                ruter[i][j] = new Firkant(temp[i][j]);
            }
        }
        return ruter;
    }

    private Labyrint leggTilLabyrint(Stage s){
        File fil = new FileChooser().showOpenDialog(s);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n");
            System.exit(1);
        }
        return l;
    }

    static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
        boolean[][] losning = new boolean[hoyde][bredde];
        java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
        java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
        while (m.find()) {
            int x = Integer.parseInt(m.group(1));
            int y = Integer.parseInt(m.group(2));
            losning[y][x] = true;
        }
        return losning;
    }

    public void finnKortesteUtvei(int rad, int kolonne){
        this.nesteTeller = 0;
        this.utveiene = null;
        this.labyrint.nullStillHelt();
        this.koordinatR = rad;
        this.koordinatK = kolonne;
        int teller = 0;

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                if (ruter[i][j].erILosning() == true){
                    ruter[i][j].tilbakeStillErIlosning();
                }
            }
        }

        Liste<String> utveier = this.labyrint.finnUtveiFra(rad,kolonne);
        for (String s : utveier){
            teller++;
        }
        String korteste = this.labyrint.finnKortesteUtvei();

        boolean[][] losning = losningStringTilTabell(korteste, this.kolonner, this.rader);

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                if (losning[i][j] == true){
                    ruter[j][i].settIUtvei();
                }
            }
        }

        tekstfelt.setText("Korteste utvei fra (" + rad + "." + kolonne + ") vises. Antall utveier: " + teller);
        this.utveiene = utveier;
    }

    public void finnAnnenUtvei(int rad, int kolonne){
        this.labyrint.nullStill();
        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                if (ruter[i][j].erILosning() == true){
                    ruter[i][j].tilbakeStillErIlosning();
                }
            }
        }

        int teller = 0;
        for (String s : this.utveiene){
            teller++;
        }
        // Random randomGenerator = new Random();
		// int randomInt = randomGenerator.nextInt(this.utveiene.stoerrelse() -1);


        boolean[][] losning = losningStringTilTabell(this.utveiene.hent(nesteTeller), this.kolonner, this.rader);
        nesteTeller++;

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                if (losning[i][j] == true){
                    ruter[j][i].settIUtvei();
                }
            }
        }

        tekstfelt.setText("En av: " + teller + " antall utveier vises fra (" + rad + "." + kolonne + ")");
    }

    class Firkant extends StackPane {
        // private boolean erHvit = false;
        // private boolean erSort = false;
        private Rectangle firkant;
        public int rad,kolonne;
        private boolean erILosning = false;

        public Firkant(Rute r){
            this.rad = r.hentRad();
            this.kolonne = r.hentKolonne();
            if (r.tilTegn() == '.'){
                firkant = new Rectangle(15,15, Color.WHITE);
                // firkant.setStroke(Color.BLACK);
                getChildren().add(firkant);
                firkant.setOnMouseClicked(e -> klikk());
                this.erHvit = true;
            }else {
                firkant = new Rectangle(15,15, Color.BLACK);
                firkant.setStroke(Color.BLACK);
                getChildren().add(firkant);
                this.erSort = true;
            }
        }

        public boolean erILosning(){
            return this.erILosning;
        }

        public void tilbakeStillErIlosning(){
            this.erILosning = false;
            firkant.setFill(null);
        }

        public void settTilbake(){
            firkant.setFill(Color.WHITE);
        }

        public void settIUtvei(){
            if (this.erILosning = true){
                firkant.setFill(Color.PINK);
            }
        }

        private void klikk(){
            finnKortesteUtvei(rad,kolonne);
       }
    }
}
