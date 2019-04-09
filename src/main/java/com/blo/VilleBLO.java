package com.blo;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleBLO {

	public ArrayList<Ville> getInfoVilles(String codePostal) throws VilleException;
	
	public void insertVille(Ville ville) throws VilleException;
	
	public void updateVille(String codePostal, Ville ville) throws VilleException;

}
