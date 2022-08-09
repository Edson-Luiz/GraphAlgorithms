public class Graph {

  private int countNodes;
  private int countEdges;
  private int[][] adjMatrix;

  public int getCountEdges() {
    return countEdges;
  }

  public int getCountNodes() {
    return countNodes;
  }

  public int[][] getAdjMatrix() {
    return adjMatrix;
  }

  public Graph(int countNodes) {

    this.countNodes = countNodes;
    this.adjMatrix = new int[countNodes][countNodes];

  }

  public void addEdge(int source, int sink, int weight){
    
    if(source < 0 || source >= this.countNodes - 1 
       || sink < 0 || sink > this.countNodes - 1 || weight <=0){
      
        System.out.print("\nInvalid edge: " + source + sink + weight);
        return;
      }
    
      this.adjMatrix[source][sink] = weight;
      this.countEdges++;

  }

  public int degree(int node){

    int cont = 0;

    if(node > this.countNodes - 1){
      System.err.println("Invalid node: \n");
    }
    else 
    {
      for (int i = 0; i < this.adjMatrix[node].length; i++) {
      if(this.adjMatrix[node][i] != 0){
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

}