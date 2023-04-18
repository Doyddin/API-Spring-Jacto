package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import trevo.agro.Api.entidade.login.DadosListagemLogin;
import trevo.agro.Api.entidade.login.DadosLogin;
import trevo.agro.Api.entidade.login.Login;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {

    Optional<DadosLogin> findByEmailAndSenha(String email, String senha);

    Optional<Login> findById(Long idUsuario);

    void deleteById(Long idUsuario);

    Optional<Login> findByEmail(String email);

}
