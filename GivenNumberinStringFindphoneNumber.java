package com.sample.String;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class GivenNumberinStringFindphoneNumber
{
    private static void popElements(char[] array, StringBuilder str)
    {
        for(int i = 0; i < array.length; i++)
        {
            int index = str.indexOf(Character.toString(array[i]));
            str.deleteCharAt(index);
        }
    }
    
    private static void FindPhoneNumber(StringBuilder str_phoneNumber)
    {
        ArrayList<Integer> PhoneNumber = new ArrayList<Integer>();
        Instant start = Instant.now();
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
        
        Instant finish = Instant.now();
        
        Collections.sort(PhoneNumber);
        System.out.println(PhoneNumber);
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total Time Taken by looping through String and poping = " + timeElapsed);
    }
    
    private static void FindPhoneNumber1(StringBuilder str_phoneNumber)
    {
        Map<Character,Integer> charCount = new HashMap<>();
        char[] charArray = str_phoneNumber.toString().toCharArray();
        ArrayList<Integer> PhoneNumber = new ArrayList<>();
        
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
        Instant start = Instant.now();
        if(charCount.containsKey('z') && charCount.get('z')>0)
        {
            int count = charCount.get('z');
            charCount.put('z',charCount.get('z') - count);
            charCount.put('e',charCount.get('e') - count);
            charCount.put('r',charCount.get('r') - count);
            charCount.put('o',charCount.get('o') - count);
            while(count>0)
            {
                PhoneNumber.add(0);
                count--;
            }
        }
        if(charCount.containsKey('w') && charCount.get('w') > 0)
        {
            int count = charCount.get('w');
            charCount.put('t',charCount.get('t') - count);
            charCount.put('w',charCount.get('w') - count);
            charCount.put('o',charCount.get('o') - count);
            while(count>0)
            {
                PhoneNumber.add(2);
                count--;
            }
        }
        if(charCount.containsKey('u') && charCount.get('u')>0)
        {
            int count = charCount.get('u');
            charCount.put('f',charCount.get('f') - count);
            charCount.put('o',charCount.get('o') - count);
            charCount.put('u',charCount.get('u') - count);
            charCount.put('r',charCount.get('r') - count);
            while(count>0)
            {
                PhoneNumber.add(4);
                count--;
            }
        }
        if(charCount.containsKey('x') && charCount.get('x')>0)
        {
            int count = charCount.get('x');
            charCount.put('s',charCount.get('s') - count);
            charCount.put('i',charCount.get('i') - count);
            charCount.put('x',charCount.get('x') - count);
            while(count>0)
            {
                PhoneNumber.add(6);
                count--;
            }
        }
        if(charCount.containsKey('f') && charCount.get('f') > 0)
        {
            int count = charCount.get('f');
            charCount.put('f', charCount.get('f') - count);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('v', charCount.get('v') - count);
            charCount.put('e', charCount.get('e') - count);
            while(count > 0)
            {
                PhoneNumber.add(5);
                count--;
            }
        }
        if(charCount.containsKey('v') && charCount.get('v') > 0)
        {
            int count = charCount.get('v');
            charCount.put('s', charCount.get('s') - count);
            charCount.put('e', charCount.get('e') - count*2);
            charCount.put('v', charCount.get('v') - count);
            charCount.put('n', charCount.get('n') - count);
            while(count > 0)
            {
                PhoneNumber.add(7);
                count--;
            }
        }
        if(charCount.containsKey('g') && charCount.get('g') > 0)
        {
            int count = charCount.get('g');
            charCount.put('e', charCount.get('e') - count);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('g', charCount.get('g') - count);
            charCount.put('h', charCount.get('h') - count);
            charCount.put('t', charCount.get('t') - count);
            while(count > 0)
            {
                PhoneNumber.add(8);
                count--;
            }
        }
        if(charCount.containsKey('i') && charCount.get('i') > 0)
        {
            int count = charCount.get('i');
            charCount.put('n', charCount.get('n') - count*2);
            charCount.put('i', charCount.get('i') - count);
            charCount.put('e', charCount.get('e') - count);
            while(count > 0)
            {
                PhoneNumber.add(9);
                count--;
            }
        }
        if(charCount.containsKey('o') && charCount.get('o') > 0)
        {
            int count = charCount.get('o');
            charCount.put('o', charCount.get('o') - count);
            charCount.put('n', charCount.get('n') - count);
            charCount.put('e', charCount.get('e') - count);
            while(count > 0)
            {
                PhoneNumber.add(1);
                count--;
            }
        }
        if(charCount.containsKey('h') && charCount.get('h') > 0)
        {
            int count = charCount.get('h');
            charCount.put('t', charCount.get('t') - count);
            charCount.put('h', charCount.get('h') - count);
            charCount.put('r', charCount.get('r') - count);
            charCount.put('e', charCount.get('e') - count*2);
            while(count > 0)
            {
                PhoneNumber.add(3);
                count--;
            }
        }
        Instant finish = Instant.now();
        Collections.sort(PhoneNumber);
        System.out.println(PhoneNumber);
    
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("Total Time Taken by using hasmap and subtracting elements in map = " + timeElapsed);
    }
    
    public static void main(String ar[])
    {
        StringBuilder str_phoneNumber = new StringBuilder("reefiineneeeightzethrrosixothvneesfouevenr");
        StringBuilder str_phoneNumber1 = new StringBuilder("reefiineneeeightzethrrosixothvneesfouevenr");
        FindPhoneNumber(str_phoneNumber);
        FindPhoneNumber1(str_phoneNumber1);
    }
}
