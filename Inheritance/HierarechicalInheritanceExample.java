
class Account {  // Common Parent
    String accountNumber;
    
    void deposit() {
        System.out.println("Money deposited in " + accountNumber);
    }
}

class SavingsAccount extends Account {  // Child 1
    void earnInterest() {
        System.out.println("Interest earned on savings");
    }
}

class CurrentAccount extends Account {  // Child 2
    void overdraft() {
        System.out.println("Overdraft allowed for current account");
    }
}

public class HierarechicalInheritanceExample {
    public static void main(String[] args) {
        // Savings Account
        SavingsAccount savings = new SavingsAccount();
        savings.accountNumber = "12345";
        savings.deposit();      // From Account
        savings.earnInterest(); // From Savings
        
        System.out.println();
        
        // Current Account  
        CurrentAccount current = new CurrentAccount();
        current.accountNumber = "67890";
        current.deposit();     // From Account  
        current.overdraft();   // From Current
    }
}
