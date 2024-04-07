package uvg.edu.gt;

import java.util.PriorityQueue;

public class JavaPriorityQueue<E extends Comparable<E>> extends PriorityQueue<E> implements PriorityInteface<E> {

    public JavaPriorityQueue(){
        super();
    }

    @Override
    public E getFirst() {
        return super.peek();
    }

    public E remove(){
        return super.remove();
    }


    @Override
    public boolean add(E value){
        return super.add(value);
    }


    public boolean isEmpty(){
        return super.isEmpty();
    }


    public int size(){
        return super.size();
    }

    public void clear(){
        super.clear();
    }


}
