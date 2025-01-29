package bankKata;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option;
        int amount=0;
        Account account = new Account();
        Scanner sc = new Scanner(System.in);
        String options = """
                1- withdraw amount
                2- deposit
                3- print statement
                4- exit \n
                """;
        while (true) {
            System.out.println(options);
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Enter amount to withdraw: ");
                    amount=sc.nextInt();
                    account.withdraw(amount);
                    break;
                case 2:
                    System.out.println("Enter amount to deposit: ");
                    amount=sc.nextInt();
                    account.deposit(amount);
                    break;
                case 3:
                    account.printStatement();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("please enter a valid option");
            }
        }
    }
}