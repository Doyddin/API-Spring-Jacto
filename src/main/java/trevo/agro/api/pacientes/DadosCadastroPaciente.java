package trevo.agro.api.pacientes;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import trevo.agro.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @NotBlank
        String email,

        @NotBlank
        String telefone,

        @NotBlank
        String cpf,

        @NotNull @Valid
        DadosEndereco endereco) {

}
