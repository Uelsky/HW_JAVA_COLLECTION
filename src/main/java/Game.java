import java.util.ArrayList;

public class Game {
    ArrayList<Player> players = new ArrayList<>();

    public boolean register (Player player) {
        return players.contains(player);
    }

    public Player findByName(String playerName) {
        for (Player player : players) {
            if (player.getName() == playerName) {
                return player;
            }
        }
        return null;
    }

    public int round (String playerName1, String playerName2) {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 != null && player2 != null) {
            if (player1.getStrength() > player2.getStrength()) {
                return 1;
            } else if (player1.getStrength() < player2.getStrength()) {
                return 2;
            } else {
                return 0;
            }
        } else {
            throw new NotRegisteredException("There is(are) unregistered player(s)!");
        }
    }
}
