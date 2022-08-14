public class Graph {

  private int countNodes; //Contador de nos
  private int countEdges; //Contador de arestas
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

  public int highestDegree(){
    int highest = 0;
    
    for (int i = 0; i < this.adjMatrix.length; i++) {
      int degreeNodeI = this.degree(i);
        if(degreeNodeI > highest){
          highest = degreeNodeI;
      }
        
    }
    
    return highest;
  }

  public int lowestDegree(){
    int lowest = this.adjMatrix.length;
    
    for (int i = 0; i < this.adjMatrix.length; i++) {
      int degreeNodeI = this.degree(i);
        if(degreeNodeI < lowest){
          lowest = degreeNodeI;
      }
        
    }
    
    return lowest;
  }

  public Graph complement(){
    Graph g2 = new Graph(this.countNodes); 

    for (int i = 0; i < this.adjMatrix.length; i++) {
      for (int j = 0; j < this.adjMatrix[i].length; j++) {
        if(this.adjMatrix[i][j] == 0 && i != j){
          g2.addEdge(i, j, 1);
          
        }
        
      }
      
    }

    return g2;
  }

}