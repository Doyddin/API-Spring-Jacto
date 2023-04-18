package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;
import trevo.agro.Api.entidade.imagem.DadosListagemImagem;
import trevo.agro.Api.entidade.produto.DadosCadastroProduto;
import trevo.agro.Api.entidade.produto.DadosListagemProduto;
import trevo.agro.Api.entidade.produto.Produto;
import trevo.agro.Api.repository.ImagemRepository;
import trevo.agro.Api.repository.ProdutoRepository;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ImagemRepository imagensRepository;

    public void cadastrarProduto(DadosCadastroProduto dadosCadastroProduto)
    {
        //Define a data de hoje para salvar no banco sem erro
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDateTime now = LocalDateTime.now();

        Produto produto = new Produto(dadosCadastroProduto);
        produto.setDataCadastro(dtf.format(now));
        repository.save(produto);
    }

    public Page<DadosListagemProduto> listarProdutos(@PageableDefault(size = 10) Pageable paginacao){
        return repository.findAll(paginacao).map(DadosListagemProduto::new);
    }

    public Produto findProduto(Long idProduto){
        Produto produto = repository.findById(idProduto).get();
        List<DadosListagemImagem> imagens = imagensRepository.findAllByIdProduto(idProduto);
        return produto;
    }

    public void editarProduto(Long idProduto, DadosCadastroProduto novoProduto){
        Produto produtoEditado = new Produto(novoProduto);
        produtoEditado.setId(idProduto);

        repository.save(produtoEditado);
    }

    public void excluirProduto(Long idProduto){
        repository.deleteById(idProduto);
    }
}
