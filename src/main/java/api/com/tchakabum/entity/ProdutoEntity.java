package api.com.tchakabum.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "TB_PRODUTO")
public class ProdutoEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME_PRODUTO")
    private String nomeProduto;

    @Column(name = "DESCRICAO_PRODUTO")
    private String descricaoProduto;

    @Column(name = "VALOR_PRODUTO")
    private Double valorProduto;

    @Column(name = "QUANTIDADE_PRODUTO")
    private int quantidadeProduto;

    @Column(name = "CATEGORIA_PRODUTO")
    private String categoriaProduto;

    @Column(name = "PROMOCAO_PRODUTO")
    private double promocaoProduto;

    @Column(name = "ID_FORNECEDOR", nullable = true)
    private Long fornecedorProdutoId;
}
