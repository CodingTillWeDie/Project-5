import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Vertex<T> implements VertexInterface<T>
{
    private T label;
    private ListWithIteratorInterface<Edge> edgeList; // Edges to neighbors
    private boolean visited;                          // True if visited
    private VertexInterface<T> previousVertex;        // On path to this vertex
    private double cost;                              // Of path to this vertex

    public Vertex(T vertexLabel)
    {
        label = vertexLabel;
        edgeList = new LinkedListWithIterator<>();
        visited = false;
        previousVertex = null;
        cost = 0;
    } // end constructor

    /**
     * Gets this vertex's label.
     *
     * @return The object that labels the vertex.
     */
    @Override
    public T getLabel() {
        return null;
    }

    /**
     * Marks this vertex as visited.
     */
    @Override
    public void visit() {

    }

    /**
     * Removes this vertex's visited mark.
     */
    @Override
    public void unvisit() {

    }

    /**
     * Sees whether the vertex is marked as visited.
     *
     * @return True if the vertex is visited.
     */
    @Override
    public boolean isVisited() {
        return false;
    }

    /**
     * Connects this vertex and a given vertex with a weighted edge.
     * The two vertices cannot be the same, and must not already
     * have this edge between them. In a directed graph, the edge
     * points toward the given vertex.
     *
     * @param endVertex  A vertex in the graph that ends the edge.
     * @param edgeWeight A real-valued edge weight, if any.
     * @return True if the edge is added, or false if not.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex, double edgeWeight) {
        return false;
    }

    /**
     * Connects this vertex and a given vertex with an unweighted
     * edge. The two vertices cannot be the same, and must not
     * already have this edge between them. In a directed graph,
     * the edge points toward the given vertex.
     *
     * @param endVertex A vertex in the graph that ends the edge.
     * @return True if the edge is added, or false if not.
     */
    @Override
    public boolean connect(VertexInterface<T> endVertex) {
        return false;
    }

    /**
     * Creates an iterator of this vertex's neighbors by following
     * all edges that begin at this vertex.
     *
     * @return An iterator of the neighboring vertices of this vertex.
     */
    @Override
    public Iterator<VertexInterface<T>> getNeighborIterator() {
        return null;
    }

    /**
     * Creates an iterator of the weights of the edges to this
     * vertex's neighbors.
     *
     * @return An iterator of edge weights for edges to neighbors of this
     * vertex.
     */
    @Override
    public Iterator<Double> getWeightIterator() {
        return null;
    }

    /**
     * Sees whether this vertex has at least one neighbor.
     *
     * @return True if the vertex has a neighbor.
     */
    @Override
    public boolean hasNeighbor() {
        return false;
    }

    /**
     * Gets an unvisited neighbor, if any, of this vertex.
     *
     * @return Either a vertex that is an unvisited neighbor or null
     * if no such neighbor exists.
     */
    @Override
    public VertexInterface<T> getUnvisitedNeighbor() {
        return null;
    }

    /**
     * Records the previous vertex on a path to this vertex.
     *
     * @param predecessor The vertex previous to this one along a path.
     */
    @Override
    public void setPredecessor(VertexInterface<T> predecessor) {

    }

    /**
     * Gets the recorded predecessor of this vertex.
     *
     * @return Either this vertex's predecessor or null if no predecessor
     * was recorded.
     */
    @Override
    public VertexInterface<T> getPredecessor() {
        return null;
    }

    /**
     * Sees whether a predecessor was recorded for this vertex.
     *
     * @return True if a predecessor was recorded.
     */
    @Override
    public boolean hasPredecessor() {
        return false;
    }

    /**
     * Records the cost of a path to this vertex.
     *
     * @param newCost The cost of the path.
     */
    @Override
    public void setCost(double newCost) {

    }

    /**
     * Gets the recorded cost of the path to this vertex.
     *
     * @return The cost of the path.
     */
    @Override
    public double getCost() {
        return 0;
    }

    protected class Edge
    {
        private VertexInterface<T> vertex; // Vertex at end of edge
        private double weight;

        protected Edge(VertexInterface<T> endVertex, double edgeWeight)
        {
            vertex = endVertex;
            weight = edgeWeight;
        } // end constructor

        protected Edge(VertexInterface<T> endVertex)
        {
            vertex = endVertex;
            weight = 0;
        } // end constructor

        protected VertexInterface<T> getEndVertex()
        {
            return vertex;
        } // end getEndVertex

        protected double getWeight()
        {
            return weight;
        } // end getWeight
    } // end Edge
} // end Vertex

