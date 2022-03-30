package it.polito.tdp.lab04.model;


import java.util.List;

import it.polito.tdp.lab04.DAO.CorsoDAO;
import it.polito.tdp.lab04.DAO.StudenteDAO;

public class Model {
	private StudenteDAO studenteDao;
	private CorsoDAO corsoDao;
	
	public Model() {
		this.studenteDao = new StudenteDAO();
		this.corsoDao = new CorsoDAO();
	}
	
	public List<Corso> getTuttiICorsi() {
		return this.corsoDao.getTuttiICorsi();
	}
	
	public Studente getStudenteByMatricola(int matricola) {
		return this.studenteDao.getStudenteByMatricola(matricola);
	}
}
