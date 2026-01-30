class AllLoopExampleDemo{

public static void main(String args[])  // main method
{
   
 System.out.println("While loop Example: " );  

 int i=1;
  while(i<=20){
System.out.println(i+ "");
i++;
}
 System.out.println("Do - While loop Example: " );  //
 
 int j=0;
 do{
     System.out.println(j);
     j++;
 }
 while(j<=20);


 System.out.println("For loop Example: " );  //
 for(int p= 1;p<=5;p++){
     for(int k=1; k<=5;k++){
          System.out.print("*" );  //

     }
               System.out.println();  //

     
 }
 
  System.out.println("For-Each loop Example: " );  //
  int arr[]  = {10,20,30,40};
 
  for(int num: arr){
        System.out.println(num);  //

     
  }


}
}