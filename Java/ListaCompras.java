/**
 * Desafio

    Pedro trabalha sempre até tarde todos os dias, com isso tem pouco tempo tempo para as tarefas doméstica. 
    Para economizar tempo ele faz a lista de compras do supermercado em um aplicativo e costuma anotar cada 
    item na mesma hora que percebe a falta dele em casa.

    O problema é que o aplicativo não exclui itens duplicados, como Pedro anota o mesmo item mais de uma vez 
    e a lista acaba ficando extensa. Sua tarefa é melhorar o aplicativo de notas desenvolvendo um código que 
    exclua os itens duplicados da lista de compras e que os ordene alfabeticamente.

  * Entrada
    
    A primeira linha de entrada contém um inteiro N (N < 100) com a quantidade de casos de teste que vem a 
    seguir, ou melhor, a quantidade de listas de compras para organizar. Cada lista de compra consiste de 
    uma única linha que contém de 1 a 1000 itens ou palavras compostas apenas de letras minúsculas (de 1 a 
    20 letras), sem acentos e separadas por um espaço.

  * Saída
    
    A saída contém N linhas, cada uma representando uma lista de compra, sem os itens repetidos e em ordem 
    alfabética.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;


public class ListaCompras {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    
    int nArgs;
    String arg = "";

    ArrayList<String> listOfCompras = new ArrayList<String>();

    //Recebe número de Argumentos
    nArgs = scanner.nextInt();
    
    //Recebe cada um dos Argumentos
    for(int i = 0; i <= nArgs; i++){
        ArrayList<String> listOfItens = new ArrayList<String>();

        arg = scanner.nextLine();
        
        //Quebra String recebida em Lista
        String[] str = arg.split(" ", 1000);
        
        for(String s: str){
            listOfItens.add(s);
        }

        //Ordena
        Collections.sort(listOfItens);
        
        //Remove duplicados
        List<String> listWithoutDuplicates = listOfItens.stream().distinct().collect(Collectors.toList());

        //Monta nova lista ordenada
        String strUnica = listWithoutDuplicates.stream().collect(Collectors.joining(" "));

        //Adiciona na lista final
        listOfCompras.add(strUnica);
    }

    //Imprime lista final
    listOfCompras.stream().forEach(System.out::println);
    
  }
}