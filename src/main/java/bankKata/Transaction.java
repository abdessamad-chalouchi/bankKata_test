package bankKata;

import java.time.LocalDate;

public class Transaction {
    private final LocalDate transactionDate;
    private final int amount;
    private final int balance;
    public Transaction(LocalDate transactionDate, int amount, int balance) {
        this.transactionDate = transactionDate;
        this.amount = amount;
        this.balance = balance;
    }
    public Transaction(int amount, int balance) {
        this.transactionDate = LocalDate.now();
        this.amount = amount;
        this.balance = balance;
    }
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    public int getAmount() {
        return amount;
    }
    public int getBalance() {
        return balance;
    }
}
