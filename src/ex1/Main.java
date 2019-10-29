/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Faça um programa usando Lock para simular a atualização de um contador que é acessado por múltiplas threads.
    O contador pode diminuir e aumentar.
 */

package ex1;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        for(int i = 0; i < 5; i++){
            Thread t = new Thread(new CounterThread(counter, false, "Thread " + Integer.toString(i), 3));
            t.start();
        }

        for(int i = 0; i < 2; i++){
            Thread t = new Thread(new CounterThread(counter, true, "Thread " + Integer.toString(i), 3));
            t.start();
        }

    }
}
