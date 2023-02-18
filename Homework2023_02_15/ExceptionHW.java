package Homework2023_02_15;

import java.util.regex.Pattern;

public class ExceptionHW {
    public static void main(String[] args) {
        System.out.println(loginPasswordCheck("Vlad_alt1997", "123VL321ghj", "123VL321ghj"));
    }

    public static boolean loginPasswordCheck(String login, String password, String confirmPassword) {
        Pattern check = Pattern.compile("[a-zA-Z0-9_]{5,19}");

        try {
            if (!check.matcher(login).matches()) {
                throw new WrongLoginException("wrong login.");
            }
            if (!check.matcher(password).matches() || !password.equals(confirmPassword)) {
                throw new WrongPasswordException("wrong password.");
            }
        } catch (WrongLoginException | WrongPasswordException | NullPointerException e) {
            System.err.println("Invalid data: " + e.getMessage());
            return false;
        }
        return true;
    }
}
//Exceptions. Проверка логина и пароля
//Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//Длина login должна быть меньше 20 символов.
//Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.
//Password должен содержать только латинские буквы, цифры и знак подчеркивания.
//Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
//Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//второй принимает сообщение исключения и передает его в конструктор класса Exception.
//Обработка исключений проводится внутри метода.
//Используем multi-catch block. Метод возвращает true, если значения верны или false в другом случае.