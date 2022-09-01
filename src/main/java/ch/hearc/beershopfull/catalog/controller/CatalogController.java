package ch.hearc.beershopfull.catalog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ch.hearc.beershopfull.catalog.model.Beer;
import ch.hearc.beershopfull.catalog.service.CatalogService;

import org.springframework.web.bind.annotation.PostMapping;

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
	CatalogService catalogeService;
	
	/**
	 * Point d'entrée permettant de poster une nouvelle bière
	 * @param beer la bière à créér
	 * @param errors un objet contenant les erreurs éventuelles
	 * @param model le modèle de la page
	 * @return on redirige sur la page d'accueil. On redirige sur l'url, pas sur le template
	 */
	@PostMapping(value = "/save-beer")
	//notation alternative:
	//@RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String saveBeer(@ModelAttribute Beer beer, BindingResult errors, Model model) {
	   catalogeService.addBeerToCatalog(beer);
       return "redirect:/accueil"; //
    }
	
	/**
	 * Retourn le template de création des bières
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = "/new-beer")
	public String showNewBeerForm(Model model) {
	    model.addAttribute("beer", new Beer());   
		return "new-beer";
	}
	
	/**
	 * Retourne le template de création de la page d'accueil
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = {"/","/accueil"})
	public String showAccueilPage(Model model) {
	    model.addAttribute("beers", catalogeService.getAllBeersFromCatalog());   
		return "accueil";
	}
	
	
	
}
