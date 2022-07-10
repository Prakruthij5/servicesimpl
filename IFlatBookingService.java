package com.cg.ofr.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.ofr.dto.FlatBookingDto;
import com.cg.ofr.exception.FlatBookingNotFoundException;

public interface IFlatBookingService {

	public FlatBookingDto addFlatBooking(FlatBookingDto flatbookingDto);
	
	public List<FlatBookingDto> viewAllFlatBooking();
	
	public FlatBookingDto updateFlatBooking(Integer bookingNo, LocalDate bookingFromDate) throws
	  FlatBookingNotFoundException;
	 
	public FlatBookingDto deleteFlatBooking(Integer bookingNo) throws
	  FlatBookingNotFoundException;
	 
	public FlatBookingDto viewFlatBooking(Integer bookingNo) throws
	  FlatBookingNotFoundException;
	 
	 
	
}
