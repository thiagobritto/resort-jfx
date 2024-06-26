package br.com.sys.model.interfaces;

@FunctionalInterface
public interface Hook<T> {	
	void hang(T controller);
}
