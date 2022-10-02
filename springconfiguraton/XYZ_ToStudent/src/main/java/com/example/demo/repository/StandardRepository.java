package com.example.demo.repository;

import java.util.List;

import com.example.demo.exception.XyzException;
import com.example.demo.model.StandardDTO;


public interface StandardRepository {
	public Integer addStandard(StandardDTO project) throws XyzException;
	public List<StandardDTO>  getStandardDetails() throws XyzException;
}
