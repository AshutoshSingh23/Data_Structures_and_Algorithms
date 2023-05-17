package stringPatternMatching;

import java.util.Scanner;
import java.util.ArrayList;
import  java.io.PrintStream;
import java.io.PrintWriter;

public class kmp {

    public static boolean kMP(String s, String p){
        //System.out.println("Reached kmp");
        int[] lps = new int[p.length()];
        int i = 0, j = 1;
        while(j<p.length()){
            //System.out.println(i+" "+j);
            if(p.charAt(i)==p.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i==0){
                    j++;
                    continue;
                }else{
                    i--;
                    i = lps[i]; 
                }
            }
        }
        // for(int k=0;k<p.length();k++)
        //     System.out.println(k+" "+lps[k]);
        i=0;
        j=0;
        while(i<s.length()&&j<p.length()){
            if(s.charAt(i)==p.charAt(j)){
                j++;
                i++;
            }else{
                if(j!=0){
                    j = lps[j-1];
                }
            }
        }
        return j==p.length();
    }

    public static ArrayList<Integer> kMP2(String s, String p){
        //System.out.println("Reached kmp");
        int[] lps = new int[p.length()];
        int i = 0, j = 1;
        while(j<p.length()){
            //System.out.println(i+" "+j);
            if(p.charAt(i)==p.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }else{
                if(i==0){
                    j++;
                    continue;
                }else{
                    i--;
                    i = lps[i]; 
                }
            }
        }
        // for(int k=0;k<p.length();k++)
        //     System.out.println(k+" "+lps[k]);
        i=0;
        j=0;
        int k=0;
        while(i<s.length()){
            if(s.charAt(i)==p.charAt(j)){
                while(i<s.length()&&j<p.length()&&s.charAt(i)==p.charAt(j)){
                    j++;
                    i++;
                }
                if(j==p.length()){

                }
                if(i==s.length())
                    break;
                j = lps[j-1];
            }else{
                if(j!=0){
                    j = lps[j-1];
                }
            }
        }
        return new ArrayList<Integer>();
    }
    public static void main(String[] args){
        String s,p;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Strings: ");
        s = sc.next();
        p = sc.next();
        // System.out.println(s);
        // System.out.println(p);
        boolean b = kMP(s, p);
        System.out.println(b);
        // PrintStream ps = new PrintWriter(out)  ;
        //writeln();
        sc.close();
    }
}
