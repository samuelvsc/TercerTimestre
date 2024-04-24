package Perez_Esteban_Marcos_ut7_2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("modificacionSamuel");

        boolean primerBucle = true,segundoBucle = true,segundoBuclePrimeraVez=true; //Variables para los bucles
        Scanner sc = new Scanner(System.in); //Scanner
        Maleta maleta = null; //Crear la maleta
        while (primerBucle){ //Bucle inicial
            System.out.println("1. Crear maleta");
            System.out.println("2. Salir");
            int elecion = sc.nextInt();
            switch (elecion){
                case 1 ->{
                    //Si es la primera vez que entras te pide que tipo quieres la maleta
                    if(segundoBuclePrimeraVez){
                        segundoBuclePrimeraVez=false;
                        System.out.println("De que tipo quiere crear la maleta: ");
                        System.out.println("1. String");
                        System.out.println("2. Int");
                        elecion = sc.nextInt();
                        int iniciales = 0;
                        String textoSC;
                        switch (elecion){
                            //Depende de la eleccion se te crea de un tipo u otro
                            case 1->{
                                System.out.println("Cuantos objetos iniciales?");
                                iniciales = sc.nextInt();
                                maleta = new Maleta<String>(new String[100],iniciales);
                                break;
                            }case 2->{
                                System.out.println("Cuantos objetos iniciales?");
                                iniciales = sc.nextInt();
                                maleta = new Maleta<Integer>(new Integer[100],iniciales);
                                break;
                            }default -> {
                                System.out.println("Error");
                                segundoBucle = false;
                            }
                        }
                        if(maleta.getObjetosIniciales()<1||maleta.getObjetosIniciales()>100){
                            System.out.println("Error, Limites invalidos");
                        }else{

                        }
                        //Rellenas con los objetos principales
                        if(segundoBucle){
                            for (int i = 0; i < iniciales; i++) {
                                System.out.println("Objeto " +(i+1) );
                                switch (elecion){
                                    case 1->{
                                        textoSC = sc.next();
                                        maleta.addElemento(textoSC);
                                        break;
                                    }
                                    case 2->{
                                        textoSC = sc.next();
                                        maleta.addElemento(Integer.valueOf(textoSC));
                                        break;
                                    }
                                }
                                if(!segundoBucle) break;
                            }
                        }
                    }


                    //Segundo bucle
                    while (segundoBucle){
                        System.out.println("1. Ver maleta");
                        System.out.println("2. Añadir elemento");
                        System.out.println("3. Borrar elemento");
                        System.out.println("4. Salir");
                        elecion = sc.nextInt();
                        switch (elecion){

                            case 1->{
                                for (int i = 0; i < maleta.getMaleta().length; i++) {
                                    if(maleta.getMaleta()[i]!=null)System.out.println((i+1)+": "+maleta.getMaleta()[i]);
                                    if(i==Maleta.contador) break;
                                    //Muestra maleta
                                }
                            }
                            case 2->{
                                System.out.println("Que objeto quieres añadir: ");
                                if(maleta.getMaleta()[0] instanceof String){
                                    maleta.addElemento(sc.next());
                                }else if(maleta.getMaleta()[0] instanceof Integer){
                                    maleta.addElemento(sc.nextInt());
                                }
                                //Añade objeto a maleta
                            }
                            case 3->{
                                for (int i = 0; i < maleta.getMaleta().length; i++) {
                                    if(maleta.getMaleta()[i]!=null){
                                        System.out.println((i+1)+": "+maleta.getMaleta()[i]);
                                    }
                                }
                                int borrar = sc.nextInt();
                                maleta.quitarElemento(borrar);
                                //Borras objeto a maleta
                            }
                            case 4->{
                                segundoBucle = false;
                                break;
                                //Salir
                            }
                            default -> {
                                System.out.println("Error");
                            }

                        }
                    }
                    segundoBucle = true;
                    segundoBuclePrimeraVez=true;
                    break;
                }case 2->{
                    primerBucle = false;
                    break;
                }default -> {
                    System.out.printf("Invalido");
                }
            }
        }
    }
}
