package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trevo.agro.Api.entidade.imagem.DadosImagem;
import trevo.agro.Api.entidade.imagem.DadosListagemImagem;

import java.util.List;
import java.util.Optional;

public interface ImagemRepository extends JpaRepository<DadosImagem, Long> {


    Optional<DadosImagem> findByNome(String nomeImagem);

    Optional<DadosImagem> findById(Long idImagem);

    List<DadosListagemImagem> findAllByIdProduto(Long idProduto);
}
