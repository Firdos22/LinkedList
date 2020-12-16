/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author SATISH
 */
public class SinglyLinearController implements Initializable {
    public static Label lbl;
    public static HBox nodes;
    @FXML
    private Label lable;
    @FXML
    private HBox list;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       lbl=lable;
       nodes=list;
    }    
    
}
