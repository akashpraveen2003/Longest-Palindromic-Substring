package longest_palindromic_Substring;

import java.util.Scanner;

/*
 Given a string A of size N, find and return the longest palindromic substring in A.

Substring of string A is A[i...j] where 0 <= i <= j < len(A)

Palindrome string: A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A


	Input 1:
	
	A = "aaaabaaa"
	
	Input 2:
	
	A = "abba
	
	Output 1:
	
	"aaabaaa"
	
	Output 2:
	
	"abba"
	
	for ref : https://www.youtube.com/watch?v=fxwvVnBMN6I
 */
public class Longest_Palindromic_SubString {
	
	private static void find_longest_palindromic_subString(String s) {
		
		int n=s.length();
		int dp[][]=new int[n][n];		// for checking substring or not
		String answer="";
		int max_length=0;
		int i,j,k;
		for(k=0;k<n;k++)
		{
			i=0;		// row
			j=k;		//column
			while(j<n)
			{
				if(i==j)				// all individual characters are palindrome
				{
					dp[i][j]=1;		
				}
				else if(j-i==1)				// Checks if two characters are palindrome i.e here 1 iss given because 0 based indexing
				{
					if(s.charAt(i)==s.charAt(j))
					{
						dp[i][j]=2;		// if palindrome, assign 2
					}
					else
					{
						dp[i][j]=0;
					}
				}
				else
				{
					if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]!=0)		// We check that inner string(dp array) and checking the current characters is palindrome or not  
					{
						dp[i][j]=2+dp[i+1][j-1];
					}
				}
				if(dp[i][j]>max_length)
				{
					max_length=dp[i][j];
					answer=s.substring(i,j+1);
				}
				i++;
				j++;
			}
		}
		System.out.println(answer);
	}

	public static void main(String[] args) {
		
		Scanner scanner=new Scanner(System.in);
		String s=scanner.nextLine();
		find_longest_palindromic_subString(s);

	}

	

}
