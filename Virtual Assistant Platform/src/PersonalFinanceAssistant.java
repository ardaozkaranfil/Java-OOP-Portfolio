public class PersonalFinanceAssistant extends VirtualAssistant{
    private double currentBalance;

    public PersonalFinanceAssistant(String assistantName,double version){
        super(assistantName,version);
        currentBalance=500;
    }

    public double getCurrentBalance(){return currentBalance;}
    public void setCurrentBalance(double currentBalance){this.currentBalance = currentBalance;}

    @Override
    public String greetUser(){
        return "Hi! I’m your Finance Assistant. Let’s manage your money wisely!";
    }
    public String performTask(String task){
        String[] taskSplit=task.split(" ");
        if(task.equalsIgnoreCase("show balance")){
            return "Your current balance: "+String.valueOf(currentBalance)+"dollars.";
        }
        else if(taskSplit.length==3&&taskSplit[0].equalsIgnoreCase("deposit")&&taskSplit[1].equalsIgnoreCase("money")){
            currentBalance+=Double.parseDouble(taskSplit[2]);
            return taskSplit[2]+" dollars is deposited into your account. Your current balance: "+currentBalance+" dollars.";
        }
        else if(taskSplit.length==2&&taskSplit[0].equalsIgnoreCase("withdraw")){
            if(currentBalance<Double.parseDouble(taskSplit[1])){
                return "Sorry, insufficient balance!";
            }
            else{
                currentBalance-=Double.parseDouble(taskSplit[1]);
                return taskSplit[1]+" dollars is withdrawn from your account. Your current balance: "+currentBalance+" dollars.";
            }
        }
        else{
            return "I don’t know how to do that.";
        }
    }
}
