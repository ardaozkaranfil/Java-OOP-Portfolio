import java.io.*;
import java.util.*;

public class CensorModule{
    private HashSet<String> badWords;
    private String expletiveDictPath;

    public CensorModule(String expletiveDictPath){
        this.expletiveDictPath=expletiveDictPath;
        this.badWords=new HashSet<>();

        try(BufferedReader br=new BufferedReader(new FileReader(expletiveDictPath))){
            String line;
            while((line=br.readLine())!=null){
                if(!line.trim().isEmpty()){
                    badWords.add(line.trim().toLowerCase());
                }
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public HashSet<String> getBadWords(){return badWords;}
    public void setBadWords(HashSet<String> dictionary){this.badWords=dictionary;}
    public String getExpletiveDictPath(){return expletiveDictPath;}
    public void setExpletiveDictPath(String dictionaryFilePath){this.expletiveDictPath=dictionaryFilePath;}

    private void saveExpletiveDictionary(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(expletiveDictPath))){
            for(String word:badWords){
                bw.write(word);
                bw.newLine();
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void addExpletive(String word){
        if(!badWords.contains(word.trim().toLowerCase())&&!word.trim().isEmpty()){
            badWords.add(word.trim().toLowerCase());
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(expletiveDictPath,true))){
                bw.write(word.trim().toLowerCase());
                bw.newLine();
            }
            catch(IOException e){
                System.err.println(e.getMessage());
            }
        }
        else{
            System.out.println("This word already exist or empty parameter.");
        }
    }

    public void removeExpletive(String word){
        if(badWords.contains(word.trim().toLowerCase())){
            badWords.remove(word.trim().toLowerCase());
            saveExpletiveDictionary();
        }
        else{
            System.out.println("This word already doesn't exist.");
        }
    }

    public void censorFile(String inputPath, String outputPath){
        try(BufferedReader br=new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw=new BufferedWriter(new FileWriter(outputPath))){

            String line;

            while((line=br.readLine())!=null){
                if(!line.isEmpty()){
                    String[] words=line.split(" ");
                    StringBuilder editedLine=new StringBuilder();

                    for(String word:words){
                        String cleanedWord=word.replaceAll("[^a-zA-Z]","");

                        if(cleanedWord.isEmpty()){
                            editedLine.append(word).append(" ");
                            continue;
                        }

                        String lowerCleanedWord=cleanedWord.toLowerCase();

                        if(badWords.contains(lowerCleanedWord)){
                            String censor=word.replace(cleanedWord,"[CENSORED]");
                            editedLine.append(censor).append(" ");
                        }
                        else{
                            editedLine.append(word).append(" ");
                        }
                    }
                    bw.write(editedLine.toString().trim());
                    bw.newLine();
                }
                else{
                    bw.newLine();
                    continue;
                }
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }
}
