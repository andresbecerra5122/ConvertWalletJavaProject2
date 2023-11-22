class CheckingAccount extends BankAccount {
    private double balance;
    private String currency;

    public CheckingAccount(double balance, String currency) {
        super(balance);
        this.balance = balance;
        this.currency = currency;
    }
    public void convertToSavings(double amount, SavingsAccount savingsAccount) {
        if (amount <= balance) {
            balance -= amount;
            savingsAccount.deposit(amount);
            System.out.println("Conversion to savings account successful.");
        } else {
            System.out.println("Insufficient funds for conversion.");
        }
    }
}
