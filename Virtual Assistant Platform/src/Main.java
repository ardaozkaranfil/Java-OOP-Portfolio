public class Main{
    public static void main(String[] args) {
        AssistantManager manager=new AssistantManager();
        System.out.println("Assistant Manager Initialized.");

        PersonalFinanceAssistant finance=new PersonalFinanceAssistant("Jarvis Finance",1.1);
        HomeAssistant home=new HomeAssistant("Jarvis Home",2.0);
        LanguageTranslatorAssistant translator=new LanguageTranslatorAssistant("Jarvis Translator",1.0);

        manager.addAssistant(finance);
        manager.addAssistant(home);
        manager.addAssistant(translator);

        System.out.println("All assistants added. Total assistants: "+manager.getAssistants().size());

        System.out.println("\n=====SCENARIO 1: Finance Task (deposit)=====");
        String task1="deposit money 300";
        manager.interactWithAll(task1);

        System.out.println("\n=====SCENARIO 2: Home Task (turn off lights)=====");
        String task2="turn off lights";
        manager.interactWithAll(task2);

        System.out.println("\n=====SCENARIO 3: Translator Task (French)=====");
        String task3="translate thank you to French";
        manager.interactWithAll(task3);

        System.out.println("\n=====SCENARIO 4: Unknown Task=====");
        String task4="do laundry";
        manager.interactWithAll(task4);

        System.out.println("\n=====ASSISTANT STATE CHECK=====");
        System.out.println("Current Finance Balance: "+finance.getCurrentBalance());
        System.out.println("Lights On Status: "+home.getLightOn());
        System.out.println("Last Translated Word: "+translator.getLastTranslatedWord());
    }
}