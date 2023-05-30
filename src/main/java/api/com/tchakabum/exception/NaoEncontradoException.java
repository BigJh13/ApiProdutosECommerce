package api.com.tchakabum.exception;

public class NaoEncontradoException extends RuntimeException {

	private static final long serialVersionUID = -3522355483151005629L;

	public NaoEncontradoException(String msg) {
		super(msg);
	}
}
