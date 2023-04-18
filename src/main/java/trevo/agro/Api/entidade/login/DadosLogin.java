package trevo.agro.Api.entidade.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DadosLogin(
        @NotBlank
        @Email
        String email,

        @NotBlank
        String senha
) {


}
