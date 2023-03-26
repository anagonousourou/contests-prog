public class BankAccount {
    private boolean opened = false;
    private int balance = 0;
    public synchronized void open(){
        this.opened = true;
    }
    public synchronized void close(){
        this.opened = false;
    }

    public synchronized int getBalance() throws BankAccountActionInvalidException {
        if(!this.opened){
            throw new BankAccountActionInvalidException("Account closed");
        }
        return balance;
    }

    public synchronized void deposit(int amount) throws BankAccountActionInvalidException {
        if(!this.opened){
            throw new BankAccountActionInvalidException("Account closed");
        }
        if(amount < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        this.balance += amount;
    }

    public synchronized void withdraw(int amount) throws BankAccountActionInvalidException {
        if(!this.opened){
            throw new BankAccountActionInvalidException("Account closed");
        }
        if(amount < 0){
            throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
        }
        if(this.balance <= 0){
            throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
        }
        else if(this.balance < amount){
            throw  new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
        }

        this.balance -= amount;
    }
}
