/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */

package it.polito.tdp.lab04;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="cmbCorsi"
    private ComboBox<String> cmbCorsi; // Value injected by FXMLLoader

    @FXML // fx:id="txtCognome"
    private TextField txtCognome; // Value injected by FXMLLoader

    @FXML // fx:id="txtMatricola"
    private TextField txtMatricola; // Value injected by FXMLLoader

    @FXML // fx:id="txtNome"
    private TextField txtNome; // Value injected by FXMLLoader

    @FXML // fx:id="txtRisultato"
    private TextArea txtRisultato; // Value injected by FXMLLoader
    
    private Model model;

    @FXML
    void handleAutofill(ActionEvent event) {
    	String serach = txtMatricola.getText();
    	boolean trovato = false;
    	try{
    		txtCognome.setText(this.model.getStudenteByMatricola(Integer.parseInt(serach)).getCognome());
    		txtNome.setText(this.model.getStudenteByMatricola(Integer.parseInt(serach)).getNome());
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    		txtRisultato.setText("Matricola non valida");
    	}
    	
    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {

    }

    @FXML
    void handleCercaIscrittiCorso(ActionEvent event) {

    }

    @FXML
    void handleIscrivi(ActionEvent event) {

    }

    @FXML
    void handleReset(ActionEvent event) {
    	txtMatricola.clear();
    	txtCognome.clear();
    	txtNome.clear();
    	txtRisultato.clear();
    	
    }
    
    void setModel(Model model) {
    	this.model=model;
        cmbCorsi.getItems().clear();
        for(Corso c : model.getTuttiICorsi()) {
        	cmbCorsi.getItems().add(c.getCodins() +" "+ c.getNome());
        	}
        cmbCorsi.getItems().add("");
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert cmbCorsi != null : "fx:id=\"cmbCorsi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCognome != null : "fx:id=\"txtCognome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtMatricola != null : "fx:id=\"txtMatricola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
    }

}
