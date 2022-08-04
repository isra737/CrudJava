package Consultas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Compras {
    public static void ingresarCompras() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sqlComp = "INSERT INTO compras VALUES (?, ?, ?, ?)";
        PreparedStatement senComp = Principal.conectar().prepareStatement(sqlComp);
        //Almacenar el ID que agregue el usuario
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        senComp.setInt(1, id);
        Principal.sc.nextLine();

        //Almacenar el Alias que agregue el usuario
        System.out.print("Alias del Comprador: ");
        String alias = Principal.sc.nextLine();
        senComp.setString(2, alias);

        //Almacenar el name del Fabricante que agregue el usuario
        System.out.print("Fabricante: ");
        String nombre = Principal.sc.nextLine();
        senComp.setString(3, nombre);

        /*Almacenar la fecha y hora que agregue el usuario
        IMPORTANTE: formato de fecha y hora: AAAA-MM-DD H:MIN:SEG 2020-03-20 21:30:20*/ 
        System.out.print("Fecha y Hora: ");
        String fechaHora = Principal.sc.nextLine();
        senComp.setString(4, fechaHora);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = senComp.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! Datos guardados con EXITO, vuelve pronto  !");
            System.out.println("------------------------------------");
        }
    }
}