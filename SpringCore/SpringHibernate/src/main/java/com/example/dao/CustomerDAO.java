package com.example.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.example.entities.Customer;
@Repository
@Transactional
public class CustomerDAO {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Customer customer) {
        entityManager.persist(customer);
    }
    public void update(Customer customer) {
        entityManager.merge(customer);
    }
    public List<Customer> findAll() {
        return entityManager.createQuery("FROM Customer", Customer.class)
                .getResultList();
    }
    public Customer findById(int id) {
        return entityManager.find(Customer.class, id);
    }
    public void delete(Customer customer) {
        entityManager.remove(entityManager.contains(customer) ? customer : entityManager.merge(customer));
    }
}
