package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.model.Admin;

@Stateful
public class AdminServiceImpl implements IAdminService {
	// Association UML en java
	@EJB
	IAdminService adminService;

	@Override
	public Admin isExist(Admin a) {
		return adminService.isExist(a);
	}
	
	
}
