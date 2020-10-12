/** 
 * DigitalInnovation.one - Ordenação e Filtros em Java
 * Desafio 4/5 - Fila do Banco

DESAFIO
O banco que você trabalha sempre tem problemas para organizar as filas de 
atendimento dos clientes.

Após uma reunião com a gerência ficou decidido que os clientes ao chegar na 
agência receberão uma senha numérica em seu aparelho de celular via sms e que 
a ordem da fila será dada não pela ordem de chegada, mas sim pelo número 
recebido via sms. Sendo, aqueles com número maior deverão ser atendidos 
primeiro. 

Então, dada a ordem de chegada dos clientes reordene a fila de acordo com o
número recebido via sms, e diga quantos clientes não precisaram trocar de 
lugar nessa reordenação.

ENTRADA
A primeira linha contém um inteiro N, indicando o número de casos de teste 
a seguir.

Cada caso de teste inicia com um inteiro M (1 ≤ M ≤ 1000), indicando o 
número de clientes. Em seguida haverá M inteiros distintos Pi (1 ≤ Pi ≤ 1000), 
onde o i-ésimo inteiro indica o número recebido via sms do i-ésimo cliente.

Os inteiros acima são dados em ordem de chegada, ou seja, o primeiro inteiro 
diz respeito ao primeiro cliente a chegar na fila, o segundo inteiro diz 
respeito ao segundo cliente, e assim sucessivamente.

SAIDA
Para cada caso de teste imprima uma linha, contendo um inteiro, indicando o 
número de clientes que não precisaram trocar de lugar mesmo após a fila ser 
reordenada.

*/

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays; 
import java.util.Collections;

public class FilaBanco {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    
    ArrayList<Integer> listaSaida = new ArrayList<Integer>();

    //Recebe número de Casos de Testes
    int numCasosTestes;
    numCasosTestes = Integer.parseInt(scanner.nextLine());
    
    for(int i = 0; i < numCasosTestes; i++){
        //Recebe Qtde de Pessoas na Fila
        int numQtdPessoas = 0;
        numQtdPessoas = Integer.parseInt(scanner.nextLine());
        
        //Recebe Senhas com Posição na Fila da(s) N pessoa(s) (numQtdPessoas) separadas por " "
        String strPosicaoFila = "";
        strPosicaoFila = scanner.nextLine();

        //Transforma string em Lista
        String[] str = strPosicaoFila.split(" ", numQtdPessoas); 

        //Cria Lista Final e ordena DESC
        ArrayList<Integer> listaInicial = new ArrayList<Integer>();
        ArrayList<Integer> listaFinal   = new ArrayList<Integer>();
        for(int x = 0; x < str.length; x++){
          listaInicial.add(Integer.valueOf(str[x]));
          listaFinal.add(Integer.valueOf(str[x]));
        }

        Collections.sort(listaFinal, Collections.reverseOrder());

        //System.out.println("Lista Inicial: [" + listaInicial + "]");
        //System.out.println("Lista Final  : [" + listaFinal + "]");

        //Conta quantas posições NÃO foram trocadas
        int numPosNaoTrocadas = listaInicial.size();
        //System.out.println("numPosNaoTrocadas(antes):"+numPosNaoTrocadas);

        for(int j = 0; j < listaInicial.size(); j++){
          //System.out.printf("Comparar [%d] com [%d]\n",listaInicial.get(j), listaFinal.get(j) );
          if(listaInicial.get(j).intValue() != listaFinal.get(j).intValue())
            numPosNaoTrocadas--;
            //System.out.printf("numPosNaoTrocadas(iteracao %d): %d\n",j,numPosNaoTrocadas);
        }

        listaSaida.add(numPosNaoTrocadas);
    }

    //Imprime Qtde de Posições NÃO trocadas de cada caso de teste
    listaSaida.stream().forEach(System.out::println);
  }
}
