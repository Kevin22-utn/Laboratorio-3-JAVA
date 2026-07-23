package ConvertidorUnidades;

public class ConversorTemperatura {

    public double convertir(double valor, Unidadtemperatura origen, Unidadtemperatura destino) {
        double celsius = aCelsius(valor, origen);
        return desdeCelsius(celsius, destino);
    }

    private double aCelsius(double valor, Unidadtemperatura unidad) {
        switch (unidad) {
            case CELSIUS -> {
                return valor;
            }
            case FAHRENHEIT -> {
                return (valor - 32) * 5.0 / 9.0;
            }
            case KELVIN -> {
                return valor - 273.15;
            }
            case RANKINE -> {
                return (valor - 491.67) * 5.0 / 9.0;
            }
            default -> throw new IllegalArgumentException("Unidad no soportada: " + unidad);
        }
    }

    private double desdeCelsius(double celsius, Unidadtemperatura unidad) {
        switch (unidad) {
            case CELSIUS -> {
                return celsius;
            }
            case FAHRENHEIT -> {
                return celsius * 9.0 / 5.0 + 32;
            }
            case KELVIN -> {
                return celsius + 273.15;
            }
            case RANKINE -> {
                return (celsius + 273.15) * 9.0 / 5.0;
            }
            default -> throw new IllegalArgumentException("Unidad no soportada: " + unidad);
        }
    }
}
