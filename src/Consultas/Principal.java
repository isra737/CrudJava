package Consultas;

//Importar librerias importantes para el correcto funcionamiento del pequeño sistema
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//Creamos la clase Main 
public class Principal {
    //Metodo Scanner para ingresar datos por consola
    public static Scanner sc = new Scanner(System.in);

    //Metodo menu que es lo primero que se va a ejecutar cuando se corra el programa
    public static void main(String[] args) {
        menu();
    }
    
    //Uso del trycatch para el manejo de excepciones 
    public static void menu() {
       //En caso de que se cumpla lo respectivo
       try {
           //Menu de navegación 
           System.out.println("************************\n" +
                    "***   CRUD  EN JAVA INVENTARIO ***\n" +
                    "************************\n" +
                    "Por favor administrador, seleccione una de las siguientes secciones:\n"+
                    "*********************************\n"+
                    "1. Creaacion de las Tablas.\n" +
                    "----------------------------------------------------------------------\n" +
                    "2. Ingresar datos del Proveedor.\n" +
                    "3. Ingresar datos de los Clientes.\n" +
                    "4. Ingresar datos de los Fabricantes.\n" +
                    "5. Ingresar datos de las Bicicletas.\n" +
                    "6. Ingresar datos de las Motocicletas.\n" +
                    "7. Ingresar datos de las Compras realizadass.\n" +
                    "----------------------------------------------------------------------\n" +
                    "8. Modificar Año de la Bicicleta.\n" +
                    "9. Modificar el Telefono del Cliente.\n" +
                    "10. Borrar la intención de la compra realizada.\n" +
                    "----------------------------------------------------------------------\n" +
                    "11. Lista de los Fabricantes.\n" +
                    "12. Mostrar información fabricantes Bicicletas estrenadas desde 2019.\n" +
                    "13. Mostrar fabricantes de las motocicletas con motor Auteco.\n" +
                    "14. Mostrar fabricante con intencion de Compra del cliente lucky.\n" +
                    "15. Mostrar Clientes que quieren comprar bicicleta Yeti.\n" +
                    "16. Cantidad bicicletas fabricadas desde \"x\" Año.\n" +
                    "----------------------------------------------------------------------\n" +
                    "- Ingresa un número cualquier si quieres salir del sistema -\n" +
                    "----------------------------------------------------------------------\n"
            );
      
           //Declarar variable input para recibir lo que se escribe en la consola
            System.out.print(">> ");
            //Se recibe y se convierte a byte
            String input = sc.nextLine();
            byte opcion = Byte.parseByte(input);

            /*Uso del switch para configurar cual es el número que el usuario agrega
             Depende de lo que el usuario arregle le va a aperecer el respectivo menu de cada seccion
            Y cada caso va a tener un metodo*/
            switch (opcion) {
                case 1:
                    Consultas.crearTablas();
                    break;
                case 2:
                    Proveedor.ingresarProveedor();
                    break;
                case 3:
                    Clientes.ingresarClientes();
                    break;
                case 4:
                    Fabricantes.ingresarFabricantes();
                    break;
                case 5:
                    Bicicletas.ingresarBicicletas();
                    break;
                case 6:
                    Motocicletas.ingresarMotocicletas();
                    break;
                case 7:
                    Compras.ingresarCompras();
                    break;
                case 8:
                    Consultas.modificaYear();
                    break;
                case 9:
                    Consultas.modificaTelCliente();
                    break;
                case 10:
                    Consultas.borraCompra();
                    break;
                case 11:
                    Consultas.consultaFabricantes();
                    break;
                case 12:
                    Consultas.consultaInfoBici();
                    break;
                case 13:
                    Consultas.consultaFabriMoto();
                    break;
                case 14:
                    Consultas.consultaCompBiMo();
                    break;
                case 15:
                    Consultas.consultaCompBiCli();
                    break;
                case 16:
                    Consultas.consultaBiciFab();
                    break;
                //Si el usuario agrega un nuemro mayor a 16, salir del sistema
                default:
                    System.out.println("Muchas gracias por tu tiempo, espero que vuelvas pronto");
            }
            //Si en tal caso algo sale mal y no es ninguna de las opciones anteriores, salir de inmediato
        } catch (Exception e) {
            System.out.println("Nos veremos de nuevo, hasta luego");
        }
    }

    //Metodo conección con la base de datos MySQL
    //Agregar variebles fundamentales para la coneccion
    public static Connection conectar() {
        String dbName = "reto5";
        String url = "jdbc:mysql://localhost:3322/"+dbName+"?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "12345";
        Connection con = null;
        //Uso del trycatch para excepcion si ocurre algun problema
        try{
           con = DriverManager.getConnection(url,user,password);
           //Si todo sale bien muestra resultado positivo
           if (con != null){
               System.out.println("* Conectado *");
               System.out.println("-------------");
           }
           //Si algo sale mal, mostrar mensaje negativo
        }catch (SQLException error){
            System.out.println("Error:" + error.getErrorCode() + " " + error.getMessage());
        }
        return con;
    }
}