package com.poly.assignment.controller.site;

import com.poly.assignment.dao.OrdersDAO;
import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Customer;
import com.poly.assignment.domain.Order;
import com.poly.assignment.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("site/orders")
public class OrderControllerSite {

	@Autowired
	ProductsDAO productDAO;

	@Autowired
	OrdersDAO ordersDAO;

	@Autowired
	SessionService sessionService;

	@RequestMapping("/add/{total}")
	public String add(Model model, @PathVariable("total") double total) {

		Customer customer = new Customer();
		try {
			customer = sessionService.get("customer");
			if (customer != null) {
				Date date = new Date();

				Order order = new Order();
				order.setAmount(total);
				order.setCustomer(customer);
				order.setOrderDate(date);

				ordersDAO.save(order);
				sessionService.set("order", order);
				model.addAttribute("message", "Create billing");
			} else {
				model.addAttribute("message", "You must Login");
				return "site/orders/ordertb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Login error");
		}

		return "redirect:/site/orderdetail/add";
	}

	@RequestMapping("/list")
	public ModelAndView list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		Customer customer = new Customer();
		customer = sessionService.get("customer");
		
		
		
		List<Order> resultPage = null;
		if (customer != null) {
			resultPage = ordersDAO.findByCutomer(customer);
			
			System.out.println("oke7");
		} 
		model.addAttribute("orders", resultPage);
		return new ModelAndView("site/orders/list", model);
	}
}
