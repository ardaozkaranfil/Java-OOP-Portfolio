import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Battle {
    private Party party1;
    private Party party2;
    private ArrayList<Character> team1;
    private ArrayList<Character> team2;

    public Battle(Party party1,Party party2){
        this.party1=party1;
        this.party2=party2;
        team1=new ArrayList<>();
        team2=new ArrayList<>();
    }

    public void formTeams(){
        Random r=new Random();
        Collections.shuffle(party1.getMembers());
        for(int i=0;i<3;i++) {
            int random=r.nextInt(party1.getMembers().size());
            team1.add(party1.getMembers().get(random));
        }
        Collections.shuffle(party2.getMembers());
        for(int i=0;i<3;i++) {
            int random=r.nextInt(party2.getMembers().size());
            team2.add(party2.getMembers().get(random));
        }
    }
    public void startBattle(){
        Random r=new Random();
        while(!team1.isEmpty() && !team2.isEmpty()){
            int attackerTeam=r.nextInt(2);
            if (attackerTeam==0){
                int attacker=r.nextInt(team1.size());
                int defender=r.nextInt(team2.size());
                System.out.println(team1.get(attacker).getName()+" from "+party1.getPartyName()+" team is attacking to "+team2.get(defender).getName()+" from "+party2.getPartyName()+".");
                attack(team1.get(attacker),team2.get(defender));
            }
            if (attackerTeam==1){
                int attacker=r.nextInt(team2.size());
                int defender=r.nextInt(team1.size());
                System.out.println(team2.get(attacker).getName()+" from "+party2.getPartyName()+" team is attacking to "+team1.get(defender).getName()+" from "+party1.getPartyName()+".");
                attack(team2.get(attacker),team1.get(defender));
            }
        }
    }
    public void attack(Character attacker, Character defender){
        double damage=attacker.calculateDamage();
        if(damage>=defender.getHitPoint()){
            System.out.println(defender.getName()+" has died.");
            if(team1.contains(defender)){
                team1.remove(defender);
            }else if(team2.contains(defender)){
                team2.remove(defender);
            }
        }else{
            defender.setHitPoint(defender.getHitPoint()-damage);
        }
    }
    public void declareWinner(){
        if (team1.isEmpty()){
            System.out.println(party2.getPartyName()+" team won the battle.");
        }else if(team2.isEmpty()){
            System.out.println(party1.getPartyName()+" team won the battle.");
        }
    }
}
