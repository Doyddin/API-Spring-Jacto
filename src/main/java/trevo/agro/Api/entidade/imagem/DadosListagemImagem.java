package trevo.agro.Api.entidade.imagem;

public record DadosListagemImagem(Long id, Long idProduto, String nome, String tipo) {
    public DadosListagemImagem(DadosImagem imagem){
        this(imagem.getId(), imagem.getIdProduto(), imagem.getNome(), imagem.getTipo());
    }

}
