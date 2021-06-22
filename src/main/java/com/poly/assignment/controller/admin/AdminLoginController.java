package com.poly.assignment.controller.admin;

import com.poly.assignment.dao.AccountsDAO;
import com.poly.assignment.domain.Account;
import com.poly.assignment.model.AccountDTO;
import com.poly.assignment.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes("sessionScope")
@RequestMapping("admin/logins")
public class AdminLoginController {
    @Autowired
    AccountsDAO accountsDAO;

    @Autowired
    SessionService sessionService;

    @RequestMapping("")
    public String form(Model model) {

        AccountDTO login = new AccountDTO();
        model.addAttribute("account", login);

        return "admin/accounts/login";

    }

    @PostMapping("/login")
    public ModelAndView login(ModelMap model, @Valid @ModelAttribute("account") AccountDTO dto, BindingResult result) {

        if (result.hasErrors()) {
            model.addAttribute("message", "Error");
            return new ModelAndView("admin/accounts/login", model);
        } else {
            Optional<Account> opt = accountsDAO.findById(dto.getUsername());
            if (opt.isEmpty()) {
                model.addAttribute("message", "Invalid account");
                return new ModelAndView("admin/accounts/login", model);
            } else {
                Account account = opt.get();
                if (!account.getPassword().equals(dto.getPassword())) {
                    model.addAttribute("message", "password wrong");
                    return new ModelAndView("admin/accounts/login", model);
                } else {
                    sessionService.set("account", account);

                }
            }
        }

        return new ModelAndView("redirect:/admin/customers/", model);
    }

    @RequestMapping("/logout")
    public ModelAndView logOut() {
        sessionService.remove("account");
        ;
        return new ModelAndView("forward:/admin/logins");

    }


}
