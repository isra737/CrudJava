package Consultas;

//Importar librerias para el buen funcionamiento del sistema
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Clase Bicicletas
public class Bicicletas {
    public static void ingresarBicicletas() throws SQLException {
        //Insertar datos con respecto a los campos de cada tabla 
        String sqlBici = "INSERT INTO bicicletas VALUES (?, ?, ?, ?)";
        PreparedStatement senBici = Principal.conectar().prepareStatement(sqlBici);
        //Almacenar el ID que ingrese el usuario
        System.out.print("ID: ");
        int id = Principal.sc.nextInt();
        senBici.setInt(1, id);
        Principal.sc.nextLine();

        //Almacenar el name del fabricante que ingrese el usuario
        System.out.print("Nombre del Fabricante: ");
        String nombre = Principal.sc.nextLine();
        senBici.setString(2, nombre);

        //Almacenar el precio que ingrese el usuario
        System.out.print("Precio: ");
        int precio = Principal.sc.nextInt();
        senBici.setInt(3, precio);
        Principal.sc.nextLine();

        //Almacenar el año que ingrese el usuario
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        senBici.setInt(4, year);
        Principal.sc.nextLine();

         /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = senBici.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! Se guardo correctamento los datos almacenados !");
            System.out.println("------------------------------------");
        }
    }
}