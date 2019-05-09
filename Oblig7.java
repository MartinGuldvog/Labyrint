import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Oblig7 extends Application {
    Text statusinfo;
    Knapp brett[][];
    boolean ferdig = false;

    static class Knapp extends Button {
        char merke = ' ';

        Knapp() {
            super(" ");
            setFont(new Font(50));
            setPrefSize(120, 120);
        }

    }

    class Klikkbehandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            if (! ferdig)
            System.out.println("test");
            // spillO((Knapp)e.getSource());
        }
    }

    class Stoppbehandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            Platform.exit();
        }
    }

    @Override
    public void start(Stage teater) {
	statusinfo = new Text("Velg en rute");
	statusinfo.setFont(new Font(20));
	statusinfo.setX(10);  statusinfo.setY(410);

	Button stoppknapp = new Button("Stopp");
	stoppknapp.setLayoutX(10);  stoppknapp.setLayoutY(450);
	Stoppbehandler stopp = new Stoppbehandler();
	stoppknapp.setOnAction(stopp);
    }

    public static void main(String[] args) {
        launch(args);
        String filnavn = null;

        if (args.length > 0) {
            filnavn = args[0];
        } else {
            System.out.println("FEIL! Riktig bruk av programmet: "
            +"java Oblig7 <labyrintfil>");
            return;
        }
        File fil = new File(filnavn);
        Labyrint l = null;
        try {
            l = Labyrint.lesFraFil(fil);
            l.skrivUt();
        } catch (FileNotFoundException e) {
            System.out.printf("FEIL: Kunne ikke lese fra '%s'\n", filnavn);
            System.exit(1);
        }

        Rute[][] lab = l.hentLabyrint();

        GridPane rutenett = new GridPane();
        rutenett.setGridLinesVisible(true);

        for(int i=0; i < lab.length; i++) {
            for(int j=0; j < lab[i].length; j++) {
                Rute denne = lab[i][j];
                Knapp ny = new Knapp();
                rutenett.add(ny, denne.hentRad(), denne.hentKolonne());
                }
            }



    }
}
