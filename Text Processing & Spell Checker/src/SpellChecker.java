import java.io.*;
import java.util.*;

public class SpellChecker{
    private HashSet<String> dictionary;
    private String dictionaryFilePath;

    public SpellChecker(String dictionaryFilePath){
        this.dictionaryFilePath=dictionaryFilePath;
        this.dictionary=new HashSet<>();

        try(BufferedReader br=new BufferedReader(new FileReader(dictionaryFilePath))){
            String line;
            while((line=br.readLine())!=null){
                if(!line.trim().isEmpty()){
                    dictionary.add(line.trim().toLowerCase());
                }
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public HashSet<String> getDictionary(){return dictionary;}
    public void setDictionary(HashSet<String> dictionary){this.dictionary=dictionary;}
    public String getDictionaryFilePath(){return dictionaryFilePath;}
    public void setDictionaryFilePath(String dictionaryFilePath){this.dictionaryFilePath=dictionaryFilePath;}

    private void saveDictionary(){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(dictionaryFilePath))){
            for(String word:dictionary){
                bw.write(word);
                bw.newLine();
            }
        }
        catch(IOException e){
            System.err.println(e.getMessage());
        }
    }

    public void addWord(String word){
        if(!dictionary.contains(word.trim().toLowerCase())&&!word.trim().isEmpty()){
            dictionary.add(word.trim().toLowerCase());
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(dictionaryFilePath,true))){
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
    public void removeWord(String word){
        if(dictionary.contains(word.trim().toLowerCase())){
            dictionary.remove(word.trim().toLowerCase());
            saveDictionary();
        }
        else{
            System.out.println("This word already doesn't exist.");
        }
    }

    private int getLevenshteinDistance(String a,String b){
        a=(a==null)?"":a.toLowerCase();
        b=(b==null)?"":b.toLowerCase();

        int[][] dp=new int[a.length()+1][b.length()+1];

        for(int i=0;i<=a.length();i++){
            dp[i][0]=i;
        }
        for(int j=0;j<=b.length();j++){
            dp[0][j]=j;
        }

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){

                int cost=(a.charAt(i-1)==b.charAt(j-1))?0:1;

                dp[i][j]=Math.min(dp[i-1][j]+1,
                        Math.min(
                                dp[i][j-1]+1,
                                dp[i-1][j-1]+cost
                        )
                );
            }
        }
        return dp[a.length()][b.length()];
    }

    public List<String> suggestWords(String input){
        List<String> suggested=new ArrayList<>();
        if(!input.isEmpty()){
            for(String word:dictionary){
                if (getLevenshteinDistance(word,input.trim())<=1){
                    suggested.add(word);
                }
            }
        }
        return suggested;
    }

    public void processFile(String inputPath, String outputPath){
        Scanner sc=new Scanner(System.in);
        List<String> suggested=new ArrayList<>();

        try(BufferedReader br=new BufferedReader(new FileReader(inputPath));
            BufferedWriter bw=new BufferedWriter(new FileWriter(outputPath))){
            String line;
            while((line=br.readLine())!=null){
                if(!line.isEmpty()){
                    String[] words=line.split(" ");
                    StringBuilder editedLine=new StringBuilder();
                    for(String word:words){
                        String cleanedWord=word.replaceAll("[^a-zA-Z]","");
                        if(!cleanedWord.isEmpty()){
                            String lowerCleanedWord=cleanedWord.toLowerCase();
                            suggested=suggestWords(lowerCleanedWord);
                            if(!dictionary.contains(lowerCleanedWord)){
                                System.out.println("There can be a misspelled word here, that word is: "+word+"\n There is our suggestions for this misspelled word: ");
                                for(String s:suggested){
                                    System.out.println(s);
                                }
                                System.out.println("What word do you want to use please write.");
                                String userInput=sc.nextLine();
                                if(userInput.trim().isEmpty()){
                                    editedLine.append(word).append(" ");
                                }
                                else{
                                    String newWord=word.replace(cleanedWord,userInput);
                                    editedLine.append(newWord).append(" ");
                                }
                            }
                            else{
                                editedLine.append(word).append(" ");
                            }
                        }
                        else{
                            editedLine.append(word).append(" ");
                            continue;
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
