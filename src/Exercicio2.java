import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) throws Exception {
        int PtermoFibo = 0;
        int StermoFibo = 1;
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o valor do número para conferir se pertence a sequência de Fibonacci!");
        int numeroInformado = sc.nextInt();
        boolean continua = true;
        int resultadoFibo;

        if (numeroInformado == 0) {
            System.out.println("O número "+ numeroInformado + " pertencen a sequência de Fibonacci.");
            continua = false;
        } // tratamento de exceção

        if (numeroInformado < 0) {
            System.out.println("Não pode ser calculado número negativo!");
            continua = false;
        } // tratamento de exceção

        while (continua != false) { //Ciclo até chegar á resposta final

            resultadoFibo = (PtermoFibo + StermoFibo);  //soma padrão do fibonacci

            if (resultadoFibo < numeroInformado) { //Se a soma do Fibonacci ainda for menor que o número informado, continue somando

                PtermoFibo = StermoFibo;
                StermoFibo = resultadoFibo;
                continua = true;
            }

            if (resultadoFibo == numeroInformado) { //Se for um resultado de fibonacci igual ao número informado, quer dizer que ele é da sequência de fibonacci. 
                System.out.println("O número "+ numeroInformado + " pertencen a sequência de Fibonacci.");
                continua = false;

            }

            if (resultadoFibo > numeroInformado) { //Se for um resultado de fibonacci maior ao número informado, quer dizer que ele não é da sequência de fibonacci. 

                System.out.println("O número "+ numeroInformado + " não pertencen a sequência de Fibonacci.");
                continua = false;

            }
        }

    }
}