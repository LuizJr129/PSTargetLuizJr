import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class Exercicio4 {
    public static void main(String[] args) throws Exception {

        Map<String, Double> faturamentoMap = new HashMap<String, Double>() {{
            put("SP", 67836.43);
            put("RJ", 36678.66);
            put("MG", 29229.88);
            put("ES", 27165.48);
            put("Outros", 19849.53);
        }}; //Cria um hashmap com todos os valores

        double valorTotal = 0;

        for(String key: faturamentoMap.keySet()){
            valorTotal = valorTotal + faturamentoMap.get(key);
        } //Calcula o valor total

        for(String key: faturamentoMap.keySet()){
            
            double percentualIndividual = (faturamentoMap.get(key) / valorTotal) * 100 ; //faz a conta do percentual de cada estado 

            DecimalFormat df = new DecimalFormat("#.00"); //formatação para deixar os números apenas com 2 casas decimais. 

            System.out.println("O estado de " + key + " tem um percentual de faturamento de " + df.format(percentualIndividual) +  "%");//retorna o resultado
        } 


    }
}