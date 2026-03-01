public class HomeAssistant extends VirtualAssistant {
    private boolean isLightOn;

    public HomeAssistant(String assistantName,double version) {
        super(assistantName, version);
        isLightOn = false;
    }

    public boolean getLightOn(){return isLightOn;}
    public void setLightOn(boolean lightOn){isLightOn = lightOn;}

    @Override
    public String greetUser(){
        return "Hello! I’m your Home Assistant. How can I help to control your home today?";
    }
    public String performTask(String task){
        if(task.equalsIgnoreCase("turn on lights")){
            if(!isLightOn){
                isLightOn = true;
                return "Turning on the lights!";
            }
            else{
                return "The lights are already turned on.";
            }
        }
        else if(task.equalsIgnoreCase("turn off lights")){
            if(isLightOn){
                isLightOn = false;
                return "Turning off the lights!";
            }
            else{
                return "The lights are already turned off.";
            }
        }
        else{
            return "Sorry, I can't do that.";
        }
    }
}
