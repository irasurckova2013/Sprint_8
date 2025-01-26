import io.qameta.allure.Step;
import jdk.jfr.Description;
import org.example.Account;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class AccountTest {

    @Step("Проверка валидного имени")
    @Description("Тест проверяет, что валидное имя и фамилия проходят проверку.")
    @Test
    public void testValidName() {
        Account account = new Account("Тимоти Шаламе");
        assertTrue(account.checkNameToEmboss());
    }

    @Step("Проверка слишком короткого имени")
    @Description("Тест проверяет, что имя длиной менее 3 символов не проходит проверку.")
    @Test
    public void testTooShortName() {
        Account account = new Account("Тим");
        assertFalse(account.checkNameToEmboss());
    }

    @Step("Проверка слишком длинного имени")
    @Description("Тест проверяет, что имя длиной более 19 символов не проходит проверку.")
    @Test
    public void testTooLongName() {
        Account account = new Account("Тимоти Шаламе и его друг");
        assertFalse(account.checkNameToEmboss());
    }

    @Step("Проверка имени без пробела")
    @Description("Тест проверяет, что имя без пробела не проходит проверку.")
    @Test
    public void testNoSpace() {
        Account account = new Account("ТимотиШаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Step("Проверка имени с несколькими пробелами")
    @Description("Тест проверяет, что имя с несколькими пробелами не проходит проверку.")
    @Test
    public void testMultipleSpaces() {
        Account account = new Account("Тимоти  Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Step("Проверка пробела в начале имени")
    @Description("Тест проверяет, что имя с пробелом в начале не проходит проверку.")
    @Test
    public void testSpaceAtStart() {
        Account account = new Account(" Тимоти Шаламе");
        assertFalse(account.checkNameToEmboss());
    }

    @Step("Проверка пробела в конце имени")
    @Description("Тест проверяет, что имя с пробелом в конце не проходит проверку.")
    @Test
    public void testSpaceAtEnd() {
        Account account = new Account("Тимоти Шаламе ");
        assertFalse(account.checkNameToEmboss());
    }
}