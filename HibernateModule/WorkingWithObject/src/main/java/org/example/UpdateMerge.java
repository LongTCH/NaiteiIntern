package org.example;

import org.example.entities.Person;
import org.example.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UpdateMerge {
    public static void main(String[] args) {
        UpdateMerge updateMerge = new UpdateMerge();
        updateMerge.update();
    }

    void update() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
//        session.persist(person);
        person.setName("Persist Name");
        session.update(person); // Reattach and update the persistent object
        transaction.commit();
        session.close();
    }

    void saveOrUpdate(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Person person = new Person();
        person.setName("New Name");
        session.saveOrUpdate(person); // Save or update depending on the state
        transaction.commit();
        session.close();
    }

    void merge() {
        Person detachedPerson = new Person();
        detachedPerson.setName("New Merged Name");
        detachedPerson.setId(2L);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Person mergedPerson = session.merge(detachedPerson);
        detachedPerson.setName("Another Name");
        transaction.commit();
        session.close();
    }
}
