package Consultas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultas {
    public static void crearTablas(){
//Manejo de trycatch para manejo de exceptiones
//Creacion de tablas SQL con las sentencias
        try{
            String[] sqls = {
                    "CREATE TABLE proveedor (prov_id int PRIMARY KEY,prov_nombre char(20),"
                    + "prov_direccion char(45),prov_telefono char(20))",
                    "CREATE TABLE clientes (alias char(20) PRIMARY KEY,nombre char(20),"
                    + "apellidos char(20),email varchar(45),celular char(20) ,contraseña int ,"
                    + "f_nacimiento date)",
                    "CREATE TABLE fabricantes (  fabricante char(20) PRIMARY KEY )",
                    "CREATE TABLE bicicletas (  id int PRIMARY KEY,  fabricante char(20),  "
                    + "precio int,  año int,  FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante) )",
                    "CREATE TABLE motocicletas (  id int PRIMARY KEY,  fabricante char(20),  "
                    + "precio int,  autonomia int,  id_prov  int,  "
                    + "FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante),  "
                    + "FOREIGN KEY (id_prov) REFERENCES proveedor (prov_id)  )",
                    "CREATE TABLE compras (  id int PRIMARY KEY,  alias char(20),  "
                    + "fabricante char(20) ,  fecha_hora timestamp,  "
                    + "FOREIGN KEY (alias) REFERENCES clientes (alias),  "
                    + "FOREIGN KEY (fabricante) REFERENCES fabricantes (fabricante)  )"
            };
            //Guuardar sentencias en un ciclo for 
            for (String i:sqls){
                PreparedStatement sentencia = Principal.conectar().prepareStatement(i);
                sentencia.executeUpdate();
            }
            //En caso de que el usuario quiera crear más tablas, se mandaría siguiente mensaje, por el error
            //Se ejecutará una sola vez la creación de tablas
        }catch (Exception e){
            System.out.println("Se han creado las tablas");
        }
    }

    //Si se quiere modificar año de una marca de bicicleta
    public static void modificaYear() throws SQLException {
        //Sentencia SQL dentro de String, de forma dinamica
        String sql = "UPDATE bicicletas SET año=? WHERE fabricante=?";
        PreparedStatement sentencia = Principal.conectar().prepareStatement(sql);
        System.out.println("Por favor ingrese fabricante de la bicicleta y el año a modificar. ");
        System.out.print("Fabricante: ");
        String nombre = Principal.sc.nextLine(); 
        sentencia.setString(2, nombre);

        //Año por el que se le va a cambiar
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        sentencia.setInt(1, year);
        Principal.sc.nextLine();

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! El Año se ha cambiado Correctamente !");
        }
    }
    
    //Si se quiere modificar el celular, 
    //Ingresar Alias del cliente (QUE YA SE HAYA AGREGADO ANTERIORMENTE)
    public static void modificaTelCliente() throws SQLException {
        String sql = "UPDATE clientes SET celular=? WHERE alias=?";
        PreparedStatement sentencia = Principal.conectar().prepareStatement(sql);
        System.out.println("Por favor ingresa Alias del Cliente y el nuenvo número de celular. ");
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(2, alias);

        //Ingresar el número de celular por el que se quiere cambiar
        System.out.print("Celular: ");
        String cel = Principal.sc.nextLine();
        sentencia.setString(1, cel);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! El número de Celular se ha cambiado con exito !");
         }
    }

    //Funcion de borrar compra que ya se ha reaizado anteriormente
    //Ingresar Alias del cliente y el name del Fabricante
    public static void borraCompra() throws SQLException {
        String sql = "DELETE FROM compras WHERE alias=? AND fabricante=?";
        PreparedStatement sentencia = Principal.conectar().prepareStatement(sql);
        System.out.println("Por favor ingresa Alias del Cliente y Fabricante de la intención de compra que quiere"
                + " eliminar. ");
        System.out.print("Alias: ");
        String alias = Principal.sc.nextLine();
        sentencia.setString(1, alias);

        //Agregar name del Fabricante
        System.out.print("Fabricante: ");
        String fab = Principal.sc.nextLine();
        sentencia.setString(2, fab);

        /*Si cumple con todo los parametros entonces sale mensaje positivo
        Caso contrario sale mensaje Nos veremos de nuevo, hasta luego o 
        Muchas gracias por tu tiempo, espero que vuelvas pronto*/
        int filasIns = sentencia.executeUpdate();
        if (filasIns > 0) {
            System.out.println("! La intención de compra ELIMINADA correctamente, no hay vuelta atras !");
        }
    }

    //Consultar los fabricantes que ya se encuentran
    public static void consultaFabricantes() throws SQLException {
        String sql = "SELECT fabricante FROM fabricantes ORDER BY fabricante";
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);

        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()){
            String col1 = consulta.getNString(1);
            System.out.println(col1);
        }
    }

//Consultar la informacion de las bicicletas que se hayan creado despues o en el 2019    
    public static void consultaInfoBici() throws SQLException {
        String sql = "SELECT fabricante,precio,año FROM bicicletas WHERE año >= 2019 ORDER BY fabricante";
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);

        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()) {
            String col1 = consulta.getString(1);
            int col2 = consulta.getInt(2);
            String col3 = consulta.getString(3);
            System.out.println(col1 + " " + col2 + " " + col3);
        }
    }

    //Consultar los fabricantes de las motocicletas, cuantos hay
    public static void consultaFabriMoto() throws SQLException {
        String sql = "select fabricante from motocicletas where id_prov=101";
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);

        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()) {
            String col1 = consulta.getString(1);
            System.out.println(col1);
        }
    }

    //Consultar las comprar en orden de alias ingresado y con el fabricante
    public static void consultaCompBiMo() throws SQLException {
        String sql = "select fabricante from compras where alias=\"lucky\" order by fabricante";
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);
        
        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()) {
            String col1 = consulta.getString(1);
            System.out.println(col1);
        }
    }

    //Consultar compras de Bicicletas, en orden del que se haya ingresado
    public static void consultaCompBiCli() throws SQLException {
        String sql = "select c.alias, c.nombre, c.apellidos from clientes c,"
                + "compras p where  p.alias=c.alias and p.fabricante=\"Yeti\" order by nombre";
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);

        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()) {
            String col1 = consulta.getString(1);
            String col2 = consulta.getString(2);
            String col3 = consulta.getString(3);
            System.out.println(col1 + " " + col2 + " " + col3);
        }
    }

    //Consultar año de fabricacion de Bicicletas
    public static void consultaBiciFab() throws SQLException {
        System.out.println("Por favor ingrese Año ");
        System.out.print("Año: ");
        int year = Principal.sc.nextInt();
        Principal.sc.nextLine();

        String sql = "select count(fabricante) from bicicletas where año >=" + year;
        Statement sentencia = Principal.conectar().createStatement();
        ResultSet consulta = sentencia.executeQuery(sql);

        //Ciclo while que me muestre en consola la interacion
        while (consulta.next()) {
            int col1 = consulta.getInt(1);
            System.out.println(col1);
        }
    }
}