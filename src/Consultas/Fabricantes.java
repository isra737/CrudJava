package Consultas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Creacion clase fabricantes
public class Fabricantes {
    public static void ingresarFabricantes() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sqlFab = "INSERT INTO fabricantes VALUES (?)";
        PreparedStatement senFab = Principal.conectar().prepareStatement(sqlFab);

        //Almacenar el name del fabricante que ingrese el usuario
        System.out.print("Nombre del Fabricante: ");
        String nombre = Principal.sc.nextLine();
        senFab.setString(1, nombre);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = senFab.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! Datos almacenados con extio !");
        }
    }
}