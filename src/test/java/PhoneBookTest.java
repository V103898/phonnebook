import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PhoneBookTest {
    @Test
    public void testAddSingleContact() {
        PhoneBook phoneBook = new PhoneBook();
        int count = phoneBook.add("AHHA", "123");
        assertEquals(1, count);
    }

    @Test
    public void testAddDuplicateName() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AHHA", "123");
        int count = phoneBook.add("AHHA", "456"); // дубликат имени
        assertEquals(1, count); // размер не должен измениться
    }

    @Test
    public void testFindByNumberExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AHHA", "123");
        String name = phoneBook.findByNumber("123");
        assertEquals("AHHA", name);
    }

    @Test
    public void testFindByNumberNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AHHA", "123");
        String name = phoneBook.findByNumber("999"); // несуществующий номер
        assertNull(name);
    }

    @Test
    public void testFindByNameExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AHHA", "1234567890");

        String result = phoneBook.findByName("AHHA");

        assertEquals("1234567890", result);
    }

    @Test
    public void testFindByNameNonExisting() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("AHHA", "1234567890");

        String result = phoneBook.findByName("BoBa");

        assertNull(result);
    }
    @Test
    public void testPrintAllNamesReturnsSortedList() {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("BoBa", "456");
        phoneBook.add("AHHA", "123");
        phoneBook.add("ApTyp", "789");

        List<String> names = phoneBook.printAllNames();
        assertEquals(List.of("AHHA", "ApTyp", "BoBa"), names);
    }

    @Test
    public void testPrintAllNamesReturnsEmptyList() {
        PhoneBook phoneBook = new PhoneBook();
        List<String> names = phoneBook.printAllNames();
        assertTrue(names.isEmpty());
    }
}