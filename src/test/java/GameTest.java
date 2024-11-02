import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Baraka", 7);
    Player player2 = new Player(2,"Lord Raiden", 9);
    Player player3 = new Player(3, "Shao Kahn", 10);
    Player player4 = new Player(4, "Liu Kang", 10);
    Player player5 = new Player(5, "Sub-Zero", 8);
    Player player6 = new Player(6, "Scorpion", 8);

    @Test
    public void GetIdTest() {
        Assertions.assertEquals(1, player1.getId());
        Assertions.assertEquals(2, player2.getId());
        Assertions.assertEquals(3, player3.getId());
        Assertions.assertEquals(4, player4.getId());
    }

    @Test
    public void GetNameTest() {
        Assertions.assertEquals("Baraka", player1.getName());
        Assertions.assertEquals("Lord Raiden", player2.getName());
        Assertions.assertEquals("Shao Kahn", player3.getName());
        Assertions.assertEquals("Liu Kang", player4.getName());
    }

    @Test
    public void GetStrengthTest() {
        Assertions.assertEquals(7, player1.getStrength());
        Assertions.assertEquals(9, player2.getStrength());
        Assertions.assertEquals(10, player3.getStrength());
        Assertions.assertEquals(10, player4.getStrength());
    }

    @Test
    public void RegisterTest() {
        game.players.add(player1);
        game.players.add(player2);
        game.players.add(player3);
        game.players.add(player4);

        Assertions.assertTrue(game.register(player1));
        Assertions.assertTrue(game.register(player2));
        Assertions.assertTrue(game.register(player3));
        Assertions.assertTrue(game.register(player4));

        Assertions.assertFalse(game.register(player5));
        Assertions.assertFalse(game.register(player6));
    }

    @Test
    public void FindByNameTest() {
        game.players.add(player1);
        game.players.add(player2);
        game.players.add(player3);
        game.players.add(player4);

        Assertions.assertEquals(player1, game.findByName("Baraka"));
        Assertions.assertEquals(player2, game.findByName("Lord Raiden"));
        Assertions.assertEquals(player3, game.findByName("Shao Kahn"));
        Assertions.assertEquals(player4, game.findByName("Liu Kang"));

        Assertions.assertNull(game.findByName("Sub-Zero"));
        Assertions.assertNull(game.findByName("Scorpion"));
    }

    @Test
    public void RoundTest() {
        game.players.add(player1);
        game.players.add(player2);
        game.players.add(player3);
        game.players.add(player4);

        Assertions.assertEquals(1, game.round("Lord Raiden", "Baraka"));
        Assertions.assertEquals(2, game.round("Lord Raiden", "Shao Kahn"));
        Assertions.assertEquals(0, game.round("Liu Kang", "Shao Kahn"));

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Scorpion", "Lord Raiden");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Baraka", "Sub-Zero");
        });
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Scorpion", "Sub-Zero");
        });
    }
}
