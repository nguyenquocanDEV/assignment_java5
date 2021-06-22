package com.poly.assignment.controller.site;

import com.poly.assignment.dao.ProductsDAO;
import com.poly.assignment.domain.Product;
import com.poly.assignment.services.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("site/home")
public class HomeControllerSite {

    @Autowired
    ProductsDAO productDAO;
    @Autowired
    SessionService sessionService;

//	@ModelAttribute("customerName")
//	public String getName(Model model) {
//		Customer customer = sessionService.get("customer");
//		model.addAttribute("customerId", customer != null ? customer.getCustomerId(): null);
//		return customer != null ?  customer.getName() :"Người dùng";
//	}

    @RequestMapping("")
    public String home() {
        return "site/products/home";
    }

    @RequestMapping("/searchpaginated")
    public String search(ModelMap model) {


        List<Product> list = productDAO.findAll();

        model.addAttribute("productPage", list);
        return "site/products/producthome";
    }

}
