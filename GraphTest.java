import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Tester class to test the breadth-first and depth-first traversal methods */
class GraphTest
{
    /** Method to test the breadth-first traversal method */
    @Test
    void getBreadthFirstTraversalTest()
    {
        int counter = 1;

        // graph 1
        int graphSize1 = 9;
        Graph<String> graph1 = new Graph<>(graphSize1);

        // create graph #1.
        graph1.setLabel(0, "A");
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,4);
        graph1.setLabel(1, "B");
        graph1.addEdge(1,4);
        graph1.setLabel(2, "C");
        graph1.addEdge(2,1);
        graph1.setLabel(3, "D");
        graph1.addEdge(3,6);
        graph1.setLabel(4, "E");
        graph1.addEdge(4,5);
        graph1.addEdge(4,7);
        graph1.setLabel(5, "F");
        graph1.addEdge(5,2);
        graph1.addEdge(5,7);
        graph1.setLabel(6, "G");
        graph1.addEdge(6,7);
        graph1.setLabel(7, "H");
        graph1.addEdge(7,8);
        graph1.setLabel(8, "I");
        graph1.addEdge(8,5);

        QueueInterface<String> breadthFirst1 = graph1.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst1.isEmpty())
        {
            String label = breadthFirst1.dequeue();

            System.out.print(label);
            if (counter < graphSize1)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 2
        int graphSize2 = 2;
        Graph<String> graph2 = new Graph<>(graphSize2);

        // create graph #2.
        graph2.setLabel(0, "A");
        graph2.addEdge(0,1);
        graph2.setLabel(1, "B");
        graph2.addEdge(1,0);

        QueueInterface<String> breadthFirst2 = graph2.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst2.isEmpty())
        {
            String label2 = breadthFirst2.dequeue();

            System.out.print(label2);
            if (counter < graphSize2)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 3
        int graphSize3 = 3;
        Graph<String> graph3 = new Graph<>(graphSize3);

        // create graph #3.
        graph3.setLabel(0, "A");
        graph3.addEdge(0,1);
        graph3.setLabel(1, "B");
        graph3.addEdge(1,2);
        graph3.setLabel(2, "C");
        graph3.addEdge(2,0);
        graph3.addEdge(2,1);

        QueueInterface<String> breadthFirst3 = graph3.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst3.isEmpty())
        {
            String label3 = breadthFirst3.dequeue();

            System.out.print(label3);
            if (counter < graphSize3)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 4
        int graphSize4 = 4;
        Graph<String> graph4 = new Graph<>(graphSize4);

        // create graph #4.
        graph4.setLabel(0, "A");
        graph4.addEdge(0,1);
        graph4.addEdge(0,3);
        graph4.setLabel(1, "B");
        graph4.addEdge(1,2);
        graph4.setLabel(2, "C");
        graph4.addEdge(2,1);
        graph4.setLabel(3, "D");
        graph4.addEdge(3,2);

        QueueInterface<String> breadthFirst4 = graph4.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst4.isEmpty())
        {
            String label4 = breadthFirst4.dequeue();

            System.out.print(label4);
            if (counter < graphSize4)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 5
        int graphSize5 = 5;
        Graph<String> graph5 = new Graph<>(graphSize5);

        // create graph #5.
        graph5.setLabel(0, "A");
        graph5.addEdge(0,1);
        graph5.addEdge(0,3);
        graph5.addEdge(0,4);
        graph5.setLabel(1, "B");
        graph5.addEdge(1,3);
        graph5.setLabel(2, "C");
        graph5.setLabel(3, "D");
        graph5.addEdge(3,2);
        graph5.addEdge(3,4);
        graph5.setLabel(4, "E");

        QueueInterface<String> breadthFirst5 = graph5.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst5.isEmpty())
        {
            String label5 = breadthFirst5.dequeue();

            System.out.print(label5);
            if (counter < graphSize5)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 6
        int graphSize6 = 6;
        Graph<String> graph6 = new Graph<>(graphSize6);

        // create graph #6.
        graph6.setLabel(0, "A");
        graph6.addEdge(0,1);
        graph6.addEdge(0,3);
        graph6.setLabel(1, "B");
        graph6.addEdge(1,2);
        graph6.addEdge(1,4);
        graph6.addEdge(1,3);
        graph6.setLabel(2, "C");
        graph6.addEdge(2,3);
        graph6.addEdge(2,5);
        graph6.setLabel(3, "D");
        graph6.setLabel(4, "E");
        graph6.setLabel(5, "F");

        QueueInterface<String> breadthFirst6 = graph6.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst6.isEmpty())
        {
            String label6 = breadthFirst6.dequeue();

            System.out.print(label6);
            if (counter < graphSize6)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 7
        int graphSize7 = 7;
        Graph<String> graph7 = new Graph<>(graphSize7);

        // create graph #7.
        graph7.setLabel(0, "A");
        graph7.addEdge(0,1);
        graph7.addEdge(0,2);
        graph7.addEdge(0,3);
        graph7.addEdge(0,4);
        graph7.addEdge(0,5);
        graph7.addEdge(0,6);
        graph7.setLabel(1, "B");
        graph7.setLabel(2, "C");
        graph7.setLabel(3, "D");
        graph7.setLabel(4, "E");
        graph7.setLabel(5, "F");
        graph7.setLabel(6, "G");

        QueueInterface<String> breadthFirst7 = graph7.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst7.isEmpty())
        {
            String label7 = breadthFirst7.dequeue();

            System.out.print(label7);
            if (counter < graphSize7)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 8
        int graphSize8 = 8;
        Graph<String> graph8 = new Graph<>(graphSize8);

        // create graph #8.
        graph8.setLabel(0, "A");
        graph8.addEdge(0,2);
        graph8.setLabel(1, "B");
        graph8.addEdge(1,0);
        graph8.setLabel(2, "C");
        graph8.addEdge(2,1);
        graph8.setLabel(3, "D");
        graph8.addEdge(1,3);
        graph8.addEdge(3,1);
        graph8.addEdge(3,2);
        graph8.addEdge(3,5);
        graph8.addEdge(3,4);
        graph8.setLabel(4, "E");
        graph8.addEdge(4,5);
        graph8.setLabel(5, "F");
        graph8.addEdge(5,6);
        graph8.addEdge(5,7);
        graph8.setLabel(6, "G");
        graph8.addEdge(6,4);
        graph8.setLabel(7, "H");
        graph8.addEdge(7,4);

        QueueInterface<String> breadthFirst8 = graph8.getBreadthFirstTraversal("A");

        System.out.print("Displaying the vertices in breadth-first traversal order: ");
        while (!breadthFirst8.isEmpty())
        {
            String label8 = breadthFirst8.dequeue();

            System.out.print(label8);
            if (counter < graphSize8)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
    }

    /** Method to test the depth-first traversal method */
    @Test
    void getDepthFirstTraversalTest()
    {
        int counter = 1;

        // graph 1
        int graphSize1 = 9;
        Graph<String> graph1 = new Graph<>(graphSize1);

        // create graph #1.
        graph1.setLabel(0, "A");
        graph1.addEdge(0,1);
        graph1.addEdge(0,3);
        graph1.addEdge(0,4);
        graph1.setLabel(1, "B");
        graph1.addEdge(1,4);
        graph1.setLabel(2, "C");
        graph1.addEdge(2,1);
        graph1.setLabel(3, "D");
        graph1.addEdge(3,6);
        graph1.setLabel(4, "E");
        graph1.addEdge(4,5);
        graph1.addEdge(4,7);
        graph1.setLabel(5, "F");
        graph1.addEdge(5,2);
        graph1.addEdge(5,7);
        graph1.setLabel(6, "G");
        graph1.addEdge(6,7);
        graph1.setLabel(7, "H");
        graph1.addEdge(7,8);
        graph1.setLabel(8, "I");
        graph1.addEdge(8,5);

        QueueInterface<String> depthFirst1 = graph1.getDepthFirstTraversal("A");

        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst1.isEmpty())
        {
            String label = depthFirst1.dequeue();

            System.out.print(label);
            if (counter < graphSize1)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 2
        int graphSize2 = 2;
        Graph<String> graph2 = new Graph<>(graphSize2);

        // create graph #2.
        graph2.setLabel(0, "A");
        graph2.addEdge(0,1);
        graph2.setLabel(1, "B");
        graph2.addEdge(1,0);

        QueueInterface<String> depthFirst2 = graph2.getDepthFirstTraversal("A");

        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst2.isEmpty())
        {
            String label2 = depthFirst2.dequeue();

            System.out.print(label2);
            if (counter < graphSize2)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 3
        int graphSize3 = 3;
        Graph<String> graph3 = new Graph<>(graphSize3);
        
        // create graph #3.
        graph3.setLabel(0, "A");
        graph3.addEdge(0,1);
        graph3.setLabel(1, "B");
        graph3.addEdge(1,2);
        graph3.setLabel(2, "C");
        graph3.addEdge(2,0);
        graph3.addEdge(2,1);
        
        QueueInterface<String> depthFirst3 = graph3.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst3.isEmpty())
        {
            String label3 = depthFirst3.dequeue();

            System.out.print(label3);
            if (counter < graphSize3)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 4
        int graphSize4 = 4;
        Graph<String> graph4 = new Graph<>(graphSize4);

        // create graph #4.
        graph4.setLabel(0, "A");
        graph4.addEdge(0,1);
        graph4.addEdge(0,3);
        graph4.setLabel(1, "B");
        graph4.addEdge(1,2);
        graph4.setLabel(2, "C");
        graph4.addEdge(2,1);
        graph4.setLabel(3, "D");
        graph4.addEdge(3,2);
        
        QueueInterface<String> depthFirst4 = graph4.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst4.isEmpty())
        {
            String label4 = depthFirst4.dequeue();

            System.out.print(label4);
            if (counter < graphSize4)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        //graph 5
        int graphSize5 = 5;
        Graph<String> graph5 = new Graph<>(graphSize5);

        // create graph #5.
        graph5.setLabel(0, "A");
        graph5.addEdge(0,1);
        graph5.addEdge(0,3);
        graph5.addEdge(0,4);
        graph5.setLabel(1, "B");
        graph5.addEdge(1,3);
        graph5.setLabel(2, "C");
        graph5.setLabel(3, "D");
        graph5.addEdge(3,2);
        graph5.addEdge(3,4);
        graph5.setLabel(4, "E");
        
        QueueInterface<String> depthFirst5 = graph5.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst5.isEmpty())
        {
            String label5 = depthFirst5.dequeue();

            System.out.print(label5);
            if (counter < graphSize5)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 6
        int graphSize6 = 6;
        Graph<String> graph6 = new Graph<>(graphSize6);

        // create graph #6.
        graph6.setLabel(0, "A");
        graph6.addEdge(0,1);
        graph6.addEdge(0,3);
        graph6.setLabel(1, "B");
        graph6.addEdge(1,2);
        graph6.addEdge(1,4);
        graph6.addEdge(1,3);
        graph6.setLabel(2, "C");
        graph6.addEdge(2,3);
        graph6.addEdge(2,5);
        graph6.setLabel(3, "D");
        graph6.setLabel(4, "E");
        graph6.setLabel(5, "F");
        
        QueueInterface<String> depthFirst6 = graph6.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst6.isEmpty())
        {
            String label6 = depthFirst6.dequeue();

            System.out.print(label6);
            if (counter < graphSize6)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph #7
        int graphSize7 = 7;
        Graph<String> graph7 = new Graph<>(graphSize7);

        // create graph #7.
        graph7.setLabel(0, "A");
        graph7.addEdge(0,1);
        graph7.addEdge(0,2);
        graph7.addEdge(0,3);
        graph7.addEdge(0,4);
        graph7.addEdge(0,5);
        graph7.addEdge(0,6);
        graph7.setLabel(1, "B");
        graph7.setLabel(2, "C");
        graph7.setLabel(3, "D");
        graph7.setLabel(4, "E");
        graph7.setLabel(5, "F");
        graph7.setLabel(6, "G");
        
        QueueInterface<String> depthFirst7 = graph7.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst7.isEmpty())
        {
            String label7 = depthFirst7.dequeue();

            System.out.print(label7);
            if (counter < graphSize7)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();
        counter = 1;

        // graph 8
        int graphSize8 = 8;
        Graph<String> graph8 = new Graph<>(graphSize8);

        // create graph #8.
        graph8.setLabel(0, "A");
        graph8.addEdge(0,2);
        graph8.setLabel(1, "B");
        graph8.addEdge(1,0);
        graph8.setLabel(2, "C");
        graph8.addEdge(2,1);
        graph8.setLabel(3, "D");
        graph8.addEdge(1,3);
        graph8.addEdge(3,1);
        graph8.addEdge(3,2);
        graph8.addEdge(3,5);
        graph8.addEdge(3,4);
        graph8.setLabel(4, "E");
        graph8.addEdge(4,5);
        graph8.setLabel(5, "F");
        graph8.addEdge(5,6);
        graph8.addEdge(5,7);
        graph8.setLabel(6, "G");
        graph8.addEdge(6,4);
        graph8.setLabel(7, "H");
        graph8.addEdge(7,4);
        
        QueueInterface<String> depthFirst8 = graph8.getDepthFirstTraversal("A");
        
        System.out.print("Displaying the vertices in depth-first traversal order: ");
        while (!depthFirst8.isEmpty())
        {
            String label8 = depthFirst8.dequeue();

            System.out.print(label8);
            if (counter < graphSize8)
            {
                System.out.print(" -> ");
                ++counter;
            }
        }
        System.out.println();

    }
} // end of "GraphTest.java"
