package Perez_Esteban_Marcos_ut7_2;

public class Maleta<T> {
    private T[] maleta; //Tipo
    private int objetosIniciales;
    public static int contador = 0; //Contador


    public Maleta(T[] maleta,int inicial){
        this.maleta = maleta;
        objetosIniciales = inicial;
    }

    public T[] getMaleta() {
        return maleta;
    }//Get Maleta

    public void addElemento(T maleta) {
        this.maleta[contador] = maleta;
        contador++;
    }//Añadir elemento y suma al contador
    public void quitarElemento(int i){
        if(contador!=1){
            if(i-1>=0&&maleta[i-1]!=null){
                for (int j = i-1; j < maleta.length; j++) {
                    if(maleta[j]!=null&&maleta[j+1]!=null)
                        maleta[j]=maleta[j+1];
                    else if(j+1==contador) {
                        maleta[j] = null;
                        break;
                    }
                }
                contador--;
            }else{
                System.out.println("Numero incorrecto");
            }
        }else{
            System.out.println("No puedes dejar la maleta vacia prueba a crear otra maleta.");
        }

    }//Quita elemento
    public int getObjetosIniciales() {
        return objetosIniciales;
    }//Consigues el numero de objetos iniciales

}
