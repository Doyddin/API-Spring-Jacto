package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trevo.agro.Api.entidade.produto.Produto;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findById(Long produto_id);

    void deleteById(Long produto_id);
}
