package br.com.sys.main.model.exception;

public class DialogErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String content;
	
	public DialogErrorException(String msg) {
		super(msg);
	}
	
	public DialogErrorException(String msg, String content) {
		super(msg);
		this.content = content;
	}

	public DialogErrorException(String msg, Throwable cause) {
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
