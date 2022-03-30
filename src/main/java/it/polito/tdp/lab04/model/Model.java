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
	
	public List<Studente> getStudentiIscrittiAlCorso(String codins) {
		return this.corsoDao.getStudentiIscrittiAlCorso(this.corsoDao.getCorso(codins));
	}
	
	public List<Corso> getCorsiStudente(int matricola) {
		return this.studenteDao.getCorsiStudente(this.studenteDao.getStudenteByMatricola(matricola));
	}
	
	public boolean isStudenteIscrittoACorso(int matricola, String codins) {
		return this.studenteDao.isStudenteIscrittoACorso(this.studenteDao.getStudenteByMatricola(matricola),
				this.corsoDao.getCorso(codins));
	}
	
	public boolean iscriviStudenteACorso(int matricola, String codins) {
		return this.corsoDao.iscriviStudenteACorso(this.getStudenteByMatricola(matricola), this.corsoDao.getCorso(codins));
	}
}
