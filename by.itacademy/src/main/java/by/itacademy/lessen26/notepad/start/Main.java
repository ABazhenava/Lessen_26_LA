package by.itacademy.lessen26.notepad.start;

import by.itacademy.lessen26.notepad.controller.Controller;

import java.io.FileNotFoundException;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Controller contr = new Controller();
       // String fileName = "notes.txt";

        String request;
        String response;

        request = "ADD\ntitle=Номер один\nсоntent=Первая запись по списку";
        response = contr.doAction(request);
        System.out.println(response);

        request = "ADD\ntitle=Номер два\nсоntent=Вторая запись по списку";
        response = contr.doAction(request);
        System.out.println(response);


        request = "UPDATE\nid=1\ntitle=Номер один\ncontent=Новая запись по списку\ndate=2025-01-16";
        response = contr.doAction(request);
        System.out.println(response);
        //response = contr.doAction("add ");


//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("\nМеню:");
//            System.out.println("1. Добавить запись в блокнот");
//            System.out.println("2. Найти записи в блокноте по содержимому");
//            System.out.println("3. Найти записи в блокноте по дате создания");
//            System.out.println("4. Показать все записи в блокноте");
//            System.out.println("5. Выход");
//            System.out.print("Выберите пункт от 1 до 5: ");
//            int enterValue = scanner.nextInt();
//            scanner.nextLine();
//
//            switch (enterValue) {
//                case 1:
//                    System.out.print("Введите запись: ");
//                    String content = scanner.nextLine();
//                    AddNoteCommand add = new AddNoteCommand();
//                    add.execute(request);
//
//                    System.out.println("Запись в блокнот добавлена.");
//                    break;
//                case 2:
//                    System.out.print("Введите текст для поиска: ");
//                    String searchText = scanner.nextLine();
//                    ///
//                    break;
//                case 3:
//                    System.out.print("Введите дату создания записи для поиска (YYYY-MM-DD): ");
//                    String dateStr = scanner.nextLine();
//                    LocalDateTime searchDate = LocalDateTime.parse(dateStr + "T00:00:00");
//                    List<Note> foundNotesByDate;
////
//                    break;
//                case 4:
//
//                    break;
//                case 5:
//                    System.out.println("Выход.");
//                    scanner.close();
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("\nВы ввели неправильное значение!!!! Попробуйте еще раз.");
            }
        }






