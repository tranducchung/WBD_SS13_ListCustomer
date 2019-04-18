package Controller;

import Service.CustomerServicempl;
import model.Customer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@javax.servlet.annotation.WebServlet(name = "CustomerServlet",urlPatterns = "/customers")
public class CustomerServlet extends javax.servlet.http.HttpServlet {

    private CustomerServicempl customerService = new CustomerServicempl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     String action = request.getParameter("action");
     if(action==null){
         action = "";
     }
     switch (action){
         case "create":
             createCustomer(request,response);
             break;
         case "edit":
             editCustomer(request,response);
             break;
         case "delete":
             deleteCustomer(request,response);
             break;
     }
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        customerService.remove(id);
        try {
            response.sendRedirect("/customers");
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void editCustomer(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        Customer customer = new Customer(id,name,email,address);
        customerService.update(id,customer);

        request.setAttribute("message","Edit finish cutomer");
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/edit.jsp");

        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id ;
        do
            {
                id = (int) (Math.random() * 10000);
        }while (CustomerServicempl.getCustomers().get(id) != null);

        customerService.save(new Customer(id,name,email,address));

        request.setAttribute("message","New customer was created");
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");

        try {
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action==null){
            action="";
        }
        switch (action){
            case "create":
                showCreateForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
            case "delete":
                showDeleteForm(request,response);
                break;
            case "view":
                showViewForm(request,response);
                break;
                default:
                    listCustomers(request,response);
        }
    }

    private void showViewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        request.setAttribute("customer",customer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/view.jsp");

        dispatcher.forward(request,response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);

        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error -404.jsp");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/delete.jsp");
        }
        dispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.findById(id);
        RequestDispatcher dispatcher;
        if(customer == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("customer",customer);
            dispatcher = request.getRequestDispatcher("customer/edit.jsp");
        }
         dispatcher.forward(request,response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/create.jsp");
            dispatcher.forward(request,response);
    }

    private void listCustomers(HttpServletRequest request, HttpServletResponse response){
        ArrayList customers =customerService.findAll();
        request.setAttribute("customers",customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("customer/list.jsp");
        try{
            dispatcher.forward(request,response);
        }catch (ServletException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

