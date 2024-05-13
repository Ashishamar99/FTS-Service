package com.hcltech.fts.service;

import com.hcltech.fts.config.HibernateAnnotationUtil;
import com.hcltech.fts.dao.CustomerRepository;
import com.hcltech.fts.model.Account;
import com.hcltech.fts.model.Benefeciary;
import com.hcltech.fts.model.Customer;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class FTSService {
    @Autowired
    CustomerRepository customerRepository;

    public Customer getCustomerFromId(String cid) {
        Optional<Customer> optionalCustomer = customerRepository.findById(cid);
        if(optionalCustomer.isPresent()){
            return optionalCustomer.get();
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer Not Found With Id:: " + cid);
        }
    }

   public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

//    public void generateTestData() {
//
//        Account account = new Account();
//        Benefeciary benefeciary = new Benefeciary();
//        Benefeciary benefeciary1 = new Benefeciary();
//
//        Set<Benefeciary> benefeciarySet = new HashSet<>();
//        benefeciarySet.add(benefeciary);
//        benefeciarySet.add(benefeciary1);
//
//
//
//        SessionFactory sessionFactory = HibernateAnnotationUtil.getSessionFactory();
//        Session session = sessionFactory.getCurrentSession();
////        try{
////            Transaction transaction = session.beginTransaction();
////
////        }
//    }

}
