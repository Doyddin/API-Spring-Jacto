package trevo.agro.Api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import trevo.agro.Api.entidade.cliente.Cliente;
import trevo.agro.Api.entidade.cliente.DadosCadastroCliente;
import trevo.agro.Api.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService service;


    //Lista todos os clientes cadastrados no banco de dados
    @GetMapping()
    public List<Cliente> listarClientes(){
        return service.listarClientes();
    }

    //Lista um cliente do id especificado
    @GetMapping("/{idCliente}")
    public Cliente findCliente(@PathVariable Long idCliente){
        return service.findCliente(idCliente);
    }

    //Cadastra um cliente no banco de dados
    @PostMapping
    public String cadastrarCliente(@RequestBody @Valid DadosCadastroCliente cliente){
        service.cadastrarCliente(cliente);

        return "Cliente cadastrado com sucesso!";
    }
}
