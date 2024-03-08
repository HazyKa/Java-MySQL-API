package br.com.michelhazy;

import java.io.IOException;
import java.util.Scanner;

import org.apache.http.client.ClientProtocolException;

public class Metodos {

    Scanner scann = new Scanner(System.in);
    MetodosDAO dao = new MetodosDAO();
    MetodosConversaoSQL converter = new MetodosConversaoSQL();

    public void funcaoEscolhida(int n){
        if(n == 1){
            mostrarUsuarios();
        }else if(n ==2){
            adicionarUsuarios();
        }else if(n ==3){
            excluirUsuario();
        }else if(n ==4){
            editarUsuario();
        }
    }

    private void mostrarUsuarios(){
        dao.mostrar();
    }

    private void adicionarUsuarios(){
        System.out.println("Escreva o nome do Usuario:");
        String nome = scann.nextLine();

        System.out.println("Escreva o CEP");
        int cep = scann.nextInt();

        try {
            converter.adicionar(nome, cep);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void excluirUsuario(){
        System.out.println("Digite o ID de qual Usuario deseja excluir:");
        mostrarUsuarios();

        int usuario = scann.nextInt();

        dao.excluir(usuario);
    }

    public void editarUsuario(){
        System.out.println("Digite o ID do funcionario que deseja editar:");
        mostrarUsuarios();
        int id = scann.nextInt();
        scann.nextLine();
        System.out.println("Escreva novamente o nome: ");
        String nome = scann.nextLine();
        System.out.println("Escreva novamente o cep: ");
        int cep = scann.nextInt();

        try {
            converter.editar(id, nome, cep);
        }catch (IOException e) {
            e.printStackTrace();
        }

        //usando 'editar' 'adicionar' para identificar de onde vem a funcao e dar o rumo correto

        //dao.editar(id, nome, cep);
    }
}