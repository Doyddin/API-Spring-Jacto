package trevo.agro.Api.entidade.produto;

public record DadosListagemProduto(Long id, String nome, String tipoCultura, String tamanhoArea, String descProduto,
                                   String dataCadastro, int status) {

    public DadosListagemProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getTipoCultura(), produto.getTamanhoArea(), produto.getDescProduto(),
                produto.getDataCadastro(), produto.getStatus());
    }
}
