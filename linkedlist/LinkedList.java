
package linkedlist;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LinkedList extends Application {
    public static Boolean isSplashLoaded=false;
   
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
       
        stage.setScene(scene);
        //stage.setTitle("Welcome");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
