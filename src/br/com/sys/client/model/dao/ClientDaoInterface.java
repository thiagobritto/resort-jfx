package br.com.sys.client.model.dao;

import java.util.List;

import br.com.sys.client.model.domain.Client;
import br.com.sys.main.interfaces.Dao;

public interface ClientDaoInterface extends Dao<Client> {

	List<Client> getByNameOrCpf(String search);
	
}
