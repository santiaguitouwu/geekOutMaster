package myProject;

public class Model {
    private Dado dado1, dado2, dado3, dado4, dado5, dado6, dado7, dado8, dado9, dado10;
    private int[] caras; //guarda la caras del dado
    private int tiro, flag;

    public Model(){
        dado1 = new Dado();
        dado2 = new Dado();
        dado3 = new Dado();
        dado4 = new Dado();
        dado5 = new Dado();
        dado6 = new Dado();
        dado7 = new Dado();
        dado8 = new Dado();
        dado9 = new Dado();
        dado10 = new Dado();
        caras = new int[10];
    }

    public void calcularTiro(){
        caras[0] = dado1.getCara();
        caras[1] = dado2.getCara();
        caras[2] = dado3.getCara();
        caras[3] = dado4.getCara();
        caras[4] = dado5.getCara();
        caras[5] = dado6.getCara();
        caras[6] = dado7.getCara();
        caras[7] = dado8.getCara();
        caras[8] = dado9.getCara();
        caras[9] = dado10.getCara();
        tiro = caras[0] + caras[1];
        flag = 0;
    }
    public int[] getCaras() {
        return caras;
    }
}
