package Consultas;

import java.sql.PreparedStatement;
import java.sql.SQLException;

//Creacion clase Motocicletas
public class Motocicletas {
    public static void ingresarMotocicletas() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sql = "INSERT INTO motocicletas VALUES (?,?,?,?,?)";
        PreparedStatement sentencia = Principal.conectar().prepareStatement(sql);
        //Almacenar el ID que agregue el usuario
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        sentencia.setInt(1, id);
        Principal.sc.nextLine();

        //Almacenar el name del Fabricante que agregue el usuario
        System.out.print("Nombre del Fabricante: ");
        String fabricante = Principal.sc.nextLine();
        sentencia.setString(2, fabricante);

        //Almacenar el precio que agregue el usuario
        System.out.print("Precio: ");
        int precio = Principal.sc.nextInt();
        sentencia.setInt(3, precio);
        Principal.sc.nextLine();

        //Almacenar la autonomia que agregue el usuario
        System.out.print("Autonomia, cuantas horas dura el funcionamiento: ");
        int autonomia = Principal.sc.nextInt();
        sentencia.setInt(4, autonomia);
        Principal.sc.nextLine();

        //Almacenar el ID del proveedor que agregue el usuario
        System.out.print("ID del Proverdor: ");
        int idProv = Principal.sc.nextInt();
        sentencia.setInt(5, idProv);
        Principal.sc.nextLine();
        
        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("* Se guardaron los datos correctamente *");
        }
    }
}