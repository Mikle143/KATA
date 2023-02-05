package Calculator;

import java.lang.reflect.Array;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int a=0;
        int b=0;
        int result=0;
        System.out.println("Введите одной строкой арифметическую операцию с двумя цифрами до 10");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();
        s=s.replaceAll("\\s","");
        String operation="";
        if (s.contains("+")){
            operation="+";
        } else if (s.contains("-")) {
            operation="-";
        } else if (s.contains("*")) {
            operation="*";
        }else if (s.contains("/")) {
            operation="/";
        }
        String[]numbers={};
        switch (operation){
            case "+":numbers=s.split("\\+");
            break;
            case "-":numbers=s.split("-");
            break;
            case "*":numbers=s.split("\\*");
            break;
            case "/":numbers=s.split("/");
            break;
            default: System.out.println("В операции используйте арифметический знак +, -, * или /");
            break;
        }
        if (numbers.length>2){
            System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            return;
        }
        if (numbers.length<2){
            System.out.println("строка не является математической операцией");
            return;
        }
        int counter_arabian=0;
        int counter_rome=0;
        String[]arabian_numbers={"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        for (String q:arabian_numbers){
            if (q.equals(numbers[0])) {
                a=Integer.parseInt(numbers[0]);
                counter_arabian++;
            }
            if (q.equals(numbers[1])){
                b=Integer.parseInt(numbers[1]);
                counter_arabian++;
            }
        }
        if(counter_arabian==2){
            switch (operation){
                case "+": result=a+b;
                    break;
                case "-":result=a-b;
                    break;
                case "*":result=a*b;
                    break;
                case "/":result=a/b;
                    break;
            }
        System.out.println(result);
        } else if (counter_arabian==1){
            System.out.println("введите числа от 1 до 10 в одной системе счисления");
        }

        for (Rome_numbers n:Rome_numbers.values()){
            if (n.name().equals(numbers[0])){
                a=n.arab_number;
                counter_rome++;
            }
        }
        for (Rome_numbers n:Rome_numbers.values()){
            if (n.name().equals(numbers[1])){
                b=n.arab_number;
                counter_rome++;
            }
        }
        if (counter_rome==2){
            switch (operation){
                case "+": result=a+b;
                    break;
                case "-":
                    if (a<b){
                        System.out.println("в римской системе нет отрицательных чисел");
                    } else result=a-b;
                    break;
                case "*":result=a*b;
                    break;
                case "/":result=a/b;
                    break;
            }
            System.out.println(converter(result));
        }
    }
    public static String converter(int result){
        String buf="";
        Rome_numbers[]rome_numbers=Rome_numbers.values();
        for (int i=rome_numbers.length-1; i>=0; i--){
            if (result>=rome_numbers[i].arab_number){
                buf+=rome_numbers[i].name();
                result-=rome_numbers[i].arab_number;
            }
        }return buf;
    }
}

