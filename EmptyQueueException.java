public class EmptyQueueException extends RuntimeException
{
    public EmptyQueueException()
    {
        this(null);
    } // end of default constructor

    public EmptyQueueException(String message)
    {
        super(message);
    } // end of type constructor
} // end of "EmptyQueueException" class
