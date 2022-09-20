import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;

public class Graph {

  private int countNodes; // Contador de nos
  private int countEdges; // Contador de arestas
  private int[][] adjMatrix;

  public Graph(int countNodes) {

    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes];

  }

  public int getCountEdges() {
    return countEdges;
  }

  public int getCountNodes() {
    return countNodes;
  }

  public int[][] getAdjMatrix() {
    return adjMatrix;
  }

  public void addEdge(int source, int sink, int weight) {

    if (source < 0 || source > this.countNodes - 1 || sink < 0 || sink > this.countNodes - 1
        || weight <= 0) {

      System.out.print("\nInvalid edge: " + source + sink + weight + "\n");
      return;
    }

    this.adjMatrix[source][sink] = weight;
    this.countEdges++;

  }

  public void addEdgeUnoriented(int u, int v, int w) {

    if (u < 0 || u > this.countNodes - 1 || v < 0 || v > this.countNodes - 1
        || w <= 0) {

      System.out.print("\nInvalid edge: " + u + v + w + "\n");
      return;
    }

    this.adjMatrix[u][v] = w;
    this.adjMatrix[v][u] = w;
    this.countEdges += 2;

  }

  public int degree(int node) {

    int cont = 0;

    if (node > this.countNodes - 1) {
      System.err.println("Invalid node: \n");
    } else {
      for (int i = 0; i < this.adjMatrix[node].length; i++) {
        if (this.adjMatrix[node][i] != 0) {
          cont++;
        }

      }

    }

    return cont;
  }

  public String toString() {
    String str = "";
    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        str += this.adjMatrix[i][j] + "\t";

      }
      str += "\n";

    }
    return str;
  }

  public int highestDegree() {
    int highest = 0;

    for (int i = 0; i < this.adjMatrix.length; i++) {
      int degreeNodeI = this.degree(i);
      if (degreeNodeI > highest) {
        highest = degreeNodeI;
      }

    }

    return highest;
  }

  public int lowestDegree() {
    int lowest = this.adjMatrix.length;

    for (int i = 0; i < this.adjMatrix.length; i++) {
      int degreeNodeI = this.degree(i);
      if (degreeNodeI < lowest) {
        lowest = degreeNodeI;
      }

    }

    return lowest;
  }

  public Graph complement() {
    Graph g2 = new Graph(this.countNodes);

    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        if (this.adjMatrix[i][j] == 0 && i != j) {
          g2.addEdge(i, j, 1);

        }

      }

    }

    return g2;
  }

  public float density() {
    return (float) this.countEdges / (this.countNodes * (this.countNodes - 1));
  }

  public boolean subGraph(Graph g2) {
    if (g2.countNodes > this.countNodes || g2.countEdges > this.countEdges)
      return false;
    for (int i = 0; i < g2.adjMatrix.length; i++) {
      for (int j = 0; j < g2.adjMatrix[i].length; j++) {
        if (g2.adjMatrix[i][j] != 0 && this.adjMatrix[i][j] == 0)
          return false;
      }
    }

    return true;
  }

  public ArrayList<Integer> bfs(int s) { // s = no origem

    int desc[] = new int[this.countNodes];

    ArrayList<Integer> Q = new ArrayList<>();
    ArrayList<Integer> R = new ArrayList<>();
    Q.add(s);
    R.add(s);

    desc[s] = 1;

    while (Q.size() > 0) {
      int u = Q.remove(0);
      for (int v = 0; v < this.adjMatrix[u].length; v++) {
        if (this.adjMatrix[u][v] != 0) {
          if (desc[v] == 0) {
            Q.add(v);
            R.add(v);
            desc[v] = 1;
          }
        }
      }
    }

    return R;
  }

  public ArrayList<Integer> dfs(int s) {

    int desc[] = new int[this.countNodes];

    ArrayList<Integer> S = new ArrayList<>();
    ArrayList<Integer> R = new ArrayList<>();
    S.add(s);
    R.add(s);

    desc[s] = 1;

    while (S.size() != 0) {
      boolean unstack = true;
      int u = S.get(S.size() - 1);
      for (int v = 0; v < this.adjMatrix[u].length; v++) {
        if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
          S.add(v);
          R.add(v);
          desc[v] = 1;
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

  public Graph(String fileName) throws IOException {
    File file = new File(fileName);
    FileReader reader = new FileReader(file);
    BufferedReader bufferedReader = new BufferedReader(reader);

    // Read header
    String[] line = bufferedReader.readLine().split(" ");
    this.countNodes = (Integer.parseInt(line[0]));
    int fileLines = (Integer.parseInt(line[1]));

    // Create and fill adjMatrix with read edges
    this.adjMatrix = new int[this.countNodes][this.countNodes];
    for (int i = 0; i < fileLines; ++i) {
      String[] edgeInfo = bufferedReader.readLine().split(" ");
      int source = Integer.parseInt(edgeInfo[0]);
      int sink = Integer.parseInt(edgeInfo[1]);
      int weight = Integer.parseInt(edgeInfo[2]);
      addEdge(source, sink, weight);
    }
    bufferedReader.close();
    reader.close();
  }

  public boolean nonOriented() {
    for (int i = 1; i < this.adjMatrix.length; i++) {
      for (int j = i + 1; j < this.adjMatrix[i].length; j++) {
        if (this.adjMatrix[i][j] != this.adjMatrix[j][i])
          return false;

      }
    }

    return true;
  }

  public ArrayList<Integer> dfs_rec(int s) {

    ArrayList<Integer> R = new ArrayList<>();
    int desc[] = new int[this.countNodes];
    dfs_rec_aux(s, desc, R);

    return R;
  }

  public void dfs_rec_aux(int u, int[] desc, ArrayList<Integer> R) {
    desc[u] = 1;
    R.add(u);

    for (int v = 0; v < this.adjMatrix[u].length; v++) {
      if (this.adjMatrix[u][v] != 0 && desc[v] == 0) {
        dfs_rec_aux(u, desc, R);
      }
    }

  }

  public void dijkstra(int s) {

    int dist[] = new int[this.countNodes];
    int pred[] = new int[this.countNodes];
    ArrayList<Integer> Q = new ArrayList<>();

    dist[s] = 0;
    Q.add(s);

    while (Q.size() != 0) {
      int u = 0;
      Q.remove(u);
      for (int v = 0; v < this.adjMatrix[u].length; v++) {
        if (dist[v] > dist[u]) {
          dist[v] = dist[u];
          pred[u] = v;

        }
      }
    }
  }

  public void floyd_warshall() {

    int[][] dist = new int[this.countNodes][this.countEdges];
    int[][] pred = new int[this.countNodes][this.countEdges];

    for (int i = 0; i < this.getCountNodes() - 1; i++) {
      for (int j = 0; j < this.getCountNodes() - 1; j++) {
        if (i == j) {
          dist[i][j] = 0;
        } else if (this.adjMatrix[i][j] != 0) {
          dist[i][j] = 0;
          pred[i][j] = i;
        } else {
          dist[i][j] = 100000000;
          pred[i][j] = null;
        }

      }
    }
    for (int i = 0; i < this.getCountNodes() - 1; i++) {
      for (int j = 0; j < this.getCountNodes() - 1; j++) {
        for (int k = 0; i < this.getCountNodes() - 1; k++) {
          if (dist[i][j] > dist[i][k] + dist[k][j]) {
            dist[i][j] = dist[i][k] + dist[k][j];
            pred[i][j] = pred[k][j];
          }
        }
      }
    }

  }

  

}