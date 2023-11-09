import java.util.*;
public class UserInput {

    Scanner input = new Scanner(System.in);
    HashMap map = new HashMap();
    char a ;
    //Gets user input
    public void getInput() {

        System.out.println("Enter m for Morse to English or e for English to Morse.");

               a = input.next().toLowerCase().charAt(0);

           switch (a) {
               case 'm':
                   translateMorse();
                   break;
               case 'e':
                   translateEnglish();
                   break;
               default:
                   System.out.println("Wrong input please try again:");
                   input.nextLine();
                  getInput();
           }
    }
    //in case the user want to input another word or phrase
    public void repeat() {
        boolean bool = true;
        while (bool == true ){
            System.out.println("Do you want to translate something else? y or n");

            a = input.next().toLowerCase().charAt(0);

            switch (a) {
                case 'y':
                    getInput();
                    break;
                case 'n':
                    bool = false;
                    break;
                default:
                    System.out.println("Wrong input please try again:");
                    input.nextLine();
                    repeat();
            }
        }
    }

// english to morse
    public void translateEnglish() {
        System.out.println("Enter a phrase in English.");
        input.nextLine();
        String englishToMorse = input.nextLine();
        englishToMorse = englishToMorse.toLowerCase();

        int i = 0;

        while (i < englishToMorse.length()) {
             if(englishToMorse.charAt(i) == ' '){
                 System.out.print("  ");
             }
            else{System.out.print(map.translate(englishToMorse.charAt(i)) + ' ');}
            i++;
        }
    }

//morse to english
    public  void translateMorse()
    {
        System.out.println("Enter a phrase in Morse Code.");
        input.nextLine();
        String morseToEnglish = input.nextLine();
        map.invertMap();

       String[] words = morseToEnglish.split( "\\s{3,}");

       for(int i = 0; i < words.length; i++){

           String[] letter = words[i].split(" ");
           for(int j = 0; j < letter.length; j++){
               System.out.print(map.translateMorse(letter[j]));
           }
           System.out.print(" ");
       }

    }

}
