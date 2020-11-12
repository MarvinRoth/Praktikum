package de.hfu;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ){
        Scanner e = new Scanner(System.in);
        String eingabe;

        System.out.println("String eingeben: ");
        eingabe = e.nextLine();//eingabe

        eingabe = eingabe.toUpperCase();//umwandlung zu Großbuchstaben
        System.out.println(eingabe);//Ausgabe des geänerten string
    }
}
