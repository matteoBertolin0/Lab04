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
    	String search = txtMatricola.getText();
    	try{
    		txtCognome.setText(this.model.getStudenteByMatricola(Integer.parseInt(search)).getCognome());
    		txtNome.setText(this.model.getStudenteByMatricola(Integer.parseInt(search)).getNome());
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    		txtRisultato.setText("Matricola non valida");
    	}
    	
    }

    @FXML
    void handleCercaCorsi(ActionEvent event) {
    	try {
    		String matr = txtMatricola.getText();
    		txtRisultato.clear();
    		for(Corso c : this.model.getCorsiStudente(Integer.parseInt(matr))) {
    			txtRisultato.appendText(c.toString()+"\n");
    		}
    	}catch(NumberFormatException e) {
    		e.printStackTrace();
    		txtRisultato.setText("Inserire matricola valida");
    	}
    }

    @FXML
    void handleCercaIscrittiCorso(ActionEvent event) {
    	try {
        	String corso = cmbCorsi.getValue();
        	txtRisultato.clear();
        	for(Studente s : this.model.getStudentiIscrittiAlCorso(corso.substring(0, 7))) {
        			txtRisultato.appendText(s.toString()+"\n");
        	}
    	}catch(Exception e) {
    		e.printStackTrace();
    		txtRisultato.setText("Inserire un corso");
    	}

    }

    @FXML
    void handleIscrivi(ActionEvent event) {
    	try {
        	String corso = cmbCorsi.getValue().substring(0, 7);
        	int matricola=0;
        	try{
        		matricola = Integer.parseInt(txtMatricola.getText());
        	}catch(NumberFormatException e) {
        		e.printStackTrace();
        		txtRisultato.setText("Matricola non valida");
        	}
        	
        	txtRisultato.clear();
        	boolean search = this.model.isStudenteIscrittoACorso(matricola, corso);
        	
        	if(search) {
        		txtRisultato.setText("Studente già iscritto a questo corso");
        	}else {
        		boolean ris =this.model.iscriviStudenteACorso(matricola, corso);
        		if(ris)
        			txtRisultato.setText("Studente Iscritto correttamente");
        		else
        			txtRisultato.setText("Iscrizione non riuscita");
        	}
        	
    	}catch(Exception e) {
    		e.printStackTrace();
    		txtRisultato.setText("Dat inseriti non validi");
    	}
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
