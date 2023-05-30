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
    private String nomeProduto;
    private String descricaoProduto;
    private Double valorProduto;
    private String categoriaProduto;
    private Integer quantidadeProduto;
    private Double promocaoProduto;
    private Long forncedorId;

}
