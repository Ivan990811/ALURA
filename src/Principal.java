import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main (String[] args ){

        Scanner entrada = new Scanner(System.in);
                ServConversion servicio = new ServConversion();
                int seleccion = 0;

                while (seleccion != 7) {
                    System.out.println("-------------------------------------------");
                    System.out.println("Bienvenido al convertidor de divisas");
                    System.out.println("1) USD a MXN");
                    System.out.println("2) MXN a USD");
                    System.out.println("3) EUR a MXN");
                    System.out.println("4) MXN a EUR");
                    System.out.println("5) GBP a MXN");
                    System.out.println("6) JPY a MXN");
                    System.out.println("7) AUD a MXN");
                    System.out.println("8) CAD a MXN");
                    System.out.println("9) Salir");
                    System.out.println(" Elija una opción válida \n");
                    System.out.println("\n");

                    try {
                        seleccion = entrada.nextInt();
                        entrada.nextLine(); // Limpiar el buffer del scanner

                        switch (seleccion) {
                            case 1:
                                Conver.convertir("USD", "MXN", servicio, entrada);
                                break;
                            case 2:
                                Conver.convertir("MXN", "USD", servicio, entrada);
                                break;
                            case 3:
                                Conver.convertir("EUR", "MXN", servicio, entrada);
                                break;
                            case 4:
                                Conver.convertir("MXN", "EUR", servicio, entrada);
                                break;
                            case 5:
                                Conver.convertir("GBP", "MXN", servicio, entrada);
                                break;
                            case 6:
                                Conver.convertir("JPY", "MXN", servicio, entrada);
                                break;
                            case 7:
                                Conver.convertir("AUD", "MXN", servicio, entrada);
                                break;
                            case 8:
                                Conver.convertir("CAD", "MXN", servicio, entrada);
                                break;
                            case 9:
                                System.out.println("Cerrando el programa...");
                                break;
                            default:
                                System.out.println("Por favor, ingrese una opción válida (1-7)");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Por favor, ingrese un número entero.");
                        entrada.next();
                        seleccion = 0;
                    } catch (Exception e) {
                        System.out.println("Opción no válida");
                        break;
                    }
                }
                entrada.close();


    }

}
