public class Mythread implements Runnable{
public void run() {
for (int i=1; i<=10; i++){
System.out.println("Number : "+i);
}
}
public static void main (String[] args){
Mythread t1= new Mythread(); // Creates Runnable object
// t1.start();  WRONG! Runnable has NO start() method
Thread tt1=new Thread (t1);// Wraps Runnable in Thread object
tt1.start();//  CORRECT! Thread has start() method
}
}
