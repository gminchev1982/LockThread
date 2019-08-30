package com.company.lock2;

public class Sender implements Runnable {
    private Data data;
    private String packets[] = {
            "First packet",
            "Second packet",
            "Third packet",
            "Fourth packet",
            "End"
    };

    public Sender(Data data) {
        this.data = data;
    }

    // standard constructors

    public void run() {

        for (String packet : packets) {
            data.send(packet);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread interrupted: " + e);
            }
        }
    }
}
