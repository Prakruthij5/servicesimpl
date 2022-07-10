package com.cg.ofr.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.dto.FlatDto;
import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.repository.IFlatRepository;
import com.cg.ofr.service.IFlatService;


@Service
public class FlatService implements IFlatService{
	
	@Autowired
	private IFlatRepository flatRepository;
	
	
	
	public FlatDto addFlat(FlatDto flatDto) {
		Flat flat=new Flat();
		BeanUtils.copyProperties(flatDto, flat);
		flatRepository.saveAndFlush(flat);
		return flatDto;
	}
	
	
	
	public FlatDto updateFlat(Integer flatId, Double cost) throws FlatNotFoundException{
		Flat flat=new Flat();
		FlatDto flatDto=new FlatDto();
		if(!flatRepository.existsById(flatId)) {
			throw new FlatNotFoundException();
	}
		else {
	BeanUtils.copyProperties(flatRepository.findById(flatId),flatDto);
	 flatDto.setCost(cost);
	  BeanUtils.copyProperties(flatDto, flat);
	  flatRepository.flush();
		return flatDto;
		}
		}
	public FlatDto deleteFlat(Integer flatId) throws FlatNotFoundException { 
		Flat flat=new Flat();
		FlatDto flatDto=new FlatDto();
		if(!flatRepository.existsById(flatId)) {
			throw new FlatNotFoundException();
		}else
		{
			BeanUtils.copyProperties(flatRepository.findById(flatId),flatDto);
			flatRepository.deleteById(flatId);
		BeanUtils.copyProperties(flatDto, flat);
		flatRepository.flush();
		 return flatDto;
	}
	}
	 public FlatDto viewFlat(Integer flatId) throws FlatNotFoundException {
		
	    Flat flat=new Flat();
	    FlatDto flatDto=new FlatDto();
	   
		 if(!flatRepository.existsById(flatId)) {
		 
		 throw new FlatNotFoundException();
		 }
		 else {
		 BeanUtils.copyProperties(flatRepository.findById(flatId),flatDto);
		 
			 
			
		 flatRepository.findById(flatId);
			 BeanUtils.copyProperties(flatDto, flat);
			 flatRepository.flush();
	   return flatDto;
		 }
	 }
	 
	 
	 public List<FlatDto> viewAllFlat(){
		 List<FlatDto>flatDtoList=new ArrayList<>();
		 List<Flat>flatList=flatRepository.findAll();
		 FlatDto flatDto=new FlatDto();
		 for(Flat flat:flatList) {
			 BeanUtils.copyProperties(flat,flatDto);
			 flatDtoList.add(flatDto);
		 }
		 return flatDtoList;
	 }


	 
}



	 
