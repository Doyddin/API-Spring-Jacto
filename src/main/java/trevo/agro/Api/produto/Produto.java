package trevo.agro.Api.produto;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Table(name = "produtos")
@Entity(name = "Produto")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipoCultura;
    private String tamanhoArea;
    private String listaFotos;
    private String dataCadastro;
    private String descProduto;
    private String status;


    public Produto(DadosCadastroProduto produto) {
        this.nome = produto.nome();
        this.tipoCultura = produto.tipoCultura();
        this.tamanhoArea = produto.tamanhoArea();
        this.dataCadastro = produto.dataCadastro();
        this.descProduto = produto.descProduto();
    }
}
