/**
 * Desafio
    O professor Girafales organizou a confecção de um uniforme para as turmas da escola 
    para comemorar o final do ano. Após algumas conversas, ficou decidido com os alunos 
    que eles poderiam escolher a cor do uniforme entre branco ou vermelho. Assim sendo, 
    Girafales precisa de sua ajuda para organizar as listas de quem quer o uniforme em 
    cada uma das turmas, relacionando estas camisetas pela cor, tamanho (P, M ou G) e 
    por último pelo nome.

 * Entrada
    Cada caso de teste inicia com um valor N, (1 ≤ N ≤ 60) inteiro e positivo, que 
    indica a quantidade de uniformes a serem feitas para aquela turma. As próximas N*2 
    linhas contém informações de cada um dos uniformes (serão duas linhas de informação 
    para cada uniforme). A primeira linha irá conter o nome do estudante e a segunda 
    linha irá conter a cor do uniforme ("branco" ou "vermelho") seguido por um espaço e 
    pelo tamanho do uniforme "P" "M" ou "G". A entrada termina quando o valor de N for 
    igual a zero (0) e esta valor não deverá ser processado.

 * Saída
    Para cada caso de entrada deverão ser impressas as informações ordenadas pela cor 
    em ordem ascendente, seguido pelos tamanhos em ordem descendente e por último por 
    ordem ascendente de nome, conforme o exemplo abaixo.
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;


public class OrdenaMult {
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    
    ArrayList<Aluno> listaFinal = new ArrayList<Aluno>();

    //Recebe número de Alunos
    int numAlunos;
    numAlunos = Integer.parseInt(scanner.nextLine());
    
    for(int i = 0; i < numAlunos; i++){
        //Recebe nome aluno
        String strNome = "";
        strNome = scanner.nextLine();

        //Recebe Cor + Tamanho do uniforme
        String strUniforme = "";
        strUniforme = scanner.nextLine();

        //Adiciona na lista final
        Aluno aluno = new Aluno(strNome, strUniforme);
        listaFinal.add(aluno);
    }

    //Define critério de ordenação: Cor ASC / Tamanho DESC / Nome ASC
    Comparator<Aluno> comparator = (a1, a2) -> a1.getCor().compareTo(a2.getCor());
    comparator = comparator.thenComparing( (a2, a1) -> a1.getTamanho().compareTo(a2.getTamanho()));
    comparator = comparator.thenComparing( (a1, a2) -> a1.getNome().compareTo(a2.getNome()));

    //Imprime lista final
    listaFinal.stream()
      .sorted(comparator)
      .distinct().collect(Collectors.toList())
      .forEach(System.out::println);
  }

  public static class Aluno{
    private String nome;
    private String cor;
    private String tamanho;

    public Aluno(String strNome, String strUniforme){
      this.nome    = strNome;
      this.cor     = strUniforme.substring(0, strUniforme.indexOf(" "));
      this.tamanho = strUniforme.substring(strUniforme.length()-1);
    }

    public String getNome(){
      return nome;
    }
    public String getCor(){
      return cor;
    }
    public String getTamanho(){
      return tamanho;
    }

    @Override
    public String toString() { 
        //return ("[" + this.nome + ", " + this.cor + ", " + this.tamanho + "]"); 
        return (cor + " " + tamanho + " " + nome);
    }    
  }
}
