package com.blo;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Slf4j
@Service
public class VilleBLOImpl implements VilleBLO {
	
	@Autowired
	private VilleDAO villeDAO;
	
	@Override
	public ArrayList<Ville> getInfoVilles(String codePostal) throws VilleException {
		ArrayList<Ville> listVille;
		
		// dans le cas ou numTrain est null ou vide = récupération de l'ensemble des informations
        if (codePostal == null || "".equalsIgnoreCase(codePostal)) {
			listVille = villeDAO.findAllVilles();
		} else {
			listVille = villeDAO.findVilleByCodePostal(codePostal);
		}
        
		log.info("Nombre de ville récupérée(s) : " + listVille.size() );
		
		return listVille;
	}
	
	@Override
	public void insertVille(Ville ville) throws VilleException {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.saveVille(ville);
		} 
		// exemple de gestion des erreurs
		/*} catch (Exception e) {
			log.error("Impossible d'ajouter le message", e);
			throw new TchatException("ERREUR_INCONNUE");
		}*/
		
	}
	
	@Override
	public void updateVille(String codePostal, Ville ville) throws VilleException {

		if (!"".equalsIgnoreCase(ville.getCodePostal())) {
			villeDAO.updateVille(codePostal, ville);
		} 
		// exemple de gestion des erreurs
		/*} catch (Exception e) {
			log.error("Impossible d'ajouter le message", e);
			throw new TchatException("ERREUR_INCONNUE");
		}*/
		
	}
	
	
}
