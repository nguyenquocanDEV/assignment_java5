package com.poly.assignment.controller.site;


import com.poly.assignment.dao.CustomerDAO;
import com.poly.assignment.domain.Customer;
import com.poly.assignment.model.CustomerDTO;
import com.poly.assignment.services.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("site/customers")
public class CustomerControllerSite {

	@Autowired
	CustomerDAO customerDao;

	@Autowired
	SessionService sessionService;

	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("customer", new CustomerDTO());
		return "site/customers/addOrEdit";
	}

	@PostMapping("/saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("customer") CustomerDTO dto,
			BindingResult result) {

		if (result.hasErrors()) {
			return new ModelAndView("site/customers/addOrEdit", model);
		}

		Customer entity = new Customer();
		BeanUtils.copyProperties(dto, entity);

		customerDao.save(entity);

		model.addAttribute("message", "customer is save");

		return new ModelAndView("redirect:/site/home/searchpaginated", model);
	}

	@GetMapping("/edit/{customerId}")
	public ModelAndView edit(ModelMap model, @PathVariable("customerId") Integer customerId) {

		Optional<Customer> opt = customerDao.findById(customerId);
		CustomerDTO dto = new CustomerDTO();

		if (opt.isPresent()) {
			Customer entity = opt.get();

			BeanUtils.copyProperties(entity, dto);
			dto.setIsEdit(true);

			model.addAttribute("customer", dto);
			return new ModelAndView("site/customers/addOrEdit", model);
		}
		model.addAttribute("message", "Customer is not exits");
		return new ModelAndView("redirect:site/home/searchpaginated", model);
	}

	@GetMapping("/edit")
	public ModelAndView edit(ModelMap model) {

		Customer customerSession = sessionService.get("customer");

		CustomerDTO dto = new CustomerDTO();

		if (customerSession != null) {

			BeanUtils.copyProperties(customerSession, dto);
			dto.setIsEdit(true);

			model.addAttribute("customer", dto);
			return new ModelAndView("site/customers/addOrEdit", model);
		}
		model.addAttribute("message", "Customer is not exits");
		return new ModelAndView("redirect:site/home/searchpaginated", model);
	}

	@GetMapping("/delete/{customerId}")
	public ModelAndView delete(ModelMap model, @PathVariable("customerId") Integer customerId) {

		customerDao.deleteById(customerId);

		return new ModelAndView("redirect:/admin/customers/searchpaginated", model);
	}

}
