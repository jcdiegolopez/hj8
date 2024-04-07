package uvg.edu.gt;

public class PriorityFactory{
    public PriorityInteface<Paciente> createQueue(String type){
        if (type.equals("java")) {
            return new JavaPriorityQueue<Paciente>();
        } else {
            return new VectorHeap<Paciente>();
        }
    }
}
