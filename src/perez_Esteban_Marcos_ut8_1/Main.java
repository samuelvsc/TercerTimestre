package perez_Esteban_Marcos_ut8_1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean end = false;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("1. Pedir valores.");
            System.out.println("2. Llenar array.");
            System.out.println("3. Calculadora.");
            System.out.println("4. Pedir numero.");
            System.out.println("5. Comprar producto.");
            System.out.println("6. Salir.");
            try{
                int menu = sc.nextInt();
                switch (menu){
                    case 1->{
                        pedirValores();
                        break;
                    }case 2->{
                        llenarArray();
                        break;
                    }case 3->{
                        calculadora();
                        break;
                    }case 4->{
                        pedirNumero();
                        break;
                    }case 5->{
                        System.out.println(comprarProducto()+"€");
                    }case 6->{
                        end  = true;
                        break;
                    }
                    default -> System.out.println("Error");
                }
            }catch (InputMismatchException e){
                System.out.println("Error.");
            } catch (ExcepcionPersonalizada e) {
                throw new RuntimeException(e);
            } finally {
                sc.nextLine();
            }
        }while (!end);
        sc.close();
    }

    static float comprarProducto() throws ExcepcionPersonalizada{
        Scanner sc = new Scanner(System.in);
        float[] precios = {15,3.5f,1.2f,4};
        String[] articulos = {"Mesa","Coca-Cola","Vaso","Platos"};
        boolean error = true;
        boolean artValido = false;
        int arrPos = 0;
        do{
            System.out.println("Que objeto quiere comprar:");
            try{
                String selecion = sc.nextLine();
                for (int i = 0; i < articulos.length; i++) {
                    if(selecion.equalsIgnoreCase(articulos[i])){
                        artValido = true;
                        arrPos = i;
                        break;
                    }
                }
                if(!artValido){
                    throw new ExcepcionPersonalizada();
                }else{
                    System.out.println("Cuantos quieres comprar:");
                    int cantidad = sc.nextInt();
                    if(cantidad<=0){
                        throw new InputMismatchException();
                    }else{
                        error = false;
                        return precios[arrPos]*cantidad;
                    }
                }

            }catch (ExcepcionPersonalizada e){
                System.out.println("Articulo no valido.");
            }
            catch (InputMismatchException e){
                System.out.println("No es un numero positivo.");
            }
        }while (error);
        return 0;
    }

    static void pedirNumero() throws InputMismatchException{
        Scanner scanner = new Scanner(System.in);
        boolean error = true;
        do{
            System.out.println("Introduzca un numero:");
            try{
                int num = scanner.nextInt();
                if(num<0){
                    throw new InputMismatchException();
                }
                error = false;
            }catch (InputMismatchException e){
                System.out.println("No es un numero positivo.");
            }finally {
                scanner.nextLine();
            }
        }while (error);


    }

    static void calculadora(){
        Scanner scanner = new Scanner(System.in);
        boolean errorOP = true;
        int op = 0;
        do{
            System.out.println("1. Sumar.");
            System.out.println("2. Resta.");
            System.out.println("3. Multiplicacion.");
            System.out.println("4. Division.");
            try{
                op = scanner.nextInt();
                errorOP = false;
            }catch (InputMismatchException e){
                System.out.println("Error al elegir.");
            }finally {
                scanner.nextLine();
            }
        }while (errorOP);
        errorOP = true;
        do{
            try {
                System.out.println("Primer numero:");
                float n1 = scanner.nextFloat();
                System.out.println("Segundo numero:");
                float n2 = scanner.nextFloat();
                errorOP = false;
                switch (op){
                    case 1->{
                        System.out.println(n1+n2);
                        break;
                    }case 2->{
                        System.out.println(n1-n2);
                        break;
                    }case 3->{
                        System.out.println(n1*n2);
                        break;
                    }case 4->{
                        System.out.println(n1/n2);
                        break;
                    }
                }
            }
            catch (InputMismatchException e){
                System.out.println("Error");
            }finally {
                scanner.nextLine();
            }
        }while (errorOP);
    }

    static void llenarArray(){
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[0];
        boolean errorArray=true;
        do{
            try{
                System.out.println("De cuanto tamaño quieres la array:");
                array = new int[scanner.nextInt()];
                errorArray = false;

            }catch (InputMismatchException e){
                System.out.println("Tamaño incorrecto.");
            }finally {
                scanner.nextLine();
            }
        }while (errorArray);
        for (int i = 0; i < array.length; i++) {
            do{
                try{
                    System.out.println("Valor en posicion "+ i+ ": ");
                    array[i] = scanner.nextInt();
                    errorArray = false;
                }catch (InputMismatchException e) {
                    System.out.println("Error de entrada");
                    errorArray = true;
                }finally {
                    scanner.nextLine();
                }
            }while (errorArray);
        }
        System.out.print("La array: [");
        for (int i = 0; i <array.length ; i++) {
            System.out.print(" " +array[i] + " ");
        }
        System.out.println("]");
    }

    static void pedirValores(){
        Scanner scanner = new Scanner(System.in);
        boolean correcto = false;
        int intentos = 0;
        do {
            try {
                System.out.println("Cual es su nombre:");
                String nombre = scanner.nextLine();
                System.out.println("Cual es su edad:");
                int edad = scanner.nextInt();
                System.out.println("Registro exitoso.");
                correcto = true;
            }catch (InputMismatchException e){
                System.out.println("Error al introducir un valor.");
            }finally {
                scanner.nextLine();
                intentos++;
            }
        }while (!correcto && intentos != 3);
    }
}
