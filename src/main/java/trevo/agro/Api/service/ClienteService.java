package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trevo.agro.Api.entidade.cliente.Cliente;
import trevo.agro.Api.entidade.cliente.DadosCadastroCliente;
import trevo.agro.Api.repository.ClienteRepository;
import trevo.agro.Api.repository.ProdutoRepository;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Cliente> listarClientes(){
        return repository.findAll();
    }

    public Cliente findCliente(Long idCliente){
        return repository.findById(idCliente).get();
    }

    //Pesquisa no banco de dados por um id
    public void cadastrarCliente(DadosCadastroCliente dadosCadastroCliente){
        String nomeProduto = produtoRepository.findById(dadosCadastroCliente.idProduto()).get().getNome();
        Cliente cliente = new Cliente(dadosCadastroCliente);
        cliente.setProdutoInteresse(nomeProduto);
        repository.save(cliente);
    }
}
