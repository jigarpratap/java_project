package com.wecp.progressive.controller;


import com.wecp.progressive.entity.CreditCard;
import com.wecp.progressive.service.CreditCardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/credit-cards")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;
    @GetMapping
    public ResponseEntity<List<CreditCard>> getAllCreditCards() {
        return new ResponseEntity<List<CreditCard>>(creditCardService.getAllCreditCards(), HttpStatus.OK);
    }
@GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        CreditCard localCreditCard = creditCardService.getCreditCardById(id);
        if (localCreditCard != null) {
            return new ResponseEntity<>(localCreditCard, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<CreditCard>(creditCardService.createCreditCard(creditCard), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        CreditCard foundCard = creditCardService.getCreditCardById(id);
        if (foundCard != null) {
            creditCard.setId(id);
            creditCardService.updateCreditCard(creditCard);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        CreditCard foundCard = creditCardService.getCreditCardById(id);
        if (foundCard != null) {
            creditCardService.deleteCreditCard(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}