import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

class FaturamentoDiario { //classe para armazenar os dados do json
    int dia;
    double valor;

    FaturamentoDiario() {
    } 

    @Override
    public String toString() { //formatacao de como retornará escrito os dados do json
        return "Faturamento Diário{ " + "dia=" + dia + " teve o valor faturado de " + valor + " }";
    }
}

public class Exercicio3 {
    public static void main(String[] args) throws Exception {

        Gson gson = new Gson(); //cria um novo objeto tipo Gson

        HashMap<Integer, Double> faturamentoMap = new HashMap<>(); //Hashmap para armazenar os valores de dia e faturamento. 

        try (FileReader reader = new FileReader("dados.json")) { 

            // Define o tipo como uma lista de objetos de Faturamento
            Type listaFaturamentos = new TypeToken<List<FaturamentoDiario>>() {
            }.getType();

            // Converte o conteúdo do arquivo JSON para uma lista de objetos Java da classe FaturamentoDiario
            List<FaturamentoDiario> listaFaturamento = gson.fromJson(reader, listaFaturamentos);

            for (FaturamentoDiario faturamentos : listaFaturamento) {

                if (faturamentos.valor != 0) { //Se o valor for diferente de zero, adicione no hashmap
                    faturamentoMap.put(faturamentos.dia, faturamentos.valor);
                }

            }

            Double maiorValor = Collections.max(faturamentoMap.values()); //descobre o maior valor no hashmap valores
            int diaMaiorValor = 0; 

            for (Integer dia : faturamentoMap.keySet()) {

                if (faturamentoMap.get(dia) == maiorValor) {
                    diaMaiorValor = dia;
                    break;

                }
            } //Acha o dia(key) que teve o maior valor

            Double menorValor = Collections.min(faturamentoMap.values());//descobre o menor valor no hashmap valores
            int diaMenorValor = 0;

            for (Integer dia : faturamentoMap.keySet()) {

                if (faturamentoMap.get(dia) == menorValor) {
                    diaMenorValor = dia;
                    break;

                }
            } //Acha o dia(key) que teve o menor valor

            double valorTotal = 0;
            int qtdDiasVendas = 0;

            for(Integer dia: faturamentoMap.keySet()){
                valorTotal = valorTotal + faturamentoMap.get(dia);
                qtdDiasVendas++;
            } //Calcula o valor total e a quantidade de dias 

            double mediaFaturamento = valorTotal/qtdDiasVendas;
            int qtdDiasMaiorqueMedia = 0;

            for(Integer dia: faturamentoMap.keySet()){
                if(faturamentoMap.get(dia) < mediaFaturamento ){
                qtdDiasMaiorqueMedia++;}
            } //Calcula a quantidade de dias maiores que a média

            System.out.println("O maior valor é de " + maiorValor + " que ocorreu no dia " + diaMaiorValor);
            System.out.println("O menor valor é de " + menorValor + " que ocorreu no dia " + diaMenorValor);
            System.out.println(qtdDiasMaiorqueMedia + " dias tiveram o valor de faturamento diário superior à média mensal.");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}