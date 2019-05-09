// import javafx.scene.shape.Rectangle;
// import javafx.scene.paint.Color;
// import java.util.Random;
// import java.util.ArrayList;
// import javafx.scene.layout.StackPane;
// import javafx.scene.text.Text;
//
// class Firkant extends StackPane {
//     private boolean erHvit = false;
//     private boolean erSort = false;
//     private ArrayList<Rute> naboer;
//     private Rectangle firkant;
//     // private Rute rute;
//     private boolean erBesokt;
//
//     public Firkant(Rute r){
//         if (r.tilTegn() == '.'){
//             firkant = new Rectangle(15,15, Color.WHITE);
//             // firkant.setStroke(Color.BLACK);
//             getChildren().add(firkant);
//             firkant.setOnMouseClicked(e -> klikk());
//             this.erHvit = true;
//         }else {
//             firkant = new Rectangle(15,15, Color.BLACK);
//             firkant.setStroke(Color.BLACK);
//             getChildren().add(firkant);
//             this.erSort = true;
//         }
//     }
//
//     private void klikk(){
//
//    }
// }
