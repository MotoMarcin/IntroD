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
        Scanner scanner = new Scanner(System.in);
        consoleHelper.printTitle1();
        playSound("sounds/HAL_9000.wav");
        System.out.println(" Loading...");

        try {
            simulateLoading();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("\n Press ENTER to coninue");
        waitForEnter();

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

        playSound("sounds/just_a_moment.wav");
        consoleHelper.printTitle2();
        int option = 1;
        while (option != 6) {
            consoleHelper.Intro1(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        consoleHelper.startThatBrutalGame();
                        break;
                    case 2:
                        consoleHelper.showInstructions();
                        System.out.println("           Press ENTER to go back");
                        waitForEnter();
                        break;
                    case 3:
                        consoleHelper.showHistoryofDraughts();
                        System.out.println("           Press ENTER to continue");
                        waitForEnter();
                        break;
                    case 4:
                        teamInfo();
                        System.out.println("       Press Enter if you love Team ONE.");
                        waitForEnter();
                        break;
                    case 5:
                        consoleHelper.quoteOfTheDay();
                        break;
                    case 6:
                        exit(0);
                    case 666:
                        consoleHelper.printDocumentation();
                        waitForEnter();
                        break;
                    default: {
                        System.out.println(RED_FOREGROUND + "   Hey, that's not how we get along. Follow the instructions below." + RESET);
                        System.out.println("   Please choose an option (number between 1 and " + options.length + ")");
                        Toolkit.getDefaultToolkit().beep();
                    }
                }
            } catch (Exception ex) {
                System.out.println(RED_FOREGROUND + "   Well, that's not how we get along. Follow the instructions below." + RESET);
                System.out.println("   Please choose an option (number between 1 and " + options.length + ")...\n");
                playSound("sounds/enough_info.wav");
                scanner.next();
            }
        }
    }


    public static void waitForEnter() {
        Scanner s666 = new Scanner(System.in);
        String ave = " ";
        ave = s666.nextLine();
    }


}
