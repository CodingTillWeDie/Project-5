import java.util.EmptyStackException;

/** A class of stacks whose entries are stored in a linked chain. */
public class LinkedStack<T> implements StackInterface<T>
{
    private Node topNode;

    public LinkedStack()
    {
        topNode = null;
    } // end of default constructor.

    @Override
    public void push(T newEntry)
    {
        topNode = new Node(newEntry, topNode);
    } // end of push.

    @Override
    public T pop()
    {
        T top = peek(); // might throw EmptyStackException.
        // Assertion: topNode != null;
        topNode.setData(null);
        topNode = topNode.getNextNode();
        return top;
    } // end of "pop"

    @Override
    public T peek()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            return topNode.getData();
        }
    } // end of "peek"

    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    } // end of "isEmpty"

    @Override
    public void clear()
    {
        topNode = null;
    } // end of clear.

    private class Node
    {
        private T data;
        private Node next;

        public Node(T data, Node nextNode)
        {
            setData(data);
            setNextNode(nextNode);
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public void setNextNode(Node next)
        {
            this.next = next;
        }

        public T getData()
        {
            return this.data;
        }

        public Node getNextNode()
        {
            return this.next;
        }
    } // end of "Node" class
} // end of "LinkedStack" class
