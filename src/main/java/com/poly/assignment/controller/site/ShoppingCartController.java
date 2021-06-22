package com.poly.assignment.controller.site;

import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Product;
import com.poly.assignment.model.CartItemDTO;
import com.poly.assignment.services.ShoppingCartService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("site/shoppingCart")
public class ShoppingCartController {

	@Autowired
	ProductsDAO productDAO;
	
	@Autowired
	ShoppingCartService shoppingCartService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		Collection<CartItemDTO> cartItem = shoppingCartService.getProduct();
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("total", shoppingCartService.getAmount());
		model.addAttribute("NoOfItems", shoppingCartService.getCount());
		
		return "site/shoppingCarts/list";
	}
	
	@GetMapping("/add/{productID}")
	public String add(@PathVariable("productID") Long productId) {
		Optional<Product> opt = productDAO.findById(productId);
		if(opt.isPresent()) {
			Product product = opt.get();
			CartItemDTO item = new CartItemDTO();
			
			BeanUtils.copyProperties(product, item);
			
			item.setQuantity(1);
			shoppingCartService.add(item);
		}
		return "redirect:/site/shoppingCart/list";
	}
	@GetMapping("/remove/{productID}")
	public String remove(@PathVariable("productID") Long productId) {
		
		shoppingCartService.remove(productId);;
		
		return "redirect:/site/shoppingCart/list";
	}	
	
	@PostMapping("/update")
	public String update(@RequestParam("productID") Long productId,
			@RequestParam("quantity") Integer quantity) {
		
		shoppingCartService.update(productId, quantity);
		
		return "redirect:/site/shoppingCart/list";
	}
}
