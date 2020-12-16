
package linkedlist;
    
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.JFXTextField;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class Dialog {
    public static JFXTextField tf;
    public static JFXTextField tf1;
    public static JFXDialog dialog;
    
    public static void loadDialogPane(StackPane sp,Node body,JFXButton close,JFXDialog.DialogTransition transition){                          
             close.setButtonType(JFXButton.ButtonType.RAISED);
             JFXDialogLayout layout=new JFXDialogLayout();
             //layout.setHeading(heading);
             layout.setBody((StackPane)body);           
             JFXDialog dialog=new JFXDialog(sp, layout,transition);             
             close.setOnAction(e->dialog.close());
             layout.setActions(close);
               dialog.show();
    }
   
    public static void loadDialog(StackPane sp,Node heading,Node body,String buttonname,Double btnwidth,Double btnheight,JFXDialog.DialogTransition transition){
             JFXButton button=new JFXButton(buttonname);
             button.setPrefSize(btnwidth,btnheight);             
             button.setButtonType(JFXButton.ButtonType.RAISED);
             JFXDialogLayout layout=new JFXDialogLayout();
             layout.setHeading(heading);
             layout.setBody(body);           
             JFXDialog dialog=new JFXDialog(sp, layout,transition);             
             button.setOnAction(e->dialog.close());
             layout.setActions(button);
               dialog.show();
    }
    
     public static void loadDialog(StackPane sp,Node heading,Node body,String buttonname,Double btnwidth,Double btnheight,JFXDialog.DialogTransition transition,EventHandler event){
             JFXButton button=new JFXButton(buttonname);
             button.setPrefSize(btnwidth,btnheight);             
             button.setButtonType(JFXButton.ButtonType.RAISED);
             JFXDialogLayout layout=new JFXDialogLayout();
             layout.setHeading(heading);
             layout.setBody(body);           
             JFXDialog dialog=new JFXDialog(sp, layout,transition);             
             button.setOnAction(event);
             layout.setActions(button);
               dialog.show();
    }
 public static void loadInputDialog(StackPane sp,Node heading,String buttonname,EventHandler handler,String prompt1,String prompt2){                     
             JFXButton button=new JFXButton(buttonname);
             tf=new JFXTextField();
             tf1=new JFXTextField();
             tf.setPromptText(prompt1);
             tf1.setPromptText(prompt2);
             tf.setPrefSize(100, 50);
             tf1.setPrefSize(100, 50);
             HBox hbox=new HBox(tf,tf1);
             hbox.setSpacing(30);
             button.setMinSize(100,40);             
             button.setButtonType(JFXButton.ButtonType.RAISED);
             JFXDialogLayout layout=new JFXDialogLayout();
             layout.setHeading(heading);
             layout.setBody(hbox);
             //layout.setMaxSize();
             dialog=new JFXDialog(sp, layout,JFXDialog.DialogTransition.TOP);             
             layout.setActions(button);
             button.setOnAction(handler);                         
             dialog.show();
             
    } 
    public static void loadInputDialog(StackPane sp,Node heading,String buttonname,EventHandler handler){                     
             JFXButton button=new JFXButton(buttonname);
             tf=new JFXTextField();
             tf.setPrefSize(100, 50);
             button.setMinSize(100,40);             
             button.setButtonType(JFXButton.ButtonType.RAISED);
             JFXDialogLayout layout=new JFXDialogLayout();
             layout.setHeading(heading);
             layout.setBody(tf);
             layout.setMaxSize(400,300);
             dialog=new JFXDialog(sp, layout,JFXDialog.DialogTransition.TOP);             
             layout.setActions(button);
             button.setOnAction(handler);   
             tf.requestFocus();
             dialog.show();
             
    } 
}
