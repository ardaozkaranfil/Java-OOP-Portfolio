import java.io.*;
import java.util.ArrayList;

public class JournalManager {
    private ArrayList<JournalEntry> entries;

    public JournalManager(ArrayList<JournalEntry> entries){
        this.entries=entries;
    }
    public JournalManager(){
        entries=new ArrayList<>();
    }

    public void addEntry(JournalEntry entry){
        if(!entries.contains(entry)){
            entries.add(entry);
        }
        else{
            System.out.println("This entry already exists.");
        }
    }
    public void viewEntries(){
        for(JournalEntry j:entries){
            System.out.println(j);
        }
    }

    public void saveEntries(String filename){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(filename))){
            for(JournalEntry j:entries){
                bw.write(j.getTitle());
                bw.newLine();
                bw.write(j.getContent());
                bw.newLine();
            }
            bw.flush();
            System.out.println("Entries successfully written to "+filename+".");
        }
        catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }
    public void loadEntries(String filename){
        try(BufferedReader br=new BufferedReader(new FileReader(filename))){
            String title;
            while((title=br.readLine())!=null){
                String content=br.readLine();

                if(content!=null){
                    JournalEntry newEntry=new JournalEntry(title,content);
                    addEntry(newEntry);
                }
            }
            System.out.println("Entries successfully read from "+filename+".");
        }
        catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public void exportToBinary(String filename){
        try(DataOutputStream dos=new DataOutputStream(new FileOutputStream(filename))){
            for(JournalEntry j:entries){
                dos.writeUTF(j.getTitle());
                dos.writeUTF(j.getContent());
            }
            System.out.println("Entries successfully written to "+filename+" as binary format.");
        }
        catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }
    public void importFromBinary(String filename){
        try(DataInputStream dis=new DataInputStream(new FileInputStream(filename))){
            while(true){
                String title=dis.readUTF();
                String content=dis.readUTF();
                addEntry(new JournalEntry(title,content));
            }

        }
        catch(EOFException e){
            System.out.println("Entries successfully read from "+filename+".");
        }
        catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }

    public void flushToDiskUsingBuffer(String filename){
        String fileContent="";
        for (JournalEntry j:entries){
            fileContent+=j.toString()+"\n";
        }

        try (BufferedWriter bw=new BufferedWriter(new FileWriter(filename))) {
            bw.write(fileContent);
            bw.flush();
            System.out.println("Entries successfully read from "+filename+".");
        }
        catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }
    }
}
