package it.polito.tdp.lab04.model;

public class Studente {

	private Integer marticola;
	private String cognome, nome, CDS;
	
	public Studente(Integer marticola, String cognome, String nome, String cDS) {
		this.marticola = marticola;
		this.cognome = cognome;
		this.nome = nome;
		CDS = cDS;
	}

	public Integer getMarticola() {
		return marticola;
	}

	public void setMarticola(Integer marticola) {
		this.marticola = marticola;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCDS() {
		return CDS;
	}

	public void setCDS(String cDS) {
		CDS = cDS;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marticola == null) ? 0 : marticola.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Studente other = (Studente) obj;
		if (marticola == null) {
			if (other.marticola != null)
				return false;
		} else if (!marticola.equals(other.marticola))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Studente [marticola=" + marticola + ", cognome=" + cognome + ", nome=" + nome + ", CDS=" + CDS + "]";
	}
	
	
	
	
}
