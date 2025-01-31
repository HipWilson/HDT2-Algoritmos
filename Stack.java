public interface Stack<T>
{
    void push(T elemento);
    T pop();
    int size();
    boolean isEmpty();
    void AumentarCapacidad();
}