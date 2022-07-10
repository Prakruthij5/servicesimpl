package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.dto.TenantDto;
import com.cg.ofr.exception.TenantNotFoundException;

public interface ITenantService {

	public TenantDto addTenant(TenantDto tenantDto);
	
	public TenantDto updateTenant(int tenant_id,int age) throws TenantNotFoundException;
	
	public TenantDto deleteTenant(int tenant_id) throws TenantNotFoundException ;
	
	public TenantDto viewTenant(int tenant_id) throws TenantNotFoundException;
	
	public List<TenantDto> viewAllTenant();
	
	public TenantDto validateTenantById(int tenant_Id);
	
}
