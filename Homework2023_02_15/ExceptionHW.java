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
//Exceptions. �������� ������ � ������
//������� ����������� ����� ������� ��������� �� ���� ��� ���������: login, password � confirmPassword.
//Login ������ ��������� ������ ��������� �����, ����� � ���� �������������.
//����� login ������ ���� ������ 20 ��������.
//���� login �� ������������� ���� �����������, ���������� ��������� WrongLoginException.
//Password ������ ��������� ������ ��������� �����, ����� � ���� �������������.
//����� password ������ ���� ������ 20 ��������. ����� password � confirmPassword ������ ���� �����.
//���� password �� ������������� ���� �����������, ���������� ��������� WrongPasswordException.
//WrongPasswordException � WrongLoginException - ���������������� ������ ���������� � ����� �������������� � ���� �� ���������,
//������ ��������� ��������� ���������� � �������� ��� � ����������� ������ Exception.
//��������� ���������� ���������� ������ ������.
//���������� multi-catch block. ����� ���������� true, ���� �������� ����� ��� false � ������ ������.