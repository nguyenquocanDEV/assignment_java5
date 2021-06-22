package com.poly.assignment.controller.site;

import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Product;
import com.poly.assignment.model.ProductDTO;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("site/product")
public class ProductControllerSite {
	
	@Autowired
	ProductsDAO productDAO;
	
	@RequestMapping("/detail/{productId}")
	public ModelAndView test(ModelMap model,
			@PathVariable("productId") Long productId) {
			
			Optional<Product> opt = productDAO.findById(productId);
			ProductDTO dto = new ProductDTO();
			if(opt.isPresent()) {
				Product entity = opt.get();
				BeanUtils.copyProperties(entity, dto);
				
				model.addAttribute("product", dto);
				
				return new ModelAndView("site/products/productdetail", model);
			}
			
		model.addAttribute("product", new ProductDTO());
		
		return new ModelAndView("site/products/productdetail", model);
	}
}
