import java.time.LocalDateTime;

public class JournalEntry {
    private String title;
    private String content;
    private LocalDateTime timestamp;

    public JournalEntry(String title,String content){
        this.title=title;
        this.content=content;
        timestamp=LocalDateTime.now();
    }

    public String getTitle(){return title;}
    public void setTitle(String title){this.title = title;}
    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}
    public LocalDateTime getTimestamp(){return timestamp;}
    public void setTimestamp(LocalDateTime timestamp){this.timestamp=timestamp;}

    @Override
    public String toString() {
        return "-Journal Entries- \nTitle: "+title+"\n Content: "+content+"\n Time: "+timestamp;
    }
}
