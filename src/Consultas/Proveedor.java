package Consultas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Proveedor {
    public static void ingresarProveedor() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sqlProv = "INSERT INTO proveedor VALUES (?, ?, ?, ?)";
        PreparedStatement senProv = Principal.conectar().prepareStatement(sqlProv);
        //Almacenar el ID que agregue el usuario
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        senProv.setInt(1, id);
        Principal.sc.nextLine();

        //Almacenar el name del Proveedor que agregue el usuario
        System.out.print("Nombre del Proveedor: ");
        String nombre = Principal.sc.nextLine();
        senProv.setString(2, nombre);

        //Almacenar la dirección (pueden ser nuemros o letras) que agregue el usuario
        System.out.print("Dirección: ");
        String direccion = Principal.sc.nextLine();
        senProv.setString(3, direccion);

        //Almacenar el número telefonico del proveedor que agregue el usuario
        System.out.print("Telefono: ");
        String telefono = Principal.sc.nextLine();
        senProv.setString(4, telefono);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = senProv.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! DATOS GUARDADOS !");
            System.out.println("------------------------------------");
        }
    }
}