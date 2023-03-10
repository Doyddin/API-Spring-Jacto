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
import trevo.agro.Api.service.ProdutoService;

import java.io.IOException;


public class ProdutoContoller {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public String cadastrarProduto(@RequestBody @Valid DadosCadastroProduto produto) throws IOException
    {
        produtoService.cadastrarProduto(new Produto(produto));

        return "Produto cadastrado com sucesso!";
    }

    @GetMapping
    public Page<DadosListagemProduto> listarProdutos(Pageable paginacao)
    {
        return produtoService.listarProdutos(paginacao);
    }
}
