package ru.gb.level3.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
        private ArrayList<Stage> stages;
        private CyclicBarrier raceCB;
        private CountDownLatch raceCDL;
        private CountDownLatch phaseCDL;
        private Lock finishLock;

    public CountDownLatch getRaceCDL() {
        return raceCDL;
    }

    public CyclicBarrier getRaceCB() {
        return raceCB;
    }

    public Lock getFinishLock() {
        return finishLock;
    }

    public CountDownLatch getPhaseCDL() {
        return phaseCDL;
    }

    public ArrayList<Stage> getStages() { return stages; }
        public Race(int carsCount, Stage... stages) {
            this.stages = new ArrayList<>(Arrays.asList(stages));
            this.raceCB = new CyclicBarrier(carsCount);
            this.raceCDL = new CountDownLatch(carsCount);
            this.phaseCDL = new CountDownLatch(carsCount);
            this.finishLock = new ReentrantLock();
        }
    }
