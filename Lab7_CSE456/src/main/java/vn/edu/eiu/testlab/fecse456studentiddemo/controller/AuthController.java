package vn.edu.eiu.testlab.fecse456studentiddemo.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.eiu.testlab.fecse456studentiddemo.model.User;
import vn.edu.eiu.testlab.fecse456studentiddemo.service.UserService;

@Controller
public class AuthController {
    // show login page
    @Autowired
    UserService userServ;

    @GetMapping({"/", "/login"})
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/auth")
    public String doLogin(@ModelAttribute User user, HttpSession ses, RedirectAttributes ra) {
        User loginUser = userServ.findByUserName(user.getUserName());
        // check username in db, if not exist -> return to login
        if(loginUser == null) {
            ra.addFlashAttribute("errLogin", "Username or password is incorrect");
            ra.addFlashAttribute("username", user.getUserName());
            return "redirect:/login";
        }
        if(!loginUser.getPassword().equals(user.getPassword())) {
            ra.addFlashAttribute("errLogin", "Username or password is incorrect");
            ra.addFlashAttribute("username", user.getUserName());
            return  "redirect:/login";
        }
        //if login sucess -> return to list page

        ses.setAttribute("user", loginUser);
        return "redirect:/students";
    }

    @GetMapping("/logout")
    public String logout(HttpSession ses) {
//        ses.setAttribute("user", null);
//        ses.removeAttribute("user");
        ses.invalidate();
        return "redirect:/login";
    }

}
