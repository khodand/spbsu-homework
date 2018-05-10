package group144.khodko;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Main class with interactive interface
 */
public class Main {
    public static void main(String[] args) {
        HashMap map = new HashMap(141);

        Scanner in = new Scanner(System.in);
        String command = " ";
        System.out.println("Hash table created. Use help for help");

        boolean isRunning = true;
        while(isRunning) {
            command = in.next();
            switch (command) {
                case "add":
                    map.add(in.next());
                    break;

                case "useXor":
                    map.changeHashFunc(new XorHash());
                    break;

                case "usePolynomial":
                    map.changeHashFunc(new PolynomialHash());
                    break;

                case "wholeChain":
                    map.outWholeChain(in.next());
                    break;

                case "frequency":
                    System.out.println(map.getFrequencyOfWord(in.next()));
                    break;

                case "stats":
                    printStats(map);
                    break;

                case "fill":
                    fillFromFile(map);
                    System.out.println("Filled");
                    break;

                case "help":
                    help();
                    break;

                case "exit":
                    isRunning = false;
                    break;
            }
        }
    }

    /**
     * External methods (stats, help, file input)
     */
    private static void printStats(HashMap map) {
        System.out.println("STATS: ");
        System.out.print("Element number: ");
        System.out.println(map.numberOfWords());
        System.out.print("Average list length: ");
        System.out.println(map.getAverageLen());
        System.out.print("Load factor: ");
        System.out.println(map.getLoadFactor());
        System.out.print("Number of free containers: ");
        System.out.println(map.numberOfEmptyBuckets());
        System.out.print("Max list size: ");
        System.out.println(map.getMaxLen());
    }

    private static void help() {
        System.out.println("------------------------------------------------------");
        System.out.println("add <word> (adds word to table)");
        System.out.println("contains <word> (returns true if word contains)");
        System.out.println("frequency <word> (shows frequency of word)");
        System.out.println("useXor (changes hash function to xorHash)");
        System.out.println("usePolynomial (changes hash function to polynomialHash)");
        System.out.println("stats");
        System.out.println("fill (fills table from file)");
        System.out.println("wholeChain <word> (out whole chain from word's list)");
        System.out.println("exit");
        System.out.println("------------------------------------------------------");
    }

    private static void fillFromFile(HashMap map) {
        Scanner file;
        try {
            file = new Scanner(new FileInputStream("input.txt"));
        } catch (FileNotFoundException exception) {
            System.out.println("File is not found");
            return;
        }
        while (file.hasNext()) {
            map.add(file.next());
        }
    }

}