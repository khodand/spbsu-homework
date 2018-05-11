package group144.khodko;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CountsTree tree = new CountsTree(input);

        tree.print(System.out);
        System.out.println();
        System.out.println(tree.count());
    }
}