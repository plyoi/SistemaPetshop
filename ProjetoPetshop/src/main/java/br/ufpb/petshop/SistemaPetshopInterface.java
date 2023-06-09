package br.ufpb.petshop;

import java.util.Collection;
import java.util.List;

public interface SistemaPetshopInterface {
    public Collection<Produto> pesquisaProduto(int codProduto);
    public boolean removeProduto(String nome);
    public boolean cadastraProduto(Produto produto);
    public List<Produto> getProdutos();
    public void setContatos(List<Produto> produtos);
    public void carregaNovosProdutos(List<Produto> novosProdutos)throws ProdutoJaExisteException;
    public boolean existeProduto(int codigo,String nome, TipoProduto tipo, int quantidade);
}
