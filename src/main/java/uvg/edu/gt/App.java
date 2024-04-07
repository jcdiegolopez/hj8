package uvg.edu.gt;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;


public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        PriorityFactory factory = new PriorityFactory();
        PriorityInteface<Paciente> pacientes = null;
        boolean condition = true;
        while (condition) {
            System.out.println("Ingrese el tipo de heap que quiere: ");
            System.out.println("1. Java Priority Heap");
            System.out.println("2. Vector priority heap");
            System.out.println("3. Salir");
            System.out.println("Ingrese el tipo de heap que quiere: ");
            int opt = scanner.nextInt();
            switch (opt) {
                case 1:
                    pacientes = factory.createQueue("java");
                    break;
                case 2:
                    pacientes = factory.createQueue("vector");
                    break;
                case 3:
                    condition = false;
                    pacientes = null;
                    System.out.println("Saliendo...");
                    break;
                default:
                    pacientes = null;
                    System.out.println("Opcion no valida");
            }
            if(pacientes!=null){
                System.out.println("Cargando pacientes...");
                loadPacientes("pacientes.txt", pacientes);
                System.out.println("");
                System.out.println("Orden de atencion de pacientes: ");
                pollPacientes(pacientes);

            }
        }
        
        
    }

    public static void loadPacientes(String filePath, PriorityInteface<Paciente> pacientes) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line = reader.readLine();
            while (line != null) {
                String[] data = line.split(",");
                Paciente paciente = new Paciente(data[0], data[1], data[2]);
                System.out.println(paciente + " agregado");
                pacientes.add(paciente);
                line = reader.readLine();
            }
            reader.close();
            System.out.println("Pacientes cargados correctamente");
        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
    }

    public static void pollPacientes(PriorityInteface<Paciente> pacientes) {
        while (!pacientes.isEmpty()) {
            System.out.println(pacientes.remove());
        }
        
    }


}
