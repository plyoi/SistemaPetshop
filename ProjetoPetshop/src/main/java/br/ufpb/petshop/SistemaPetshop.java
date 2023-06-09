package br.ufpb.petshop;

import java.io.IOException;
import java.util.*;

import javax.swing.JOptionPane;


public class SistemaPetshop implements SistemaPetshopInterface{

    private List<Produto> produtos;
    GravadorDeProdutos gravador = new GravadorDeProdutos();
    public SistemaPetshop(){
    	this.produtos = new ArrayList<Produto>();
    }
    
    public void carregaNovosProdutos(List<Produto> novosProdutos)
            throws ProdutoJaExisteException{
        for(Produto produto: novosProdutos){
            if (this.existeProduto(produto.getCodProduto(), produto.getNome(),produto.getTipoProduto(),produto.getQuantProduto())){
                throw new ProdutoJaExisteException("Já existe o atrativo "+produto.toString());
            } else {
                this.produtos.add(produto);
            }
        }
    }
    public boolean existeProduto(int codigo,String nome, TipoProduto tipo, int quantidade){
        for (Produto p: this.produtos){
            if (p.getCodProduto()==codigo && p.getNome().equals(nome) && p.getTipoProduto().equals(tipo) && p.getQuantProduto()==quantidade){
                return true;
            }
        }
        return false;
    }
    
    public boolean cadastraProduto(Produto produto) {
        this.produtos.add(produto);
        return true;
    }

    @Override
    public Collection<Produto> pesquisaProduto(int codProduto) {
        Collection<Produto> produtosAchados = new ArrayList<>();
        for (Produto p: this.produtos){
            if (p.getCodProduto()==codProduto){
                produtosAchados.add(p);
            }
        }
        return produtosAchados;
    }


    public boolean removeProduto(String nome){
    	boolean removeu = false;
    	for (Produto p: this.produtos) {
    		if (p.getNome().equals(nome)){
    			this.produtos.remove(p);
    			removeu = true;
    		}
    	}
    	return removeu;
        
    }
    public List<Produto> getProdutos() {
        return this.produtos;
    }

    public void setContatos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}


