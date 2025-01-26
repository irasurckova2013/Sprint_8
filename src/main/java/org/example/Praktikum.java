import org.example.Account;

public class Praktikum {

    public static void main(String[] args) {
        // Тестируемая строка
        String testName = "Тимоти Шаламе";

        // Создаем экземпляр класса Account
        Account account = new Account(testName);

        // Проверяем, можно ли использовать имя и фамилию для печати на банковской карте
        boolean canEmboss = account.checkNameToEmboss();

        // Выводим результат проверки
        if (canEmboss) {
            System.out.println("Имя и фамилия подходят для печати на карте.");
        } else {
            System.out.println("Имя и фамилия не подходят для печати на карте.");
        }
    }
}