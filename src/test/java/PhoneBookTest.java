import org.junit.jupiter.api.Test;
import ru.netology.PhoneBook;

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
}