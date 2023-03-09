package trevo.agro.Api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import trevo.agro.Api.produto.DadosCadastroProduto;
import trevo.agro.Api.produto.DadosListagemProduto;
import trevo.agro.Api.produto.Produto;
import trevo.agro.Api.repository.ProdutoRepository;


public class ProdutoContoller {

    @Autowired
    private ProdutoRepository repository;

    @PostMapping
    public void CadastrarProduto(@RequestBody @Valid DadosCadastroProduto produto)
    {
        repository.save(new Produto(produto));
    }

    @GetMapping
    public Page<DadosListagemProduto> ListarProdutos(@PageableDefault(size = 10) Pageable paginacao)
    {
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }
}
