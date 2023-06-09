package br.ufpb.petshop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GravadorDeDados {
    public List<String> leProdutos() throws IOException{
    	BufferedReader leitor = null;
        List<String> textoLido = new ArrayList<>();
        try {
            leitor = new BufferedReader(new FileReader("produtos.txt"));
            String texto = null;
            do {
                texto = leitor.readLine();
                if (texto!=null){
                    textoLido.add(texto);
                }
            } while (texto!=null);
        } catch (FileNotFoundException e) {
            throw new IOException("Não foi encontrado o arquivo produtos.txt", e);
        } catch (IOException e){
            throw e;
        } finally {
            if (leitor != null){
                leitor.close();
            }
        }
        return textoLido;
    }
    public void gravaProdutosTexto(List<String> produtos) throws IOException {
    	BufferedWriter  gravador = null;
        try {
            gravador = new BufferedWriter(new FileWriter("produtos.txt"));
            for (String s: produtos){
                gravador.write(s+"\n");
            }
        }catch (FileNotFoundException e){
            throw new IOException("Não foi encontrado o arquivo produtos.txt", e);
        }catch (IOException e){
            throw e;
        }finally {
            if (gravador != null){
                gravador.close();
            }
        }
    }
}
