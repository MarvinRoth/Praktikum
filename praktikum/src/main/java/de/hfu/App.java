package de.hfu;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        Scanner e = new Scanner(System.in);
        String eingabe;

        System.out.println("String eingeben: ");
        eingabe = e.nextLine();

        eingabe = eingabe.toUpperCase();
        System.out.println(eingabe);
    }
}
