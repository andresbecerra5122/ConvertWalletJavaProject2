class SavingsAccount extends BankAccount {
    public SavingsAccount(double balance) {
        super(balance);
    }

    public void ConvertToChecking(double amount, CheckingAccount checkingAccount) {
        if (amount <= balance) {
            balance -= amount;
            checkingAccount.deposit(amount);
            System.out.println("Conversion to savings account successful.");
        } else {
            System.out.println("Insufficient funds for conversion.");
        }
    }

    public void ConvertToConvert(double amount,String currency,
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