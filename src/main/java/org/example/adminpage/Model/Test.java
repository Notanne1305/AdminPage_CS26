package org.example.adminpage.Model;

import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Map<String, Integer> map = Map.of("a", 1, "b", 2, "c", 3, "d",4);

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a list of letters: ");
        String letters = input.nextLine();
        String[] list = letters.split(",");
        int length = 10;

        for(int i = 0; i < list.length; i++){

            System.out.print(map.get(list[i]));

            if ((i + 1) % length == 0) {
                System.out.println();
            }
        }
    }
}
