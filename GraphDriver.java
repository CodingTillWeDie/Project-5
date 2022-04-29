import java.util.Iterator;

public class GraphDriver<T>
{
    public static void main(String args[])
    {
        // create a graph given in the project prompt.
        Graph<String> graph = new Graph<>(9);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.addEdge(1,4);
        graph.addEdge(2,1);
        graph.addEdge(3,6);
        graph.addEdge(4,5);
        graph.addEdge(4,7);
        graph.addEdge(5,2);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.addEdge(7,8);
        graph.addEdge(8,5);

        // perform a breadth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<Integer> breadthFirst = getBreadthFirstTraversal(0);

        // display the vertices in order in which they were visited.
        while (!breadthFirst.isEmpty())
        {
            T label = breadthFirst.dequeue();

            System.out.print(label + “ => ”);
        }
        System.out.println();


        // perform a depth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<Integer> depthFirst = getBreadthFirstTraversal(1);

        // display the vertices in order in which they were visited.
        while (!depthFirst.isEmpty())
        {
            T label = depthFirst.dequeue();

            System.out.print(label + “ -> ”);
        }
        System.out.println();

    } // end of main
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<>(); // a new queue for the resulting traversal order.
        QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>(); // a new queue to hold the vertices as they are visited.

        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);    // Enqueue vertex label
        vertexQueue.enqueue(originVertex); // Enqueue vertex

        while (!vertexQueue.isEmpty())
        {
            VertexInterface<T> frontVertex = vertexQueue.dequeue();
            Iterator<VertexInterface<T>> neighbors = frontVertex.getNeighborIterator();

            while (neighbors.hasNext())
            {
                VertexInterface<T> nextNeighbor = neighbors.next();
                if (!nextNeighbor.isVisited())
                {
                    nextNeighbor.visit();
                    traversalOrder.enqueue(nextNeighbor.getLabel());
                    vertexQueue.enqueue(nextNeighbor);
                } // end if
            } // end while
        } // end while

        return traversalOrder;
    } // end getBreadthFirstTraversal

    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();
        QueueInterface<T> traversalOrder = new LinkedQueue<T>(); // a new queue for the resulting traversal order.
        StackInterface<VertexInterface<T>> vertexStack = new LinkedStack<>(); // a new stack to hold the vertices as they are visited.

        // mark the origin vertex as visited.
        VertexInterface<T> originVertex = vertices.getValue(origin);
        originVertex.visit();
        traversalOrder.enqueue(origin);
        vertexStack.push(originVertex);

        while (!vertexStack.isEmpty())
        {
            VertexInterface<T> topVertex = vertexStack.peek();
            VertexInterface<T> nextNeighbor = topVertex.getUnvisitedNeighbor();

            // check to see if top vertex has an unvisited neighbor.
            if (nextNeighbor != null)
            {
                // if so, mark next neighbor as visited.
                nextNeighbor.visit();
                traversalOrder.enqueue(nextNeighbor.getLabel());
                vertexStack.push(nextNeighbor);
            }
            // otherwise, all neighbors are visited.
            else
                vertexStack.pop();
        }

        return traversalOrder;
    }
    protected void resetVertices()
    {
        Iterator<VertexInterface<T>> vertexIterator = vertices.getValueIterator();
        while (vertexIterator.hasNext())
        {
            VertexInterface<T> nextVertex = VertexIterator.next();
            nextVertex.unvisit();
            nextVertex.setCost(0);
            nextVertex.setPredecessor(null);
        } // end while
    } // end resetVertices
} // end of "GraphDriver"
