package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import trevo.agro.Api.entidade.produto.DadosCadastroProduto;
import trevo.agro.Api.entidade.produto.DadosListagemProduto;
import trevo.agro.Api.entidade.produto.Produto;
import trevo.agro.Api.repository.ProdutoRepository;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void cadastrarProduto(DadosCadastroProduto produto)
    {
        repository.save(new Produto(produto));
    }

    public Page<DadosListagemProduto> listarProdutos(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }

    public Optional<Produto> findProduto(Long id_produto){
        return repository.findById(id_produto);
    }
}
