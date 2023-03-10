package trevo.agro.Api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import trevo.agro.Api.entidade.produto.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
