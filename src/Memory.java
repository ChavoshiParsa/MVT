import java.util.ArrayList;

public class Memory {
    final private int size;
    private int allocatedMemory;
    private int externalFragmentation;

    final private ArrayList<Process> processList;

    public Memory(int size) {
        this.size = size;
        this.allocatedMemory = 0;
        this.externalFragmentation = size;
        processList = new ArrayList<>();
    }

    public boolean allocate(Process process) {
        if (process.size() <= externalFragmentation) {
            externalFragmentation -= process.size();
            allocatedMemory += process.size();
            processList.add(process);

            return true;
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getAllocatedMemory() {
        return allocatedMemory;
    }

    public void printData() {
        System.out.println("\nPROCESS MEMORY ALLOCATED");
        for (Process process : processList) {
            System.out.println("● " + process.id() + ": " + process.size());
        }
        System.out.println("Total Memory Allocated is " + allocatedMemory + ", Total External Fragmentation is " + externalFragmentation);
    }
}
