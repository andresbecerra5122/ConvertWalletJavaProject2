class ConvertAccount extends BankAccount {
    private double balance;
    private String currency;
    private Converter converter;

    public ConvertAccount(double balance, String currency) {
        super(balance);
        this.balance = balance;
        this.currency = currency;
        this.converter = new Converter();
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit made. Current balance: " + balance + " " + currency);
    }

    public void withdraw(double amount, String withdrawalCurrency) {
        if (amount <= balance) {
            double withdrawnAmount = converter.convert(amount, withdrawalCurrency, currency);
            balance -= withdrawnAmount;
            System.out.println("Withdrawal made. Amount withdrawn: " + withdrawnAmount + " " + currency +
                    ". Current balance: " + balance + " " + currency);
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public void convertToCurrency(double amount, String targetCurrency) {
        double convertedAmount = converter.convert(amount, currency, targetCurrency);
        balance -= amount;
        System.out.println("Conversion made. Amount converted: " + amount + " " + currency +
                " to " + convertedAmount + " " + targetCurrency + ". Current balance: " + balance + " " + currency);
    }

    public void receiveFundsFromChecking(double amount, String checkingCurrency) {
        // Convert the amount to the account's currency
        double convertedAmount = converter.convert(amount, checkingCurrency, currency);

        // Add the converted amount to the account's balance
        balance += convertedAmount;

        System.out.println("Funds received from CheckingAccount: " + convertedAmount + " " + currency +
                ". Current balance: " + balance + " " + currency);
    }
}
