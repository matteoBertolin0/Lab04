package it.polito.tdp.lab04.DAO;

import it.polito.tdp.lab04.model.Studente;

public class TestDB {

	public static void main(String[] args) {

		/*
		 * 	This is a main to check the DB connection
		 */
//		
//		CorsoDAO cdao = new CorsoDAO();
//		System.out.println(cdao.getTuttiICorsi().toString());
//		
//		StudenteDAO sdao = new StudenteDAO();
//		for(Studente s : sdao.getTuttiGliStudenti())
//			System.out.println(s.getMarticola()+" "+s.getNome());
		
		CorsoDAO cdao = new CorsoDAO();
		System.out.println(cdao.getStudentiIscrittiAlCorso(cdao.getCorso("02PBVPG")).toString());
	}

}
