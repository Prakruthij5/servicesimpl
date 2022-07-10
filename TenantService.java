package com.cg.ofr.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.dto.TenantDto;
import com.cg.ofr.entities.Tenant;
import com.cg.ofr.exception.TenantNotFoundException;
import com.cg.ofr.repository.ITenantRepository;
import com.cg.ofr.service.ITenantService;

@Service
public class TenantService implements ITenantService  {
	@Autowired
	private ITenantRepository tenantRepository;
	
	public TenantDto addTenant(TenantDto tenantDto) {
		Tenant tenant=new Tenant();
		BeanUtils.copyProperties(tenantDto, tenant);
		tenantRepository.save(tenant);
		return tenantDto;
	}
	
public TenantDto updateTenant(int tenant_id,int age) throws TenantNotFoundException {
	Tenant tenant=new Tenant();
	TenantDto tenantDto=new TenantDto();
	    
		if(!tenantRepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
		
		}
		else {
			BeanUtils.copyProperties(tenantRepository.findById(tenant_id),tenantDto);
			
	tenant.setAge(tenant_id);
	BeanUtils.copyProperties(tenantDto,tenant);
	tenantRepository.flush();
	return tenantDto;
		}
}

public TenantDto deleteTenant(int tenant_id) throws TenantNotFoundException {
	Tenant tenant=new Tenant();
	TenantDto tenantDto=new TenantDto();
		if(!tenantRepository.existsById(tenant_id)) {
			throw new TenantNotFoundException();
	    }	
		else {
			BeanUtils.copyProperties(tenantRepository.findById(tenant_id),tenantDto);
			tenantRepository.deleteById(tenant_id);
			BeanUtils.copyProperties(tenantDto, tenant);
			tenantRepository.flush();
			return tenantDto;
		}
}
	
public TenantDto viewTenant(int tenant_id) throws TenantNotFoundException{
	Tenant tenant=new Tenant();
	TenantDto tenantDto=new TenantDto();
	tenantRepository.findById(tenant_id);
	    if(tenantRepository.findById(tenant_id).get()==null) {
	    	
			throw new TenantNotFoundException();
	    }
	    else {
	    	BeanUtils.copyProperties(tenantRepository.existsById(tenant_id),tenantDto);
	    	tenantRepository.findById(tenant_id);
	    	BeanUtils.copyProperties(tenantDto,tenant);
	    	tenantRepository.flush();
	    
			return tenantDto;
	    }
	}	

public List<TenantDto> viewAllTenant(){
	List<TenantDto> tenantDtoList=new ArrayList<>();
	List<Tenant> tenantList=tenantRepository.findAll();
	TenantDto tenantDto=new TenantDto();
	for(Tenant tenant:tenantList) {
		BeanUtils.copyProperties(tenant,tenantDto);
		tenantDtoList.add(tenantDto);
	}
		
	
	
	return tenantDtoList;
}



public TenantDto validateTenantById(int tenant_Id)  {
	Tenant tenant=new Tenant();
	TenantDto tenantDto=new TenantDto();
	tenantRepository.findById(tenant_Id);
	    //if(tenantRepository.findById(tenant_Id).get()==null) {
	    	
			
	   // }
	    //else {
	    	BeanUtils.copyProperties(tenantRepository.existsById(tenant_Id),tenantDto);
	    	tenantRepository.findById(tenant_Id);
	    	BeanUtils.copyProperties(tenantDto,tenant);
	    	tenantRepository.flush();
	    
			return tenantDto;
	    }
}

	




