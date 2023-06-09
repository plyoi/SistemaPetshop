package br.ufpb.petshopTest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import br.ufpb.petshop.*;

public class TestaPetshopGUI {
	public static void main(String[] args) {
        JFrame janela = new PetshopGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                int resp = JOptionPane.showConfirmDialog(janela, "Tem certeza que quer sair?");
                if (resp==JOptionPane.YES_OPTION){
                    System.exit(0);
                }
            }
        });

    }

}
