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

    @PostMapping("/imagem/cadastro")
    public ResponseEntity<?> uploadImagem(@RequestParam("image") MultipartFile imagem) throws IOException {
        String uploadImagem = imagemService.uploadImagem(imagem);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImagem);
    }

    @GetMapping("/imagem/{nomeImagem}")
    public ResponseEntity<?> downloadImagem(@PathVariable String nomeImagem){
        byte[] dadosImagem = imagemService.downloadImagem(nomeImagem);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(dadosImagem);
    }
}
