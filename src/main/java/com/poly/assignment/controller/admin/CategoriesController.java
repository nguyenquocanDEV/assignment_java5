package com.poly.assignment.controller.admin;


import com.poly.assignment.dao.CategoryDAO;
import com.poly.assignment.domain.Category;
import com.poly.assignment.model.CategoryDTO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("admin/categories")
public class CategoriesController {
    @Autowired
    CategoryDAO categoryDAO;

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("category", new CategoryDTO());
        return "admin/categories/add-edit";
    }

    @GetMapping("edit/{categoryID}")
    public ModelAndView edit(ModelMap model, @PathVariable("categoryID") Long categoryID) {
        CategoryDTO dto = new CategoryDTO();

        Optional<Category> opt = categoryDAO.findById(categoryID);

        if (opt.isPresent()) {
            Category entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("category", dto);

            return new ModelAndView("admin/categories/add-edit", model);
        }
        model.addAttribute("message", "Category is not existed");

        return new ModelAndView("forward:/admin/categories/", model);
    }

    @PostMapping(value = "saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("category") CategoryDTO dto, BindingResult result) {

        //check nếu lỗi thì trả lại view trang add hoặc edit
        if (result.hasErrors()) {
            return new ModelAndView("admin/categories/add-edit");
        }
        Category entity = new Category();
        BeanUtils.copyProperties(dto, entity);

        categoryDAO.save(entity);

        model.addAttribute("message", "Category is saved !");

        return new ModelAndView("forward:/admin/categories/", model);
    }

    @GetMapping("delete/{categoryID}")
    public ModelAndView delete(ModelMap model, @PathVariable("categoryID") Long categoryID) {

        categoryDAO.deleteById(categoryID);
        model.addAttribute("message", "category is delete");

        return new ModelAndView("forward:/admin/categories/", model);
    }

    @RequestMapping(value = " ", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {

        List<Category> list = categoryDAO.findAll();

        model.addAttribute("categories", list);

        return "admin/categories/list";
    }

    @GetMapping("search")
    //dùng required để xác định có param hoặc không có đều được
    public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {

        List<Category> list = null;

        //check xem có giá trị name được truyền vào từ param hay không
        if (StringUtils.hasText(name)) {
            list = categoryDAO.findByNameContaining(name);
        } else {
            list = categoryDAO.findByNameContaining(name);
        }
        //thêm list cate vào attribute để hiển thị lên form
        model.addAttribute("categories", list);

        return "admin/categories/list";
    }

}
