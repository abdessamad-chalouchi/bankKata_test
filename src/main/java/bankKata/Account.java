package bankKata;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account implements AccountService{
//    private final List<Transaction> transactions;
    private final List<Transaction> transactions = new ArrayList<>();
    private final DateProvider dateProvider;
    private int balance = 0;
    // Constructor for production (uses real dates)
    public Account() {
        this.dateProvider = new SystemDateProvider();
    }
    public Account(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public void deposit(int amount) {
        balance += amount;
        transactions.add(new Transaction(dateProvider.getCurrentDate(), amount, balance));
    }
    @Override
    public void withdraw(int amount) {
        if (balance - amount < 0) {
//            throw new IllegalStateException("exceeded balance");
            System.out.println("operation not allowed");
            return;
        }
        balance -= amount;
        transactions.add(new Transaction(dateProvider.getCurrentDate(), -amount, balance));
    }
    @Override
    public void printStatement() {
        // Reverse transactions for "most recent first" order
        List<Transaction> reversed = new ArrayList<>(transactions);
        Collections.reverse(reversed);

        // Format header and transactions
        StringBuilder statement = new StringBuilder("date       || amount  || balance\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (Transaction t : reversed) {
            String date = t.getTransactionDate().format(formatter);
            String amount = String.format("%d", t.getAmount());
            String balance = String.format("%d", t.getBalance());

            statement.append(String.format("%s || %4s || %s\n", date, amount, balance));
        }

        System.out.println(statement.toString().trim());
    }
}
