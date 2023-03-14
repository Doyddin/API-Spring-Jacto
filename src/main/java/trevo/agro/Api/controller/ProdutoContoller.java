package trevo.agro.Api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import trevo.agro.Api.entidade.produto.DadosCadastroProduto;
import trevo.agro.Api.entidade.produto.DadosListagemProduto;
import trevo.agro.Api.entidade.produto.Produto;
import trevo.agro.Api.service.ProdutoService;

import java.io.IOException;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoContoller {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public String cadastrarProduto(@RequestBody @Valid DadosCadastroProduto produto) throws IOException
    {
        produtoService.cadastrarProduto(produto);

        return "Produto cadastrado com sucesso!";
    }

    // Listagem de todos os produtos cadastrados
    @GetMapping
    public Page<DadosListagemProduto> listarProdutos(Pageable paginacao)
    {
        return produtoService.listarProdutos(paginacao);
    }

    // Listagem de um produto específico
    @GetMapping("/{idProduto}")
    public Produto findProduto(@PathVariable Long idProduto)
    {
        return produtoService.findProduto(idProduto);
    }
}
