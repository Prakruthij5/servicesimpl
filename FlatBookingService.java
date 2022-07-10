package com.cg.ofr.serviceimpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.dto.FlatBookingDto;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.exception.FlatBookingNotFoundException;

import com.cg.ofr.repository.IFlatBookingRepository;
import com.cg.ofr.service.IFlatBookingService;

@Service
public class FlatBookingService implements IFlatBookingService {
	
	
	@Autowired
	private IFlatBookingRepository flatbookingRepository;
	
	public FlatBookingDto addFlatBooking(FlatBookingDto flatbookingDto) 
	{
		FlatBooking flatbooking=new FlatBooking();
		BeanUtils.copyProperties(flatbookingDto, flatbooking);
		flatbookingRepository.saveAndFlush(flatbooking);
		
		return flatbookingDto;
	}
	
	public List<FlatBookingDto> viewAllFlatBooking() {
		
		List<FlatBookingDto>flatbookingDtoList=new ArrayList<>();
		List<FlatBooking>flatbookingList=flatbookingRepository.findAll();
		
		FlatBookingDto flatbookingDto=new FlatBookingDto();
		for(FlatBooking flatbooking:flatbookingList) {
			BeanUtils.copyProperties(flatbooking, flatbookingDto);
			flatbookingDtoList.add(flatbookingDto);
		}
		
   	 return flatbookingDtoList;
	}


	
	
	  public FlatBookingDto updateFlatBooking(Integer bookingNo,LocalDate bookingFromDate) throws
	  FlatBookingNotFoundException{
		  FlatBooking flatbooking=new FlatBooking();
		  FlatBookingDto flatbookingDto=new FlatBookingDto();
	  if(!flatbookingRepository.existsById(bookingNo)) { 
		  throw new FlatBookingNotFoundException(); }
	  else {
		  BeanUtils.copyProperties(flatbookingRepository.findById(bookingNo),flatbookingDto);
	  flatbookingDto.setBookingFromDate(bookingFromDate);
	  BeanUtils.copyProperties(flatbookingDto, flatbooking);
	  flatbookingRepository.flush();
	  return flatbookingDto;
	  }
	  }
	  
	  public FlatBookingDto deleteFlatBooking(Integer bookingNo) throws FlatBookingNotFoundException{
		  FlatBooking flatbooking=new FlatBooking();
		  FlatBookingDto flatbookingDto=new FlatBookingDto();
	  if(!flatbookingRepository.existsById(bookingNo)) { 
		  throw new FlatBookingNotFoundException(); }
	  else {
		  BeanUtils.copyProperties(flatbookingRepository.findById(bookingNo),flatbookingDto);
	  
	  BeanUtils.copyProperties(flatbookingDto, flatbooking);
	  flatbookingRepository.flush();
	  return flatbookingDto;
	  }
	  }
	  
	  
	  public FlatBookingDto viewFlatBooking(Integer bookingNo) throws  FlatBookingNotFoundException{
		  FlatBooking flatbooking=new FlatBooking();
		  FlatBookingDto flatbookingDto=new FlatBookingDto();
	  if(!flatbookingRepository.existsById(bookingNo)) { 
		  throw new FlatBookingNotFoundException(); } 
	  else {
		  BeanUtils.copyProperties(flatbookingRepository.findById(bookingNo),flatbookingDto);
		  BeanUtils.copyProperties(flatbookingDto, flatbooking);
	  flatbookingRepository.flush();
	  
	  return flatbookingDto;
			}
	 
     
     
     
     

	
	}
}

	

		
//	public Flat updateFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat deleteFlatBooking(Flat flat) throws FlatBookingNotFoundException;
//	public Flat viewFlatBooking(int id) throws FlatBookingNotFoundException;
//	public List<FlatBooking> viewAllFlatBooking();

	


