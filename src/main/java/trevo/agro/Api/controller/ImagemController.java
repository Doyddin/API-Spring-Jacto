package trevo.agro.Api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import trevo.agro.Api.entidade.imagem.DadosListagemImagem;
import trevo.agro.Api.service.ImagemService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/imagem")
public class ImagemController {

    @Autowired
    private ImagemService imagemService;

    // Faz o upload de uma imagem vinda de um formulário, comprimindo em binário e salvando no banco
    @PostMapping
    public ResponseEntity<?> uploadImagem(@RequestParam("imagem") MultipartFile imagem,
                                          @RequestParam("id_produto") Long idProduto) throws IOException {
        String uploadImagem = imagemService.uploadImagem(imagem, idProduto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImagem);
    }

    // Apresenta a imagem descomprimindo do banco de dados
    @GetMapping("/{id}")
    public ResponseEntity<?> downloadImagem(@PathVariable Long id){
        byte[] dadosImagem = imagemService.downloadImagem(id);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dadosImagem);
    }

    @GetMapping("/idProduto={idProduto}")
    public List<DadosListagemImagem> getImagens(@PathVariable Long idProduto){
        return imagemService.getImagens(idProduto);

    }
}
