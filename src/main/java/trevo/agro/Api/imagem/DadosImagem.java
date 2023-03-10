package trevo.agro.Api.imagem;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "imagens")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DadosImagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String tipo;

    @Lob
    @Column(name = "dadosImagem")
    private byte[] dadosImagem;

}
