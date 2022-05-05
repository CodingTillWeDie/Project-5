// driver program that creates a graph given in the project prompt using
// both representations of the graph (adjacency matrix and adjacency list).
public class GraphDriver
{
    public static void main(String[] args)
    {
        int graphSize = 9;
        int counter = 1;

        // create a graph given in the project prompt using adjacency matrix.
        System.out.println("Creating a graph using adjacency matrix...");
        ArrayGraph<String> arrayGraph = new ArrayGraph<>(graphSize);

        arrayGraph.setLabel(0, "A");
        arrayGraph.addEdge(0,1);
        arrayGraph.addEdge(0,3);
        arrayGraph.addEdge(0,4);
        arrayGraph.setLabel(1, "B");
        arrayGraph.addEdge(1,4);
        arrayGraph.setLabel(2, "C");
        arrayGraph.addEdge(2,1);
        arrayGraph.setLabel(3, "D");
        arrayGraph.addEdge(3,6);
        arrayGraph.setLabel(4, "E");
        arrayGraph.addEdge(4,5);
        arrayGraph.addEdge(4,7);
        arrayGraph.setLabel(5, "F");
        arrayGraph.addEdge(5,2);
        arrayGraph.addEdge(5,7);
        arrayGraph.setLabel(6, "G");
        arrayGraph.addEdge(6,7);
        arrayGraph.setLabel(7, "H");
        arrayGraph.addEdge(7,8);
        arrayGraph.setLabel(8, "I");
        arrayGraph.addEdge(8,5);

        // perform a breadth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<String> breadthFirst1 = arrayGraph.getBreadthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in breadth-first traversal order: [");
        while (!breadthFirst1.isEmpty())
        {
            String label = breadthFirst1.dequeue();

            System.out.print(label);
            if (counter < graphSize)
            {
                System.out.print(", ");
                ++counter;
            }
        }
        System.out.println("]");
        // restart the counter that's used for the number of arrows used.
        counter = 1;

        // perform a depth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<String> depthFirst1 = arrayGraph.getDepthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in depth-first traversal order: [");
        while (!depthFirst1.isEmpty())
        {
            String label = depthFirst1.dequeue();

            System.out.print(label);
            if (counter < graphSize)
            {
                System.out.print(", ");
                ++counter;
            }
        }
        System.out.println("]");
        // restart the counter that's used for the number of arrows used.
        counter = 1;

        // create a graph given in the project prompt using adjacency list.
        System.out.println("\nCreating a graph using adjacency list...");
        LinkedGraph<String> linkedGraph = new LinkedGraph<>(graphSize);

        linkedGraph.setLabel(0, "A");
        linkedGraph.addEdge(0,1);
        linkedGraph.addEdge(0,3);
        linkedGraph.addEdge(0,4);
        linkedGraph.setLabel(1, "B");
        linkedGraph.addEdge(1,4);
        linkedGraph.setLabel(2, "C");
        linkedGraph.addEdge(2,1);
        linkedGraph.setLabel(3, "D");
        linkedGraph.addEdge(3,6);
        linkedGraph.setLabel(4, "E");
        linkedGraph.addEdge(4,5);
        linkedGraph.addEdge(4,7);
        linkedGraph.setLabel(5, "F");
        linkedGraph.addEdge(5,2);
        linkedGraph.addEdge(5,7);
        linkedGraph.setLabel(6, "G");
        linkedGraph.addEdge(6,7);
        linkedGraph.setLabel(7, "H");
        linkedGraph.addEdge(7,8);
        linkedGraph.setLabel(8, "I");
        linkedGraph.addEdge(8,5);

        // perform a breadth-first traversal on the
        // graph starting at vertex A.
        QueueInterface<String> breadthFirst2 = linkedGraph.getBreadthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst2.isEmpty())
        {
            String label = breadthFirst2.dequeue();

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
        QueueInterface<String> depthFirst2 = linkedGraph.getDepthFirstTraversal("A");

        // display the vertices in order in which they were visited.
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst2.isEmpty())
        {
            String label = depthFirst2.dequeue();

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
