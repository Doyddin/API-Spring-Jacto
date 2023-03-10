package trevo.agro.Api.entidade.produto;

public record DadosListagemProduto(Long id, String nome, String tipoCultura, String tamanhoArea, String listaFotos,
                                   String dataCadastro, int status) {
    public DadosListagemProduto(Produto produto) {
        this(produto.getId(), produto.getNome(), produto.getTipoCultura(), produto.getTamanhoArea(),
                produto.getListaFotos(), produto.getDataCadastro(), produto.getStatus());
    }
}
