package ch.hearc.beershopfull.catalog.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	CatalogService catalogueService;
	
	
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
    public String saveBeer(@ModelAttribute Beer beer, BindingResult errors, Model model,@RequestParam String type) {
		
		if(type.equals("new")) {
			catalogueService.addBeerToCatalog(beer);
		}else {
			catalogueService.deleteBeer(beer.getId());
			catalogueService.addBeerToCatalog(beer);
		}
		
       return "redirect:/admin/"; //
    }
	
	@PostMapping(value = "/delete-beer")
	private String deleteStudent(@RequestParam Integer id){
	    catalogueService.deleteBeer(new Long(id));
	    return "redirect:/admin/";
	}
	
	/**
	 * Retourn le template de création des bières
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = "/new-beer")
	public String showNewBeerForm(Model model) {
	    model.addAttribute("beer", new Beer());   
	    model.addAttribute("showList",Boolean.FALSE);
	    model.addAttribute("showNew",Boolean.TRUE);
	    
	    model.addAttribute("isNew",Boolean.TRUE);
	    model.addAttribute("isEdit",Boolean.FALSE);
		return "admin/accueil";
	}
	
	/**
	 * Retourn le template de création des bières
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@PostMapping(value = "/edit-beer")
	public String showNEditBeerForm(Model model,@RequestParam Integer id) {
	    
		Beer beerToEdit = catalogueService.getBeerById(id);
		
		model.addAttribute("beer", beerToEdit);   
	    model.addAttribute("showList",Boolean.FALSE);
	    model.addAttribute("showNew",Boolean.TRUE);
	    
	    model.addAttribute("isEdit",Boolean.TRUE);
	    model.addAttribute("isNew",Boolean.FALSE);
	    
	    
	    
		return "admin/accueil";
	}
	
	/**
	 * Retourne le template de création de la page d'accueil
	 * @param model le modèle de la page
	 * @return le nom du template
	 */
	@GetMapping(value = {"/"})
	public String showAccueilPage(Model model) {
	    model.addAttribute("showList",Boolean.TRUE);
	    model.addAttribute("showNew",Boolean.FALSE);
	    model.addAttribute("isAdmin",Boolean.TRUE);
	    model.addAttribute("beers", catalogueService.getAllBeersFromCatalog());  
	    return "admin/accueil";
	}
	
	
}
