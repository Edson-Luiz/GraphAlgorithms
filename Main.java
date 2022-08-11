class Main {
  public static void main(String[] args) {

    Graph g1 = new Graph(4);

    g1.addEdge(0, 1, 1);
    g1.addEdge(1, 0, 1);
    g1.addEdge(0, 3, 1);
    g1.addEdge(3, 0, 1);
    //g1.addEdge(3, 4, 1); // Warning

    System.err.println(g1);
    // System.err.println(g1.degree(0));

    //System.out.println(g1.highestDegree());
    //System.out.println(g1.lowestDegree());
    System.out.println(g1.complement());

    //Postar link atualizado do GIT
    
  }

}