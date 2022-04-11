/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

/*package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.fxml.FXML;

public class FXMLController {
	
	private Dizionario model;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {

    }
    

}*/

package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.Dizionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dizionario model;
	private String testo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtAlien;

    @FXML
    private TextArea txtResult;

    @FXML
    void operationTranslate(ActionEvent event) {
    	testo = this.txtAlien.getText();
    	if(testo.contains(" ")) {
    		//caso 1: aggiungo la parola e la relativa traduzione al dizionario
    		String array[] = testo.split(" ");
    		String s1 = array[0];
    		String s2 = array[1];
    		//verifico che le stringhe siano scritte correttamente
    		if(!s1.matches("[a-zA-Z]+") && !s2.matches("[a-zA-Z]+")) {
    			this.txtResult.setText("ERRORE: inserisci solo caratteri alfabetici!");
    			return;
    		}
    		this.model.aggiungiParola(s1, s2);
    		this.txtResult.setText("Parola: "+s1+". Traduzione: "+s2);
    		this.txtResult.appendText("\nDizionario: "+this.model.getDizionario().toString());
    	}
    	else {
    		//caso 2: cerco la traduzione della parola aliena passata nel textField
    		String traduzione = "";
    		if(testo.matches("[a-zA-Z?]*") && !testo.matches("[a-zA-Z]*")) {
    			//caso wildcard
    			traduzione = this.model.cercaTradWildcard(testo);
    		}else if(testo.matches("[a-zA-Z]*")) {
    			traduzione = this.model.cercaTraduzione(testo);
    		}else {
    			this.txtResult.setText("ERRORE: inserisci solo caratteri alfabetici o '?'!");
    			return;
    		}
    		if(traduzione == null) {
    			this.txtResult.setText("Il dizionario non contiene la traduzione della parola "+testo);
    		}
    		else {
    			this.txtResult.setText("La traduzione di "+testo+" è: "+traduzione);
    		}
    	}
    }

    @FXML
    void toClear(ActionEvent event) {
    	this.txtAlien.clear();
    }
    
    public void setModel(Dizionario model) {
    	this.model = model;
    }

    @FXML
    void initialize() {
        assert txtAlien != null : "fx:id=\"txtAlien\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}
