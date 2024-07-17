package org.example;

import org.example.entities.Person;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;

public class GetLoad {
    public static void main(String[] args) {
        GetLoad getLoad = new GetLoad();
        getLoad.get();
    }

    void get() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person person = session.get(Person.class, 2L);
        System.out.println("Database access");
        System.out.println(person.getName());
        session.close();
    }

    void load() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Person person = session.load(Person.class, 2L);
        System.out.println("No database access yet");
        System.out.println(person.getName());
        session.close();
    }
}
