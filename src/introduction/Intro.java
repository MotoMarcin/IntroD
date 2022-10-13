//        ______         __ __         __         _____                          __     __
//        |   __ \.-----.|  |__|.-----.|  |--.    |     \.----.---.-.--.--.-----.|  |--.|  |_.-----.
//        |    __/|  _  ||  |  ||__ --||     |    |  --  |   _|  _  |  |  |  _  ||     ||   _|__ --|
//        |___|   |_____||__|__||_____||__|__|    |_____/|__| |___._|_____|___  ||__|__||____|_____|
//             a  brutal  game  by   T 3 /-\ /\/\   () /\/ 3              |_____|


package introduction;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;

public class Intro {

    public static final String PLAIN = "\033[0;0m";
    public static final String BOLD = "\033[0;1m";
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW_FOREGROUND = "\u001B[33m";
    public static final String CYAN_FOREGROUND = "\u001B[36m";
    public static final String RED_FOREGROUND = "\u001B[31m";
    public static final String BLUER_FOREGROUND = "\033[1;34m";
    public static final String YELLOWER_FOREGROUND = "\033[1;33m";
    public static final String BLACK_BACKGROUND = "\033[48;2;127;66;40m";
    public static final String BLACK_FOREGROUND = "\033[38;2;0;0;0m";
    public static final String WHITE_BACKGROUND = "\033[48;2;234;240;174m";
    public static final String WHITE_FOREGROUND = "\033[38;2;255;255;255m";
    private static final Random DRAWN = new Random();

    public void Intro1(String[] options) {

        System.out.print(BOLD + YELLOW_FOREGROUND +
                " ╔╦╗  ╔═╗  ╦  ╔╗╔    ╔╦╗  ╔═╗  ╔╗╔  ╦ ╦\n" +
                " ║║║  ╠═╣  ║  ║║║    ║║║  ║╣   ║║║  ║ ║\n" +
                " ╩ ╩  ╩ ╩  ╩  ╝╚╝    ╩ ╩  ╚═╝  ╝╚╝  ╚═╝\n" + PLAIN + RED_FOREGROUND +
                "▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞▞\n" + RESET);
        for (String option : options) {
            System.out.println(option);
            waitFor(100);
        }

    }

    public void goIntro(String[] args) {
        try {
            playSound("sounds/HAL_9000.wav");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try {
            simulateLoading();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        String[] options = {" [1] - Start the game",
                " [2] - Game instructions",
                " [3] - History of polish draughts",
                " [4] - The great team behind",
                " [5] - Random quote of the day",
                " [6] - Exit"
        };
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 6) {
            Intro1(options);
            try {
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        startThatBrutalGame();
                        break;
                    case 2:
                        showInstructions();
                        break;
                    case 3:
                        showHistoryofDraughts();
                        break;
                    case 4:
                        teamInfo();
                        break;
                    case 5:
                        quoteOfTheDay();
                        break;
                    case 6:
                        exit(0);
                    default: {
                        System.out.println(RED_FOREGROUND + "   Hey, that's not how we get along. Follow the instructions below." + RESET);
                        System.out.println("   Please choose an option (number between 1 and " + options.length + ")");
                    }
                }
            } catch (Exception ex) {
                System.out.println(RED_FOREGROUND + "   Well, that's not how we get along. Follow the instructions below." + RESET);
                System.out.println("   Please choose an option (number between 1 and " + options.length + ")...\n");
                scanner.next();
            }
        }
    }

    public void quoteOfTheDay() {
        final String[] QUOTES = { "Kill them Johny. Kill them all.“ (Unknown)",
                " “Evil’s just destructive? Then storms are evil if it’s that simple." +
                        " And we have a fire, and there’s hail. Underwriters lump it all under ‘Acts of God.’ (Hannibal Lecter)”",
                " “Being smart spoils a lot of things, doesn’t it?“ (Hannibal Lecter)",
                " “Knwxn cwcs spcow!“ (Guaycjjtr)", " “o0o0oooOooo)OO)oo0ooO)(oo...“  {Oo0oo)",
                " “I do wish we could chat longer, but I’m having an old friend for dinner.“ (Hannibal Lecter)",
                " “Remarkable boy. I do admire your courage. I think I’ll eat your heart!” (Hannibal Lecter)",
                " “You fly back to school now, little Starling. Fly, fly, fly. Fly, fly, fly.” (Hannibal Lecter)"};

                String quote = drawFromArray(QUOTES);
                fakeCLS();
                System.out.println("\n");
                System.out.println(quote);
    }

    public String drawFromArray(String[] input) {
            if (input != null || input.length > 0) {

            }

            return input[DRAWN.nextInt(input.length)];
        }


    public void showHistoryofDraughts() {
        fakeCLS();

    }

    public void showInstructions() {
        System.out.println(BLUER_FOREGROUND + "\n" + YELLOWER_FOREGROUND);
        System.out.println("       __ __  __  __  ______ ____  __ __   ___ ______ __   ___   __  __  __ \n" +
                "       || ||\\ || (( \\ | || | || \\\\ || ||  //   | || | ||  // \\\\  ||\\ || (( \\\n" +
                "       || ||\\\\||  \\\\    ||   ||_// || || ((      ||   || ((   )) ||\\\\||  \\\\ \n" +
                "       || || \\|| \\_))   ||   || \\\\ \\\\_//  \\\\__   ||   ||  \\\\_//  || \\|| \\_))\n\n" +
                RESET+ "       ===========================================================================\n");
        System.out.println(
                "       The goal of Polish Draughts Game is to remove all your opponent's pieces\n" +
                "        from the board or block its ability to move with the remaining pawns.\n\n" +
                "       Your pieces can only move forward one tile diagonally.\n\n" +
                "       To capture an opponent's piece and remove it from the board,\n" +
                "        you need to jump over their piece with one of yours.\n\n" +
                "       If one of your pieces gets to the opposite side of the board (the last row),\n" +
                "        it will turn into a Queen.\n" +
                "       Queens can move and jump diagonally in any direction at any distance.\n\n" + RED_FOREGROUND +
                "                               The marvellous Team ONE wish you good luck!\n" + RESET);

    }

    public void startThatBrutalGame() {
        fakeCLS();
        try {
            playSound("sounds/quite_sure.wav");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printItSlow("  Tu coś na sekundę max można mignąć");
        System.exit(1);
        fakeCLS();
    }

    // Options
    public static void option1() {
        System.out.println("Thanks for choosing option 1");
    }

    public static void option2() {
        System.out.println("Thanks for choosing option 2");
    }

    public static void teamInfo() {
        fakeCLS();
        try {
            playSound("sounds/l_ysium.wav");
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printTeamONE();
        waitFor(1000);
    }


    public static void fakeCLS() {
        for (int i = 0; i < 10; i++)
            System.out.println("\n\n\n\n\n");
    }

    public static void waitFor(int delay) throws RuntimeException {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    public static void playSound(String soundFile) throws LineUnavailableException, IOException {
        File f = new File("./" + soundFile);
        AudioInputStream audioIn = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        }
        clip.open(audioIn);
        clip.start();
    }


    private static String lastLine = "";

    public static void print(String line) {
        //clear the last line if longer
        if (lastLine.length() > line.length()) {
            String temp = "";
            for (int i = 0; i < lastLine.length(); i++) {
                temp += " ";
            }
            if (temp.length() > 1)
                System.out.print("\r" + temp);
        }
        System.out.print("\r" + line);
        lastLine = line;
    }

    private static byte anim;

    public static void animate(String line) {
        switch (anim) {
            case 1:
                print("[ \\ ] " + line);
                break;
            case 2:
                print("[ | ] " + line);
                break;
            case 3:
                print("[ / ] " + line);
                break;
            default:
                anim = 0;
                print("[ - ] " + line);
        }
        anim++;
    }

    public static void simulateLoading() throws InterruptedException {
        Intro consoleHelper = new Intro();
        for (int i = 0; i < 102; i += 2) {
            animate(i + "");
            Thread.sleep(80);
        }
    }


    public void printTitle1() {
        fakeCLS();
        System.out.println(
                        "8888888b.          888 d8b          888           8888888b.                                    888      888             \n" +
                        "888   Y88b         888 Y8P          888           888  \"Y88b                                   888      888             \n" +
                        "888    888         888              888           888    888                                   888      888             \n" +
                        "888   d88P .d88b.  888 888 .d8888b  88888b.       888    888 888d888 8888b.  888  888  .d88b.  88888b.  888888 .d8888b  \n" +
                        "8888888P\" d88\"\"88b 888 888 88K      888 \"88b      888    888 888P\"      \"88b 888  888 d88P\"88b 888 \"88b 888    88K      \n" +
                        "888       888  888 888 888 \"Y8888b. 888  888      888    888 888    .d888888 888  888 888  888 888  888 888    \"Y8888b. \n" +
                        "888       Y88..88P 888 888      X88 888  888      888  .d88P 888    888  888 Y88b 888 Y88b 888 888  888 Y88b.       X88 \n" +
                        "888        \"Y88P\"  888 888  88888P' 888  888      8888888P\"  888    \"Y888888  \"Y88888  \"Y88888 888  888  \"Y888  88888P' \n" +
                        "                              _                      ___             _     __              888                          \n" +
                        "   _    |_  __   _|_ _  |    (_| _ __  _    |_  \\/    |  _  _ __    / \\|\\||_          Y8b d88P                          \n" +
                        "  (_|   |_) | |_| |_(_| |    __|(_||||(/_   |_) /     | (/_(_||||   \\_/| ||__          \"Y88P\"                           ");
    }

    public void printTitle2() {
        System.out.println(CYAN_FOREGROUND +
                        "█ ▄▄  ████▄ █    ▄█    ▄▄▄▄▄    ▄  █     ██▄   █▄▄▄▄ ██     ▄     ▄▀   ▄  █    ▄▄▄▄▀ ▄▄▄▄▄ \n" +
                        "█   █ █   █ █    ██   █     ▀▄ █   █     █  █  █  ▄▀ █ █     █  ▄▀    █   █ ▀▀▀ █   █     ▀▄ \n" +
                        "█▀▀▀  █   █ █    ██ ▄  ▀▀▀▀▄   ██▀▀█     █   █ █▀▀▌  █▄▄█ █   █ █ ▀▄  ██▀▀█     █ ▄  ▀▀▀▀▄ \n" +
                        "█     ▀████ ███▄ ▐█  ▀▄▄▄▄▀    █   █     █  █  █  █  █  █ █   █ █   █ █   █    █   ▀▄▄▄▄▀ \n" +
                        " █              ▀ ▐               █      ███▀    █      █ █▄ ▄█  ███     █    ▀ \n" +
                        "  ▀                              ▀              ▀      █   ▀▀▀          ▀ \n" +
                        "                                                      ▀ " + RESET + "\n");
    }


    public static void printTeamONE() { System.out.println(YELLOWER_FOREGROUND);
        printItSlow("   ████████╗███████╗ █████╗ ███╗   ███╗     ██████╗ ███╗   ██╗███████╗");
        System.out.println(BLUER_FOREGROUND);
        printItSlow("   ╚══██╔══╝██╔════╝██╔══██╗████╗ ████║    ██╔═══██╗████╗  ██║██╔════╝");
        System.out.println(YELLOWER_FOREGROUND);
        printItSlow("      ██║   █████╗  ███████║██╔████╔██║    ██║   ██║██╔██╗ ██║█████╗  ");
        System.out.println(BLUER_FOREGROUND);
        printItSlow("      ██║   ██╔══╝  ██╔══██║██║╚██╔╝██║    ██║   ██║██║╚██╗██║██╔══╝  ");
        System.out.println(YELLOWER_FOREGROUND);
        printItSlow("      ██║   ███████╗██║  ██║██║ ╚═╝ ██║    ╚██████╔╝██║ ╚████║███████╗");
        System.out.println(BLUER_FOREGROUND);
        printItSlow("      ╚═╝   ╚══════╝╚═╝  ╚═╝╚═╝     ╚═╝     ╚═════╝ ╚═╝  ╚═══╝╚══════╝");
        System.out.println("");
        System.out.println(RED_FOREGROUND);
        printItSlow("         ..... tu czekam na pomysuy od Was (tylko imiona/nicki/role/co chcecie?");
        for (int i=0; i<10; i++) {
            System.out.println("");
            waitFor(333);
        }
        System.out.println(CYAN_FOREGROUND + " na razie wracam do mejnmenjó" + RESET);
        waitFor(321);
        fakeCLS();



    }

    public static void printItSlow(String sayWhat) {
        for (int i = 0; i < sayWhat.length(); i++) {
            System.out.print(sayWhat.charAt(i));
            if (sayWhat.charAt(i) == ' ') continue;
            waitFor(15);
        }





    }


    public void printDocumentation() {
        try {
            playSound(("sounds/chimera.wav"));
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fakeCLS();
        System.out.println("\n\n" + RED_FOREGROUND);
        System.out.println("                              ...\n" +
                "           s,                .                    .s\n" +
                "            ss,              . ..               .ss\n" +
                "            'SsSs,           ..  .           .sSsS'\n" +
                "             sSs'sSs,        .   .        .sSs'sSs\n" +
                "              sSs  'sSs,      ...      .sSs'  sSs\n" +
                "               sS,    'sSs,         .sSs'    .Ss\n" +
                "               'Ss       'sSs,   .sSs'       sS'\n" +
                "      ...       sSs         ' .sSs'         sSs       ...\n" +
                "     .           sSs       .sSs' ..,       sSs       .\n" +
                "     . ..         sS,   .sSs'  .  'sSs,   .Ss        . ..\n" +
                "     ..  .        'Ss .Ss'     .     'sSs. ''        ..  .\n" +
                "     .   .         sSs '       .        'sSs,        .   .\n" +
                "      ...      .sS.'sSs        .        .. 'sSs,      ...\n" +
                "            .sSs'    sS,     .....     .Ss    'sSs,\n" +
                "         .sSs'       'Ss       .       sS'       'sSs,\n" +
                "      .sSs'           sSs      .      sSs           'sSs,\n" +
                "   .sSs'____________________________ sSs ______________'sSs,\n" +
                ".sSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS'.Ss SSSSSSSSSSSSSSSSSSSSSs,\n" +
                "                        ...         sS'\n" +
                "                         sSs       sSs\n" +
                "                          sSs     sSs       - LCF\n" +
                "                           sS,   .Ss\n" +
                "                           'Ss   sS'\n" +
                "                            sSs sSs\n" +
                "                             sSsSs\n" +
                "                              sSs\n" +
                "                               s");
        waitFor(5000);
        System.out.println("\n  Press ENTER to hail Satan!!!\n" + RESET);


    }
}