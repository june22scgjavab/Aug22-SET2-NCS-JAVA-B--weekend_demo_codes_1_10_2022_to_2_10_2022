package com.infosys.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.infosys.demo.entity.Transaction;
@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Integer>{
	public List<Transaction> findByTransactionDateAfter(LocalDate transactionDate, Pageable pageable);

}