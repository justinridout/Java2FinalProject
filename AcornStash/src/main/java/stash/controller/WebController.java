package stash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import stash.beans.Acorn;
import stash.beans.User;
import stash.repository.AcornRepository;

@Controller
public class WebController {

	@Autowired
	AcornRepository repo;
	
	@GetMapping({"viewAllUsers" })
	public String viewAllUsers(Model model) {
		if (repo.findAll().isEmpty()) {
			return "index";
		}
		
		List<User> allUsers = repo.findAll();
		model.addAttribute("users", allUsers);
		return "viewAllUsers";
	}
		
	@GetMapping("/view/{id}")
	public String viewAcornByUser(@PathVariable("ID") long id, Model model) {
		User u = repo.findById(id).orElse(null);
		
		List<Acorn> userAcorns = u.getAcornList();
		
		model.addAttribute("acorns", userAcorns);
		return "viewAcornsByUser";
	}
	//ADD VIEW ACORN DETAILS
	
	@GetMapping("/addUser")
	public String addNewUser(Model model) {
		User u = new User(); 
		model.addAttribute("newUser", u); 
	return "viewAllUsers";
	}

	@PostMapping("/addUser")
	public String addNewUser(@ModelAttribute User u,
	Model model) {
	repo.save(u);
	     return viewAllUsers(model);
	}
	
	@PostMapping("/update/{ID}")
	public String updateUser(User user, Model model) {
		repo.save(user);
	return viewAllUsers(model);
	}


	
}
