package com.controller;

import java.util.ArrayList;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Slf4j
@RestController
//@RequestMapping("/path")
class VilleController {
	
	@Autowired
	VilleBLO villeService;

	@RequestMapping(value="/ville", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> recover(@RequestParam(required = false, value="codePostal") String codePostal) {
		log.info("Appel GET");

		ArrayList<Ville> listVille =  villeService.getInfoVilles(codePostal);
		return listVille;
	}
	
	// autre méthode avec des mappings via des Map
	/*@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	//public String insert(@RequestBody String num) {
	public void insert(@RequestBody HashMap<String, HashMap<String, String>> requestData) {
		
	    HashMap<String, String> customerInfo = requestData.get("param");
	    String num = customerInfo.get("num");
	    String date = customerInfo.get("date");
	    // ...
	    
	}*/
	
	@RequestMapping(value="/ville", method=RequestMethod.POST)
	@ResponseBody
	public String insert(@RequestBody Ville ville, Model model) {
	//public String insert(@RequestBody String num) {
	    //System.out.println(num);
		log.info("Appel POST");
		log.info("ville Post : " + ville.toString());
		ObjectMapper mapper = new ObjectMapper();
		try {
			String jsonInString = mapper.writeValueAsString(ville);
			log.info("ville Json : " + jsonInString);

		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    villeService.insertVille(ville);
		return "index";
	}
	
	@RequestMapping(value="/ville/{codePostal}", method=RequestMethod.PUT)
	@ResponseBody
	//public String connexion(@RequestBody String num) {
	public String update(@PathVariable String codePostal, @RequestBody Ville ville, Model model) {
		log.info("Appel PUT");

	    System.out.println(codePostal);
	    System.out.println(ville.getCodePostal());
	    villeService.updateVille(codePostal, ville);
		return "index";
	}
}
