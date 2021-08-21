package co.utp.imaster.misiontic2022.c2.angel.Main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import co.utp.imaster.misiontic2022.c2.angel.Automovil;
import co.utp.imaster.misiontic2022.c2.angel.Motocicleta;
import co.utp.imaster.misiontic2022.c2.angel.Pedido;
import co.utp.imaster.misiontic2022.c2.angel.TipoTransmision;
import co.utp.imaster.misiontic2022.c2.angel.Vehiculo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {


        try {

            var fecha = new SimpleDateFormat("dd/MM/yyyy").parse("17/03/2021");
            var pedido = new Pedido(fecha, "Carlos Perez");
            pedido.adicionarVehiculo(
                    new Automovil("Kia", "Rio Sedan", 60_000_000d, TipoTransmision.MANUAL, false, false));
            pedido.adicionarVehiculo(
                    new Automovil("Kia", "Rio Hatchback", 64_000_000d, TipoTransmision.AUTOMATICA, true, true));
            pedido.adicionarVehiculo(new Motocicleta("Suzuki", "VStrong", 30_000_000d, 600));
            pedido.adicionarVehiculo(new Motocicleta("Auteco", "VICTORY BOLD", 5_999_000d, 125));
            System.out.printf("Cliente: %s %n", pedido.getCliente());
            System.out.printf("Numero vehiculos: %d %n", pedido.calcularCantidadVehiculos());
            System.out.printf("Subtotal: %,.2f %n", pedido.calcularSubtotal());
            System.out.printf("Descuento: %,.2f %n", pedido.calcularDescuentos());
            System.out.printf("Impuestos: %,.2f %n", pedido.calcularImpuestos());
            System.out.printf("Total: %,.2f %n", pedido.calcularTotal());

            var fecha1 = new SimpleDateFormat("dd/MM/yyyy").parse("10/06/2021");
            var pedido2 = new Pedido(fecha1, "Cesar Díaz");
            pedido2.adicionarVehiculo(new Automovil("BMW", "i8", 300_000_000d, TipoTransmision.MANUAL, true, true));
            pedido2.adicionarVehiculo(new Motocicleta("Suzuki", "VStrong", 30_000_000d, 600));
            System.out.printf("Cliente: %s %n", pedido2.getCliente());
            System.out.printf("Numero vehiculos: %d %n", pedido2.calcularCantidadVehiculos());
            System.out.printf("Subtotal: %,.2f %n", pedido2.calcularSubtotal());
            System.out.printf("Descuento: %,.2f %n", pedido2.calcularDescuentos());
            System.out.printf("Impuestos: %,.2f %n", pedido2.calcularImpuestos());
            System.out.printf("Total: %,.2f %n", pedido2.calcularTotal());

        } catch (ParseException e) {
            e.printStackTrace();
        }

    }



}
