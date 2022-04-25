public QueueInterface<T> getBreadthFirstTraversal(T origin)
{
   resetVertices();
   QueueInterface<T> traversalOrder = new LinkedQueue<>();
   QueueInterface<VertexInterface<T>> vertexQueue = new LinkedQueue<>();
   
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
