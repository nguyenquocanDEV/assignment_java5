package com.poly.assignment.controller.site;

import com.poly.assignment.dao.OrderDetailsDAO;
import com.poly.assignment.dao.OrdersDAO;
import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Order;
import com.poly.assignment.domain.OrderDetail;
import com.poly.assignment.domain.Product;
import com.poly.assignment.model.CartItemDTO;
import com.poly.assignment.services.SessionService;
import com.poly.assignment.services.ShoppingCartService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("site/orderdetail")
public class OrderDetailControllerSite {
	
	@Autowired
	OrderDetailsDAO orderDetailDAO;
	
	@Autowired
	OrdersDAO orderDAO;
	
	@Autowired
	SessionService sessionService;

	@Autowired
	ShoppingCartService shoppingCartService;
	
	@Autowired
	ProductsDAO productDAO;
	
	@RequestMapping("/add")
	public ModelAndView add(ModelMap model) {
		Collection<CartItemDTO> cartItem = shoppingCartService.getProduct();
		for (CartItemDTO item : cartItem) {
			OrderDetail entityOD = new OrderDetail();

			Product product = productDAO.getById(item.getProductID());

			Order order = sessionService.get("order");
			
			entityOD.setOrder(order);
			entityOD.setProduct(product);
			entityOD.setQuantity(item.getQuantity());
			entityOD.setUnitPrice(item.getUnitPrice());

			orderDetailDAO.save(entityOD);
		}
		model.addAttribute("message", "Create billing successfully. Input infomation");
		sessionService.remove("order");
		shoppingCartService.clear();
		return new ModelAndView("site/orders/ordertb",model);
	}
	@RequestMapping("/list/{orderId}")
	public ModelAndView list(ModelMap model,
			@PathVariable("orderId") Integer orderId) {

		Order order = new Order();
		order = orderDAO.getById(orderId);
		
		System.out.println("oke41");
		
		System.out.println("oke51");
		
		List<OrderDetail> resultPage = null;
		
		System.out.println("oke61");
		if (order != null) {
			resultPage = orderDetailDAO.findByOrder(order);
			
			System.out.println("oke71");
		} 
		model.addAttribute("orderdetails", resultPage);
		return new ModelAndView("site/ordersdetail/list", model);
	}
}
