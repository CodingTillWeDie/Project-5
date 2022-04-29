public class GraphDriver implements Graph<E>
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

            System.out.print(label + “ -> ”);
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

} // end of "GraphDriver"
