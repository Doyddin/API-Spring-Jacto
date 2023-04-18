package trevo.agro.Api.entidade.login;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroLogin(
    @NotBlank
    @Email
    String email,

    @NotBlank
    String nome,

    @NotBlank
    String senha,

    @NotNull
    Role nivelAcesso
) {
}
