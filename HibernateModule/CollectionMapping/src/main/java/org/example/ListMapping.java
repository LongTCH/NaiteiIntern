package org.example;
import org.example.entities.Person;
import org.example.entities.PhoneNumber;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ListMapping {
    public static void main(String[] args) {
        ListMapping main = new ListMapping();
        main.get();
    }

    void init(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Person person = new Person();
        person.setName("John Doe");

        PhoneNumber phone1 = new PhoneNumber();
        phone1.setNumber("1234567890");
        PhoneNumber phone2 = new PhoneNumber();
        phone2.setNumber("0987654321");

        person.getPhoneNumbers().add(phone1);
        person.getPhoneNumbers().add(phone2);

        session.save(person);
        transaction.commit();
        session.close();

        HibernateUtil.shutdown();
    }

    void get(){
        Session session = HibernateUtil.getSessionFactory().openSession();

        Person person = session.get(Person.class, 1L); // assuming ID is 1
        System.out.println("Person: " + person.getName());
        for (PhoneNumber phoneNumber : person.getPhoneNumbers()) {
            System.out.println("Phone Number: " + phoneNumber.getNumber());
        }

        session.close();
        HibernateUtil.shutdown();
    }
}