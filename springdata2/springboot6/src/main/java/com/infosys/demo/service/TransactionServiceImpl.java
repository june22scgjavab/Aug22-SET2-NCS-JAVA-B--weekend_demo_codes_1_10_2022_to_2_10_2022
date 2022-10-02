package com.infosys.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.infosys.demo.dto.TransactionDTO;
import com.infosys.demo.entity.Transaction;
import com.infosys.demo.repository.TransactionRepository;
@Service
public class TransactionServiceImpl implements TransactionService {
   @Autowired
   private TransactionRepository transactionRepository;

    public  List<TransactionDTO> getData(int pageNo, int pageSize){
       // We have to create a reference of Pageable which will represent a page
       //  To get an object of Pageable we have to write PageRequest.of(pagenumber,number of records)
       Pageable firstPagewithFiveRecords = PageRequest.of(pageNo,pageSize);
        // With the repository object we called findAll method which will receive a parameter of Pageable type
       //and will return a Page object
       Page<Transaction> transactions = transactionRepository.findAll(firstPagewithFiveRecords);
        // Further from page object we can get a list of objects
       List<Transaction> entityList = transactions.getContent();
       List<TransactionDTO> transactionDTOs=null;
       transactionDTOs = entityList.stream()
				.map(p -> new TransactionDTO(p.getTransactionId(), p.getTransactionDate(), p.getTransactionAmount()))
				.collect(Collectors.toList());
		

   /* for(Transaction transaction : entityList){
     TransactionDTO transactionDTO=new TransactionDTO();
     transactionDTO.setTransactionId(transaction.getTransactionId());
     transactionDTOs.add(transactionDTO); */
     return transactionDTOs;
  
    } 
    public List<TransactionDTO> transactionAfterADate(LocalDate transactionDate,int pageNo, int pageSize){
    	//LocalDate transactionDate = LocalDate.of(1996, 1, 29);
    	Pageable pageable = PageRequest.of(pageNo, pageSize);
    	List<Transaction> entityList = transactionRepository.findByTransactionDateAfter(transactionDate,pageable);
    	List<TransactionDTO> transactionDTOs=null;
    	       transactionDTOs = entityList.stream()
    					.map(p -> new TransactionDTO(p.getTransactionId(), p.getTransactionDate(), p.getTransactionAmount()))
    					.collect(Collectors.toList());
    	  return transactionDTOs;
    	}
 }
