package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Studente;

public class StudenteDAO {
	
	/*
	 * Ottengo tutti gli studenti salvati nel Db
	 */
	public Studente getStudenteByMatricola(int matricola) {

		final String sql = "SELECT * FROM studente WHERE matricola = ?";	

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, matricola);

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				if(rs.getInt("matricola") == matricola) {
					String cognome = rs.getString("cognome");
					String nome = rs.getString("nome");
					String CDS = rs.getString("CDS");					
					Studente s = new Studente(matricola, cognome, nome, CDS);
					return s;
				}

			}

			conn.close();
			
			return null;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public List<Corso> getCorsiStudente(Studente s){

		final String sql = "SELECT c.codins, c.crediti, c.nome, c.pd "
				+ "FROM corso c, iscrizione i "
				+ "WHERE c.codins=i.codins AND i.matricola = ?";	
		
		List<Corso> corsiStudente = new LinkedList<Corso>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, s.getMarticola());

			ResultSet rs = st.executeQuery();

			while (rs.next()) {

				String codins = rs.getString("codins");
				int numeroCrediti = rs.getInt("crediti");
				String nome = rs.getString("nome");
				int periodoDidattico = rs.getInt("pd");
				
				Corso c = new Corso(codins, numeroCrediti, nome, periodoDidattico);
				corsiStudente.add(c);

			}

			conn.close();
			
			return corsiStudente;
			

		} catch (SQLException e) {
			// e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}
	
	public boolean isStudenteIscrittoACorso(Studente s, Corso c) {
		final String sql = "SELECT * "
				+ "FROM iscrizione i "
				+ "WHERE i.codins=? AND i.matricola = ?";	

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, c.getCodins());
			st.setInt(2, s.getMarticola());

			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				return true;
			}
			else {
				return false;
			}
		}catch(Exception e) {
//			e.printStackTrace();
			throw new RuntimeException("Errore Db", e);
		}
	}

}
