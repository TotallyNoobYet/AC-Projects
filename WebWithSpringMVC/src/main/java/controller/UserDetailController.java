package controller;

import model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserDetailController {


    @RequestMapping(method = RequestMethod.GET, value = "/hello")
    public String showDetails(Model model) {

        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("JohnDoea@gmail.com");

        model.addAttribute("customer", customer);

        return "CustomerDetails";

    }


}
