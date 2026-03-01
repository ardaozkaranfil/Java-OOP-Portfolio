import java.util.*;

public class Main {
    public static final String ANSI_RESET="\u001B[0m";
    public static final String ANSI_RED="\u001B[31m";

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);

        String dictionaryFile="C:\\Users\\HP\\IdeaProjects\\SE116-9\\src\\dictionary.txt";
        String expletivesFile="C:\\Users\\HP\\IdeaProjects\\SE116-9\\src\\badWords.txt";

        SpellChecker spellChecker=new SpellChecker(dictionaryFile);
        CensorModule censorModule=new CensorModule(expletivesFile);

        System.out.println("Dictionary loaded. Words: "+spellChecker.getDictionary().size());
        System.out.println("Expletive dictionary loaded. Words: "+censorModule.getBadWords().size());

        while(true){
            printMenu();
            System.out.print("Choose an option: ");
            String option=scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter word to add to dictionary: ");
                    String wordToAdd=scanner.nextLine();
                    spellChecker.addWord(wordToAdd);
                    break;
                case "2":
                    System.out.print("Enter word to remove from dictionary: ");
                    String wordToRemove=scanner.nextLine();
                    spellChecker.removeWord(wordToRemove);
                    break;
                case "3":
                    System.out.print("Enter word to add to expletives: ");
                    String expletiveToAdd=scanner.nextLine();
                    censorModule.addExpletive(expletiveToAdd);
                    break;
                case "4":
                    System.out.print("Enter word to remove from expletives: ");
                    String expletiveToRemove=scanner.nextLine();
                    censorModule.removeExpletive(expletiveToRemove);
                    break;
                case "5":
                    System.out.print("Enter input file path: ");
                    String inputPathCheck=scanner.nextLine();
                    System.out.print("Enter output file path: ");
                    String outputPathCheck=scanner.nextLine();

                    spellChecker.processFile(inputPathCheck,outputPathCheck);

                    System.out.println("\nFile processed successfully!");
                    System.out.println("Corrected text written to: "+outputPathCheck);
                    break;
                case "6":
                    System.out.print("Enter input file path: ");
                    String inputPathCensor=scanner.nextLine();
                    System.out.print("Enter output file path: ");
                    String outputPathCensor=scanner.nextLine();

                    censorModule.censorFile(inputPathCensor,outputPathCensor);

                    System.out.println("Censored version saved to: "+outputPathCensor);
                    break;
                case "7":
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println(ANSI_RED + "Invalid option, please try again."+ANSI_RESET);
            }
            System.out.println();
        }
    }

    private static void printMenu(){
        System.out.println("Menu");
        System.out.println("1. Add a word to dictionary");
        System.out.println("2. Remove a word from dictionary");
        System.out.println("3. Add a word to expletives dictionary");
        System.out.println("4. Remove a word from expletives dictionary");
        System.out.println("5. Check and auto-correct a text file");
        System.out.println("6. Censor expletives from a text file");
        System.out.println("7. Exit");
    }
}