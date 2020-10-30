import java.io.*;
import java.util.*;

public class StupidLang {
    public static int[] memory = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public static int memoryState = memory[0];
    public static void main(String[] args) throws IOException {
        Scanner keyboard = new Scanner(System.in);
        File file = new File(""); // Put filepath of StupidLang file.
        BufferedReader br = new BufferedReader(new FileReader(file));
        String output;
        while ((output = br.readLine()) != null) {
            String[] codeLine = output.split(" ");
            for (int i = 0; i < codeLine.length; i++) {
                if (codeLine[i].equals("ADD") || codeLine[i].equals("add")) {
                    int num = Integer.parseInt(codeLine[i + 1]);
                    memory[memoryState] += num;
                }
                else if (codeLine[i].equals("SUB") || codeLine[i].equals("sub")) {
                    int num = Integer.parseInt(codeLine[i + 1]);
                    memory[memoryState] -= num;
                }
                else if (codeLine[i].equals("PRINT") || codeLine[i].equals("print")) {
                    System.out.print(Character.toChars(memory[memoryState]));
                }
                else if (codeLine[i].equals("=>")) {
                    memoryState += 1;
                }
                else if (codeLine[i].equals("<=")) {
                    memoryState -= 1;
                }
                else if (codeLine[i].equals("INPUT") || codeLine[i].equals("input")) {
                    char input = keyboard.nextLine().charAt(0);
                    String a = Integer.toHexString(input);
                    int conv = Integer.parseInt(a);
                    memory[memoryState] += conv;
                }
                else if (codeLine[i].equals("LOOP:") || codeLine[i].equals("loop:")) {
                    loopMethod(codeLine);
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
                    if (codeLine[x].equals("ADD") || codeLine[x].equals("add")) {
                        int num = Integer.parseInt(codeLine[x + 1]);
                        memory[memoryState] += num;
                    }
                    else if (codeLine[x].equals("SUB") || codeLine[x].equals("sub")) {
                        int num = Integer.parseInt(codeLine[x + 1]);
                        memory[memoryState] -= num;
                    }
                    else if (codeLine[x].equals("PRINT") || codeLine[x].equals("print")) {
                        System.out.print(Character.toChars(memory[memoryState]));
                    }
                    else if (codeLine[x].equals("=>")) {
                        memoryState += 1;
                    }
                    else if (codeLine[x].equals("<=")) {
                        memoryState -= 1;
                    }
                    else if (codeLine[x].equals("INPUT") || codeLine[x].equals("input")) {
                        char input = keyboard.nextLine().charAt(0);
                        String a = Integer.toHexString(input);
                        int conv = Integer.parseInt(a);
                        memory[memoryState] += conv;
                    }
                    else if (codeLine[x].equals("LOOP:") || codeLine[x].equals("loop:")) {
                        loopMethod(codeLine);
                    }
                }
            }
        }
    }
}
