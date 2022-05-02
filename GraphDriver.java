public class GraphDriver
{
    public static void main(String[] args)
    {
        // create a graph given in the project prompt.
        int graphSize = 9;
        int counter = 1;
        Graph<String> graph = new Graph<>(graphSize);

        graph.setLabel(0, "A");
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(0,4);
        graph.setLabel(1, "B");
        graph.addEdge(1,4);
        graph.setLabel(2, "C");
        graph.addEdge(2,1);
        graph.setLabel(3, "D");
        graph.addEdge(3,6);
        graph.setLabel(4, "E");
        graph.addEdge(4,5);
        graph.addEdge(4,7);
        graph.setLabel(5, "F");
        graph.addEdge(5,2);
        graph.addEdge(5,7);
        graph.setLabel(6, "G");
        graph.addEdge(6,7);
        graph.setLabel(7, "H");
        graph.addEdge(7,8);
        graph.setLabel(8, "I");
        graph.addEdge(8,5);

        // perform a breadth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<String> breadthFirst = graph.getBreadthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst.isEmpty())
        {
            String label = breadthFirst.dequeue();

            System.out.print(label);
            if (counter < graphSize)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        // restart the counter that's used for the number of arrows used.
        counter = 1;

        // perform a depth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<String> depthFirst = graph.getDepthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst.isEmpty())
        {
            String label = depthFirst.dequeue();

            System.out.print(label);
            if (counter < graphSize)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();

    } // end of main

} // end of "GraphDriver"
