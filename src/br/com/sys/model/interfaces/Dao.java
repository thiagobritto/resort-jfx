package br.com.sys.model.interfaces;

import java.util.List;
import java.util.Optional;

public interface Dao<T> {

	void save(T t);

	void update(T t);

	void delete(T t);

	List<T> getAll();

	Optional<T> get(Long id);

}
