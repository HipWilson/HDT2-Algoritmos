import java.util.Arrays;

public class VectorStack<T> implements Stack<T>
{
    private T[] stack;
    private int capacidad;
    private int cantidad;

    public VectorStack()
    {
        capacidad = 8;
        stack = (T[]) new Object[capacidad];
        cantidad = -1;
    }

    @Override
    public void push(T caracter)
    {
        if (cantidad + 1 == capacidad)
        {
            AumentarCapacidad();
        }
        cantidad++;
        stack[cantidad] = caracter;
    }

    @Override
    public T pop()
    {
        if (this.isEmpty())
        {
            throw new IllegalStateException("Stack vacío.");
        }
        T caracter = this.stack[cantidad];
        this.stack[cantidad] = null;
        cantidad--;
        return caracter;
    }

    @Override
    public boolean isEmpty()
    {
        if (this.size()==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public int size()
    {
        return this.cantidad + 1;
    }

    @Override
    public void AumentarCapacidad()
    {
        this.capacidad = 2 * this.capacidad;
        this.stack = Arrays.copyOf(this.stack, this.capacidad);
    }
}