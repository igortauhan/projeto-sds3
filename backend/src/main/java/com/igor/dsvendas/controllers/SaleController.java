package com.igor.dsvendas.controllers;

import com.igor.dsvendas.dto.SaleDTO;
import com.igor.dsvendas.dto.SaleSucessDTO;
import com.igor.dsvendas.dto.SaleSumDTO;
import com.igor.dsvendas.dto.SellerDTO;
import com.igor.dsvendas.entities.Sale;
import com.igor.dsvendas.service.SaleService;
import com.igor.dsvendas.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SaleSumDTO>> amountGroupedBySeller() {
        List<SaleSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/sucess-by-seller")
    public ResponseEntity<List<SaleSucessDTO>> sucessGroupedBySeller() {
        List<SaleSucessDTO> list = service.sucessGroupedBySeller();
        return ResponseEntity.ok(list);
    }
}
