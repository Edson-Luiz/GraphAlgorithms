import java.io.IOException;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws IOException {
    int opcao = -1;
    int segundaopcao = -1;
    int terceiraopcao = -1;
    int source=0;
    int end=0;

    GraphList graphList;
    GraphMatrix graphMatrix;

    Scanner leitor = new Scanner(System.in);
    Interface menu = new Interface();
    long tempoInicial = System.currentTimeMillis();

    do {
      menu.Imenu();
      opcao = leitor.nextInt();
      switch (opcao) {
        case 1:
          do{
            menu.Icaminho();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              case 1:
                do{
                  menu.Iarquivos();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //DIJKSTRA
                    case 1:
                      graphList= new GraphList("toy.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 2:
                      graphList= new GraphList("rg300_4730.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 3:
                      graphList= new GraphList("rome99c.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 4:
                      graphList= new GraphList("facebook_combined.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 5:
                      graphList= new GraphList("USA-road-dt.DC.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 6:
                      graphList = new GraphList("USA-road-dt.NY.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.dijkstra(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    case 7:
                      System.out.println("Saindo do algoritmo de Dijkstra...");
                      break;

                    default:
                      System.out.println("Opção inválida, porfavor tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 2:
                do{
                  menu.Iarquivos();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD
                    case 1:
                      graphList= new GraphList("toy.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      graphList= new GraphList("rg300_4730.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      graphList= new GraphList("rome99c.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      graphList= new GraphList("facebook_combined.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      graphList= new GraphList("USA-road-dt.DC.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      graphList = new GraphList("USA-road-dt.NY.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFord(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;

                    default:
                      System.out.println("Opção inválida, tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 3:
                do{
                  menu.Iarquivos();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //FLOYDWARSHALL
                    case 1:
                      graphMatrix= new GraphMatrix("toy.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      graphMatrix = new GraphMatrix("rg300_4730.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      graphMatrix = new GraphMatrix("rome99c.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      graphMatrix = new GraphMatrix("facebook_combined.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      graphMatrix = new GraphMatrix("USA-road-dt.DC.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      graphMatrix = new GraphMatrix("USA-road-dt.NY.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphMatrix.floydWarshall(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Floyd-Warshall...");
                      break;

                    default:
                      System.out.println("Opção inválida, tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              case 4:
                do{
                  menu.Iarquivos();
                  terceiraopcao=leitor.nextInt();
                  switch (terceiraopcao){
                    //BELLMANFORD MELHORADO
                    case 1:
                      graphList= new GraphList("toy.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 2:
                      graphList= new GraphList("rg300_4730.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 3:
                      graphList= new GraphList("rome99c.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 4:
                      graphList= new GraphList("facebook_combined.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 5:
                      graphList= new GraphList("USA-road-dt.DC.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 6:
                      graphList = new GraphList("USA-road-dt.NY.txt");
                      menu.inicio();
                      source = leitor.nextInt();
                      menu.fim();
                      end = leitor.nextInt();
                      System.out.println(" Processando os dados...");
                      tempoInicial = System.currentTimeMillis();
                      graphList.bellmanFordImproved(source,end);
                      System.out.println("O algoritmo foi processado em " + ((System.currentTimeMillis() - tempoInicial)*0.001) + " segundos");
                      break;
                    case 7:
                      System.out.println("Saindo do algoritmo de Bellman-Ford melhorado...");
                      break;

                    default:
                      System.out.println("Opção inválida, tente novamente!");

                  }
                }while(terceiraopcao!=7);
                break;
              default:
            }
          }while(segundaopcao!=5);

          break;
        case 2:
          do{
            menu.Ilabirinto();
            segundaopcao=leitor.nextInt();
            switch (segundaopcao){
              //LABIRINTO
              case 1:
                //graphMatrix = new GraphMatrix("maze3_blocks.txt");
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
                System.out.println("Saindo do algoritmo do labirinto...");
                break;

              default:
            }
          }while(segundaopcao!=7);



          break;
        case 3:
          System.out.println("Saindo do programa...");
          break;
        default:
          System.out.println("OPCAO INVÁLIDA!!!");
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


