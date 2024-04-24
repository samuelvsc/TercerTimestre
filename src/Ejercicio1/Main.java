package Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Animal a = new Animal();
        Gato g = new Gato();
        Leon l = new Leon();
        Animal polimorfico;
        polimorfico = g;
        System.out.println(((Gato)polimorfico).getInfo());
        polimorfico = l;
        if(l instanceof Leon){

        }
        System.out.println(((Leon)polimorfico).getInfo());
        /*polimorfico = a;
        System.out.println(((l)polimorfico).getInfo());*/
    }
}
