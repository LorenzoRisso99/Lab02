package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Model;
import model.Parole;

public class FXMLController {
	
	
	private Model model;
	String regex = "[a-zA-Z]+";

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtArea;

    @FXML
    private TextField txtInsert;

    @FXML
    void handleClear(ActionEvent event) {
    	txtArea.clear();
    	txtInsert.clear();
    }

    @FXML
    void handleTranslate(ActionEvent event) {
    	
    	String celle[] = txtInsert.getText().split(" ");
    	
    	if(celle.length == 2) {
    		if (!celle[0].matches(regex) || !celle[1].matches(regex)) {
				txtArea.setText("Errore, caratteri speciali inseriti");
				return;
    		}
    		model.aggiungiAlDizionario(celle[0].toLowerCase(),celle[1].toLowerCase());
    		txtArea.setText("Aliena:" + celle[0] + ", Tradotta: " + celle[1]);
    		txtInsert.clear();
    		
    	} else if(celle.length == 1) {
    		if (!celle[0].matches(regex)) {
				txtArea.setText("Errore, caratteri speciali inseriti");
				return;
    		}
    		txtArea.setText(model.traduci(celle[0].toLowerCase()));
    		txtInsert.clear();
    		
    	} else {
    		return;
    	}
    	
    }

    @FXML
    void initialize() {
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtArea != null : "fx:id=\"txtArea\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtInsert != null : "fx:id=\"txtInsert\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model = model;
	}

}
