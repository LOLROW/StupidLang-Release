import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int[] memory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int memoryState = memory[0];
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        File file = new File("C:\\Users\\strader_883193\\IdeaProjects\\first\\src\\examplecode.txt"); // Put filepath of StupidLang file.
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String output;
            while ((output = br.readLine()) != null) {
                String[] codeLine = output.split(" ");
                for (int i = 0; i < codeLine.length; i++) {
                    switch (codeLine[i]) {
                        case "ADD", "add" -> {
                            int num = Integer.parseInt(codeLine[i + 1]);
                            memory[memoryState] += num;
                            break;
                        }
                        case "SUB", "sub" -> {
                            int num = Integer.parseInt(codeLine[i + 1]);
                            memory[memoryState] -= num;
                            break;
                        }
                        case "PRINT", "print" -> System.out.print(Character.toChars(memory[memoryState]));
                        case "=>" -> memoryState += 1;
                        case "<=" -> memoryState -= 1;
                        case "INPUT", "input" -> {
                            char input = keyboard.nextLine().charAt(0);
                            String a = Integer.toHexString(input);
                            int conv = Integer.parseInt(a);
                            memory[memoryState] += conv;
                        }
                        case "LOOP:", "loop:" -> loopMethod(codeLine);
                    }
                }
            }
        }
        System.out.println("\n" + Arrays.toString(memory));
    }
    public static void loopMethod(String[] codeLine) {
        Scanner keyboard = new Scanner(System.in);
        int memoryStateSave = memoryState;
        boolean finished = false;
        while (!finished) {
            for (int x = 1; x < codeLine.length; x++) {
                if (memory[memoryStateSave] == 1) {
                    finished = true;
                }
                else {
                    switch (codeLine[x]) {
                        case "ADD", "add" -> {
                            int num = Integer.parseInt(codeLine[x + 1]);
                            memory[memoryState] += num;
                            break;
                        }
                        case "SUB", "sub" -> {
                            int num = Integer.parseInt(codeLine[x + 1]);
                            memory[memoryState] -= num;
                            break;
                        }
                        case "PRINT", "print" -> System.out.print(Character.toChars(memory[memoryState]));
                        case "=>" -> memoryState += 1;
                        case "<=" -> memoryState -= 1;
                        case "INPUT", "input" -> {
                            char input = keyboard.nextLine().charAt(0);
                            String a = Integer.toHexString(input);
                            int conv = Integer.parseInt(a);
                            memory[memoryState] += conv;
                        }
                        case "LOOP:", "loop:" -> loopMethod(codeLine);
                    }
                }
            }
        }
    }
}
