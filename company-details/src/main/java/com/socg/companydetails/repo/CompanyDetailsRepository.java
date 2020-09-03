package com.socg.companydetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.socg.companydetails.model.CompanyDetails;
@Repository
public interface CompanyDetailsRepository extends JpaRepository<CompanyDetails, Integer> {

}
