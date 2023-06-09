package br.ufpb.petshop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetshopAddController implements ActionListener {
    private SistemaPetshopInterface sistemaPetshop;
    private JFrame janelaPrincipal;
    public PetshopAddController(SistemaPetshopInterface sistemaPetshop,JFrame janela){
        this.sistemaPetshop = sistemaPetshop;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int codProduto = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal, "Qual o codigo do Produto?"));
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do Produto?");
        TipoProduto[] tipoList = TipoProduto.values();
        TipoProduto tipoProduto = (TipoProduto)JOptionPane.showInputDialog(janelaPrincipal,"Qual o tipo do Produto?",null, JOptionPane.QUESTION_MESSAGE,null,tipoList,tipoList[0]);
        int quantProduto = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Qual a quantidade do Produto?"));
        boolean cadastrou = sistemaPetshop.cadastraProduto(new Produto(codProduto,nome, tipoProduto, quantProduto));
        if(cadastrou){
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto Cadastrado");
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto não foi cadastrado. "+
                    "Verifique se já não existia");
        }
    }
}
