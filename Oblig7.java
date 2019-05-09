import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javafx.stage.FileChooser;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Oblig7 extends Application {
    public Labyrint labyrint;
    private int rader;
    private int kolonner;
    private Rute[][] temp;
    public Firkant[][] ruter;

    public void start(Stage stage){
        this.labyrint = leggTilLabyrint(stage);
        this.rader = labyrint.antallRader();
        this.kolonner = labyrint.antallKolonner();
        this.temp = labyrint.hentLabyrint();

        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        this.ruter = settOppBrett();

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                root.add(ruter[i][j], j, i);
            }
        }

        stage.setScene(scene);
        stage.setTitle("Oblig7");
        stage.show();
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
        Liste<String> utveier = this.labyrint.finnUtveiFra(rad,kolonne);
        String korteste = this.labyrint.finnKortesteUtvei();

        boolean[][] losning = losningStringTilTabell(korteste, this.kolonner, this.rader);

        for (int i = 0; i < rader; i++) {
            for (int j = 0; j < kolonner; j++) {
                if (losning[i][j] == true){
                    ruter[j][i].settIUtvei();
                }
            }
        }

    }

    class Firkant extends StackPane {
        private boolean erHvit = false;
        private boolean erSort = false;
        private Rectangle firkant;
        public int rad,kolonne;
        private boolean erBesokt;

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

        public void settIUtvei(){
            firkant.setFill(Color.BLUE);
        }

        private void klikk(){
            finnKortesteUtvei(rad,kolonne);

       }
    }
}
