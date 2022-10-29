public class Edge {
    
    private int source;
    private int sink;
    private int weight;

    public Edge (int source, int sink, int weight){
        this.source = source;
        this.sink = sink;
        this.weight = weight;
    }

    public int getSink() {
        return sink;
    }

    public int getSource() {
        return source;
    }

    public int getWeight() {
        return weight;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public void setSink(int sink) {
        this.sink = sink;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(" + source + ", " + sink + ", " + weight + ")";
    }
    
}
