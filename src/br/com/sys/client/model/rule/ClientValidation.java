package br.com.sys.client.model.rule;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import br.com.sys.client.model.domain.Client;
import br.com.sys.main.util.ValidaCPF;

public class ClientValidation {

	public static boolean valide(Client client) {

		if (client.getName().length() < 3)
			return false;

		if (!ValidaCPF.isCPF(client.getCpf()) && !ValidaCPF.isCnpj(client.getCpf()))
			return false;

		if (client.getPhone().replaceAll("[^0-9]", "").length() < 10
				|| client.getPhone().replaceAll("[^0-9]", "").length() > 11)
			return false;

		if (client.getRg().replaceAll("[^0-9]", "").length() < 9
				|| client.getRg().replaceAll("[^0-9]", "").length() > 9)
			return false;

		if (client.getBirthday() == null)
			return false;

		long until = client.getBirthday().until(LocalDate.now(), ChronoUnit.MONTHS);
		if (until / 12 < 18)
			return false;

		return true;
	}

}
