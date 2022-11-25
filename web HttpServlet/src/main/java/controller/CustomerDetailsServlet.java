package controller;

import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CustomerDetailsServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("johndoe@academiadecodigo.org");

        getServletContext().setAttribute("customer", customer);


        RequestDispatcher page1Dispatcher = getServletContext().getRequestDispatcher("/CustomerDetails.jsp");
        page1Dispatcher.forward(request, response);


    }
}
