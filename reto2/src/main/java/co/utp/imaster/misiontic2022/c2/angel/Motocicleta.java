package co.utp.imaster.misiontic2022.c2.angel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Motocicleta extends Vehiculo {

    private Integer cilindraje;

    public Motocicleta(String marca, String modelo, Double precioBase, Integer cilindraje) {
        super(marca, modelo, precioBase);
        this.cilindraje = cilindraje;
    }

    @Override
    public Double calcularPrecio() {

        var precio = getPrecioBase();

        if (cilindraje >= 200 && cilindraje < 351) {
            precio += 500000d;
        } else if (cilindraje >= 351 && cilindraje <= 500) {
            precio += 750000d;
        } else if (cilindraje > 500) {
            precio += 1000000d;
        }

        return precio;
    }

    @Override
    public Double calcularPorcentajeImpuesto() {
        var precio = calcularPrecio();
        return precio > 7500000d ? 0.10d : 0d;
    }

    @Override
    public Double calcularDescuento(Date fecha) {
        // Extrae el mes de la fecha actual.
        // Para comparar use las constantes Calendar.JULY o Calendar.JUNE
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);

        var precio = calcularPrecio();
        
        if(mes == Calendar.JULY && getMarca().equalsIgnoreCase("BMW")){
            return precio * 0.15;
        } else if (mes == Calendar.JUNE && getMarca().equalsIgnoreCase("Suzuki")){
            return precio * 0.05;
        } 

        return 0d;
    }

}
