package br.com.sys.main.interfaces;

@FunctionalInterface
public interface Hook<T> {	
	void hang(T controller);
}
