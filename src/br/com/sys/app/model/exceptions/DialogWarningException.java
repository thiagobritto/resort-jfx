package br.com.sys.app.model.exceptions;

public class DialogWarningException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String content;
	
	public DialogWarningException(String msg) {
		super(msg);
	}
	
	public DialogWarningException(String msg, String content) {
		super(msg);
		this.content = content;
	}

	public DialogWarningException(String msg, Throwable cause) {
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
