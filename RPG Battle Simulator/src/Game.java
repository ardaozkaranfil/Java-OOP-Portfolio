import java.util.ArrayList;

public class Game{

    public static void main(String[] args){
        ArrayList<Character> player1Characters = new ArrayList<>();
        player1Characters.add(new Warrior("Aragon",150.0,"Male"));
        player1Characters.add(new Mage("Gandalf",120.0,"Male"));
        player1Characters.add(new Warrior("Legolas",110.0,"Male"));

        ArrayList<Character> player2Characters=new ArrayList<>();
        player2Characters.add(new Mage("Merlin",130.0,"Male"));
        player2Characters.add(new Warrior("Xena",140.0,"Female"));

        Player player1=new Player("John Doe", "123",player1Characters);
        Player player2=new Player("Jane Smith", "456",player2Characters);

        ArrayList<Player> allPlayers=new ArrayList<>();
        allPlayers.add(player1);
        allPlayers.add(player2);

        System.out.println("---PLAYER INFO BEFORE BATTLE---");
        player1.printPlayerInfo();
        player2.printPlayerInfo();

        System.out.println("\nAragon attacks...");
        player1Characters.get(0).attack();

        System.out.println("\n---EXAMPLE PLAYER INFO AFTER BATTLE---");
        player1.printPlayerInfo();

        Party partyA=new Party("Alliance", player1Characters);
        Party partyB=new Party("Horde", player2Characters);

        System.out.println("\n---A NEW BATTLE IS STARTING---");
        Battle newBattle=new Battle(partyA,partyB);
        newBattle.formTeams();
        newBattle.startBattle();
        newBattle.declareWinner();
    }
}