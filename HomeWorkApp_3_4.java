package ru.gb.level3;

public class HomeWorkApp_3_4 {
    private final Object monitor = new Object();
    private volatile char currentLetter = 'A';

    public static void main(String[] args) {
        HomeWorkApp_3_4 hmwrk = new HomeWorkApp_3_4();
        Thread thread1 = new Thread (() -> {
            hmwrk.printA();
        });
        Thread thread2 = new Thread (() -> {
            hmwrk.printB();
        });
        Thread thread3 = new Thread (() -> {
            hmwrk.printC();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    private void printA() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'A') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printB() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'B') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void printC() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (currentLetter != 'C') {
                        monitor.wait();
                    }
                    System.out.print(currentLetter);
                    currentLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
