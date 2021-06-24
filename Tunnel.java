package ru.gb.level3.lesson5;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static Semaphore tunnelSemaphore;
        public Tunnel(int carsCount) {
            this.length = 80;
            this.description = "Тоннель " + length + " метров";
            this.tunnelSemaphore = new Semaphore(carsCount/2);
        }

    public Semaphore getTunnelSemaphore() {
        return tunnelSemaphore;
    }

    @Override
        public void go(Car c) {
            try {
                try {
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                    getTunnelSemaphore().acquire();
                    System.out.println(c.getName() + " начал этап: " + description);
                    Thread.sleep(length / c.getSpeed() * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    System.out.println(c.getName() + " закончил этап: " + description);
                    getTunnelSemaphore().release();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
