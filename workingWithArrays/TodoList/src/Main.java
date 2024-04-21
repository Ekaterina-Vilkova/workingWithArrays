import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String LIST; //выводит дела с их порядковыми номерами;
//        String ADD; //добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер; если указан несуществующий индекс - добавить в конец списка.
//        String EDIT; // заменяет дело с указанным номером; если указан несуществующий индекс - ничего не делать.
//        String DELETE; // удаляет; если указан несуществующий индекс - ничего не делать.

        TodoList2 todoList2 = new TodoList2();
        System.out.println("Введите команду:");
        while (true) {
            String text = new Scanner(System.in).nextLine();
            String result = "";

            String[] word = text.split("\s");
            if (word[0].equals("ADD")) {
                String[] withoutFirstWord = Arrays.copyOfRange(word, 1, word.length);
                String textWithoutFirstWord = Arrays.toString(withoutFirstWord).replaceAll("\\[|\\]|,", "");
                if (todoList2.list.isEmpty()) {
                    System.out.println("Список дел был пуст");
                    String withoutIndex = textWithoutFirstWord.replaceAll(withoutFirstWord[0], "");
                    todoList2.addNewDeal(null, withoutIndex);
                    result = "Добавлено дело" + " \"" + withoutIndex.trim() + "\"" + " под номером 0";

                } else if (withoutFirstWord[0].matches("[0-9]{1,}") && Integer.valueOf(withoutFirstWord[0]) > todoList2.list.size()) {
                    String withoutIndex = textWithoutFirstWord.replaceAll(withoutFirstWord[0], "");
                    todoList2.addNewDeal(null, withoutIndex);
                    result = "Добавлено дело" + " \"" + withoutIndex.trim() + "\"" + " в конец списка";

                } else if (withoutFirstWord.length > 0 && withoutFirstWord[0].matches("[0-9]{1,}")) {
                    String withoutIndex = textWithoutFirstWord.replaceAll(withoutFirstWord[0], "");
                    todoList2.addNewDeal(Integer.valueOf(withoutFirstWord[0]), withoutIndex);
                    result = "Добавлено дело" + " \"" + withoutIndex.trim() + "\" " + "под номером " + Integer.valueOf(withoutFirstWord[0]);
                } else {
                    todoList2.addNewDeal(null, textWithoutFirstWord);
                    result = "Добавлено дело" + " \"" + textWithoutFirstWord.trim() + "\"";
                }
                System.out.println(result);
            }
            if (word[0].equals("EDIT") && word[1].matches("[0-9]{1,}")) {
                if (Integer.valueOf(word[1]) > todoList2.list.size()) {
                    System.out.println("Дело с таким номером не существует");
                } else {
                    String previousDeal = todoList2.list.get(Integer.valueOf(word[1]));
                    String[] withoutFirstWord = Arrays.copyOfRange(word, 2, word.length);
                    String textWithoutFirstWord = Arrays.toString(withoutFirstWord).replaceAll("\\[|\\]|,", "");
                    todoList2.editDeal(Integer.valueOf(word[1]), textWithoutFirstWord);
                    result = "Дело" + " \"" + previousDeal.trim() + "\" " + "заменено на " + "\"" + textWithoutFirstWord.trim() + "\" ";
                    System.out.println(result);
                }
            }
            if (word.length == 2 && word[0].equals("DELETE") && word[1].matches("[0-9]{1,}")) {
                int transmitted = Integer.parseInt(word[1]);
                int all = todoList2.list.size();
                if (transmitted > all) {
                    System.out.println("Дело с таким номером не существует");
                } else {
                    String previousDeal = todoList2.list.get(Integer.valueOf(word[1]));
                    todoList2.deleteDeal(Integer.valueOf(word[1]));
                    result = "Дело" + " \"" + previousDeal.trim() + "\" " + "удалено";
                    System.out.println(result);
                }
            }
            if (word.length == 1 && word[0].equals("LIST")) {
                todoList2.listAllDeal();
            }
        }
    }
}
