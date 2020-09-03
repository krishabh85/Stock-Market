package com.socg.companydetails.service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.socg.companydetails.model.CompanyDetails;
import com.socg.companydetails.model.StockPrice;
import com.socg.companydetails.repo.CompanyDetailsRepository;
import com.socg.companydetails.repo.IpoDetailsRepository;
import com.socg.companydetails.repo.StockExchangeRepository;


//import com.socg.casestud.register.repository.RegisterRepository;
@Service
public class CompanyDetailsService {
	
	@Autowired
	private CompanyDetailsRepository repo1;
	private StockExchangeRepository repo2;
	private IpoDetailsRepository repo3;

    @Transactional
    public Optional<CompanyDetails> findByCompanyId(Integer companyId) {
    	return repo1.findById(companyId);
    }
    
    @Transactional
    public List<CompanyDetails> findAllCompanies(){
    	return repo1.findAll();
    }

    @Transactional
    public CompanyDetails createCompanyDetails (CompanyDetails companyDetails) {
    	return repo1.save(companyDetails);
    }

    @Transactional
    public CompanyDetails updateCompanyDetails (CompanyDetails companyDetails) {
    	return repo1.save(companyDetails);
    }
    
    @Transactional
    public List<StockPrice> findStockPriceBycompanyId(Integer companyId, Date fromPeriod, Date toPeriod){
    	return null;
    }
    
    
}
