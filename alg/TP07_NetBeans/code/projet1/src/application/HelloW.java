/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

/**
 *
 * @author armand claveau
 */
public class HelloW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Hello, World.");
        System.out.println("un texte");
        int variable;
        variable = 1;
        variable = variable +1;
        variable++;
        variable+=1;
        variable*=variable;
        System.out.println("Variable : " + variable);
        variable = addition(12, variable);
        System.out.println(addition(1, variable));
    }
    /**
     * Ceci est une fonction d'addition
     * @param a Le premier opérande
     * @param b Le second
     * @return Le résultat
     */
    public static int addition(int a,int b) {
        return a+b;
    }
}
