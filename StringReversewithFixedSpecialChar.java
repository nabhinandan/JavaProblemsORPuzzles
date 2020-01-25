package com.sample.String;

public class StringReversewithFixedSpecialChar
{
    public static void main(String[] args)
    {
        String str1 = new String("d#,b$g,c$#");
        
        char[] chararray = str1.toCharArray();
        int leftindex = 0;
        int rightindex = chararray.length - 1;
        while(leftindex < rightindex)
        {
            if(!Character.isAlphabetic(chararray[leftindex]))
            {
                leftindex++;
            }
            if(!Character.isAlphabetic(chararray[rightindex]))
            {
                rightindex--;
            }
            if(Character.isAlphabetic(chararray[rightindex]) && Character.isAlphabetic(chararray[leftindex]))
            {
                Character tempChar = chararray[rightindex];
                chararray[rightindex] = chararray[leftindex];
                chararray[leftindex] = tempChar;
                leftindex++;
                rightindex--;
            }
            
        }
        for(int i = 0; i < chararray.length; i++)
        {
            System.out.print(chararray[i]);
        }
    }
}
