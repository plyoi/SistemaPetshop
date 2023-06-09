package br.ufpb.petshop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PetshopRemoveController implements ActionListener {
    private SistemaPetshopInterface sistemaPetshop;
    private JFrame janelaPrincipal;
    public PetshopRemoveController(SistemaPetshopInterface sistemaPetshop,JFrame janela){
        this.sistemaPetshop = sistemaPetshop;
        this.janelaPrincipal = janela;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        String nome = JOptionPane.showInputDialog(janelaPrincipal, "Qual o nome do Produto a remover?");
        boolean removeu = sistemaPetshop.removeProduto((nome));
        if (removeu) {
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto removido com sucesso");
        }else {
            JOptionPane.showMessageDialog(janelaPrincipal,"Produto não encontrado. "+
                    "Operação não realizada");
        }
    }
}
