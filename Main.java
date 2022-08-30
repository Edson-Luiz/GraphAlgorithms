import java.io.IOException;

class Main {
  public static void main(String[] args) throws IOException {

    Graph g1 = new Graph(9);
    g1.addEdgeUnoriented(7, 5, 1);
    g1.addEdgeUnoriented(7, 1, 1);
    g1.addEdgeUnoriented(7, 2, 1);
    g1.addEdgeUnoriented(1, 0, 1);
    g1.addEdgeUnoriented(1, 4, 1);
    g1.addEdgeUnoriented(2, 3, 1);
    g1.addEdgeUnoriented(5, 6, 1);
    g1.addEdgeUnoriented(6, 8, 1);

    //System.out.println(g1.bfs(7));
    System.out.println(g1.connected());
    Graph g2 = new Graph("graph.txt");
    System.out.println(g1.nonOriented());
    System.out.println(g1.dfs(7));

    // Graph g1 = new Graph(4);

    // g1.addEdge(0, 1, 1);
    // g1.addEdge(1, 0, 1);
    // g1.addEdge(0, 3, 1);
    // g1.addEdge(3, 0, 1);
    // // g1.addEdge(3, 4, 1); // Warning

    // System.out.println("\nGRAFO PRINCIPAL ");
    // System.err.println(g1);
    // // System.err.println(g1.degree(0));
    // // System.out.println(g1.highestDegree());
    // // System.out.println(g1.lowestDegree());
    // System.out.println("\nGRAFO COMPLEMENTAR ");
    // System.out.println(g1.complement());
    // // System.out.println(g1.getCountEdges());
    // // System.out.println(g1.getCountNodes());

    // System.out.println("\nDENSIDADE DO GRAFO ");
    // System.out.println(g1.density());

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
