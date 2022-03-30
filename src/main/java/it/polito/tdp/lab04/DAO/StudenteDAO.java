package it.polito.tdp.lab04.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;


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

}
