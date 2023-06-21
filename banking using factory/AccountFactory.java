class AccountFactory {
    public static Account getAccount(String accountType) {
        if (accountType.equalsIgnoreCase("Bank")) {
            return new BankAccount();
        }
        return null;
    }
}