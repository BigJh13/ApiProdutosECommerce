package api.com.tchakabum.exception.handler;

import api.com.tchakabum.exception.MsgException;
import api.com.tchakabum.exception.NaoEncontradoException;
import api.com.tchakabum.exception.model.ExceptionResponseVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

	private static final String HEADER_MESSAGE = "mensagem";

	private static final String TITLE_ERRO_REGRA_NEGOCIO = "Regra de negócio";
	private static final String TITLE_PARAMETROS_INVALIDOS = "Parâmetros inválidos";
	private static final String TITLE_DADOS_JA_CADASTRADOS = "Dados já cadastrados";
	private static final String TITLE_ERRO_SERVIDOR = "Erro no servidor";
	private static final String TITLE_NAO_ENCONTRADO = "Registro não encontrado";

	private static final String TYPE_VALIDACAO_REGRA_NEGOCIO = "Validação de regras de negócio";
	private static final String TYPE_VALIDACAO_PARAMETROS = "Validação de Parâmetros";
	private static final String TYPE_DADOS_JA_CADASTRADOS = "Dados já cadastrados";
	private static final String TYPE_ERRO_INESPERADO = "Erro inesperado";
	private static final String TYPE_NAO_ENCONTRADO = "Registro não encontrado";

	@ExceptionHandler(MsgException.class)
	public ResponseEntity<Object> handleDadosJaCadastradosException(MsgException e, ServletWebRequest request) {
		logger.warn(e.getMessage());

		ExceptionResponseVO bodyExceptionResponse = criarExceptionResponse(TITLE_ERRO_REGRA_NEGOCIO,
				TYPE_VALIDACAO_REGRA_NEGOCIO, Arrays.asList(e.getMessage()), request.getRequest().getRequestURI());

		HttpHeaders header = new HttpHeaders();
		header.add(HEADER_MESSAGE, e.getMessage());

		return handleExceptionInternal(e, bodyExceptionResponse, header, org.springframework.http.HttpStatus.BAD_REQUEST, request);
	}
	
	@ExceptionHandler(NaoEncontradoException.class)
	public ResponseEntity<Object> handleNaoEncontradoException(NaoEncontradoException e, ServletWebRequest request) {
		logger.warn(e.getMessage());

		ExceptionResponseVO bodyExceptionResponse = criarExceptionResponse(TITLE_NAO_ENCONTRADO,
				TYPE_NAO_ENCONTRADO, Arrays.asList(e.getMessage()), request.getRequest().getRequestURI());
		
		HttpHeaders header = new HttpHeaders();
		header.add(HEADER_MESSAGE, e.getMessage());

		return handleExceptionInternal(e, bodyExceptionResponse, header,  org.springframework.http.HttpStatus.NOT_FOUND, request);
	}
	
	private ExceptionResponseVO criarExceptionResponse(String title, String type, List<String> detail,
			String instance) {
		ExceptionResponseVO ex = new ExceptionResponseVO();

		ex.setDetail(detail);
		ex.setInstance(instance);
		ex.setTitle(title);
		ex.setType(type);
		return ex;

	}
}
