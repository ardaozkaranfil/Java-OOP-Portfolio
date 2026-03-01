import java.util.ArrayList;
import java.util.List;

public class AssistantManager {
    private List<VirtualAssistant> assistants;

    public AssistantManager(){
        assistants=new ArrayList<>();
    }

    public List<VirtualAssistant> getAssistants(){return assistants;}
    public void setAssistants(List<VirtualAssistant> assistants){this.assistants = assistants;}

    public void addAssistant(VirtualAssistant assistant){
        if(!assistants.contains(assistant)) {
            assistants.add(assistant);
        }
        else{
            System.out.println("There is already named "+assistant+" assistant.");
        }
    }
    public void removeAssistant(VirtualAssistant assistant){
        if(assistants.contains(assistant)){
            assistants.remove(assistant);
        }
        else{
            System.out.println("There is no named "+assistant+" assistant.");
        }
    }
    public List<String> interactWithAll(String task){
        List<String> responses = new ArrayList<>();
        for(VirtualAssistant va:assistants){
            responses.add(va.greetUser());
            responses.add(va.performTask(task));
        }
        for(String response:responses){
            System.out.println(response);
        }
        return responses;
    }
}
