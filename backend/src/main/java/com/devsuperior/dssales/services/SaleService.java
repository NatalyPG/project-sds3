package com.devsuperior.dssales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.devsuperior.dssales.dto.SaleDTO;
import com.devsuperior.dssales.dto.SalesSuccessDTO;
import com.devsuperior.dssales.dto.SalesSumDTO;
import com.devsuperior.dssales.entities.Sale;
import com.devsuperior.dssales.repositories.SaleRepository;
import com.devsuperior.dssales.repositories.SellerRepository;


@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SalesSumDTO> amountGroupedBySeller(){
		return repository.amountGroupedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SalesSuccessDTO> successGroupedBySeller(){
		return repository.successGroupedBySeller();
	}
}
