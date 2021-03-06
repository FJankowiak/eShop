package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IAdminDao;
import fr.adaming.model.Admin;

@Stateful
public class AdminServiceImpl implements IAdminService {
	// Association UML en java
	@EJB
	private IAdminDao adminDao;

	@Override
	public Admin isExist(Admin a) {
		return adminDao.isExist(a);

	}

}
