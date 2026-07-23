package AgendaTarea;

public class ListaTareas {
    private Tarea[] vectorTareas;

    public ListaTareas() {
        vectorTareas = new Tarea[30];
    }

    public int obtenerCantidadTareas() {
        int contador = 0;
        for (int i = 0; i < 30; i++) {
            if (vectorTareas[i] != null) {
                contador = contador + 1;
            }
        }
        return contador;
    }

    public boolean agregarTarea(Tarea nueva) {
        boolean guardado = false;
        if (nueva != null) {
            for (int i = 0; i < 30; i++) {
                if (vectorTareas[i] == null) {
                    vectorTareas[i] = nueva;
                    guardado = true;
                    break;
                }
            }
        }
        return guardado;
    }

    public Tarea getTarea(int indice) {
        if (indice >= 0 && indice < 30) {
            return vectorTareas[indice];
        }
        return null;
    }

    public boolean eliminarTarea(int indice) {
        if (indice >= 0 && indice < 30) {
            if (vectorTareas[indice] != null) {
                vectorTareas[indice] = null;
                         
                for (int i = indice; i < 29; i++) {
                    vectorTareas[i] = vectorTareas[i + 1];
                }
                vectorTareas[29] = null;
                return true;
            }
        }
        return false;
    }
}