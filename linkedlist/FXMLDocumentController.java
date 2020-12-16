package linkedlist;

import home.resource.animatefx.animation.BounceInDown;
import home.resource.animatefx.animation.BounceInRight;
import home.resource.animatefx.animation.BounceOut;
import home.resource.animatefx.animation.BounceOutLeft;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
public class FXMLDocumentController implements Initializable,EventHandler<ActionEvent>{
   
   
    int count=0,tempsearch;
    VBox tempnode;
    String val,val1;
    Label lbl;
    HBox nodes;
    int idx=0;
   int n=0;
   
   @FXML
    private StackPane stack;
    @FXML
    private AnchorPane pane;
    @FXML
    private AnchorPane anchor;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            load_linear();
                if(!LinkedList.isSplashLoaded){
                    
                loadSplashScreen();
               }
      anchor=pane;
        
    }    
  
    private void loadSplashScreen()
 { 
     LinkedList.isSplashLoaded=true;
        try {
          StackPane pan=FXMLLoader.load(getClass().getResource(("Splash.fxml")));
           stack.getChildren().setAll(pan);
          FadeTransition fadeIn=new FadeTransition(Duration.seconds(3),pan);
          fadeIn.setFromValue(0);
          fadeIn.setToValue(1);
          fadeIn.setCycleCount(1);
          
          
          FadeTransition fadeOut=new FadeTransition(Duration.seconds(3),pan);
          fadeOut.setFromValue(1);
          fadeOut.setToValue(0);
          fadeOut.setCycleCount(1);
          
          fadeIn.play();
          fadeIn.setOnFinished((ActionEvent e)->{fadeOut.play();});
            fadeOut.setOnFinished((ActionEvent e)->{
              try {
                  StackPane pan1=FXMLLoader.load(getClass().getResource(("FXMLDocument.fxml")));
                  stack.getChildren().setAll(pan1);
              } catch (IOException ex) {
                  Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
              }
            });
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
   
    

    @FXML
    private void create(ActionEvent event) {
        lbl=SinglyLinearController.lbl;
        nodes=SinglyLinearController.nodes;
        new BounceInRight(lbl).play();
    }

    @FXML
    private void clear(ActionEvent event) {
       
        new BounceOutLeft(lbl).play();
        for(int i=0;i<count;i++){
            new BounceOutLeft(((VBox)nodes.getChildren().get(i))).play();
          
    
        }
         nodes.getChildren().get(0).opacityProperty().addListener(e ->{
                if(nodes.getChildren().get(0).getOpacity()==0.0){
                    count=0;
                    n=0;
                    nodes.getChildren().clear();        
                }
            });       
        }

    @FXML
    private void ins_beg(ActionEvent event) {
        try {
            idx=1;
              Dialog.loadInputDialog(stack, new Text("Enter value"), "insert",this );             
            tempnode = FXMLLoader.load(getClass().getResource("Node.fxml"));           
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }void addBeg(){ 
        nodes.getChildren().add(0, tempnode);
        ((Label)((HBox)((VBox)nodes.getChildren().get(0)).getChildren().get(0)).getChildren().get(0)).setText(val);        
        new BounceInDown( nodes.getChildren().get(0)).play();  
        idx=0;
        count++;
    }    
    @FXML
    private void ins_bet(ActionEvent event) {
         try {
            idx=3;
              Dialog.loadInputDialog(stack, new Text("Enter value"), "insert bet",this,"search value","Enter value" );             
            tempnode = FXMLLoader.load(getClass().getResource("Node.fxml"));                       
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }void addBet(){
        String info="";
        int i=0;
        for(i=0;i<count;i++){
        info=((Label)((HBox)((VBox)nodes.getChildren().get(i)).getChildren().get(0)).getChildren().get(0)).getText();        
           if(val.equals(info))break;          
        }
        nodes.getChildren().add(i+1, tempnode);
        ((Label)((HBox)(tempnode).getChildren().get(0)).getChildren().get(0)).setText(val1);        
        new BounceInDown(tempnode).play();  
        idx=0;
        count++;
    }

    @FXML
    private void ins_end(ActionEvent event) {
           try {
            idx=2;
              Dialog.loadInputDialog(stack, new Text("Enter value"), "insert",this );             
            tempnode = FXMLLoader.load(getClass().getResource("Node.fxml"));           
            
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }void addEnd(){ 
        nodes.getChildren().add(tempnode);
        ((Label)((HBox)tempnode.getChildren().get(0)).getChildren().get(0)).setText(val);        
        new BounceInDown(tempnode).play();  
        idx=0;
        count++;
    }    
    @FXML
    private void rem_beg(ActionEvent event) {
         BounceOut a1=new BounceOut(nodes.getChildren().get(0));
            a1.play();
            nodes.getChildren().get(0).opacityProperty().addListener(e ->{
                if(nodes.getChildren().get(0).getOpacity()==0.0){
                    nodes.getChildren().remove(0);
                    count--;
                }
            });            
    }

    @FXML
    private void rem_bet(ActionEvent event) {        
              idx=4;
              Dialog.loadInputDialog(stack, new Text("Enter search value"), "remove",this );             
              
    }void remBet(){
        String info="";
        int i=0;
        for(i=0;i<count;i++){
        info=((Label)((HBox)((VBox)nodes.getChildren().get(i)).getChildren().get(0)).getChildren().get(0)).getText();        
           if(val.equals(info))break;          
        }
            System.out.println(i+1);
        tempsearch=i+1;
        BounceOut a1=new BounceOut(nodes.getChildren().get(i+1));
        a1.play();
         nodes.getChildren().get(i+1).opacityProperty().addListener(e ->{
                if(nodes.getChildren().get(tempsearch).getOpacity()==0.0){
                    nodes.getChildren().remove(tempsearch);
                    count--;
                }
            });       
        idx=0;
       
    }


    @FXML
    private void rem_end(ActionEvent event) {
          BounceOut a1=new BounceOut(nodes.getChildren().get(count-1));
            a1.play();
            nodes.getChildren().get(count-1).opacityProperty().addListener(e ->{
                if(nodes.getChildren().get(count-1).getOpacity()==0.0){
                    nodes.getChildren().remove(count-1);
                    count--;
                }
            });            
    }

    @Override
    public void handle(ActionEvent event) {     
        val=Dialog.tf.getText();     
        if(idx==3)
           val1=Dialog.tf1.getText();                
        Dialog.dialog.close();
        switch(idx){
            case 1: addBeg();break;
            case 2: addEnd();break;
            case 3: addBet();break;
            case 4: remBet();break;
        }
    }

    private void load_linear() {
        try {
            AnchorPane pane1=FXMLLoader.load(getClass().getResource("SinglyLinear.fxml"));  
            pane.getChildren().setAll(pane1);
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void help(ActionEvent event) {
        try{          
        Stage stage=new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Help.fxml"));        
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        stage.show();
        }catch(IOException e){}
    }



}
