package ConvertidorUnidades;

public class ConversorTemperatura {

    private double[][] matrizFactores;

    public ConversorTemperatura() {
        matrizFactores = new double[4][4];
        matrizFactores[0][0] = 1.0;
        matrizFactores[0][1] = 1.8;
        matrizFactores[0][2] = 1.0;
        matrizFactores[0][3] = 1.8;
        matrizFactores[1][0] = 0.5555555555555556; 
        matrizFactores[2][0] = 1.0;
        matrizFactores[3][0] = 0.5555555555555556;
    }

    public int obtenerPosicion(String unidad) {
        if (unidad != null) {
            if (unidad.equals("Celsius")) {
                return 0;
            } else if (unidad.equals("Fahrenheit")) {
                return 1;
            } else if (unidad.equals("Kelvin")) {
                return 2;
            } else if (unidad.equals("Rankine")) {
                return 3;
            }
        }
        return -1;
    }

    public double convertir(double valor, String origen, String destino) {
        int posOrigen = obtenerPosicion(origen);
        int posDestino = obtenerPosicion(destino);

        if (posOrigen == -1 || posDestino == -1) {
            return 0.0;
        }

        if (posOrigen == posDestino) {
            return valor;
        }

        double resultado = 0.0;
        double celsius = valor;

        if (posOrigen == 1) {
            celsius = (valor - 32.0) * matrizFactores[1][0];
        } else if (posOrigen == 2) {
            celsius = valor - 273.15;
        } else if (posOrigen == 3) {
            celsius = (valor - 491.67) * matrizFactores[3][0];
        }

        if (posDestino == 0) {
            resultado = celsius;
        } else if (posDestino == 1) {
            resultado = (celsius * matrizFactores[0][1]) + 32.0;
        } else if (posDestino == 2) {
            resultado = celsius + 273.15;
        } else if (posDestino == 3) {
            resultado = (celsius + 273.15) * matrizFactores[0][3];
        }

        return resultado;
    }
}