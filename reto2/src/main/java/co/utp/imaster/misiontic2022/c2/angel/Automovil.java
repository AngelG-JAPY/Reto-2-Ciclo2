package co.utp.imaster.misiontic2022.c2.angel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Automovil extends Vehiculo {

    private TipoTransmision transmision;
    private Boolean vidriosElectricos;
    private Boolean aireAcondicionado;

    public Automovil(String marca, String modelo, Double precioBase, TipoTransmision transmision,
            Boolean vidriosElectricos, Boolean aireAcondicionado) {
        super(marca, modelo, precioBase);
        this.transmision = transmision;
        this.vidriosElectricos = vidriosElectricos;
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public Double calcularPrecio() {

        var precio = getPrecioBase();

        if (transmision == TipoTransmision.AUTOMATICA) {
            precio += (precio * 5)/100;
        }

        if (vidriosElectricos) {
            precio += 400000d;
        }

        if (aireAcondicionado) {
            precio += 3000000d;
        }

        return precio;
    }

    @Override
    public Double calcularPorcentajeImpuesto() {
        var precio = calcularPrecio();
        return precio > 60000000d ?  0.10d : 0d;
    }

    @Override
    public Double calcularDescuento(Date fecha) {
        // Extrae el mes de la fecha actual.
        // Para comparar use las constantes Calendar.JULY o Calendar.JUNE
        var cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        var mes = cal.get(Calendar.MONTH);

        var precio = calcularPrecio();

        if (mes == Calendar.JULY && getMarca().equalsIgnoreCase("BMW")) {
            return precio * 0.15;
        } else if (mes == Calendar.JUNE && getMarca().equalsIgnoreCase("Suzuki")) {
            return precio * 0.10;
        }

        return 0d;
    }

}
