package trevo.agro.Api.entidade.login;

import java.time.LocalDate;

public record DadosListagemLogin(Long id, String nome, String email, Role nivelAcesso, LocalDate data_cadastro) {
    public DadosListagemLogin(Login login){
        this(login.getId_cadastros(), login.getNome(), login.getEmail(), login.getNivelAcesso(), login.getDataCadastro());
    }
}
