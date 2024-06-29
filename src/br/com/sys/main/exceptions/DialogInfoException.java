package br.com.sys.main.exceptions;

public class DialogInfoException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String content;
	
	public DialogInfoException(String msg) {
		super(msg);
	}
	
	public DialogInfoException(String msg, String content) {
		super(msg);
		this.content = content;
	}

	public DialogInfoException(String msg, Throwable cause) {
		super(msg, cause);
	}
	
	/**
	 * Retorna um conteudo com uma dica, ou ""
	 * @return
	 */
	public String getContent() {
		return content.isBlank() ? "" : content;
	}
	
}
