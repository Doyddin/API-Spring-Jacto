package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trevo.agro.Api.imagem.DadosImagem;

import java.util.Optional;

public interface ImagemRepository extends JpaRepository<DadosImagem, Long> {


    Optional<DadosImagem> findByNome(String nomeImagem);
}
