package com.gla.Map;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Set;
public class MapPractice {
    public static void main (String[]args){
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(1,98);
        hm.put(5,76);
        hm.put(0,22);
        hm.put(11,99);
        System.out.println("----------HASHMAP----------");
        System.out.println(hm);
        System.out.println(hm.keySet());
        System.out.println(hm.values());
        Set<Integer> s =hm.keySet();
        System.out.println("key set : "+s);
        System.out.println(hm.values());
        System.out.println("====== key set=======");
        for(int a:hm.keySet()) {
            System.out.println(a);
        }
        System.out.println("-----values-----");
        for(int b:hm.values()){
            System.out.println(b);
        }
        System.out.println(hm.entrySet());
        System.out.println("========ITERATE VALUES========");
        for(int key : hm.keySet()) { // syntax :  for(DataType variable : mapName.values()) {
            // use variable }
            System.out.println(hm.get(key));
        }


        LinkedHashMap<String,String> lm= new LinkedHashMap<>();
        TreeMap<Integer,String> tm= new TreeMap<>();
    }
}
