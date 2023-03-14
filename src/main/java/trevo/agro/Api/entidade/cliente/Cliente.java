package trevo.agro.Api.entidade.cliente;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String email;

    private String telefone;

    public String produtoInteresse;

    public Cliente(DadosCadastroCliente cliente) {
        this.nome = cliente.nome();
        this.email = cliente.email();
        this.telefone = cliente.telefone();
    }
}
