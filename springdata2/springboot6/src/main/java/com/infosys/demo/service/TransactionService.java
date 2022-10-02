package com.infosys.demo.service;

import java.time.LocalDate;
import java.util.List;

import com.infosys.demo.dto.TransactionDTO;

public interface TransactionService {
      List<TransactionDTO> getData(int pageNo, int pageSize);
      List<TransactionDTO> transactionAfterADate(LocalDate transactionDate,int pageNo, int pageSize);
     }