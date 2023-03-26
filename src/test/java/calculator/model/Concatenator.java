package model;

import calculator.exception.BadNumberValue;

/**
 * Класс конкатенатор хранит в себе операции вычисления
 */
public class Concatenator {

    /**
     * Метод, складывающий два введенных числа и возвращающий сумму
     * @param number1 первое введенное число либо результат предыдущих вычислений
     * @param number2 второе введенное число
     * @return результат сложения
     */
    public String plusString (String number1, String number2) {
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
        a += b;
        number1 = Integer.toString(a);
        System.out.println("Результат вычисления: " + number1);
        System.out.println("-----------------------");
        return number1; }

    /**
     * Метод, вычитающий из первого числа второе и возвращающий результат
     * @param number1 первое введенное число либо результат предыдущих вычислений
     * @param number2 второе введенное число
     * @return результат вычисления
     */
    public String minusString (String number1, String number2) {
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
        a -= b;
        number1 = Integer.toString(a);
        System.out.println("Результат вычисления: " + number1);
        System.out.println("-----------------------");
        return number1; }

    /**
     * Метод, умножающий два числа и возвращающий результат
     * @param number1 первое введенное число либо результат предыдущих вычислений
     * @param number2 второе введенное число
     * @return результат вычислений
     */
    public String multiplictionString (String number1, String number2) {
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
        a *= b;
        number1 = Integer.toString(a);
        System.out.println("Результат вычисления: " + number1);
        System.out.println("-----------------------");
        return number1; }

    /**
     * Метод, делящий два числа и возвращающий результат
     * @param number1 первое введенное число либо результат предыдущих вычислений
     * @param number2 второе введенное число
     * @return результат вычислений
     */
    public String divisionString (String number1, String number2) {
        int a = Integer.parseInt(number1);
        int b = Integer.parseInt(number2);
        if (b == 0) {
           throw new BadNumberValue("Делить на ноль нельзя"); }
        else {
            a /= b;
            number1 = Integer.toString(a);
            System.out.println("Результат вычисления: " + number1);
            System.out.println("-----------------------");
            return number1;  }
        }
   }

