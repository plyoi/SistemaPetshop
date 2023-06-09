package br.ufpb.petshop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class PetshopSearchController implements ActionListener {
    private SistemaPetshopInterface sistemaPetshop;
    private JFrame janelaPrincipal;
    public PetshopSearchController(SistemaPetshopInterface sistemaPetshop,JFrame janela){
        this.sistemaPetshop = sistemaPetshop;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        int codProduto = Integer.parseInt(JOptionPane.showInputDialog(janelaPrincipal,"Qual codigo do Produto a pesquisar?"));
        Collection<Produto> produtos = sistemaPetshop.pesquisaProduto(codProduto);
        if(produtos.size()>0){
            JOptionPane.showMessageDialog(janelaPrincipal, "Produto encontrado:");
            for (Produto p: produtos){
                JOptionPane.showMessageDialog(janelaPrincipal, p.toString());
            }
        } else {
            JOptionPane.showMessageDialog(janelaPrincipal, "Não foi encontrado nenhum Produto");
        }
    }
}
