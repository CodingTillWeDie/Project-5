/** A linked implemention of the ADT list. */
public class LinkedList<T> implements ListInterface<T>
{
    private Node firstNode;// Reference to first node of chain
    private int  numberOfEntries;

    public LinkedList()
    {
        initializeDataFields();
    } // end default constructor

    public void clear()
    {
        initializeDataFields();
    } // end clear


    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields
    private class Node
    {
        private T    data; // Entry in stack
        private Node next; // Link to next node

        private Node(T dataPortion)
        {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode
    } // end Node
    private Node getNodeAt(int givenPosition)
    {
        // Assertion: (firstNode != null) &&
        //            (1 <= givenPosition) && (givenPosition <= numberOfEntries)
        Node currentNode = firstNode;

        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();

        // Assertion: currentNode != null
        return currentNode;
    } // end getNodeAt

    public void add(int givenPosition, T newEntry) // OutOfMemoryError possible
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries + 1))
        {
            Node newNode = new Node(newEntry);
            if (givenPosition == 1)                // Cases 1 and 2
            {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else                                    // Cases 3 and 4: list is not empty
            {                                       // and givenPosition > 1
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            } // end if
            numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to add  operation.");
    } // end add

    public void add(T newEntry)          // OutOfMemoryError possible
    {
        Node newNode = new Node(newEntry);

        if (isEmpty())
            firstNode = newNode;
        else                              // Add to end of nonempty list
        {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode); // Make last node reference new node
            lastNode = newNode;
            numberOfEntries++;
        } // end if

        numberOfEntries++;
    } // end add

    public T remove(int givenPosition)
    {
        T result = null;                           // Return value
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            if (givenPosition == 1)                 // Case 1: Remove first entry
            {
                result = firstNode.getData();        // Save entry to be removed
                firstNode = firstNode.getNextNode(); // Remove entry
            }
            else                                    // Case 2: Not first entry
            {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = nodeToRemove.getData();     // Save entry to be removed
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);   // Remove entry
            } // end if
            numberOfEntries--;                      // Update count
            return result;                          // Return removed entry
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    } // end remove

    public T[] toArray()
    {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null))
        {
            result[index] = currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        } // end while

        return result;
    } // end toArray

    public boolean contains(T anEntry)
    {
        boolean found = false;
        Node currentNode = firstNode;

        while (!found && (currentNode != null))
        {
            if (anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        } // end while

        return found;
    } // end contains

    public T getEntry(int givenPosition)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            return getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
    } // end getEntry

    public T replace(int givenPosition, T newEntry)
    {
        if ((givenPosition >= 1) && (givenPosition <= numberOfEntries))
        {
            // Assertion: !isEmpty()
            Node desiredNode = getNodeAt(givenPosition);
            T originalEntry = desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
    } // end replace
    public boolean isEmpty()
    {
        return numberOfEntries == 0;
    } // end isEmpty
    public int getLength()
    {
        return numberOfEntries;
    } // end getLength
    

}
