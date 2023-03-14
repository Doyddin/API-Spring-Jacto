package trevo.agro.Api.entidade.produto;


import jakarta.persistence.*;
import lombok.*;


@Table(name = "produto")
@Entity(name = "Produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipoCultura;
    private String tamanhoArea;
    private String dataCadastro;
    private String descProduto;
    private int status;


    public Produto(DadosCadastroProduto produto) {
        this.nome = produto.nome();
        this.tipoCultura = produto.tipoCultura();
        this.tamanhoArea = produto.tamanhoArea();
        this.descProduto = produto.descProduto();
    }
}
