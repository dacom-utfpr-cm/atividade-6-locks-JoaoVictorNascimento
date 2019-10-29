/*
    Autor: João Victor Nascimento
    RA: 1817442
    Descrição: Crie uma classe SharedFifoQueue e use Conditions para controlar se a fila está vazia ou cheia.
    Teste usando threads produtoras e consumidoras.
 */

package ex2;

public class Main {
    public static void main(String[] args) {
        SharedFifoQueue sharedFifoQueue = new SharedFifoQueue();

        for(int i = 0; i < 2; i++){
            Thread t = new Thread(() -> {
                try{
                    sharedFifoQueue.put(5);
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
            });
            t.start();
        }

        for(int i = 0; i < 2; i++){
            Thread t = new Thread(() -> {
                try{
                    sharedFifoQueue.take();
                } catch (InterruptedException error) {
                    error.printStackTrace();
                }
            });
            t.start();
        }
    }

}
