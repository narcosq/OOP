class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(double balance, double withdrawalAmount) {
        super("Insufficient balance. Current balance: " + balance + ", Withdrawal amount: " + withdrawalAmount);
    }
}

class Account {
    private double balance;

    public Account(double initialBalance) {
        this.balance = initialBalance;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException(balance, amount);
        } else {
            balance -= amount;
            System.out.println("Withdrawal of " + amount + " successful. Remaining balance: " + balance);
        }
    }
}

public class AccountManagementDemo {
    public static void main(String[] args) {
        try {
            // Create an Account object with initial balance
            Account myAccount = new Account(1000);

            // Try to withdraw an amount larger than the balance
            double withdrawalAmount = 1500;
            myAccount.withdraw(withdrawalAmount);

        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
