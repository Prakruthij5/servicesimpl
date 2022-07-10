package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.exception.FlatNotFoundException;

public interface IFlatService {

	public FlatDto addFlat(FlatDto flatDto);
	
	public FlatDto updateFlat(Integer flatId, Double cost) throws FlatNotFoundException;
	
	public FlatDto deleteFlat(Integer flatId) throws FlatNotFoundException;
	
	public FlatDto viewFlat(Integer flatId) throws FlatNotFoundException;

	public List<FlatDto> viewAllFlat();
	 
}