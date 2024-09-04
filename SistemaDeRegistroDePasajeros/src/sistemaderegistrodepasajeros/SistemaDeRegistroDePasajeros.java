package sistemaderegistrodepasajeros;

/**
 *
 * @author Valentina Rubio & Luisa Lucio
 */
public class SistemaDeRegistroDePasajeros {

    class NodoCircular {
        int asiento;
        NodoCircular ant;
        NodoCircular sgte;

        NodoCircular(int asiento) {
            this.asiento = asiento;
            this.ant = null;
            this.sgte = null;
        }
    }

    public class Ejercicio3 {
        NodoCircular cabeza;

        public Ejercicio3() {
            this.cabeza = null;
        }

        public void registrarPasajero(int asiento) {
            NodoCircular nuevoPasajero = new NodoCircular(asiento);
            if (cabeza == null) {
                cabeza = nuevoPasajero;
                cabeza.sgte = cabeza;
                cabeza.ant = cabeza;
            } else {
                NodoCircular ultimo = cabeza.ant;
                ultimo.sgte = nuevoPasajero;
                nuevoPasajero.ant = ultimo;
                nuevoPasajero.sgte = cabeza;
                cabeza.ant = nuevoPasajero;
            }
        }

        public void eliminarPasajero(int asiento) {
            if (cabeza == null) return;

            NodoCircular temp = cabeza;
            do {
                if (temp.asiento == asiento) {
                    if (temp == cabeza && temp.sgte == cabeza) {
                        cabeza = null;
                    } else {
                        temp.ant.sgte = temp.sgte;
                        temp.sgte.ant = temp.ant;
                        if (temp == cabeza) {
                            cabeza = temp.sgte;
                        }
                    }
                    break;
                }
                temp = temp.sgte;
            } while (temp != cabeza);
        }

        public boolean buscarAsiento(int asiento) {
            if (cabeza == null) return false;

            NodoCircular temp = cabeza;
            do {
                if (temp.asiento == asiento) {
                    return true;
                }
                temp = temp.sgte;
            } while (temp != cabeza);

            return false;
        }

        public void imprimirAsientos() {
            if (cabeza == null) return;

            NodoCircular temp = cabeza;
            System.out.println("Estado actual de los asientos:");
            do {
                System.out.println("Asiento " + temp.asiento);
                temp = temp.sgte;
            } while (temp != cabeza);
        }

        public static void main(String[] args) {
            Ejercicio3 bus = new Ejercicio3();
            bus.registrarPasajero(1);
            bus.registrarPasajero(2);
            bus.registrarPasajero(3);

            bus.imprimirAsientos();

            System.out.println("\nEliminando al pasajero del asiento 2.");
            bus.eliminarPasajero(2);

            bus.imprimirAsientos();
        }
    }
    
}
