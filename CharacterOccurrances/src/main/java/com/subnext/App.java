package com.subnext;

import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public Map<Character, Integer> findOccurances(String inputString){
        Map<Character, Integer> storage = new HashMap<Character, Integer>();

        if (inputString == null || inputString.length() == 0)
            return storage;

        char[] charArray = inputString.toCharArray();
        for(char c: charArray){
            if (storage.containsKey(c)){
                //Increment the value
                storage.put(c, storage.get(c)+1);
            }
            else {
                //Set the value
                storage.put(c, 1);
            }
        }
        return storage;
    }
}
