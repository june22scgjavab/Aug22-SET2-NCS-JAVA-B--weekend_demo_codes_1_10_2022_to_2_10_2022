package com.infosys.demo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.infosys.demo.dto.TransactionDTO;
import com.infosys.demo.service.TransactionService;

@SpringBootApplication
public class Springboot6Application implements CommandLineRunner{
	@Autowired
	private TransactionService transactionService;   
	public static void main(String[] args) {
		SpringApplication.run(Springboot6Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		 displayTransactions();
		 displayTransactionsAfterDate();

		
	}
	 private void displayTransactionsAfterDate() {
		  LocalDate transactionDate = LocalDate.of(2000, 1, 1);
	        List<TransactionDTO> transactionDTOs=transactionService.transactionAfterADate(transactionDate,0,5);
	        transactionDTOs.forEach(System.out::println);
		
	}
	public void displayTransactions(){

         List<TransactionDTO> transactionDTOs=transactionService.getData(0,5);
          transactionDTOs.forEach(System.out::println);
 }

}
