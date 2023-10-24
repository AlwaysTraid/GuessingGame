import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // System.out.println(s);
        String word = "lion";
        int guessCount = 5;
        int guessLimit = 0;
        Boolean letterFound = false;
        Boolean gameDone = false;
        String finalWord = "";
        
        String guess = "";
        char[] arr = new char[word.length()];

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = '-';
        }

        boolean outOfGuesses = false;
        Scanner reader = new Scanner(System.in);

        while(!guess.equals(word) && !outOfGuesses && !gameDone){
            for (int i = 0; i < arr.length; i++)
            {
                System.out.print(arr[i]);
            }
            if(guessCount >= guessLimit){
                System.out.print('\n');
                System.out.print("Enter guess: ");
                guess = reader.nextLine();

                for (int i = 0; i < word.length(); i++)
                {
                    if(guess.charAt(0) == (word.charAt(i))){
                        System.out.println("Correct");
                        arr[i] = guess.charAt(0);
                        letterFound = true;
                    }

                }
                //Checking Game Win
                for (int i = 0; i < arr.length; i++)
                {
                    finalWord += arr[i];
                }
                if(finalWord.equals(word)){
                    gameDone = true;
                }else{
                    finalWord = "";
                }
                if(!letterFound){
                    System.out.println("You have " + guessCount + " incorrect guess left.");
                    guessCount--;
                }
                letterFound = false;

            }
            else {
                outOfGuesses = true;
            }
            System.out.println();
        }

        if(outOfGuesses){
            System.out.println("You lose");
        }
        else {
            System.out.println("You Win!");
        }


    }
}

