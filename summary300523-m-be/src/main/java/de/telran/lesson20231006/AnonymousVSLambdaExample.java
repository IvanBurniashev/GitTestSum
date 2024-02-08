package de.telran.lesson20231006;

import java.util.function.Consumer;

public class AnonymousVSLambdaExample {

    public static void main(String[] args) {

        Playable footballPlayer = new FootballPlayer();
        Playable basketballPlayer = new BasketballPlayer();
        Playable basketballPlayer2 = new BasketballPlayer();
        Playable basketballPlayer3 = new BasketballPlayer();

        // anonymous class
        Playable chessPlayer = new Playable() {
            @Override
            public void play() {
                System.out.println("Playing chess");
            }
        };

        int someData = 1; // effectively final variable
//        someData++;

        // anonymous class
        new Playable() {
            int someData2 = 100;

            @Override
            public void play() {
                System.out.println("Playing badminton " + someData + " " + someData2);
            }
        }.play();

        Playable golfPlayer = () -> System.out.println("Playing golf");


        ((Playable) () -> System.out.println("Playing some game")).play();
        ((Runnable) () -> System.out.println("Playing some game")).run();

        // void -> void
        Consumer dartsPlayer = (x) -> System.out.println("Playing darts");
        dartsPlayer.accept(null);



        Playable cardsPlayer = () -> {
//            int someData = 100;
            int anotherData = 1000;
            System.out.println("Playing cards");
            System.out.println("Cool game " + anotherData + " " + someData);
            };
        cardsPlayer.play();

//        footballPlayer.play();
//        basketballPlayer.play();

        // anonymous class in method call usage
//        playAll(new Playable() {
//            @Override
//            public void play() {
//                System.out.println("Playing some game");
//            }
//        });

        playAll(footballPlayer,
                basketballPlayer,
                basketballPlayer2,
                basketballPlayer3,
                chessPlayer,
                golfPlayer);
//        playAll(footballPlayer);
//        playAll(footballPlayer, basketballPlayer);
//        playAllAlternative(new Playable[] {footballPlayer, basketballPlayer});
    }

    public static void playAll(Playable... players) {
        for (Playable p : players) {
            p.play();
        }
    }

    public static void playAllAlternative(Playable[] players) {
        for (Playable p : players) {
            p.play();
        }
    }


}
