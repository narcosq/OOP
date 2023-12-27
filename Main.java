class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public double withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Cannot withdraw " + amount);
        } else {
            balance -= amount;
            return balance;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Account myAccount = new Account(1000);

            double withdrawalAmount = 1500;
            double remainingBalance = myAccount.withdraw(withdrawalAmount);

            System.out.println("Withdrawal successful. Remaining balance: " + remainingBalance);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
