package br.ufpb.petshop;

import java.io.Serializable;

public class Produto implements Serializable {
    private int codProduto;
    private String nome;
    private TipoProduto tipoProduto;
    private int quantProduto;


    public Produto(int codProduto, String nome, TipoProduto tipoProduto,int quantProduto) {
        this.codProduto = codProduto;
        this.nome = nome;
        this.tipoProduto = tipoProduto;
        this.quantProduto = quantProduto;
    }

    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public String toString() {
        return "Produto de nome "+this.nome
                +", codigo "+this.codProduto
                +", tipo "+this.tipoProduto
                +" e quantidade "+this.quantProduto;
    }

}