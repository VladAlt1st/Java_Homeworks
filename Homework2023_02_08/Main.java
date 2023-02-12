package Homework2023_02_08;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        List<Contact> list = getFromFile("input_business_card.txt");
        //System.out.println(list);

        list.stream().sorted(Comparator.comparing(Contact::getTel)).forEach(System.out::println);


    }

    public static List<Contact> getFromFile(String fileName) {
        List<Contact> list = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {

            StringBuilder sb = new StringBuilder();

            String line = bufferedReader.readLine();

            while (line != null) {
                if (line.contains("END")) {
                    sb.append(line);
                    list.add(parse(sb.toString()));
                    sb = new StringBuilder();
                }
                sb.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return list;
    }

    private static Contact parse(String string) {
        Pattern fn = Pattern.compile("FN:(.+)");
        Matcher mFN = fn.matcher(string);
        mFN.find();

        Pattern field = Pattern.compile("(.+)[:;]TYPE=.+:(\\s*.+)");
        Matcher mFIELD = field.matcher(string);

        String tel = "";
        String address = "";
        String email = "";
        String web = "";

        while (mFIELD.find()) {
            if (mFIELD.group(1).equals("TEL")) {
                tel = tel + mFIELD.group(2) + ";";
            }
            if (mFIELD.group(1).equals("ADDRESS")) {
                address = address + mFIELD.group(2) + ";";
            }
            if (mFIELD.group(1).equals("EMAIL")) {
                email = email + mFIELD.group(2) + ";";
            }
            if (mFIELD.group(1).equals("WEB")) {
                web = web + mFIELD.group(2) + ";";
            }

        }
        return new Contact(mFN.group(1),tel,address,email,web);
    }
    //Описание занятия: распарсить файл inputbuisnesscard.txt
    //создать класс типа Contact и сопутствующие классы при необходимости
    //заполнить обьекты типа Contact данными из файла(
    //Имя \ Фамилия
    //Телефон
    //Адрес
    //Емэйл
    //Вебсайт
    //)
    //вывести в консоль список контактов отсортированных по № телефона
    //
    //
    //факультативно:
    //
    //
    //
    //используя интерфейс Serializable сохранить обьекты типа  Contact в файл
    //
    //реализовать считывание и выдачу в консоль сохраненых обьектов
}
