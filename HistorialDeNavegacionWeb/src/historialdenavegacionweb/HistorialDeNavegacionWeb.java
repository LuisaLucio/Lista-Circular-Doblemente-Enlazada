package historialdenavegacionweb;
/**
 *
 * @author Valentina Rubio
 */
public class HistorialDeNavegacionWeb {

    class NodoDoble {
        String pag;
        NodoDoble anterior;
        NodoDoble sgte;

        NodoDoble(String pag) {
            this.pag = pag;
            this.anterior = null;
            this.sgte = null;
        }
    }

    public class Ejercicio2 {
        NodoDoble cabeza;
        NodoDoble cola;

        public Ejercicio2() {
            this.cabeza = null;
            this.cola = null;
        }

        public void agregarPag(String pag) {
            NodoDoble nuevaPag = new NodoDoble(pag);
            if (cabeza == null) {
                cabeza = cola = nuevaPag;
            } else {
                cola.sgte = nuevaPag;
                nuevaPag.anterior = cola;
                cola = nuevaPag;
            }
        }

        public void navegarAtras() {
            if (cola != null && cola.anterior != null) {
                cola = cola.anterior;
            }
        }

        public void navegarAdelante() {
            if (cola != null && cola.sgte != null) {
                cola = cola.sgte;
            }
        }

        public void eliminarPagina(String pag) {
            NodoDoble temp = cabeza;
            while (temp != null) {
                if (temp.pag.equals(pag)) {
                    if (temp.anterior != null) {
                        temp.anterior.sgte = temp.sgte;
                    } else {
                        cabeza = temp.sgte;
                    }

                    if (temp.sgte != null) {
                        temp.sgte.anterior = temp.anterior;
                    } else {
                        cola = temp.anterior;
                    }
                    break;
                }
                temp = temp.sgte;
            }
        }

        public void imprimirHistorial() {
            NodoDoble temp = cabeza;
            System.out.println("Historial de paginas:");
            while (temp != null) {
                System.out.println(temp.pag);
                temp = temp.sgte;
            }
        }

        public void imprimirHistorialReverso() {
            NodoDoble temp = cola;
            System.out.println("Historial de paginas en orden inverso:");
            while (temp != null) {
                System.out.println(temp.pag);
                temp = temp.anterior;
            }
        }

        public static void main(String[] args) {
            Ejercicio2 historial = new Ejercicio2();
            historial.agregarPag("Google.com");
            historial.agregarPag("Facebook.com");
            historial.agregarPag("YouTube.com");

            historial.imprimirHistorial();

            System.out.println("\nNavegando hacia atrás:");
            historial.navegarAtras();
            historial.imprimirHistorial();

            System.out.println("\nNavegando hacia adelante:");
            historial.navegarAdelante();
            historial.imprimirHistorial();

            System.out.println("\nEliminando la pagina 'Facebook.com'.");
            historial.eliminarPagina("Facebook.com");

            System.out.println("\nHistorial despues de eliminar:");
            historial.imprimirHistorial();

            System.out.println("\nHistorial en orden inverso:");
            historial.imprimirHistorialReverso();
        }
    }    
}
