public class TreadwithSleep extends Threads {
public void run (){
try {
System.out.println("Task 1: Numbers");
for(int i= 1; i<=5; i++){
System.out.println(i);
Thread.sleep(500);
}
}
catch (InterruptedException e){
System.out.println(e);
}
}
}
class Task22 extends Thread{
public void run() {
try {
System.out.println("Task 2: Alphabets");
for (char c = 'A'; c <= 'E'; c++) {
System.out.println(c);
Thread.sleep(700); // pause 0.7 sec
}
} catch (InterruptedException e) {
System.out.println(e);
}
}



public static void main(String[] args) {

TreadwithSleep s1 = new TreadwithSleep();
Task22 t2 = new Task22();
s1.start();
t2.start();
}
}
