package br.com.michelhazy;

import java.util.Scanner;

public class App {
    public static void main( String[] args ){
        Scanner scan = new Scanner(System.in);

        Metodos metodos = new Metodos();

        System.out.println("O que deseja fazer?\n 1 - Ver todos Usuarios\n 2 - Adicionar Usuario\n 3 - Excluir Usuario\n 4 - Editar Usuario");
        int escolha = scan.nextInt();

        metodos.funcaoEscolhida(escolha);
    }
}
