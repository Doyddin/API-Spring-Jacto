package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trevo.agro.Api.entidade.login.DadosCadastroLogin;
import trevo.agro.Api.entidade.login.DadosListagemLogin;
import trevo.agro.Api.entidade.login.DadosLogin;
import trevo.agro.Api.entidade.login.Login;
import trevo.agro.Api.repository.LoginRepository;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private LoginRepository repository;


    public boolean login(DadosLogin dadosLogin){
        return repository.findByEmailAndSenha(dadosLogin.email(), dadosLogin.senha()).isPresent();
    }

    public void criarUsuario(DadosCadastroLogin cadastroLogin){
        Login dadosCadastroLogin = new Login(cadastroLogin);
        repository.save(dadosCadastroLogin);
    }

    public List<Login> listarUsuarios(){
        return repository.findAll();
    }

    public Login listarUsuario(Long idUsuario){
        return repository.findById(idUsuario).get();
    }

    public void editarUsuario(Long idUsuario, DadosCadastroLogin loginEditado){
        Login novoLogin = new Login(loginEditado);

        novoLogin.setId_cadastros(idUsuario);
    }

    public void excluirUsuario(Long idUsuario){
        repository.deleteById(idUsuario);
    }
}
