/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projettp7;

/**
 *
 * @author alaudebert
 */
public class ProjetTP7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("hello,World.");
        System.out.println("Ceci est du texte.");
        int uneVariable;
        uneVariable =1;
        uneVariable = uneVariable +1;
        uneVariable = addition(12, uneVariable);
        System.err.println(addition (1,uneVariable));
    }
    
    public static int addition(int a, int b){
     return a +b; }
}
