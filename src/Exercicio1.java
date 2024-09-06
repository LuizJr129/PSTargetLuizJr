public class Exercicio1 {


    public static void main(String[] args) throws Exception {
        int INDICE = 13;
        int SOMA = 0;
        int K = 0;

        while (K < INDICE) {
            K = K+1;
            SOMA = SOMA + K;
            System.out.println((K) + "º Valor de SOMA: " + SOMA);
        }
        System.out.println("O valor da SOMA final será " + SOMA);
    }
}
