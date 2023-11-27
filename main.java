class InsufficientBalanceException(Exception):
    def __init__(self, balance, withdrawal_amount):
        self.balance = balance
        self.withdrawal_amount = withdrawal_amount
        super().__init__(f"Insufficient balance. Current balance: {balance}, Withdrawal amount: {withdrawal_amount}")

class Account:
    def __init__(self, initial_balance=0):
        self.balance = initial_balance

    def withdraw(self, amount):
        if amount > self.balance:
            raise InsufficientBalanceException(self.balance, amount)
        else:
            self.balance -= amount
            print(f"Withdrawal of {amount} successful. Remaining balance: {self.balance}")

try:
    my_account = Account(initial_balance=1000)

    withdrawal_amount = 1500
    my_account.withdraw(withdrawal_amount)

except InsufficientBalanceException as e:
    print(f"Error: {e}")

except Exception as e:
    print(f"An unexpected error occurred: {e}")
