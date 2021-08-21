package co.utp.imaster.misiontic2022.c2.angel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Date fecha;
    private String cliente;
    private List<Vehiculo> listaVehiculos;

    public Pedido() {
    }

    public Pedido(Date fecha, String cliente) {
        this.fecha = fecha;
        this.cliente = cliente;
        listaVehiculos = new ArrayList<Vehiculo>();
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public void adicionarVehiculo(Vehiculo vehiculo) {
        listaVehiculos.add(vehiculo);
    }

    public Integer calcularCantidadVehiculos() {
        return listaVehiculos.size();
    }

    public Double calcularSubtotal() {
        
        var subtotal = 0d;
        for (Vehiculo vehiculo : listaVehiculos) {
            subtotal += vehiculo.calcularPrecio();
        }

        return subtotal;
    }

    public Double calcularDescuentos() {
        var descuentos = 0d;

        for (Vehiculo vehiculo : listaVehiculos) {
            descuentos += vehiculo.calcularDescuento(fecha);
        }

        return descuentos;
    }

    public Double calcularImpuestos() {
        var impuestos = 0d;
        var porcentaje = 0.0d;
        for (Vehiculo vehiculo : listaVehiculos) {
            porcentaje = vehiculo.calcularPorcentajeImpuesto();
            impuestos += (vehiculo.calcularPrecio() - vehiculo.calcularDescuento(fecha))*porcentaje;
        }
        return impuestos;
    }

    public Double calcularTotal() {
        return calcularSubtotal() - calcularDescuentos() + calcularImpuestos();
    }

}
