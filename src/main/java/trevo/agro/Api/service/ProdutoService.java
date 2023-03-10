package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import trevo.agro.Api.produto.DadosListagemProduto;
import trevo.agro.Api.produto.Produto;
import trevo.agro.Api.repository.ProdutoRepository;

public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public void cadastrarProduto(Produto produto)
    {
        repository.save(produto);
    }


    public Page<DadosListagemProduto> listarProdutos(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }
}
