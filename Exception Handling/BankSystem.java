public class BankSystem {
int balance = 10000;
public void withdraw(int amount) {
try {
if (amount > balance) {
throw new InsufficientBalanceException("Insufficient balance");
}
balance = balance - amount;
System.out.println("Amount withdrawn successfully: " + balance);

} catch (InsufficientBalanceException e) {
System.out.println("Exception handled inside method: " + e.getMessage());
}
}
public static void main(String[] args) {

BankSystem bs = new BankSystem();
bs.withdraw(200000);
System.out.println("Program continues...");
}
}
