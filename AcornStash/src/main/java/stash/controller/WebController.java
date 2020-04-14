package stash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import stash.beans.Acorn;
import stash.beans.User;
import stash.repository.AcornRepository;

@Controller
public class WebController {

	@Autowired
	AcornRepository repo;
	@GetMapping({ "/", "viewAllUsers" })
	public String viewAllAcorns(Model model) {
		if (repo.findAll().isEmpty()) {
			//return addNewAcorn(model);
		}
		
		List<User> allUsers = repo.findAll();
		model.addAttribute("users", allUsers);
		return "viewAllUsers";
	}
	
	@GetMapping("/view/{id}")
	public String viewAcornByUser(@PathVariable("id") long id, Model model) {
		User u = repo.findById(id).orElse(null);
		
		List<Acorn> userAcorns = u.getAcornList();
		
		model.addAttribute("acorns", userAcorns);
		return "viewAcornsByUser";
	}
	//ADD VIEW ACORN DETAILS
	
}
