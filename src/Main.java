import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the total memory available (in Bytes) ");
        int size = scanner.nextInt();

        Memory memory = new Memory(size);

        int processNum = 1;
        while (true) {
            System.out.print("Enter memory required for process " + processNum + " (in Bytes) ");
            int processSize = scanner.nextInt();
            boolean isAllocated = memory.allocate(new Process(processNum, processSize));

            if (isAllocated) {
                System.out.println("Memory is allocated for process " + processNum);
            } else {
                System.out.println("Memory is full, Total memory available-" + memory.getSize());
                memory.printData();
                break;
            }

            if (memory.getSize() == memory.getAllocatedMemory()) {
                System.out.println("Memory doesn't have any additional space");
                memory.printData();
                break;
            }

            while (true) {
                System.out.print("Do you want to continue(y/n) ");
                String answer = scanner.next();
                if (answer.equals("y") || answer.equals("Y")) {
                    processNum++;
                    break;
                } else if (answer.equals("n") || answer.equals("N")) {
                    memory.printData();
                    System.exit(0);
                } else {
                    System.out.println("Invalid answer! try again.");
                }
            }
        }

    }
}