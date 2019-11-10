import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Pattern;

/**Написать программу, в которой будет храниться перечень e-mail-ов. E-mail’ы  можно добавлять через консоль командой ADD
 и печатать весь список командой LIST.
 * Проверять корректность вводимых e-mail’ов и в случае необходимости печатать сообщение об ошибке.**/

public class Main {
    private static final Pattern ADD_MAIL = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$");

    public static boolean isADD(String email) {
        return ADD_MAIL.matcher(email).matches();
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TreeSet<String> mails = new TreeSet<>();

        for (;;){
            System.out.println("Введите команду:");
            String command = scanner.nextLine();
            if (command.equals("ADD"))
            {
                System.out.println("Пожалуйста введите E-mail:");
                command = scanner.nextLine();
                if (isADD(command)) {
                    mails.add(command);
                }
                //else
               //     System.out.println("Извените, вы ввели некорректный электронный адрес!");

            } else if (command.equals("LIST")) {
                System.out.println("Список электронный адресов:");
                for (String mail : mails) {
                    System.out.println(mail);
                }
            } else {
                System.out.println("Вы ввели неверную команду!");
            }
        }
    }
}
