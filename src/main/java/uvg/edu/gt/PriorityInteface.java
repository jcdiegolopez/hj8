package uvg.edu.gt;

public interface PriorityInteface<E extends Comparable<E>>
{
	public E getFirst();

	
	public E remove();

	
	public boolean add(E value);

	
	public boolean isEmpty();

	
	public int size();

	
	public void clear();

}
