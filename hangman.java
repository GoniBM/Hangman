import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.ArrayList;
import java.util.Random;
import java.util.Locale;
import java.util.Scanner;

public class hangman {
    public static ArrayList<Character> prev = new ArrayList<Character>();

    public static void main(String[] args) {
        String userword;

        System.out.println("enter 1 for user input and 0 for random word");


        if (startgame() == 1) {
            userword = userPicksWord();
        } else {
            userword = randomWord();
        }
        int originalHealth = wordhealthGenerator(userword);
        char[] board = boardGenerator(userword);
        System.out.println("\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n" + "\n");


        int z = 6;
        int count = 0;

        while (true) {

            missprinter(count);

            if (originalHealth == 0) {
                System.out.println("winner winner chicken dinner");
                break;
            }

            if (z == 0) {
                System.out.println("loser loser eat a rotten tomatoe");
                break;
            }

            //System.out.println(originalHealth + " letters to guess");
            // System.out.println(z + " attempts till lost");
            System.out.println("Guess A Letter");
            System.out.println(board);
            Scanner IO = new Scanner(System.in);
            String g = IO.next().toLowerCase(Locale.ROOT);
            char guess = g.charAt(0);

            while (!Character.isLetter(guess) || g.length() != 1 || prev.contains(guess)) {
                System.out.println("enter a single letter you have not guessed before");
                g = IO.next().toLowerCase(Locale.ROOT);
                guess = g.charAt(0);
            }
/*
            if (z == 1) {
                System.out.println("this is your last chance");
            }
            if (originalHealth == 1) {
                System.out.println("almost there");
            }

 */

            int counter = 0;
            for (int i = 0; i < userword.length(); i++) {

                if (userword.charAt(i) == guess) {
                    originalHealth = originalHealth - 1;
                    board[i] = guess;
                    counter++;
                }

            }
            if (userword.contains(g)) {
                System.out.println(counter + " correct letter(s) guessed");
                z++;
            }

            if (!userword.contains(g)) {
                count = count + 1;
                System.out.println("wrong");

            }


            z--;


            prev.add(guess);
        }


    }

    public static int startgame() {
        Scanner Io = new Scanner(System.in);
        String a = Io.nextLine();

        while (!Stringnum(a)||Integer.parseInt(a) > 2|| Integer.parseInt(a) < 0 ) {
            System.out.println("try again");
            a = Io.nextLine();
        }


        return Integer.parseInt(a);
    }


    public static boolean badworddetector(String word) {

        String[] notallowed = {"fuck", "shit", "mom", "your", "stupid", "dumb", "idiot", "bullshit", "bullshit", "dumby", "goni", "bitch", "fucker", "motherfucker"};
        for (int i = 0; i < notallowed.length; i++) {
            if (word.contains(notallowed[i])) {
                System.out.println("the word " + notallowed[i].toUpperCase(Locale.ROOT) + " is not allowed, you should look down on yourself for writing such a thing, you " + notallowed[i].toUpperCase(Locale.ROOT) + "in idiot");
                return true;
            }
        }
        return false;

    }


    public static String userPicksWord() {
        System.out.println("Enter a word for your opponents to guess");
        Scanner forx = new Scanner(System.in);

        String word = forx.nextLine();




        while (word.length() < 2 || !VowelChecker(word) || badworddetector(word) || !isWord(word)) {
            System.out.print("Pick a word of length two or more that contains at least one vowel\n");
            Scanner g = new Scanner(System.in);
            word = g.nextLine();

        }

        return word;
    }
    public static boolean isWord(String word){
        for(int i = 0; i < word.length();i++){
            if(!(Character.isLetter(word.charAt(i))) &&  word.charAt(i) != ' ' ){
                return false;
            }
        }
    return true;}

    public static String randomWord() {
        Random rand = new Random();
        String[] random = {"Terminator", "Slicer", "Ninja", "cow", "Robot", "Person"};

        int randword = rand.nextInt(random.length);

    return random[randword];}

    public static boolean Stringnum(String num) {
        try {
            Integer.valueOf(num);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public static void missprinter(int count) {
        if(count ==0){
            miss();
        }
        if (count == 1) {
            miss12();
        }
        if (count == 2) {
            miss1();
        }
        if (count == 3) {
            miss2();
        }
        if (count == 4) {
            miss3();
        }
        if (count == 5) {
            miss4();
        }
        if (count == 6) {
            miss5();
        }

    }

    public static void miss() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("___");

    }

    public static void miss12() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|");
        System.out.println("| ");
        System.out.println("|");
        System.out.println("___");
    }

    public static void miss1() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|     |");
        System.out.println("| ");
        System.out.println("|");
        System.out.println("___");
    }


    public static void miss2() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    -|");
        System.out.println("|");
        System.out.println("|");
        System.out.println("___");
    }

    public static void miss3() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    -|-");
        System.out.println("| ");
        System.out.println("|");
        System.out.println("___");
    }

    public static void miss4() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    -|-");
        System.out.println("|      (");
        System.out.println("|");
        System.out.println("___");
    }

    public static void miss5() {
        System.out.println("------");
        System.out.println("|     |");
        System.out.println("|     O");
        System.out.println("|    -|-");
        System.out.println("|    ) (");
        System.out.println("|");
        System.out.println("___");
    }


    public static boolean VowelChecker(String word) {

        for (int i = 0; i < word.length(); i++) {
            if (word.contains("a") || word.contains("e") || word.contains("y") || word.contains("u") || word.contains("i")) {
                return true;
            }
        }
        return false;
    }

    public static char[] boardGenerator(String word) {
        char[] board = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ' ') {
                board[i] = ' ';
            } else {
                board[i] = '_';
            }

        }

        return board;
    }

    public static int wordhealthGenerator(String word) {
        int health = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != ' ') {
                health = health + 1;
            }


        }
        return health;
    }

    public static int wordHealtht(int health) {
        health = health - 1;
        return health;
    }

}
