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
    private String nome;

    @Column(name = "DESCRICAO_PRODUTO")
    private String descricao;

    @Column(name = "VALOR_PRODUTO")
    private Double valor;

    @Column(name = "QUANTIDADE_PRODUTO")
    private int quantidade;

    @Column(name = "CATEGORIA_PRODUTO")
    private String categoria;

    @Column(name = "PROMOCAO_PRODUTO")
    private double promocao;

    @Column(name = "ID_FORNECEDOR", nullable = true)
    private Long idFornecedor;
}
