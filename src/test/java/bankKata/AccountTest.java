package bankKata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccountTest {
    @Test
    public void acceptanceTest() {
        // Mock dates for 10-01-2012, 13-01-2012, 14-01-2012
        DateProvider mockDateProvider = new MockDateProvider(List.of(
                LocalDate.of(2012, 1, 10),
                LocalDate.of(2012, 1, 13),
                LocalDate.of(2012, 1, 14)
        ));

        Account account = new Account(mockDateProvider);
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);

        String expected = """
            date       || amount  || balance
            14/01/2012 || -500 || 2500
            13/01/2012 || 2000 || 3000
            10/01/2012 || 1000 || 1000""";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        account.printStatement();
        System.setOut(originalOut);
        String actualOutput = outputStream.toString().trim();
        assertEquals(expected, actualOutput);
    }
}