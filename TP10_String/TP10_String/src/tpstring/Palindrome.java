package tpstring;

/**
 * Exercice Palindrome.
 */
public class Palindrome {
    
   
    private String s;
    
    public Palindrome(String s_){
        s=s_;
    }
    
    public boolean isPalindrome(){
        int posEspace = s.indexOf(' ');
        while(posEspace != -1){
            String str1 = s.substring(0,posEspace-1);
            String str2 = s.substring(posEspace+1,s.length());
            s = str1.concat(str2);
            posEspace = s.indexOf(' ');
        }
        
        int pos = 0;
        while (s.charAt(pos) == s.charAt(s.length()-pos)){
            pos++;
        }
        
        if (pos >= (s.length()/2)-1){
            return true;
        }
        
        return false;
    }
}
