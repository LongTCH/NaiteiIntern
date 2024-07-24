package com.example.main;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.example.dao.CustomerDAO;
import com.example.entities.Customer;
public class MainApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        customerDAO.save(new Customer("Jack", "London"));
        customerDAO.save(new Customer("John", "Anh"));

        List<Customer> listCustomer = customerDAO.findAll();
        for (Customer customer : listCustomer) {
            System.out.println(customer.getId() + " - " + customer.getName() + " - " + customer.getAddress());
        }

//        Customer customerToUpdate = listCustomer.get(0);
//        customerToUpdate.setAddress("Canada");
//        customerDAO.update(customerToUpdate);

//        Customer customerToDelete = listCustomer.get(0);
//        customerDAO.delete(customerToDelete);
        context.close();
    }
}