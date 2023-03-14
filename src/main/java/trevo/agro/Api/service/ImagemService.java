
package trevo.agro.Api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import trevo.agro.Api.entidade.imagem.DadosListagemImagem;
import trevo.agro.Api.service.utils.ImagemUtils;
import trevo.agro.Api.entidade.imagem.DadosImagem;
import trevo.agro.Api.repository.ImagemRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ImagemService {

    @Autowired
    private ImagemRepository repository;

    public String uploadImagem(MultipartFile imagem, Long idProduto) throws IOException {
        DadosImagem dadosImagem = repository.save(DadosImagem.builder()
                .nome(imagem.getOriginalFilename())
                .tipo(imagem.getContentType())
                .dadosImagem(ImagemUtils.compressImage(imagem.getBytes()))
                .idProduto(idProduto).build());

        if(dadosImagem!=null) {
            return "Arquivo salvo com sucesso : "+ imagem.getOriginalFilename();
        }

        return null;
    }

    public byte[] downloadImagem(Long id){
        Optional<DadosImagem> dbDadosImagem = repository.findById(id);
        return ImagemUtils.decompressImage(dbDadosImagem.get().getDadosImagem());
    }

    public List<DadosListagemImagem> getImagens(Long idProduto){
        return repository.findAllByIdProduto(idProduto);
    }
}
