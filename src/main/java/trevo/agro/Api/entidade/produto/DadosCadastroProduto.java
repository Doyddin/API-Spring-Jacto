package trevo.agro.Api.entidade.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public record DadosCadastroProduto(
        @NotBlank
        String nome,

        @NotBlank
        String tipoCultura,

        @NotBlank
        String tamanhoArea,

        @NotBlank
        String descProduto,

        @NotNull
        int status

        ) {

}

