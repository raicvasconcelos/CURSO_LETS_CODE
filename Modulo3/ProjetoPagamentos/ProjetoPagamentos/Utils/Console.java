package ProjetoPagamentos.Utils;

import java.util.List;
import java.util.Scanner;

public class Console {

    public static void limpar() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }  

    private static String getLinha(int tamanho){
        StringBuilder linha = new StringBuilder();
        for(int i = 0; i < tamanho; i++){
            linha.append("-");
        }
        return linha.toString();
    }
    
    public static <T> void  mostrarTitulo(String titulo){
        String linha = getLinha(titulo.length());
        System.out.println();
        System.out.println(linha);
        System.out.println(titulo);
        System.out.println(linha);
        
    }    

    public static <T> void mostrar(List<T> lista) {
        for (T objeto : lista) {
            System.out.println(Convert.toString(objeto));
        }
        System.out.println();
    }

    public static <T> void mostrar(T objeto) {
        System.out.println(Convert.toString(objeto));
        System.out.println();
    }

    public static void pause(){
        
        String mensagem = "Tecle ENTER para continuar.";
        String inputString;

        System.out.println(mensagem);
        
        Scanner input = new Scanner(System.in);

        inputString = input.nextLine();

        while (!inputString.equals("")) {
            System.out.println(mensagem);
            inputString = input.nextLine();
        }

        limpar();
    }


}
