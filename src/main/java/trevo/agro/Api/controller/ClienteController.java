package trevo.agro.Api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import trevo.agro.Api.entidade.cliente.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @GetMapping()
    public Cliente listarClientes(){
        return null;
    }

    @GetMapping("/{id}")
    public Cliente findCliente(@PathVariable String id_cliente){
        return null;
    }
}
