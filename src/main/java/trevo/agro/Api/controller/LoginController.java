package trevo.agro.Api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import trevo.agro.Api.auth.AuthenticationRequest;
import trevo.agro.Api.auth.AuthenticationResponse;
import trevo.agro.Api.auth.AuthenticationService;
import trevo.agro.Api.auth.RegisterRequest;
import trevo.agro.Api.entidade.login.DadosCadastroLogin;
import trevo.agro.Api.entidade.login.DadosListagemLogin;
import trevo.agro.Api.entidade.login.DadosLogin;
import trevo.agro.Api.entidade.login.Login;
import trevo.agro.Api.service.LoginService;

import java.util.List;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService service;

    @Autowired
    private  AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> criarUser(
            @RequestBody RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> criarUser(
            @RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }

    @GetMapping
    public List<Login> listarUsuarios(){
        return service.listarUsuarios();
    }

    @GetMapping("/{idUsuario}")
    public Login listarUsuario(@PathVariable Long idUsuario){
        return service.listarUsuario(idUsuario);
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long idUsuario,@RequestBody DadosCadastroLogin loginEditado){
        service.editarUsuario(idUsuario, loginEditado);
        return ResponseEntity.status(HttpStatus.OK)
                .body("Usuário atualizado com sucesso.");
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<?> excluirUsuario(@PathVariable Long idUsuario){
        service.excluirUsuario(idUsuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario excluido com sucesso.");
    }

}
