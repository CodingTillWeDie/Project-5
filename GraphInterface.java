/** An interface for the ADT Graph. */
public interface GraphInterface <T> {

    /** Performs a breadth-first traversal of this graph.
     @param origin  An object that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
    public QueueInterface<T> getBreadthFirstTraversal(T origin);

    /** Performs a depth-first traversal of this graph.
     @param origin  An object that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
    public QueueInterface<T> getDepthFirstTraversal(T origin);

    /** Gets an unvisited neighbor, if there are any,
     of the vertex that was passed in as an argument.
     @return Either a vertex that is an unvisited neighbor or null
     if no such neighbor exists. */
    public T getUnvisitedNeighbor(T vertexLabel);

    /** Gets the label of a vertex in this graph.
     @param vertex  An object that labels the vertexs of the traversal.
     @return  The label of the vertex at the given index. */
    public T getLabel(int vertex);

    /** Gets the index of a vertex in this graph.
     @param label  An object to check if the label is the same as the label in the index.
     @return  The index of the vertex at the given label. */
    public int getIndex(T label);

    /** Sees whether the vertex is marked as visited.
     @return True if the vertex is visited. */
    public boolean isVisited(int vertexIndex);

    /** Sees whether an edge exists.
     @return The edge at the given source and target. */
    public boolean isEdge(int source, int target);

    /** Adds an edge. */
    public void addEdge(int source, int target);

    /** Obtain a list of neighbors of a specified vertex of this Graph
     @return An array of the neighbors of a specified vertex in the graph. */
    public int[] neighbors(int vertex);

    /** Checks to see if a vertex has another unvisited neighbor.
     @return True if a vertex has unvisited neighbors, false otherwise. */
    public boolean hasNextNeighbor(T vertex);

    /** Removes an edge. */
    public void removeEdge(int source, int target);

    /** Change the label of a vertex of this Graph */
    public void setLabel(int vertex, T newLabel);

    /** Accessor method to determine the number of vertices in this Graph
     @return the length of the array "labels" */
    public int size();

    /** marks all vertices in the graph as unvisited */
    public void resetVertices();
}
