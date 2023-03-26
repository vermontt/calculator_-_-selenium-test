package calculator;

import calculator.exception.BadNumberValue;
import model.Concatenator;
import utils.Validator;

import java.util.Scanner;

/**
 * Программа, выполняющая операции вычисления: *, /, +, -
 */
public class Application {

    public static void main(String[] args) {

        //Создание объекта класс клнкатенатор
        Concatenator concatenator = new Concatenator();

        //Создание строки, которая будет хранить первое число, а также в последующем сумму вычислений
        String num1 = "";
        //Вывод на экран информациооного сообщения
        System.out.println("Input number №1:");
        //Создание объекта класса сканер, который считывает число с консоли
        Scanner scanner = new Scanner(System.in);
        //Ввод первого числа и проверка валидности введенного числа
        num1 = Validator.validateInputNumber(scanner.next());

        //Бесконечный цикл, чтобы выполнение программы не прывалось
        while (true){

            //Создание строки, которая будет хранить введенную операцию
            String oper = "";
            //Вывод на экран информационного сообщения
            System.out.println("Input operation:");
            //Создание объекта класса сканер, который считывает операцию с консоли
            Scanner scanner1 = new Scanner(System.in);
            //Ввод операции вычисления и проверка валидности
            oper = Validator.validateInputOperation(scanner1.next());

            //Создание строки, которая будет хранит второе число
            String num2 = "";
            //Вывод на экран информационного сообщения
            System.out.println("Input number №2:");
            //Создание объекта класса сканер, который считывает второе число с консоли
            Scanner scanner2 = new Scanner(System.in);
            //Ввод второго числа и проверка валидности
            num2 = Validator.validateInputNumber(scanner2.next());

            //Ветвление операций вычисления
            switch (oper) {
                case "+":
                    num1 = concatenator.plusString(num1, num2);
                    break;
                case "-":
                    num1 = concatenator.minusString(num1, num2);
                    break;
                case "/":
                    num1 = concatenator.divisionString(num1, num2);
                    break;
                case "*":
                    num1 = concatenator.multiplictionString(num1, num2);
                    break;
            }
        }
    }
}
