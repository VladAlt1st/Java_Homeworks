package Homework2023_03_01;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(Main::writeTxt);
        Thread thread2 = new Thread(Main::readTxt);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void writeTxt() {
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(Path.of("HW2023_03_01"))) {
            for (int i = 0; i < 10000; i++) {
                if (i % 1000 == 0) {
                    bufferedWriter.write(i + System.lineSeparator());
                    Thread.sleep(500);
                }
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static synchronized void readTxt() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Path.of("HW2023_03_01"))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
