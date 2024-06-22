package br.com.sys.app.model.interfaces;

@FunctionalInterface
public interface HookController<T> {
	
	void hang(T controller);
}
