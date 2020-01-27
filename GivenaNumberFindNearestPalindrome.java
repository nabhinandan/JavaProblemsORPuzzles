package com.sample.integer;

public class GivenaNumberFindNearestPalindrome
{
    public static void main(String[] args)
    {
        int number = 1;
        GivenaNumberFindNearestPalindrome classobj = new GivenaNumberFindNearestPalindrome();
        int less_num = classobj.decreseTheNumberCheckpalindrome(number);
        int more_num = classobj.increaseTheNumberCheckpalindrome(number);
        int diff_lessnum = number - less_num;
        int diff_morenum = more_num - number;
        
        if(diff_lessnum < diff_morenum)
        {
            System.out.println("The nearest palindrome of a given number is after subtracting " + less_num);
        }
        else
        {
            System.out.println("The nearest palindrome of a given number is after adding " + more_num);
        }
        System.out.println("After Subtracting " + less_num);
        System.out.println("After Adding " + more_num);
    }
    
    private int decreseTheNumberCheckpalindrome(int num)
    {
        while(true)
        {
            if(isPalindrome(num))
            {
                return num;
            }
            num--;
        }
    }
    
    private int increaseTheNumberCheckpalindrome(int num)
    {
        while(true)
        {
            if(isPalindrome(num))
            {
                return num;
            }
            num++;
        }
        
    }
    
    public int reversenum(int num)
    {
        int reverse_num = 0;
        while(num > 0)
        {
            reverse_num = reverse_num*10 + num%10;
            num = num/10;
        }
        return reverse_num;
    }
    
    public boolean isPalindrome(int number)
    {
        
        int reverse_num = reversenum(number);
        
        if(number < 10)
        {
            return false;
            
        }
        if(number == reverse_num)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
