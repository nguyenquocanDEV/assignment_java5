package com.poly.assignment.controller.admin;


import com.poly.assignment.dao.CustomerDAO;
import com.poly.assignment.domain.Customer;
import com.poly.assignment.model.CategoryDTO;
import com.poly.assignment.model.CustomerDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {

    @Autowired
    CustomerDAO customerDAO;


    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "admin/customers/add-edit";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid @ModelAttribute("customer") CustomerDTO dto,
                                     BindingResult result) {


        Customer entity = new Customer();
        BeanUtils.copyProperties(dto, entity);

        customerDAO.save(entity);

        model.addAttribute("message", "customer is save");

        return new ModelAndView("forward:/admin/customers/", model);
    }

    @RequestMapping(value = " ", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {

        List<Customer> list = customerDAO.findAll();


		model.addAttribute("customers",list);
		return"admin/customers/list";
}

    @GetMapping("/edit/{customerId}")
    public ModelAndView edit(ModelMap model,
                             @PathVariable("customerId") Integer customerId) {

        Optional<Customer> opt = customerDAO.findById(customerId);
        CustomerDTO dto = new CustomerDTO();

        if (opt.isPresent()) {
            Customer entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("customer", dto);
            return new ModelAndView("admin/customers/add-edit", model);
        }
        model.addAttribute("message", "Customer is not exits");
        return new ModelAndView("forward:admin/customers/", model);
    }

    @GetMapping("/delete/{customerId}")
    public ModelAndView delete(ModelMap model,
                               @PathVariable("customerId") Integer customerId) {

        customerDAO.deleteById(customerId);

        return new ModelAndView("forward:/admin/customers/", model);
    }

}
