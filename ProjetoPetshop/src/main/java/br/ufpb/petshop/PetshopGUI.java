package br.ufpb.petshop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class PetshopGUI extends JFrame {
    JLabel linha1, linha2;
    ImageIcon fotoImg = new ImageIcon("imgs/foto.png");
    ImageIcon addImg = new ImageIcon("imgs/add.png");
    ImageIcon pesqImg = new ImageIcon("imgs/pesquisa.png");
    ImageIcon removeImg = new ImageIcon("imgs/remove.png");
    JMenuBar barraDeMenu = new JMenuBar();
    JButton botaoAdicionar, botaoPesquisar, botaoRemover, botaoEstoque;
    SistemaPetshopInterface sistemaPetshop = new SistemaPetshop();
    public PetshopGUI(){
        setTitle("Sistema PetShop");
        setSize(800,600);
        setLocation(150,150);
        setResizable(false);
        getContentPane().setBackground(Color.lightGray);
        SistemaPetshopInterface sistemaPetshop = new SistemaPetshop();
        GravadorDeProdutos gravador = new GravadorDeProdutos();
        List<Produto> produtosList = new ArrayList<>();
        try {
            produtosList = gravador.recuperaProdutos();
            sistemaPetshop.carregaNovosProdutos(produtosList);
        } catch (IOException e){
            JOptionPane.showMessageDialog(null, "Nenhum dado encontrado no sistema");
        } catch (ProdutoJaExisteException e){
            JOptionPane.showMessageDialog(null, "Nem todos os produtos puderam ser recuperados. Verifique se algum já existia");
            e.printStackTrace();
        }
        linha1 = new JLabel("PetShop", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("serif", Font.BOLD, 24));
        linha2 = new JLabel(fotoImg, JLabel.CENTER);
        botaoAdicionar = new JButton("Adicionar",addImg);
        botaoAdicionar.addActionListener(new PetshopAddController(sistemaPetshop, this));
        botaoPesquisar = new JButton("Pesquisar",pesqImg);;
        botaoPesquisar.addActionListener(new PetshopSearchController(sistemaPetshop, this));
        botaoRemover = new JButton("Remover",removeImg);
        botaoRemover.addActionListener(new PetshopRemoveController(sistemaPetshop, this));
        getContentPane().setLayout(new GridLayout(3,1));
        getContentPane().add(linha1);
        getContentPane().add(botaoAdicionar);
        getContentPane().add(linha2);
        getContentPane().add(botaoPesquisar);
        getContentPane().add(new JLabel());
        getContentPane().add(botaoRemover);
        JMenu menuPrincipal = new JMenu("Menu");
        JMenuItem menuPesquisaEstoque = new JMenuItem("Meu Estoque");
        menuPrincipal.add(menuPesquisaEstoque);
        JMenuItem menuSalvar = new JMenuItem("Salvar");
        menuPrincipal.add(menuSalvar);
        menuSalvar.addActionListener((ae) -> {
        	try {
                gravador.gravaProdutos(sistemaPetshop.getProdutos());
                JOptionPane.showMessageDialog(null, "Dados salvos");
            } catch (IOException e){
                JOptionPane.showMessageDialog(null, "Não foi possível gravar os dados dos produtos");
                e.printStackTrace();
            }
        });
        menuPesquisaEstoque.addActionListener((ae) -> {
        	List<Produto> produtos = sistemaPetshop.getProdutos();
            if (produtos.size()==0){
                JOptionPane.showMessageDialog(null, "Não foi encontrado nenhum atrativo no sistema");
            }
            for (Produto a: produtos){
                JOptionPane.showMessageDialog(null, a.toString());
            }
        });
        barraDeMenu.add(menuPrincipal);
        setJMenuBar(barraDeMenu);
    }
    
    public static void main(String[] args) {
        JFrame janela = new PetshopGUI();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);
    }
}
