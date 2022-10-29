import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class GraphList {

  private int countNodes;
  private int countEdges;
  private ArrayList<ArrayList<Edge>> adjList;
  private ArrayList<Edge> edgeList;
  private static final int INF = 999999;

  public GraphList(int countNodes) {

    this.countNodes = countNodes;
    adjList = new ArrayList<>(countNodes);
    for (int i = 0; i < countNodes; i++) {
      adjList.add(new ArrayList<Edge>());
    }

    edgeList = new ArrayList<>();

  }

  public int getCountNodes() {
    return countNodes;
  }

  public int getCountEdges() {
    return countEdges;
  }

  public ArrayList<ArrayList<Edge>> getAdjList() {
    return adjList;
  }

  public void setAdjList(ArrayList<ArrayList<Edge>> adjList) {
    this.adjList = adjList;
  }

  public void addEdge(int source, int sink, int weight) {

        if(source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1 || weight <= 0){

            System.err.println("\nInvalid edge: " + source + sink + weight);
            return;
        }

        adjList.get(source).add(new Edge(source, sink, weight));
        this.countEdges++;

  }

  public void addEdgeUnoriented(int source, int sink, int weight) {

        addEdge(source, sink, weight);
        addEdge(sink, source, weight);

    }

  public String toString() {
        String str = "";
        for (int i = 0; i < this.adjList.size(); i++) {
            str += i + ": ";
            for (int j = 0; j < this.adjList.get(i).size(); j++) {
                str += this.adjList.get(i).get(j) + "\t";

            }
            str += "\n";

        }
        return str;
    }

  public GraphList(String fileName) throws IOException {
        File file = new File(fileName);
        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);

        // Read header
        String[] line = bufferedReader.readLine().split(" ");
        this.countNodes = (Integer.parseInt(line[0]));
        int fileLines = (Integer.parseInt(line[1]));

        // Create and fill adjMatrix with read edges
        adjList = new ArrayList<>(this.countNodes);
        for (int i = 0; i < this.countNodes; i++) {
            adjList.add(new ArrayList<Edge>());
        }
        bufferedReader.close();
        reader.close();
    }

  public int degree(int node) {
        if (node < 0 || node > this.countNodes - 1)
            System.err.println("Invalid node: " + node);
        return this.adjList.get(node).size();
    }

    public int highestDegree() {
        int highest = 0;

        for (int i = 0; i < this.adjList.size(); i++) {
            int degreeNodeI = this.degree(i);
            if (degreeNodeI > highest) {
                highest = degreeNodeI;
            }

        }

        return highest;
    }

    public int lowestDegree() {
        int lowest = this.countNodes;

        for (int i = 0; i < this.adjList.size(); i++) {
            int degreeNodeI = this.degree(i);
            if (degreeNodeI < lowest) {
                lowest = degreeNodeI;
            }

        }

        return lowest;
    }

    public float density() {
      return (float) this.countEdges / (this.countNodes * (this.countNodes - 1));
    }

    public ArrayList<Integer> bfs(int s) {
        int[] desc = new int[this.countNodes];

        ArrayList<Integer> Q = new ArrayList<>();
        Q.add(s);

        ArrayList<Integer> R = new ArrayList<>();
        R.add(s);

        desc[s] = 1;

        while (Q.size() > 0) {
            int u = Q.remove(0);
            for (int v = 0; v < this.adjList.get(u).size(); v++) {
                if (desc[this.adjList.get(u).get(v).getSink()] == 0) {
                    Q.add(this.adjList.get(u).get(v).getSink());
                    R.add(this.adjList.get(u).get(v).getSink());
                    desc[this.adjList.get(u).get(v).getSink()] = 1;
                }
            }
        }
        return R;
    }
    
    public ArrayList<Integer> dfs(int s) {
        int[] desc = new int[this.countNodes];

        ArrayList<Integer> S = new ArrayList<>();
        S.add(s);

        ArrayList<Integer> R = new ArrayList<>();
        R.add(s);

        desc[s] = 1;

        while (S.size() > 0) {
            boolean unstack = true;
            int u = S.get(S.size() - 1);
            for (int v = 0; v < this.adjList.get(u).size(); v++) {
                if (desc[this.adjList.get(u).get(v).getSink()] == 0) {
                    S.add(this.adjList.get(u).get(v).getSink());
                    R.add(this.adjList.get(u).get(v).getSink());
                    desc[this.adjList.get(u).get(v).getSink()] = 1;
                    unstack = false;
                    break;
                }
            }
            if (unstack) {
                S.remove(S.size() - 1);
            }
        }
        return R;
    }

     public boolean connected() {
       return this.bfs(0).size() == this.countNodes;
     }

     public boolean isOriented() {
        for (int i = 0; i < this.adjList.size(); i++) {
            for (int j = 0; j < this.adjList.get(i).size(); j++) {
                int sink = this.adjList.get(i).get(j).getSink();
                int source = this.adjList.get(i).get(j).getSource();
                boolean hasEdgeSinkSource = false;
                for (int k = 0; k < this.adjList.get(sink).size(); k++) {
                    if (this.adjList.get(sink).get(k).getSink() == source) {
                        hasEdgeSinkSource = true;
                        break;
                    }
                }
                if (!hasEdgeSinkSource) {
                    return true;
                }
            }
        }
        return false;
    }



    public GraphList complement() {
      GraphList g2 = new GraphList(this.countNodes);
      for (int u = 0; u < this.adjList.size(); ++u) {
          for (int v = 0; v < this.countNodes; ++v) {
              boolean addEdgeUV = true;
              for (int idx = 0; idx < this.adjList.get(u).size(); ++idx) {
                  int v2 = this.adjList.get(u).get(idx).getSink();
                  if (v2 == v) { // Edge (u, v) exists and should not be added
                      addEdgeUV = false;
                      break;
                  }
              }
              if (addEdgeUV && u != v) {
                  g2.addEdge(u, v, 1); // It assumes edges are unweighted
              }
          }
      }
      return g2;
  }

    public boolean subgraph(GraphList g2) {
      if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
          return false;
      for (int u = 0; u < g2.adjList.size(); ++u) {
          boolean foundEdge = false;
          for (int idx = 0; idx < g2.adjList.get(u).size(); ++idx) {
              int v = g2.adjList.get(u).get(idx).getSink();
              // Check if edge (u,v) exists in this graph
              for (int idx2 = 0; idx2 < this.adjList.get(u).size(); ++idx2) {
                  int v2 = this.adjList.get(u).get(idx2).getSink();
                  if (v == v2) { // Edge exists
                      foundEdge = true;
                      break;
                  }
              }
              if (!foundEdge)
                  return false;
          }
      }
      return true;
  }

  public int menorDistanciaList(int dist[],  ArrayList<Integer> q) {

    int shortest = dist[q.get(0)];
    int u = q.get(0);

    for (int i = 0; i < this.countNodes; i++) {
        if(q.contains(i)){
            if(dist[i] < shortest){
                shortest = dist[i];
                u = i;
            }
        }
    }
    return u;
}


  public void dijkstra(int source, int sink) {
    ArrayList<Integer> q = new ArrayList<Integer>();
    int[] pred = new int[this.countNodes];
    int[] dist = new int[this.countNodes];

    for (int i = 0; i < this.countNodes; i++) {
        q.add(i);
        dist[i] = INF;

    }

    dist[source] = 0;

    while(q.size()!=0){
        Integer u = menorDistanciaList(dist,q);
        q.remove(u);

        for (int i = 0; i < this.adjList.get(u).size(); i++) {
            if(dist[this.adjList.get(u).get(i).getSink()] > dist[u] + this.adjList.get(u).get(i).getWeight()){
                dist[this.adjList.get(u).get(i).getSink()] = dist[u] + this.adjList.get(u).get(i).getWeight();
                pred[this.adjList.get(u).get(i).getSink()] = u;
            }
        }
    }


    System.out.printf("Distância entre %d e %d: %d   ", source,sink,dist[sink]);
    ArrayList<Integer> caminho = new ArrayList<Integer>();
    int aux = sink;
    caminho.add(sink);
    while(aux != source){
        aux = pred[aux];
        caminho.add(0,aux);
    }
    System.out.println("Caminho: " + caminho);

}

    public ArrayList<Edge> kruskal() {
      ArrayList<Edge> T = new ArrayList<Edge>(this.countNodes - 1);
      int[] F = new int[this.countNodes];
      // makeset(u)
      for (int u = 0; u < this.countNodes; ++u)
          F[u] = u;
      edgeList.sort(null);
      for (int idx = 0; idx < edgeList.size(); ++idx) {
          int u = edgeList.get(idx).getSource();
          int v = edgeList.get(idx).getSink();
          if (F[u] != F[v]) { // findset(u) != findset(v)
              T.add(edgeList.get(idx));
              // Save some iterations if tree is already built
              if (T.size() == countNodes - 1)
                  break;
              // union(u, v)
              int k = F[v];
              for (int i = 0; i < F.length; ++i) {
                  if (F[i] == k) {
                      F[i] = F[u];
                  }
              }
          }
      }
      return T;
  }

  public ArrayList<Edge> prim() {
    ArrayList<Edge> T = new ArrayList<Edge>(this.countNodes - 1);
    int s = 0;
    int[] dist = new int[this.countNodes];
    int[] parent = new int[this.countNodes];
    // Q represents the nodes that were not connected yet
    ArrayList<Integer> Q = new ArrayList<Integer>(this.countNodes);
    for (int u = 0; u < this.countNodes; ++u) {
        dist[u] = INF;
        parent[u] = -1;
        Q.add(u);
    }
    dist[s] = 0;
    while (Q.size() != 0) {
        int u = -1;
        int min = INF;
        for (int idx = 0; idx < Q.size(); ++idx) {
            int i = Q.get(idx);
            if (dist[i] < min) {
                min = dist[i];
                u = i;
            }
        }
        // Node u is gonna be connected
        Q.remove((Integer) u);
        for (int idx = 0; idx < this.adjList.get(u).size(); ++idx) {
            int v = this.adjList.get(u).get(idx).getSink();
            int w = this.adjList.get(u).get(idx).getWeight();
            if (Q.contains(v) && w < dist[v]) {
                dist[v] = w;
                parent[v] = u;
            }
        }
    }
    // Recover the tree from parent array
    for (int u = 0; u < parent.length; ++u) {
        if (parent[u] != -1) {
            T.add(new Edge(u, parent[u], 1));
        }
    }
    return T;
  }

  public ArrayList<Integer> bellmanFord(int s, int t) {
    int[] dist = new int[this.countNodes]; // * Vetor de distancias, armazena a distancia de um vertice ate a origem
    Integer[] path = new Integer[this.countNodes]; // * Vetor do caminho percorrido

    // * Inicializa todas as distancias como infinito
    for (int i = 0; i < this.countNodes; i++)
      dist[i] = INF;

    // * Marca a distancia da origem para ela mesma como 0
    dist[s] = 0;

    for (int k = 0; k < this.countNodes - 1; k++) {
      for (int i = 0; i < this.countNodes; i++) {
        for (int j = 0; j < this.adjList.get(i).size(); j++) {
          int u = this.adjList.get(i).get(j).getSource();
          int v = this.adjList.get(i).get(j).getSink();
          int w = this.adjList.get(i).get(j).getWeight();

          if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            path[v] = u;
          }
        }
      }
    }

    // * Cria um vetor para representar o caminho final
    // * O caminho final seria percorrer o vetor de path até a origem
    // * Começando por t, veriamos qual vertice o originou, e assim por diante
    // * Isso possibilita seguir a "trilha" da resposta
    ArrayList<Integer> result = new ArrayList<>();
    int current = t;

    // * Percorro o vetor de caminhos até encontrar a origem
    while (path[current] != null) {
      result.add(current);
      current = path[current];
    }

    // * Adiciona a origem a resposta
    result.add(s);

    // * Como percorremos de tras para frente, invertemos a soucao para visualizacao
    Collections.reverse(result);

    // * Imprimo o caminho
    System.out.println("Caminho: " + result);
    System.out.println("Custo: " + dist[t]); // * O custo é o vetor de distancia na posicao t, final, ja que esse
                                             // *vetor armazena a distancia de um dado vertice até a origem

    return result;

  }

  public ArrayList<Integer> bellmanFordImproved(int s, int t) {
    int[] dist = new int[this.countNodes]; // * Vetor de distancias, armazena a distancia de um vertice ate a origem
    Integer[] path = new Integer[this.countNodes]; // * Vetor do caminho percorrido

    // * Inicializa todas as distancias como infinito
    for (int i = 0; i < this.countNodes; i++)
      dist[i] = INF;

    // * Marca a distancia da origem para ela mesma como 0
    dist[s] = 0;

    boolean flag;
    for (int k = 0; k < this.countNodes - 1; k++) {
      flag = false;
      for (int i = 0; i < this.countNodes; i++) {
        for (int j = 0; j < this.adjList.get(i).size(); j++) {
          int u = this.adjList.get(i).get(j).getSource();
          int v = this.adjList.get(i).get(j).getSink();
          int w = this.adjList.get(i).get(j).getWeight();

          if (dist[u] + w < dist[v]) {
            dist[v] = dist[u] + w;
            path[v] = u;

            flag = true;
          }
        }
      }

      if (!flag)
        break;
    }

    // * Cria um vetor para representar o caminho final
    // * O caminho final seria percorrer o vetor de path até a origem
    // * Começando por t, veriamos qual vertice o originou, e assim por diante
    // * Isso possibilita seguir a "trilha" da resposta
    ArrayList<Integer> result = new ArrayList<>();
    int current = t;

    // * Percorro o vetor de caminhos até encontrar a origem
    while (path[current] != null) {
      result.add(current);
      current = path[current];
    }

    // * Adiciona a origem a resposta
    result.add(s);

    // * Como percorremos de tras para frente, invertemos a soucao para visualizacao
    Collections.reverse(result);

    // * Imprimo o caminho
    System.out.println("Caminho: " + result);
    System.out.println("Custo: " + dist[t]); // * O custo é o vetor de distancia na posicao t, final, ja que esse
                                             // *vetor armazena a distancia de um dado vertice até a origem

    return result;
  }




}
