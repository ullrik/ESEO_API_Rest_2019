package com.dao;

import java.util.ArrayList;

import com.dto.Ville;

public interface VilleDAO {
	
	public ArrayList<Ville> findAllVilles();

    public ArrayList<Ville> findVilleByCodePostal(String codePostal);

	public void saveVille(Ville ville);
	
	public void updateVille(String codePostal, Ville ville);
}
