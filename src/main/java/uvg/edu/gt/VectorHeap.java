package uvg.edu.gt;

import java.util.Vector;

/**
 * Esta clase implementa un montículo binario utilizando un Vector para almacenar los elementos.
 * El montículo es una estructura de datos en la que el elemento en la posición raíz es menor o igual
 * que los elementos en sus hijos. Esta implementación está basada en la interfaz PriorityInterface
 * y utiliza la clase Vector para almacenar los datos.
 *
 * @param <E> el tipo de elementos almacenados en el montículo, que deben ser comparables.
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityInteface<E> {

    /** El Vector utilizado para almacenar los elementos del montículo. */
    protected Vector<E> data;

    /**
     * Constructor que inicializa un nuevo VectorHeap.
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Método estático que calcula el índice del padre de un nodo en el montículo.
     *
     * @param i el índice del nodo
     * @return el índice del padre del nodo
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Método estático que calcula el índice del hijo izquierdo de un nodo en el montículo.
     *
     * @param i el índice del nodo
     * @return el índice del hijo izquierdo del nodo
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Método estático que calcula el índice del hijo derecho de un nodo en el montículo.
     *
     * @param i el índice del nodo
     * @return el índice del hijo derecho del nodo
     */
    protected static int right(int i) {
        return (2 * i + 1) + 1;
    }

    /**
     * Método protegido que realiza el proceso de percolación hacia arriba para mantener la
     * propiedad del montículo después de agregar un nuevo elemento.
     *
     * @param leaf el índice del nuevo elemento
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && (value.compareTo(data.get(parent)) < 0)) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Método que agrega un nuevo elemento al montículo y lo reorganiza para mantener la propiedad del montículo.
     *
     * @param value el elemento a agregar
     * @return true si se agregó correctamente
     */
    public boolean add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
        return true;
    }

    /**
     * Verifica si el montículo está vacío.
     *
     * @return true si el montículo está vacío, false de lo contrario
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Obtiene el tamaño del montículo.
     *
     * @return el número de elementos en el montículo
     */
    @Override
    public int size() {
        return data.size();
    }

    /**
     * Elimina todos los elementos del montículo.
     */
    @Override
    public void clear() {
        data.clear();
    }

    /**
     * Método protegido que realiza el proceso de "empujar hacia abajo" para mantener la propiedad del montículo
     * después de eliminar el nodo raíz.
     *
     * @param root el índice del nodo raíz
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);
        while (root < heapSize) {
            int childpos = left(root);
            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                        ((data.get(childpos + 1)).compareTo
                                (data.get(childpos)) < 0)) {
                    childpos++;
                }
                if ((data.get(childpos)).compareTo
                        (value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } else {
                    data.set(root, value);
                    return;
                }
            } else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Obtiene el primer elemento del montículo (la raíz).
     *
     * @return el primer elemento del montículo
     */
    @Override
    public E getFirst() {
        return data.elementAt(0);
    }

    /**
     * Elimina y devuelve el elemento mínimo del montículo.
     *
     * @return el elemento mínimo del montículo
     */
    public E remove() {
        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.setSize(data.size() - 1);
        if (data.size() > 1) pushDownRoot(0);
        return minVal;
    }

    /**
     * Devuelve una representación en forma de cadena del montículo.
     *
     * @return una cadena que representa el montículo
     */
    @Override
    public String toString() {
        return "VectorHeap{" +
                "data=" + data +
                '}';
    }
}
