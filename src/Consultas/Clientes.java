package Consultas;

//Importar librerias 
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Clientes {
//Logica para que funcione correctamente la sección
    public static void ingresarClientes() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sql = "INSERT INTO clientes VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        //Almacenar en sql, el Alias que ingrese el usuario
        PreparedStatement sentencia = Principal.conectar().prepareStatement(sql);
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(1, alias);
        
        //Almacenar el Nombre que agregue el usuario
        System.out.print("Nombre: ");
        String nombre = Principal.sc.nextLine();
        sentencia.setString(2, nombre);
        
        //Almacenar el Apellido que agregue el usuario
        System.out.print("Apellido: ");
        String apellido = Principal.sc.nextLine();
        sentencia.setString(3, apellido);
        
        //Almacenar el E-mail que agregue el usuario
        System.out.print("e-mail: ");
        String email = Principal.sc.nextLine();
        sentencia.setString(4, email);
        
        //Almacenar el Celular que agregue el usuario
        System.out.print("Celular: ");
        String celular = Principal.sc.nextLine();
        sentencia.setString(5, celular);
        
        //Almacenar la Contraseña que agregue el usuario
        System.out.print("Contraseña: ");
        int contrasena = Principal.sc.nextInt();
        sentencia.setInt(6, contrasena);
        Principal.sc.nextLine();
        
        //Almacenar la Fecha de nacimiento que agregue el usuario
        //IMPORTANTE: FORMATO de la fecha de nacimiento: AAAA-MM-DD 1983-09-24
        System.out.print("F.Nacimiento: ");
        String nacimiento = Principal.sc.nextLine();
        sentencia.setString(7, nacimiento);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("* Se guardo con éxito *");
        }
    }
}