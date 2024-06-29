package br.com.sys.client.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import br.com.sys.client.model.domain.Client;
import br.com.sys.main.exceptions.DialogErrorException;
import br.com.sys.main.util.Database;

public class ClientDao implements ClientDaoInterface {

	private Database db = new Database();
	private String sql;
	
	@Override
	public void save(Client t) {
		sql = "INSERT INTO HOSPEDE (NOME,TELEFONE,CPF,RG,NASCIMENTO) VALUES (?,?,?,?,?)";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, t.getName());
			stmt.setString(2, t.getPhone());
			stmt.setString(3, t.getCpf());
			stmt.setString(4, t.getRg());
			stmt.setDate(5, Date.valueOf(t.getBirthday()));
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}

	@Override
	public void update(Client t) {
		sql = "UPDATE HOSPEDE SET NOME=?,TELEFONE=?,CPF=?,RG=?,NASCIMENTO=? WHERE ID_HOSPEDE=?";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, t.getName());
			stmt.setString(2, t.getPhone());
			stmt.setString(3, t.getCpf());
			stmt.setString(4, t.getRg());
			stmt.setDate(5, Date.valueOf(t.getBirthday()));
			stmt.setLong(6, t.getIdClient());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}

	@Override
	public void delete(Client t) {
		sql = "DELETE FROM HOSPEDE WHERE ID_HOSPEDE=?";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setLong(1, t.getIdClient());
			stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}

	@Override
	public List<Client> getAll() {
		sql = "SELECT * FROM HOSPEDE ORDER BY ID_HOSPEDE";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			return getResults(stmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}

	@Override
	public Optional<Client> get(Long id) {
		sql = "SELECT * FROM HOSPEDE WHERE ID_HOSPEDE = ?";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setLong(1, id);
			return  Optional.ofNullable(getResult(stmt));
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}
	
	private Client getResult(PreparedStatement stmt) {
		try (ResultSet res = stmt.executeQuery()) {
			
			if(!res.next())
				return null;
			
			Client client = new Client();
			client.setIdClient(res.getLong("ID_HOSPEDE"));
			client.setName(res.getString("NOME"));
			client.setCpf(res.getString("CPF"));
			client.setPhone(res.getString("TELEFONE"));
			client.setRg(res.getString("RG"));
			client.setBirthday(res.getDate("NASCIMENTO").toLocalDate());
			
			return client;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private List<Client> getResults(PreparedStatement stmt) {
		try (ResultSet res = stmt.executeQuery()) {
			
			List<Client> clientList = new ArrayList<>();
			
			while (res.next()) {
				Client client = new Client();
				client.setIdClient(res.getLong("ID_HOSPEDE"));
				client.setName(res.getString("NOME"));
				client.setCpf(res.getString("CPF"));
				client.setPhone(res.getString("TELEFONE"));
				client.setRg(res.getString("RG"));
				client.setBirthday(res.getDate("NASCIMENTO").toLocalDate());
				clientList.add(client);
			}
			return clientList;			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Client> getByNameOrCpf(String search) {
		sql = "SELECT * FROM HOSPEDE WHERE NOME ILIKE ? OR CPF ILIKE ?";
		try (Connection con = db.getConnection(); PreparedStatement stmt = con.prepareStatement(sql)) {
			
			stmt.setString(1, search + "%");
			stmt.setString(2, search + "%");
			return getResults(stmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DialogErrorException("Erro inesperado", e);
		}
	}

}
