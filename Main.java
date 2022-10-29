import java.io.IOException;

import java.util.Scanner;

public class Main {



  public static void main(String[] args) throws IOException {
    int opcao = -1;
    int segundaopcao = -1;
    int terceiraopcao = -1;
    GraphList grafolist;
    int source=0, end=0;

    GraphMatrix grafomatriz;

    Scanner leitor = new Scanner(System.in);
    Interface m = new Interface();
    long tempoInicial = System.currentTimeMillis();
    do {
      m.menutext();
      opcao = leitor.nextInt();
      switch (opcao) {
        case 1:
          do{
            m.caminhotext();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              case 1:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //DIJKSTRA
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");

                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USA-road-dt.DC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USA-road-dt.NY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.dijkstra(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Dijkstra...");
                      break;
                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 2:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USA-road-dt.DC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USA-road-dt.NY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFord(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 3:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //FLOYDWARSHALL
                    case 1:
                      grafomatriz= new GraphMatrix("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafomatriz = new GraphMatrix("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafomatriz = new GraphMatrix("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafomatriz = new GraphMatrix("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafomatriz = new GraphMatrix("USA-road-dt.DC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafomatriz = new GraphMatrix("USA-road-dt.NY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      System.out.println("Processando...");
                      tempoInicial = System.currentTimeMillis();
                      grafomatriz.floydWarshall(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Floyd-Warshall...");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 4:
                do{
                  m.arquivostext();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD MELHORADO
                    case 1:
                      grafolist= new GraphList("toy.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      grafolist= new GraphList("rg300_4730.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      grafolist= new GraphList("rome99c.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      grafolist= new GraphList("facebook_combined.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      grafolist= new GraphList("USA-road-dt.DC.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      grafolist = new GraphList("USA-road-dt.NY.txt");
                      m.escolherInicio();
                      source = leitor.nextInt();
                      m.escolherFim();
                      end = leitor.nextInt();
                      tempoInicial = System.currentTimeMillis();
                      grafolist.bellmanFordImproved(source,end);
                      System.out.println("O método foi executado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Bellman-Ford melhorado...");
                      break;

                    default:
                      System.out.println("Opção incorreta. Tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 5:
                break;
              default:
            }
          }while(segundaopcao!=5);

          break;
        case 2:
          do{
            m.labirintotext();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              //LABIRINTO
              case 1:
                //grafomatriz = new GraphMatrix("maze3_blocks.txt");
                GraphMatrix.mazeGenerator("maze3_blocks.txt");
                break;
              case 2:
                GraphMatrix.mazeGenerator("maze10_blocks.txt");
                break;
              case 3:
                GraphMatrix.mazeGenerator("maze20_blocks.txt");
                break;
              case 4:
                GraphMatrix.mazeGenerator("maze30_blocks.txt");
                break;
              case 5:
                GraphMatrix.mazeGenerator("maze40_blocks.txt");
                break;
              case 6:
                GraphMatrix.mazeGenerator("maze50_blocks.txt");
                break;
              case 7:
                System.out.println("Saindo algoritmo do labirinto...");
                break;

              default:
            }
          }while(segundaopcao!=7);



          break;
        case 3:
          System.out.println("Saindo...");
          break;
        default:
          System.out.println("OPCAO INCORRETA!!!");
          break;
      }
    } while (opcao != 3);
  }
}
/*
 * BUSCA_LARGURA(G=(V,E),s)
 * para cada v em V
 * desc[v] <- 0 //nó v foi descoberto 0/1 ?
 * Q <- {s} //fila dos nós a processar (FIFO)
 * R <- {s} //ordem de descoberta
 * desc[s] <- 1
 * enquanto Q != {}
 * u <- remova o primeiro elem. de Q
 * para cada v adjacente a U
 * se desc[v] = 0
 * adicione v ao final de Q
 * adicione v ao final de R
 * retorna R
 * 
 */

// PASSAR PARA O CADERNO E APAGAR!!!!!!!!!!!!!!!!

/*
 * 
 * Bellman-Ford
 * 
 * -Lida com aresta negativa
 * -Complexidade
 * 
 * Foyd-Warshall
 * 
 * -Todos os pares
 * 
 * 
 * 
 */


