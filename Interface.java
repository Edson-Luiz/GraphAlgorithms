public class Interface {

    public void Imenu(){
        System.out.println("-------INFORME A TAREFA-------");
        System.out.println("1 - Caminho Minimo");
        System.out.println("2 - Labirinto");
        System.out.println("3 - Sair");
      }
      public void Icaminho(){
          System.out.println("-------CAMINHO MINIMO-------");
          System.out.println("1 - Dijkstra");
          System.out.println("2 - Bellmanford");
          System.out.println("3 - FloydWarshall");
          System.out.println("4 - Bellmanford Melhorado");
          System.out.println("5 - Sair");
      }
  
      public void Iarquivos(){
          System.out.println("-------ARQUIVOS-------");
          System.out.println("1 - Toy");
          System.out.println("2 - Rg_300_4730");
          System.out.println("3 - Rome99c");
          System.out.println("4 - Facebook_combined");
          System.out.println("5 - USA-road-dt.DC");
          System.out.println("6 - USA-road-dt.NY");
          System.out.println("7 - SAIR");
      }
  
      public void Ilabirinto(){
          System.out.println("-------LABIRINTO-------");
          System.out.println("1 - Maze3");
          System.out.println("2 - Maze10");
          System.out.println("3 - Maze20");
          System.out.println("4 - Maze30");
          System.out.println("5 - Maze40");
          System.out.println("6 - Maze50");
          System.out.println("7 - SAIR");
      }

      public void inicio() {
        System.out.println("Digite o valor inicial");

      }

      public void fim(){
        System.out.println("Digite o valor do fim");
      }
      
}
