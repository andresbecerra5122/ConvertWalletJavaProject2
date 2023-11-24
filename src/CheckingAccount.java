class CheckingAccount extends BankAccount {
    private double balance;
    private String currency;

    public CheckingAccount(double balance, String currency) {
        super(balance);
        this.balance = balance;
        this.currency = currency;
    }
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit made. Current balance: " + balance);
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

    public void convertToConvert(double amount, String currency,
                                 ConvertAccount convertAccount)
    {
        if(convertAccount.getCurrency() == currency)
        {
           convertAccount.convertToCurrency(amount,currency);
        }
        else {
            System.out.println("Not Same Currency as Current Currency for ConvertAccount, \n" +
                    "Please empty the convert account or change the currency inside the convert account");
        }
    }
}
