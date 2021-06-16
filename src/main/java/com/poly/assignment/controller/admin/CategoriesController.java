package com.poly.assignment.controller.admin;


import com.poly.assignment.domain.Category;
import com.poly.assignment.model.CategoryDTO;
import com.poly.assignment.services.CategoryServices;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin/categories")
public class CategoriesController {
    @Autowired
    CategoryServices categoryDAO;


    @GetMapping({"add", "edit/{categoryid"})

    public String add_edit(Model model, HttpServletRequest req) {
        if (req.getRequestURI() == "add") {
            model.addAttribute("category", new CategoryDTO());
        }

        return "admin/categories/add-edit";
    }

    @PostMapping("saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, CategoryDTO dto) {

        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);

        categoryDAO.save(entity);

        model.addAttribute("message", "Category is saved !");

        return new ModelAndView("forward:/admin/categories/", model);
    }

    @GetMapping("delete/{categoryid")
    public String delete() {
        return "redirect:/admin/categories/";
    }

    @GetMapping(" ")
    public String list(ModelMap model) {

        List<Category> list = categoryDAO.findAll();

        model.addAttribute("categories", list);

        return "admin/categories/list";
    }

    @GetMapping("search")
    public String search() {
        return "admin/categories/search";
    }
}
