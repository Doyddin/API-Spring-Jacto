package trevo.agro.Api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import trevo.agro.Api.service.ImagemService;

import java.io.IOException;

@RestController
@RequestMapping("/imagem")
public class ImagemController {


    private ImagemService imagemService;

    public ImagemController(ImagemService imagemService) {
        this.imagemService = imagemService;
    }

    @PostMapping
    public ResponseEntity<?> uploadImagem(@RequestParam("imagem") MultipartFile imagem,
                                          @RequestParam("id_produto") Long idProduto) throws IOException {
        String uploadImagem = imagemService.uploadImagem(imagem, idProduto);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImagem);
    }

    @GetMapping("/{idProduto}")
    public ResponseEntity<?> downloadImagem(@PathVariable Long idProduto){
        byte[] dadosImagem = imagemService.downloadImagem(idProduto);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dadosImagem);
    }
}
