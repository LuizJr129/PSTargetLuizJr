
import java.util.Scanner;
import java.util.Stack;

public class Exercicio5 {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma palavra para ser invertida!");
        String palavraInserida = sc.nextLine(); // armazena a palavra inserida pelo usuario .

        Stack<Character> pilha = new Stack<>(); //cria a pilha a ser usada. 

        for(char c : palavraInserida.toCharArray()){
            pilha.push(c);
        } //armazena caracter por caracter na pilha, dos inicial pros finais. 

        StringBuilder palavraInvertida = new StringBuilder(); // criado para juntar os caracteres

        while (!pilha.isEmpty()) {
            palavraInvertida.append(pilha.pop()); //puxa sempre o primeiro caracter da pilha
        }
        
        System.out.println("Palavra Inserida: " + palavraInserida);
        System.out.println("Palavra Invertida: " + palavraInvertida);
    }
}