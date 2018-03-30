package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {
	// Association UML en java
	@EJB
	private IClientDao clientDao;

	@Override
	public Client isExist(Client a) {
		return clientDao.addClient(a);
	}
	
	
}
