package com.poly.assignment.controller.site;

import com.poly.assignment.dao.CustomerDAO;
import com.poly.assignment.domain.Customer;

import com.poly.assignment.model.SiteLoginDTO;
import com.poly.assignment.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@SessionAttributes("sessionScope")
@RequestMapping("site/logins")
public class LoginControllerSite {
	
	@Autowired
	CustomerDAO customerDao;
		
	@Autowired
	SessionService sessionService;
	
	@RequestMapping("")
	public String form(Model model) {
		
		SiteLoginDTO login = new SiteLoginDTO();
		model.addAttribute("login", login);
		
		return "site/logins/login";
		
	}

	@PostMapping("/login")
	public ModelAndView login(ModelMap model,
			@Valid @ModelAttribute("login") SiteLoginDTO dto,
			BindingResult result) {
		
		List<Customer> customerList = customerDao.findByEmailContaining(dto.getEmail());
		if(customerList.isEmpty()) {
			model.addAttribute("message", "Wrong email");
			return new ModelAndView("site/logins/login", model);
		} else {
			Customer customer = customerList.get(0);
			if(!customer.getPassword().equals(dto.getPassword())) {
				model.addAttribute("message", "Wrong password");
				return new ModelAndView("site/logins/login", model);
			} else {
				sessionService.set("customer",customer);
				//model.addAttribute("customerName", customer.getName());
			}
		}
		
		return new ModelAndView("redirect:/site/home/", model);
	}
	
	@RequestMapping("/logOut")
	public ModelAndView longOut() {
		sessionService.remove("customer");
		return new ModelAndView("redirect:/site/home/");

	}
	
}
