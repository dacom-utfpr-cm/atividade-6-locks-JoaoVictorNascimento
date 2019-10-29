/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Faça uma classe ArrayListThreadSafe usando ReadWriteLock.
    Teste usando threads que realizam leitura e escrita para essa estrutura.
 */


package ex3;

public class Main {
    public static void main(String[] args) {
        ArrayListThreadSafe arrayList = new ArrayListThreadSafe();

        for(int i = 0; i < 15; i++){
            int finalI = i;
            Thread t = new Thread(() -> {
                arrayList.put(finalI +1);
            });
            t.start();
        }


        for(int i = 0; i < 4; i++){
            int finalI = i;
            Thread m = new Thread(() -> {
                System.out.println(arrayList.get(finalI));
            });
            m.start();
        }
    }
}
