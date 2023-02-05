package Homework2023_02_01;

import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String str = "This is my first experience when I myself work with IO API. I can do everything!";

        try(FileOutputStream fileOutputStream = new FileOutputStream("HW2023_02_01")) {
            fileOutputStream.write(str.getBytes());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
