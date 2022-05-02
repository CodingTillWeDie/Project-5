import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTest {

    private Graph<String> graph;

    @BeforeEach
    void setUp() {
        graph = new Graph<>(9);
    }

    @Test
    void getBreadthFirstTraversalTest() {
        createValidGraph();

        QueueInterface<String> breadthFirst = graph.getBreadthFirstTraversal("A");
        assertNotNull(breadthFirst);
        assertFalse(breadthFirst.isEmpty());
        assertEquals("A", breadthFirst.dequeue());
        assertEquals("B", breadthFirst.dequeue());
        assertEquals("D", breadthFirst.dequeue());
        assertEquals("E", breadthFirst.dequeue());
        assertEquals("G", breadthFirst.dequeue());
        assertEquals("F", breadthFirst.dequeue());
        assertEquals("H", breadthFirst.dequeue());
        assertEquals("C", breadthFirst.dequeue());
        assertEquals("I", breadthFirst.dequeue());
    }

    @Test
    void getDepthFirstTraversalTest() {
        createValidGraph();

        QueueInterface<String> breadthFirst = graph.getDepthFirstTraversal("A");
        assertNotNull(breadthFirst);
        assertFalse(breadthFirst.isEmpty());
        assertEquals("A", breadthFirst.dequeue());
        assertEquals("B", breadthFirst.dequeue());
        assertEquals("E", breadthFirst.dequeue());
        assertEquals("F", breadthFirst.dequeue());
        assertEquals("C", breadthFirst.dequeue());
        assertEquals("H", breadthFirst.dequeue());
        assertEquals("I", breadthFirst.dequeue());
        assertEquals("D", breadthFirst.dequeue());
        assertEquals("G", breadthFirst.dequeue());
    }

    @Test
    void getIndexOfInvalidLabelTest() {
        createValidGraph();

        assertEquals(-1, graph.getIndex("Z"));
    }

    @Test
    void isEdgeTest() {
        createValidGraph();

        assertTrue(graph.isEdge(1, 4));
    }

    @Test
    void nodesWithoutNeighborsTest() {
        graph = new Graph<>(1);
        graph.setLabel(0, "A");

        graph.getBreadthFirstTraversal("A");
    }

    @Test
    void removeEdgeTest() {
        createValidGraph();

        graph.removeEdge(1, 4);
        assertFalse(graph.isEdge(1, 4));
    }

    @Test
    void resetVerticesTest() {
        createValidGraph();
        graph.getBreadthFirstTraversal("A");
        graph.resetVertices();
        assertEquals(9, graph.size());
        assertFalse(graph.isVisited(0));
    }

    private void createValidGraph() {
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
    }
}
