package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.dto.LandlordDto;
import com.cg.ofr.exception.LandlordNotFoundException;

public interface ILandlordService {

	public LandlordDto addLandlord(LandlordDto landlordDto);
	
	public LandlordDto updateLandlord(Integer landlordId,String landlordName) throws LandlordNotFoundException;
	
	public LandlordDto deleteLandlord(Integer landlordId)throws LandlordNotFoundException;
	
	public LandlordDto viewLandlord(Integer landlordId) throws LandlordNotFoundException;
	
	public List<LandlordDto> viewAllLandlord();
	
}
