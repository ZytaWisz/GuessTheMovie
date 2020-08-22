package com.company;

import org.w3c.dom.xpath.XPathNamespace;

import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception{
        File file=new File("ListOfMovies.txt");
        Scanner scanner= new Scanner(file);
        int counterLine=0;
        while(scanner.hasNextLine()){
            String line= scanner.nextLine();
            System.out.println(line);
            counterLine++;

        }
        System.out.println("Ilosc linijek = "+counterLine);
        String choseName="";
        int choseNumber=(int)(Math.random()*counterLine)+1;
        System.out.println("Wylosowano "+choseNumber);
        Scanner readLine= new Scanner(file);
        int counter=0;
        while(readLine.hasNextLine()){
            String line = readLine.nextLine();
            counter++;
            if(counter==choseNumber){
                System.out.println("Znalazlem linijke, tytul to"+line);
                choseName=line;
                break;
            }

            }



    }
}
