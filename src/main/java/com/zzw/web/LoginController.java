package com.zzw.web;

import com.zzw.dto.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class LoginController {

    /**
     * 登录默认页面，已登录则自动跳转
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "")
    public String index(HttpSession session, Model model) {
        String userId = (String) session.getAttribute("userId");
        if (userId == null) {
            model.addAttribute("loginInfo", "");
            return "page-login";
        } else {
            return "redirect:/mgr/";
        }
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("userId");
        return "redirect:/";
    }

    /**
     * 登录并跳转
     *
     * @param request
     * @param session
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request,
                        HttpSession session,
                        Model model) {
        String userName = request.getParameter("username");
        if (userName != null && userName.equals("zzw")) {
            session.setAttribute("userId", userName);
            return "redirect:/mgr/";
        } else {
            model.addAttribute("loginInfo", "用户名错误，登录失败");
            return "page-login";
        }
    }

}
























