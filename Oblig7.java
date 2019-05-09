import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Oblig7 extends Application {
    private Labyrint labyrint = leggTilLabyrint();
    private final int rader = labyrint.antallRader();
    private final int kolonner = labyrint.antallKolonner();
    private Rute[][] temp = labyrint.hentLabyrint();

    public void start(Stage stage){
        GridPane root = new GridPane();
        Scene scene = new Scene(root);
        Firkant[][] ruter = settOppBrett();

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

    private Labyrint leggTilLabyrint(){
        File fil = new File("5.in");
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n");
            System.exit(1);
        }
        return l;
    }
}
