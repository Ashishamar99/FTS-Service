package com.hcltech.fts.dao;

import com.hcltech.fts.model.Benefeciary;
import com.hcltech.fts.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BenefeciaryRepository extends JpaRepository<Benefeciary, String> {
}
