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

	@GetMapping({ "viewAllUsers" })
	public String viewAllUsers(Model model) {
		if (repo.findAll().isEmpty()) {
			return "index";
		}

		model.addAttribute("users", repo.findAll());
		return "viewAllUsers";
	}

	@GetMapping("/view/{ID}")
	public String viewAcornByUser(@PathVariable("ID") long id, Model model) {
		User u = repo.findById(id).orElse(null);
		System.out.println(u);

		List<Acorn> userAcorns = u.getAcornList();

		model.addAttribute("acorns", userAcorns);
		model.addAttribute("currentUser", repo.findById(id).orElse(null));
		
		return "viewAcornsByUser";
	}
	
	@GetMapping("/addAcornByUser/{ID}")
	public String addAcornByUser(@PathVariable("ID")long userId, Model model) {
		Acorn a = new Acorn();
		User u = repo.findById(userId).orElse(null);
		model.addAttribute("newAcorn", a);
		model.addAttribute("currentUser", u);
		
		
		return "addAcornByUser";
	}
	
	@PostMapping("/addAcornByUser/{ID}")
	public String addAcornByUser(@PathVariable("ID") long id, @ModelAttribute Acorn a, Model model) {
		User u = repo.findById(id).orElse(null);
		u.addAcorn(a);
		
		repo.save(u);
		
		return viewAllUsers(model);
	}

	/*@GetMapping("/addAcorn/{ID}")
	public String addAcornByUser(@PathVariable("ID") long id, Model model) {
		User u = repo.findById(id).orElse(null);
		
		
	}*/

	@GetMapping("addUser")
	public String addNewUser(Model model) {
		User u = new User();
		model.addAttribute("newUser", u);
		return "addUser";
	}

	@PostMapping("/addUser")
	public String addNewUser(@ModelAttribute User u, Model model) {
		repo.save(u);
		return viewAllUsers(model);
	}

	@PostMapping("/update/{ID}")
	public String updateUser(User user, Model model) {
		repo.save(user);
		return viewAllUsers(model);
	}

}
