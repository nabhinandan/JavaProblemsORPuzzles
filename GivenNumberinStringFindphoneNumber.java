package com.sample.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
Create by : Abhinandan N
Problem: Find the phone number from the given shuffeled string and arrange it in assending order.
Example: I/P: ZVEESENFIROVE O/P: 057
*/
public class GivenNumberinStringFindphoneNumber
{
    static ArrayList<Integer> PhoneNumber1 = new ArrayList<>();
    static ArrayList<Integer> PhoneNumber = new ArrayList<>();
    
    /*
    From the stringbuilder deleted the characters which are already identified and converted to number
    */
    private static void popElements(char[] array, StringBuilder str)
    {
        for(int i = 0; i < array.length; i++)
        {
            int index = str.indexOf(Character.toString(array[i]));
            str.deleteCharAt(index);
        }
    }
    /*
    Iterate through the String builder and identify the unique characters of a number in the Stringbuilder.
    Example: 'z' char can only be found in 'zero'.
    add the phone number to the list and delete the characters from the String builder until the Stringbuilder is empty.
    */
    private static void FindPhoneNumber(StringBuilder str_phoneNumber)
    {
        
        long start = System.currentTimeMillis();
        while(str_phoneNumber.length() > 0)
        {
            if(str_phoneNumber.indexOf("u") >= 0)
            {
                PhoneNumber.add(4);
                char[] number = new String("four").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("w") >= 0)
            {
                PhoneNumber.add(2);
                char[] number = new String("two").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("x") >= 0)
            {
                PhoneNumber.add(6);
                char[] number = new String("six").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("z") >= 0)
            {
                PhoneNumber.add(0);
                char[] number = new String("zero").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("g") >= 0)
            {
                PhoneNumber.add(8);
                char[] number = new String("eight").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("r") >= 0 && str_phoneNumber.indexOf("u") < 0 && str_phoneNumber.indexOf("z") < 0)
            {
                PhoneNumber.add(3);
                char[] number = new String("three").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("f") >= 0 && str_phoneNumber.indexOf("u") < 0)
            {
                PhoneNumber.add(5);
                char[] number = new String("five").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("v") >= 0 && str_phoneNumber.indexOf("f") < 0)
            {
                PhoneNumber.add(7);
                char[] number = new String("seven").toCharArray();
                popElements(number, str_phoneNumber);
            }
            if(str_phoneNumber.indexOf("i") >= 0 && str_phoneNumber.indexOf("v") < 0 && str_phoneNumber.indexOf("x") < 0 && str_phoneNumber.indexOf("g") < 0)
            {
                PhoneNumber.add(9);
                char[] number = new String("nine").toCharArray();
                popElements(number, str_phoneNumber);
            }
            
            if(str_phoneNumber.indexOf("o") >= 0 && str_phoneNumber.indexOf("w") < 0 && str_phoneNumber.indexOf("u") < 0 && str_phoneNumber.indexOf("z") < 0)
            {
                PhoneNumber.add(1);
                char[] number = new String("one").toCharArray();
                popElements(number, str_phoneNumber);
            }
        }
        
        long end = System.currentTimeMillis();
        
        Collections.sort(PhoneNumber);
        System.out.println(PhoneNumber);
        long timeElapsed = end - start;
        System.out.println("Total Time Taken by looping through String and poping = " + timeElapsed);
    }
    
    //Add identified phone number to the list
    private static void addPhoneNumber(int count, int phonenumber)
    {
        while(count > 0)
        {
            PhoneNumber1.add(phonenumber);
            count--;
        }
    }
    
    /*
    1.Convert String builder to char array.
    2. Iterate through the Char array and add each char to hashmap and maintain the count of the characters present in the char array.
    3. find the unique character which can be present in the number, example: 'z' is only present in 'zero'.
    4. find the number of times each unique char of a number present in the map and add it to the list.
    */
    private static void FindPhoneNumber1(StringBuilder str_phoneNumber)
    {
        Map<Character,Integer> charCount = new HashMap<>();
        char[] charArray = str_phoneNumber.toString().toCharArray();
        
        for(Character ch : charArray)
        {
            if(!charCount.containsKey(ch))
            {
                charCount.put(ch, 1);
            }
            else
            {
                charCount.put(ch, charCount.get(ch) + 1);
            }
        }
        long start = System.currentTimeMillis();
        if(charCount.containsKey('z') && charCount.get('z') > 0)
        {
            int count = charCount.get('z');
            charCount.put('z', charCount.get('z') - count);
            charCount.put('e', charCount.get('e') - count);
            charCount.put('r', charCount.get('r') - count);
            charCount.put('o', charCount.get('o') - count);
            addPhoneNumber(count, 0);
        }
        if(charCount.containsKey('w') && charCount.get('w') > 0)
        {
            int count = charCount.get('w');
            charCount.put('t', charCount.get('t') - count);
            charCount.put('w', charCount.get('w') - count);
            charCount.put('o', charCount.get('o') - count);
            addPhoneNumber(count, 2);
        }
        if(charCount.containsKey('u') && charCount.get('u') > 0)
        {
            int count = charCount.get('u');
            charCount.put('f', charCount.get('f') - count);
            charCount.put('o', charCount.get('o') - count);
            charCount.put('u', charCount.get('u') - count);
            charCount.put('r', charCount.get('r') - count);
            addPhoneNumber(count, 4);
        }
        if(charCount.containsKey('x') && charCount.get('x') > 0)
        {
            int count = charCount.get('x');
            charCount.put('s', charCount.get('s') - count);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('x', charCount.get('x') - count);
            addPhoneNumber(count, 6);
        }
        if(charCount.containsKey('f') && charCount.get('f') > 0)
        {
            int count = charCount.get('f');
            charCount.put('f', charCount.get('f') - count);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('v', charCount.get('v') - count);
            charCount.put('e', charCount.get('e') - count);
            addPhoneNumber(count, 5);
        }
        if(charCount.containsKey('v') && charCount.get('v') > 0)
        {
            int count = charCount.get('v');
            charCount.put('s', charCount.get('s') - count);
            charCount.put('e', charCount.get('e') - count*2);
            charCount.put('v', charCount.get('v') - count);
            charCount.put('n', charCount.get('n') - count);
            addPhoneNumber(count, 7);
        }
        if(charCount.containsKey('g') && charCount.get('g') > 0)
        {
            int count = charCount.get('g');
            charCount.put('e', charCount.get('e') - count);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('g', charCount.get('g') - count);
            charCount.put('h', charCount.get('h') - count);
            charCount.put('t', charCount.get('t') - count);
            addPhoneNumber(count, 8);
        }
        if(charCount.containsKey('i') && charCount.get('i') > 0)
        {
            int count = charCount.get('i');
            charCount.put('n', charCount.get('n') - count*2);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('e', charCount.get('e') - count);
            addPhoneNumber(count, 9);
        }
        if(charCount.containsKey('o') && charCount.get('o') > 0)
        {
            int count = charCount.get('o');
            charCount.put('o', charCount.get('o') - count);
            charCount.put('n', charCount.get('n') - count);
            charCount.put('e', charCount.get('e') - count);
            addPhoneNumber(count, 1);
        }
        if(charCount.containsKey('h') && charCount.get('h') > 0)
        {
            int count = charCount.get('h');
            charCount.put('t', charCount.get('t') - count);
            charCount.put('h', charCount.get('h') - count);
            charCount.put('r', charCount.get('r') - count);
            charCount.put('e', charCount.get('e') - count*2);
            addPhoneNumber(count, 3);
        }
        long end = System.currentTimeMillis();
        long timeElapsed = end - start;
        System.out.println("Total Time Taken by using hasmap and subtracting elements in map = " + timeElapsed);
        
        Collections.sort(PhoneNumber1);
        System.out.println(PhoneNumber1);
    }
    
    public static void main(String ar[])
    {
        StringBuilder str_phoneNumber = new StringBuilder("reefiineneeeightzethrrosixothvneesfouevenr");
        StringBuilder str_phoneNumber1 = new StringBuilder("reefiineneeeightzethrrosixothvneesfouevenr");
        FindPhoneNumber(str_phoneNumber);
        FindPhoneNumber1(str_phoneNumber1);
    }
}
