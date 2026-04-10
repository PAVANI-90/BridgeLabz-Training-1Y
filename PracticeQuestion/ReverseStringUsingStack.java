package com.gla.PracticeQuestion;
import java.util.*;
public class ReverseStringUsingStack {
    public static void main(String[] args){
        String s ="Hello";
        Stack<Character>st=new Stack<>();
        for(char c :s.toCharArray()){
            st.push(c);
        }
        String rev = "";
        while(!st.isEmpty()){
            rev += st.pop();
        }
        System.out.println("Original String: "+ s);
        System.out.println("Reverse String: "+ rev);
    }
}
