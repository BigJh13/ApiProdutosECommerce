package api.com.tchakabum.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude
public class ProdutoVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String descricao;
    private Double valor;
    private String categoria;
    private Integer quantidade;
    private Double promocao;
    private String urlImagem;
    private Long idFornecedor;

}
