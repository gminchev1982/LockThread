package com.company.lock;

import java.util.Random;

public class WriterData implements Runnable {
    private LockData<DataKeyModel, DataValueModel> data;

    public WriterData(LockData<DataKeyModel, DataValueModel> data) {
        this.data = data;
    }

    @Override
    public void run() {
        Random random = new Random();
        int number = random.nextInt(100);
        int key = random.nextInt(100);
        data.add(new DataKeyModel(key), new DataValueModel(number));

        try {
            Thread.sleep(100);
            //System.out.println(" -> put: " + number);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
    }
}
