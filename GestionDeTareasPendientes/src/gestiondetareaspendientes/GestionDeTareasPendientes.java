package gestiondetareaspendientes;

/**
 *
 * @author Luisa Lucio
 */
public class GestionDeTareasPendientes {

    class Nodo{
        //Dato que contiene el nodo
        String tareasPendientes;
        //Referencia al siguiente nodode la lista
        Nodo siguiente;
        public Nodo (String tareasPendientes){
            //Inicializa el valor del dato
            this.tareasPendientes= tareasPendientes;
            //El siguiente nodo es inicialmente el null
            this.siguiente= null;
        }    
    }
    // Clase que maneja la lista enlazada de tareas pendientes    
    class TareasPendientes {
        //El primer nodo de la lista
        Nodo cabeza;
        
        public void agregarTarea  (String tareasPendientes){
            //Crear un nuevo nodo con el valor dado
            Nodo nuevoNodo = new Nodo(tareasPendientes);
            if (cabeza == null) {
                cabeza = nuevoNodo;
            } else {
                Nodo actual = cabeza;
                while (actual.siguiente != null) {
                    actual = actual.siguiente;
                }
                actual.siguiente = nuevoNodo;
            }
        }
        public Nodo buscarTarea(String tareasPendientes){
            Nodo actual = cabeza;
            while (actual != null) {
                if (actual.tareasPendientes.equals(tareasPendientes)) {
                    return actual;
                }
                actual = actual.siguiente;
            }
            return null;
        }
            
        public void eliminarTarea(String tareasPendientes) {
            if (cabeza == null) return;

            if (cabeza.tareasPendientes.equals(tareasPendientes)) {
                cabeza = cabeza.siguiente;
                return;
            }

            Nodo actual = cabeza;
            while (actual.siguiente != null && !actual.siguiente.tareasPendientes.equals(tareasPendientes)) {
                actual = actual.siguiente;
            }if (actual.siguiente != null) {
                actual.siguiente = actual.siguiente.siguiente;
            }
        }
        
        public void mostrarTareas (){
        //Comenzamos desde la cabeza
        Nodo actual = cabeza;
        //Mientas no lleguemos al final de la lista(nodo null)
            while (actual!=  null) {
                //Imprime la tarea pendiente del nodo actual
                System.out.println(actual.tareasPendientes);
                //Avanza al siguiente nodo
                actual = actual.siguiente;
            }//Al final, imprime "null" para indicar el final de la lista
            System.out.println("null");            
        }
    }
        
    public static void main(String[] args) {
        GestionDeTareasPendientes programa = new GestionDeTareasPendientes();
        TareasPendientes lista = programa.new TareasPendientes();
        // Agregar tareas
        lista.agregarTarea("Lavar platos");
        lista.agregarTarea("Hacer la compra");
        lista.agregarTarea("Estudiar para el examen");

        // Mostrar todas las tareas pendientes
        System.out.println("Lista de tareas pendientes:");
        lista.mostrarTareas();

        // Buscar una tarea específica
        Nodo tarea = lista.buscarTarea("Hacer la compra");
        if (tarea != null) {
            System.out.println("Tarea encontrada: " + tarea.tareasPendientes);
        } else {
            System.out.println("Tarea no encontrada");
        }

        // Eliminar una tarea
        lista.eliminarTarea("Hacer la compra");

        // Mostrar lista de tareas después de eliminar una tarea
        System.out.println("Lista de tareas después de eliminar:");
        lista.mostrarTareas();
    }
}