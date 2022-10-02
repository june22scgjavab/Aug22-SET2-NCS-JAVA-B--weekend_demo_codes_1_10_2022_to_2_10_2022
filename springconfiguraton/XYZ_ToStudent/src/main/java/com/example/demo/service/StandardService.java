package com.example.demo.service;

import java.util.List;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StandardDTO;

public interface StandardService {
	public Integer addStandard(StandardDTO project) throws XyzException;	
	public List<StandardDTO> getStandardDetails(int standard) throws XyzException ;
}
