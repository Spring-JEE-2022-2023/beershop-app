package ch.hearc.beershopfull.catalog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.service.CatalogService;


/**
 * Controlleur lié au catalogue de bières
 * Une classe annoté @Controller, avec la librairie thymeleaf, permettra de retourner les noms des templates 
 * à service à l'utilisateur
 * @author Seb
 *
 */
@Controller
public class CatalogController {

	@Autowired
	CatalogService catalogService;
	
	
	/**
	 * Retourne le template de création de la page d'accueil
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = {"/","/accueil"})
	public String showAccueilPage(Model model) {
	    model.addAttribute("beers", catalogService.getAllBeersFromCatalog());   
	    model.addAttribute("isPublic",Boolean.TRUE);
		return "accueil";
	}
	
	/**
	 * Sauvegarde de l'évaluation d'une bière
	 * 
	 * @param note
	 * @param beerId
	 * @return la page courante
	 */
	@PostMapping(value = {"/evaluate"})
	public String evaluateBeer(Model model,@RequestParam Integer note,@RequestParam Integer beerId) {
	    catalogService.saveEvaluation(beerId, note);
		model.addAttribute("beers", catalogService.getAllBeersFromCatalog());   
		return "redirect:/";
	}
	
	
	
}
