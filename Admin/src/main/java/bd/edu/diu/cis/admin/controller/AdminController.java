//package bd.edu.diu.cis.admin.controller;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpSession;
//import java.security.Principal;
//
//
//@Controller
//public class AdminController {
//    @GetMapping("/")
//    public String index(Model model,
//                        HttpSession session,
//                        Principal principal) {
//
//        if(principal == null)
//            return "redirect:/login";
//
//        session.setAttribute("username", principal.getName());
//        return "categories";
//    }
//}
package bd.edu.diu.cis.admin.controller;
import bd.edu.diu.cis.library.model.Admin;
import bd.edu.diu.cis.library.service.impl.AdminServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpSession;
import java.security.Principal;

@Controller
public class AdminController {

    private final AdminServiceProxy adminServiceProxy;

    @Autowired
    public AdminController(AdminServiceProxy adminServiceProxy) {
        this.adminServiceProxy = adminServiceProxy;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session, Principal principal) {
        if (principal == null)
            return "redirect:/login";

        session.setAttribute("username", principal.getName());

        // Example: Retrieving admin data using AdminServiceProxy
        String username = principal.getName();
        Admin admin = adminServiceProxy.findByUsername(username);
        model.addAttribute("admin", admin);

        return "categories";
    }
}
