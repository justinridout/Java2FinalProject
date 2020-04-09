package stash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import stash.beans.Acorn;

@Controller
public class WebController {

	@Autowired
	Acorn repo;
	
	
	
}
