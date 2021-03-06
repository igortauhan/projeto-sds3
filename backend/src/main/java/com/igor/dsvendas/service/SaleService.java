package com.igor.dsvendas.service;

import com.igor.dsvendas.dto.SaleDTO;
import com.igor.dsvendas.dto.SaleSucessDTO;
import com.igor.dsvendas.dto.SaleSumDTO;
import com.igor.dsvendas.dto.SellerDTO;
import com.igor.dsvendas.entities.Sale;
import com.igor.dsvendas.entities.Seller;
import com.igor.dsvendas.repositories.SaleRepository;
import com.igor.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    @Transactional(readOnly = true)
    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(x -> new SaleDTO(x));
    }

    @Transactional
    public List<SaleSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional
    public List<SaleSucessDTO> sucessGroupedBySeller() {
        return repository.sucessGroupedBySeller();
    }
}
