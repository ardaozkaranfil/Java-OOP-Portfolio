public class Main {

    public static void main(String[] args) {
        JournalManager manager=new JournalManager();
        System.out.println("Journal App Started!");

        System.out.println("Adding 3 new entries...");
        manager.addEntry(new JournalEntry("Beautiful Weather Today","A sunny Sunday in Side."));
        manager.addEntry(new JournalEntry("Shopping List","Milk, Bread, Cheese, Olives"));
        manager.addEntry(new JournalEntry("Project Idea","Create a journal application with Java."));

        System.out.println("Viewing current entries:");
        manager.viewEntries();

        String textFilename="journal.txt";
        System.out.println("Saving entries to text file: "+textFilename);
        manager.saveEntries(textFilename);

        System.out.println("Simulating app restart with a new empty manager.");
        JournalManager loadedManager=new JournalManager();

        System.out.println("Loading entries from: "+textFilename);
        loadedManager.loadEntries(textFilename);

        System.out.println("Viewing entries after loading from text file:");
        loadedManager.viewEntries();

        String binaryFilename="journal.bin";
        System.out.println("Exporting entries to binary file: "+binaryFilename);
        loadedManager.exportToBinary(binaryFilename);

        JournalManager binaryLoadedManager=new JournalManager();
        System.out.println("Importing entries from: "+binaryFilename);
        binaryLoadedManager.importFromBinary(binaryFilename);

        System.out.println("Viewing entries after importing from binary file:");
        binaryLoadedManager.viewEntries();

        String flushFilename="flush_test.txt";
        System.out.println("Flushing all entries to: "+flushFilename);
        binaryLoadedManager.flushToDiskUsingBuffer(flushFilename);

        System.out.println("All tests completed successfully!");
    }
}