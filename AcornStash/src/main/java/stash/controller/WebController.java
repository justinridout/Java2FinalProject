package stash.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import stash.beans.Acorn;
import stash.beans.UpdateUser;
import stash.beans.User;
import stash.repository.AcornRepository;

@Controller
public class WebController {

	@Autowired
	AcornRepository repo;

	@GetMapping({ "viewAllUsers" })
	public String viewAllUsers(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewUser(model);
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
	
	@GetMapping("/edit/{ID}")
	public String updateUser(@PathVariable("ID") long ID, Model model) {
		User u = repo.findById(ID).orElse(null);
		UpdateUser update = new UpdateUser(u.getFirstName(), u.getLastName(), u.getCashBalance());
		System.out.println(u.toString());
		model.addAttribute("updateUser", update);
		
		return "updateUser";
	}
	
	@PostMapping("/update/{ID}")
	public String reviseUser(@PathVariable("ID") long ID, UpdateUser u, Model model) {
		User user = repo.findById(ID).orElse(null);
		user.setFirstName(u.getFirstName());
		user.setLastName(u.getLastName());
		user.setCashBalance(u.getCashBalance());
		repo.save(user);
		return viewAllUsers(model);
	}
	
	@GetMapping("/updateAcorn/{ID}/{name}")
	public String updateAcorn(@PathVariable("ID") long userID, @PathVariable("name") String name, Model model) {
		User u = repo.findById(userID).orElse(null);
		Acorn toUpdate = null;
		int index = 0;
		for(Acorn a: u.getAcornList()) {
			if(a.getName().equals(name)) {
				toUpdate = a;
				break;
			}
			
			index++;
		}
		
		System.out.println("UPDATING ACORN AT INDEX: " + index);
		model.addAttribute("acornIndex", index);
		model.addAttribute("currentUser", u);
		model.addAttribute("toUpdate", toUpdate);
		
		return "updateAcorn";
	}
	
	@PostMapping("/updateAcorn/{ID}/{acornIndex}")
	public String updateAcorn(@PathVariable("ID") long userID, @PathVariable("acornIndex") int index, Acorn toUpdate, Model model) {
		User u = repo.findById(userID).orElse(null);
		int count = 0;
		
		for(Acorn a : u.getAcornList()) {
			if(count == index) {
				a = toUpdate;
			}
			
			count++;
		}
		
		repo.save(u);
		
		return "viewAllUsers";
	}

}
