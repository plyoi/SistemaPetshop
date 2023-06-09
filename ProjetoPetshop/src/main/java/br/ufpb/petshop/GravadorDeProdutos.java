package br.ufpb.petshop;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class GravadorDeProdutos{
	

    private GravadorDeDados gravador;

    public GravadorDeProdutos(){
        this.gravador = new GravadorDeDados();
    }


    public void gravaProdutos(List<Produto> produtos) throws IOException {
        List<String> textoAGravar = new LinkedList<>();
        for (Produto produto: produtos){
            String linha = produto.getCodProduto()+"###"+produto.getNome()+"###"+produto.getTipoProduto()+"###"+produto.getQuantProduto();
            textoAGravar.add(linha);
        }
        this.gravador.gravaProdutosTexto(textoAGravar);
    }

    public List<Produto> recuperaProdutos() throws IOException {
        List<String> dadosDosProdutos = this.gravador.leProdutos();
        List<Produto> listaProdutos = new LinkedList<>();
        for (String s: dadosDosProdutos){
            String [] dados = s.split("###");
            TipoProduto dadoTipo = TipoProduto.valueOf(dados[2]); 
            Produto produto = new Produto(Integer.parseInt(dados[0]),dados[1],dadoTipo , Integer.parseInt(dados[3]));
            listaProdutos.add(produto);
        }
        return listaProdutos;
    }

}
