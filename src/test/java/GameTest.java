import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    Game game = new Game();
    Player player1 = new Player(1, "Вася", 39);
    Player player2 = new Player(2, "Игорь", 12);
    Player player3 = new Player(3, "Иван", 89);
    Player player4 = new Player(4, "Андрей", 3);
    Player player5 = new Player(5, "Миша", 39);

    @Test
    public void TestFirstPlacePayer1() {
        game.register(player1);
        game.register(player2);

        Assertions.assertEquals(1, game.round("Вася", "Игорь"));
    }

    @Test
    public void TestSecondPlacePayer2() {
        game.register(player2);
        game.register(player3);

        Assertions.assertEquals(2, game.round("Игорь", "Иван"));
    }

    @Test
    public void TestSamePlace() {
        game.register(player1);
        game.register(player5);

        Assertions.assertEquals(0, game.round("Вася", "Миша"));
    }

    @Test
    public void PlayerNotRegisteredTest() {
        game.register(player3);
        game.register(player4);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вася", "Игорь");
        });
    }

    @Test
    public void OtherPlayerNotRegisteredTest() {

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Максис", "Сергей");
        });
    }
}



