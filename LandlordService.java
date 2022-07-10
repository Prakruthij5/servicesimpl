package com.cg.ofr.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.dto.LandlordDto;
import com.cg.ofr.entities.Landlord;
import com.cg.ofr.exception.LandlordNotFoundException;
import com.cg.ofr.repository.ILandlordRepository;
import com.cg.ofr.service.ILandlordService;


@Service
public class LandlordService implements ILandlordService  {
	
	@Autowired
	private ILandlordRepository landlordRepository;
	

	public LandlordDto addLandlord(LandlordDto landlordDto) {
		Landlord landlord =new Landlord();
		BeanUtils.copyProperties(landlordDto, landlord);
		landlordRepository.saveAndFlush(landlord);
		return landlordDto;
	}
	
	public LandlordDto updateLandlord(Integer landlordId,String landlordName) throws LandlordNotFoundException{
		Landlord landlord =new Landlord();
		LandlordDto landlordDto=new LandlordDto();
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		else {
			BeanUtils.copyProperties(landlordRepository.findById(landlordId),landlordDto);
			landlordDto.setLandlordName(landlordName);
			BeanUtils.copyProperties(landlordDto, landlord);
		landlordRepository.flush();
		return landlordDto;
	}
}


	public LandlordDto deleteLandlord(Integer landlordId)throws LandlordNotFoundException{
		Landlord landlord =new Landlord();
		LandlordDto landlordDto=new LandlordDto();
		if(!landlordRepository.existsById(landlordId)) {
			throw new LandlordNotFoundException();
		}
		else {
			BeanUtils.copyProperties(landlordRepository.findById(landlordId),landlordDto);
			landlordRepository.deleteById(landlordId);
			BeanUtils.copyProperties(landlordDto, landlord);
		landlordRepository.flush();
		return landlordDto;
	}
}


	public LandlordDto viewLandlord(Integer landlordId) throws LandlordNotFoundException{
		Landlord landlord =new Landlord();
		LandlordDto landlordDto=new LandlordDto();
		
	if(!landlordRepository.existsById(landlordId)) {
		throw new LandlordNotFoundException();
	}
	else {
		BeanUtils.copyProperties(landlordRepository.findById(landlordId),landlordDto);
		BeanUtils.copyProperties(landlordDto, landlord);
	landlordRepository.flush();
	return landlordDto;
	
	}
}
	
	public List<LandlordDto> viewAllLandlord(){
		List<LandlordDto> landlordDtoList=new ArrayList<>();
		List<Landlord> landlordList=landlordRepository.findAll();
		
		
		LandlordDto landlordDto=new LandlordDto();
		for(Landlord landlord:landlordList) {
			BeanUtils.copyProperties(landlord, landlordDto);
			landlordDtoList.add(landlordDto);
		}
		return landlordDtoList;
		}	
}





	/*
	 * public Landlord updateLandlord(Landlord landlord) throws
	 * LandlordNotFoundException; public Landlord deleteLandlord(Landlord landlord)
	 * throws LandlordNotFoundException; public Landlord viewLandlord(int id) throws
	 * LandlordNotFoundException; public List<Landlord> viewAllLandlord();
	 */

