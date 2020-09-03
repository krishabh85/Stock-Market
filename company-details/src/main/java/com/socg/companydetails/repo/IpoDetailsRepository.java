package com.socg.companydetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socg.companydetails.model.IpoDetails;
@Repository
public interface IpoDetailsRepository extends JpaRepository<IpoDetails, Integer> {

}