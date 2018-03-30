package fr.adaming.service;

import javax.ejb.EJB;
import javax.ejb.Stateful;

import fr.adaming.model.Client;

@Stateful
public class ClientServiceImpl implements IClientService {
	// Association UML en java
	@EJB
	IClientService clientService;

	@Override
	public Client isExist(Client a) {
		return clientService.isExist(a);
	}
	
	
}
