//
//          ]]P [[]] ][_ ]][ ((5 ][-][   ][_) ][2 //-\ ][_][ ((6 ][-][ `][` ((5
//
//                     a.k.a.  |'()|_|_\"|-| |)|2/-\|_|[,|-|"|"_\"
//                                         by
//             _______ _______ _______ _______       _____  __   _ _______
//                |    |______ |_____| |  |  |      |     | | \  | |______
//                |    |______ |     | |  |  |      |_____| |  \_| |______

        package introduction;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

import static introduction.Intro.*;
import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        Intro consoleHelper = new Intro();
        consoleHelper.printTitle1();
        try {
            Intro.playSound("sounds/HAL_9000.wav");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(" Loading...");

        try {
            Intro.simulateLoading();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n Press ENTER to coninue");
        Scanner scanner = new Scanner(System.in);
        String dummy= scanner.nextLine();

        System.out.println("\n");
        consoleHelper.waitFor(100);
        consoleHelper.fakeCLS();


        String[] options = {" [1] - Start the game",
                " [2] - Game instructions",
                " [3] - History of polish draughts",
                " [4] - The great team behind",
                " [5] - Random quote of the day",
                " [6] - Exit"
        };

        try {
            Intro.playSound("sounds/just_a_moment.wav");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        consoleHelper.printTitle2();
        int option = 1;
        while (option!=6){
            consoleHelper.Intro1(options);
            try {
                option = scanner.nextInt();
                switch (option){
                    case 1:
                        consoleHelper.startThatBrutalGame();
                        break;
                    case 2:
                        consoleHelper.showInstructions();
                        break;
                    case 3:
                        consoleHelper.showHistoryofDraughts();
                        break;
                    case 4:
                        teamInfo();
                        break;
                    case 5:
                        consoleHelper.quoteOfTheDay();
                        break;
                    case 6:
                        exit(0);
                    default: {
                        System.out.println(RED_FOREGROUND + "   Hey, that's not how we get along. Follow the instructions below." + RESET);
                        System.out.println("   Please choose an option (number between 1 and " + options.length + ")");
                        Toolkit.getDefaultToolkit().beep();
                    }
                }
            }
            catch (Exception ex){
                System.out.println(RED_FOREGROUND + "   Well, that's not how we get along. Follow the instructions below." + RESET);
                System.out.println("   Please choose an option (number between 1 and " + options.length + ")...\n");
                try {
                    Intro.playSound("sounds/enough_info.wav");
                } catch (LineUnavailableException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                scanner.next();
            }
        }
    }


    // Options
    private static void option1() {
        System.out.println("Thanks for choosing option 1");
    }
    private static void option2() {
        System.out.println("Thanks for choosing option 2");
    }
    private static void option3() {
        System.out.println("Thanks for choosing option 3");
    }


}