public abstract class VirtualAssistant {
    private String assistantName;
    private double version;

    public VirtualAssistant(String assistantName,double version){
        this.assistantName=assistantName;
        this.version=version;
    }

    public String getAssistantName(){return assistantName;}
    public void setAssistantName(String assistantName){this.assistantName = assistantName;}
    public double getVersion(){return version;}
    public void setVersion(double version){this.version = version;}

    public abstract String greetUser();
    public abstract String performTask(String task);
}
