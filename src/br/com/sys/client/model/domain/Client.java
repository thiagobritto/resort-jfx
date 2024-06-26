package br.com.sys.client.model.domain;

import java.time.LocalDate;
import java.util.Objects;

public class Client {

	private int idClient;
	private String name;
	private String phone;
	private String cpf;
	private String rg;
	private LocalDate birthday;

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, cpf, idClient, name, phone, rg);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		return Objects.equals(birthday, other.birthday) && Objects.equals(cpf, other.cpf) && idClient == other.idClient
				&& Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(rg, other.rg);
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", phone=" + phone + ", cpf=" + cpf + ", rg=" + rg
				+ ", birthday=" + birthday + "]";
	}

}
