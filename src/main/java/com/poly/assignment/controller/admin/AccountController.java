package com.poly.assignment.controller.admin;


import com.poly.assignment.dao.AccountsDAO;
import com.poly.assignment.dao.AccountsDAO;
import com.poly.assignment.domain.Account;
import com.poly.assignment.model.AccountDTO;
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
@RequestMapping("admin/accounts")
public class AccountController {
    @Autowired
    AccountsDAO accountsDAO;

    @RequestMapping("add")
    public String add(Model model) {
        model.addAttribute("account", new AccountDTO());
        return "admin/accounts/add-edit";
    }

    @PostMapping(value = "saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model, @Valid @ModelAttribute("account") AccountDTO dto, BindingResult result) {

        //check nếu lỗi thì trả lại view trang add hoặc edit
        if (result.hasErrors()) {
            return new ModelAndView("admin/accounts/add-edit");
        }
        Account entity = new Account();
        BeanUtils.copyProperties(dto, entity);

        accountsDAO.save(entity);

        model.addAttribute("message", "account is saved !");

        return new ModelAndView("forward:/admin/accounts/", model);
    }

    @RequestMapping(value = " ", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {

        List<Account> list = accountsDAO.findAll();

        model.addAttribute("accounts", list);

        return "admin/accounts/list";
    }

    @GetMapping("edit/{username}")
    public ModelAndView edit(ModelMap model, @PathVariable("username") String username) {
        AccountDTO dto = new AccountDTO();

        Optional<Account> opt = accountsDAO.findById(username);

        if (opt.isPresent()) {
            Account entity = opt.get();
            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("account", dto);

            return new ModelAndView("admin/accounts/add-edit", model);
        }
        model.addAttribute("message", "account is not found");

        return new ModelAndView("forward:/admin/accounts/", model);
    }



    @GetMapping("delete/{username}")
    public ModelAndView delete(ModelMap model, @PathVariable("username") String username) {

        accountsDAO.deleteById(username);
        model.addAttribute("message", "account is delete");

        return new ModelAndView("forward:/admin/accounts/", model);
    }





}
