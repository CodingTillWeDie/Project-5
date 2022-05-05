public class LinkedGraph<T>
{
    private Node[] list; // list[i] contains a list of neighbors for vertex i.
    private T[] labels; // labels[i] contains the label for vertex i.
    private T[] visitedVertices;
    private int numberOfVisitedVertices;

    public LinkedGraph(int n)
    {
        list = new Node[n]; // All values initially null.
        labels = (T[]) new Object[n]; // All values initially null.
        visitedVertices = (T[]) new Object[n]; // All values initially null.
        numberOfVisitedVertices = 0;
    }

    /** Performs a breadth-first traversal of this graph.
     @param origin  An object that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
    public QueueInterface<T> getBreadthFirstTraversal(T origin)
    {
        resetVertices();

        // create a new queue for the resulting traversal order.
        QueueInterface<T> traversalOrder = new LinkedQueue<>();
        // create a new queue to hold the vertices as they are visited.
        QueueInterface<T> vertexQueue = new LinkedQueue<>();

        // mark the origin vertex as visited.
        T originVertex = origin;
        visitedVertices[numberOfVisitedVertices] = originVertex;
        numberOfVisitedVertices++;

        // enqueue the origin vertex to the traversal order.
        traversalOrder.enqueue(origin);
        // enqueue the origin vertex to the vertex queue.
        vertexQueue.enqueue(originVertex);

        while (!vertexQueue.isEmpty())
        {
            T frontVertex = vertexQueue.dequeue();

            while (hasNextNeighbor(frontVertex))
            {
                T nextNeighbor = getUnvisitedNeighbor(frontVertex);

                // mark next neighbor as visited.
                visitedVertices[numberOfVisitedVertices] = nextNeighbor;
                numberOfVisitedVertices++;

                // add the neighbor vertex to the traversal order.
                traversalOrder.enqueue(nextNeighbor);
                // enqueue the neighbor vertex to the vertex queue.
                vertexQueue.enqueue(nextNeighbor);

            } // end while
        } // end while

        return traversalOrder;
    } // end getBreadthFirstTraversal

    /** Performs a depth-first traversal of this graph.
     @param origin  An object that labels the origin vertex of the traversal.
     @return  A queue of labels of the vertices in the traversal, with
     the label of the origin vertex at the queue's front. */
    public QueueInterface<T> getDepthFirstTraversal(T origin)
    {
        resetVertices();

        // create a new queue for the resulting traversal order.
        QueueInterface<T> traversalOrder = new LinkedQueue<T>();
        // create a new stack to hold the vertices as they are visited.
        StackInterface<T> vertexStack = new LinkedStack<>();

        // mark the origin vertex as visited.
        T originVertex = origin;
        visitedVertices[numberOfVisitedVertices] = originVertex;
        numberOfVisitedVertices++;

        // enqueue the origin vertex to the traversal order.
        traversalOrder.enqueue(origin);
        // push the origin vertex to the vertex stack so that
        // this traversal method will continue until origin
        // vertex is popped off from the vertex stack.
        vertexStack.push(originVertex);

        while (!vertexStack.isEmpty())
        {
            T topVertex = vertexStack.peek();
            T nextNeighbor = getUnvisitedNeighbor(topVertex);

            // check to see if top vertex has an unvisited neighbor.
            if (nextNeighbor != null)
            {
                // if so, mark next neighbor as visited.
                visitedVertices[numberOfVisitedVertices] = nextNeighbor;
                numberOfVisitedVertices++;

                // also, update the traversal order and the vertex stack.
                traversalOrder.enqueue(nextNeighbor);
                vertexStack.push(nextNeighbor);
            }
            // otherwise, all neighbors are visited.
            else
                vertexStack.pop();

        }

        return traversalOrder;
    }

    /** Gets an unvisited neighbor, if there are any,
     of the vertex that was passed in as an argument.
     @return Either a vertex that is an unvisited neighbor or null
     if no such neighbor exists. */
    public T getUnvisitedNeighbor(T vertexLabel)
    {
        T nextNeighbor = null;
        int vertexIndex = getIndex(vertexLabel);
        int[] neighbors = neighbors(vertexIndex);

        // check to see if top vertex has an unvisited neighbor.
        for (int i = 0; i < neighbors.length; ++i)
        {
            if (!isVisited(neighbors[i]))
            {
                // if so, return this unvisited neighbor.
                nextNeighbor = getLabel(neighbors[i]);
                return nextNeighbor;
            }
        }

        // otherwise, there are no unvisited neighbors.
        return null;
    }

    // Accessor method to get the label of a vertex of this Graph.
    public T getLabel(int vertex)
    {
        return labels[vertex];
    }

    // Accessor method to get the index of a vertex of this Graph.
    public int getIndex(T label)
    {
        for (int i = 0; i < labels.length; ++i)
        {
            if (label == labels[i])
            {
                return i;
            }
        }

        // otherwise, the label was not found in this Graph.
        System.out.println("This label was not found in this graph...");
        return -1;
    }

    /** Sees whether the vertex is marked as visited.
     @return True if the vertex is visited. */
    public boolean isVisited(int vertexIndex)
    {
        T label = labels[vertexIndex];

        for (int i = 0; i < visitedVertices.length; ++i)
        {
            // check to see if the vertex was marked as visited.
            if (label == visitedVertices[i])
            {
                // if so, return true;
                return true;
            }
        }

        // otherwise, the vertex was not marked as visited.
        return false;
    }

    // Test whether an edge exists
    public boolean isEdge(int source, int target)
    {
        Node currentNode = list[source];

        // check to see whether there is an edge from the source to target.
        while (null != currentNode)
        {
            if (target == currentNode.getData())
            {
                // if the target was found from the
                // source's adjacency list, return true.
                return true;
            }
            // otherwise, keep traversing through the adjacency list
            currentNode = currentNode.getNextNode();
        }

        // return false if the target was not found.
        return false;
    }

    // Add an edge
    public void addEdge(int source, int target)
    {
        Node currentNode = list[source];

        // otherwise, traverse through the adjacency list and add an edge.
        for (int i = 0; i < labels.length; ++i)
        {
            // check to see if current node is null.
            if (null == currentNode)
            {
                // if so, simply return after adding an edge because there
                // was no edge in between the source and the target.
                Node newNode = new Node(target, null);
                currentNode.setNextNode(newNode);

                return;
            }
            // check to see if the target is already source's neighbor.
            if (target == currentNode.getData())
            {
                // if so, simply return because there's already an edge.
                return;
            }
            // otherwise, keep traversing through the adjacency list
            // to find an available location to add an edge.
            else
            {
                currentNode = currentNode.getNextNode();
            }
        }

    } // end of "addEdge"

    // Obtain a list of neighbors of a specified vertex of this Graph.
    public int[] neighbors(int vertex)
    {
        int count = 0;
        int[] answer;
        Node currentNode = list[vertex];

        // store vertex's neighbors in an array.
        while (null != currentNode)
        {
            ++count;
            currentNode = currentNode.getNextNode();
        }

        answer = new int[count];
        count = 0;
        currentNode = list[vertex];

        while (null != currentNode)
        {
            answer[count++] = currentNode.getData();
        }

        return answer;
    }

    public boolean hasNextNeighbor(T vertex)
    {
        boolean result = false;
        int vertexIndex = getIndex(vertex);
        T unvisitedNeighbor = getUnvisitedNeighbor(vertex);

        if ((neighbors(vertexIndex).length > 0) && (null != unvisitedNeighbor))
        {
            result = true;
        }

        return result;
    }

    // Remove an edge
    public void removeEdge(int source, int target)
    {
        // first, check to see if there is an edge
        // between the source and the target already.
        if (!isEdge(source, target))
        {
            // if not, simply return since there is
            // no edge to remove.
            return;
        }

        // otherwise, remove this edge.
        Node currentNode = list[source];

        // check to see if the edge between the source
        // and this target was the first entry.
        if ((null != currentNode) && (currentNode.getData() == target))
        {
            // if so, simply remove this edge.
            currentNode.setNextNode(currentNode.getNextNode());
        }

        // otherwise, keep traversing through the adjacency list to
        // find the target edge.
        Node nodeBefore = currentNode;
        Node nodeToRemove = nodeBefore.getNextNode();

        while (null != nodeToRemove)
        {
            if (target == nodeToRemove.getData())
            {
                // remove the edge.
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            else
            {
                nodeBefore.setNextNode(nodeToRemove);
                nodeToRemove.setNextNode(nodeToRemove.getNextNode());
            }
        }
    }

    // Change the label of a vertex of this Graph.
    public void setLabel(int vertex, T newLabel)
    {
        labels[vertex] = newLabel;
    }

    // Accessor method to determine the number of vertices in this Graph
    public int size()
    {
        return labels.length;
    }

    // reset the vertices by clearing any visited vertices.
    public void resetVertices()
    {
        for (int index = 0; index < numberOfVisitedVertices; ++index)
        {
            visitedVertices[index] = null;
        }

        numberOfVisitedVertices = 0;
    }

    private class Node
    {
        private int data;
        private Node next;

        public Node(int data,Node nextNode)
        {
            setData(data);
            setNextNode(nextNode);
        }

        public void setData(int data)
        {
            this.data = data;
        }

        public void setNextNode(Node next)
        {
            this.next = next;
        }

        public int getData()
        {
            return this.data;
        }

        public Node getNextNode()
        {
            return this.next;
        }
    } // end of "Node" class

} // end of "Graph" class