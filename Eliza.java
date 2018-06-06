import java.util.*;

public class Eliza {

    public static void main(String[] args)
    {
        /*
        Collections storing hedges, qualifiers and replacements
         */

        ArrayList<String> qualifiers = new ArrayList<String>();
        qualifiers.add("Why do you say that");
        qualifiers.add("You seem to think that");
        qualifiers.add("So, you are concerned that");

        ArrayList<String> hedges = new ArrayList<String>();
        hedges.add("Please tell me more");
        hedges.add("Many of my patients tell me the same thing");
        hedges.add("It is getting late, maybe we had better quit");

        HashMap<String, String> replacements = new HashMap<String, String>();
        replacements.put("i", "you");
        replacements.put("me", "you");
        replacements.put("my", "your");
        replacements.put("am", "are");

        ArrayList<String> responses = new ArrayList<String>();

        System.out.println("Good day. What is your problem? Enter your response here or Q to quit: ");

        while(true){
            Scanner input = new Scanner(System.in);
            String question = input.nextLine();

            //Quit when Q is entered
            if(question.toUpperCase().equals("Q")){
                break;
            }

            int counter = 0; //When program runs more than 10 times
            counter++;
            if(counter > 10){
                System.out.println("Sorry, it is getting late. I have to go");
                break;
            }

            Random rand = new Random();
            /*
            Split the user's input and make replacements from the HashMap
             */
            String [] questionarray = question.split(" ", 100); //Split the sentence in patches of words
            List<String> questionList = Arrays.asList(questionarray);

            String result = "";
            int i = 0;
            Boolean makeRed = false, makeCap = false, makePig = false, playGame = false;//Boolean flags for criterias

            while( i < questionList.size()) {

                /*
                Replacements
                 */
                if (questionList.get(i).toLowerCase().equals("i") || questionList.get(i).toLowerCase().equals("me")) {
                    questionList.set(i, replacements.get("i")); //getting values by key from the HashMap
                } else if (questionList.get(i).toLowerCase().equals("my")) {
                    questionList.set(i, replacements.get("my"));
                } else if (questionList.get(i).toLowerCase().equals("am")) {
                    questionList.set(i, replacements.get("am"));
                }

                /*
                Stylings
                 */
                if(questionList.get(i).toLowerCase().equals("red")){
                    makeRed = true;
                } else if(questionList.get(i).toLowerCase().equals("caps")){
                    makeCap = true;
                } else if(questionList.get(i).toLowerCase().equals("pig")) {
                    makePig = true;
                } else if(questionList.get(i).toLowerCase().equals("play") && questionList.get(i+1).toLowerCase().equals("game")) {
                    playGame = true; //Play game if two consecutive words are play and game
                } else {
                    questionList.set(i, questionList.get(i).toLowerCase());
                }
                result = result + " " + questionList.get(i); //Append response back
                i++;
            }
            /*
            Generate random message of either a hedge or a statement appended with a qualifier
             */
            switch(rand.nextInt(2)) {
                case 0:
                    /*
                    Printing qualifier
                     */
                    if(makeRed) { //print qualifier and input in red
                        responses.add("\u001B[31m" + qualifiers.get(rand.nextInt(3)) + result.toString().toLowerCase() + "\u001B[0m");
                        System.out.println("\u001B[31m" + qualifiers.get(rand.nextInt(3)) + result.toString().toLowerCase() + "\u001B[0m");
                    }else if(makeCap){ //print qualifier and input in all caps
                        responses.add(qualifiers.get(rand.nextInt(3)).toUpperCase() + result.toString().toUpperCase());
                        System.out.println(qualifiers.get(rand.nextInt(3)).toUpperCase() + result.toString().toUpperCase());
                    } else if(makePig){ //print qualfier and input in pig latin
                        String pigLatinResp = pigLatin(qualifiers.get(rand.nextInt(3)).toLowerCase().concat(result.toLowerCase()));//calling helper function
                        responses.add(pigLatinResp);
                        System.out.println(pigLatinResp);
                    } else if(playGame){ //Play game
                        AdventureGame adv = new AdventureGame();
                        System.out.println(adv.playGame());
                        String keyboard1 = input.nextLine();
                        System.out.println(adv.playGame2(keyboard1));
                        String keyboard2 = input.nextLine();
                        System.out.println(adv.playGame3(keyboard2));
                        String keyboard3 = input.nextLine();
                        System.out.println(adv.playGame4(keyboard3));
                    } else{//print qualifier and input in a regular text to the console
                        responses.add(qualifiers.get(rand.nextInt(3)) + result.toString());
                        System.out.println(qualifiers.get(rand.nextInt(3)) + result.toString());}

                    break;
                case 1:
                    /*
                    Printing hedge
                     */
                    if(makeRed){//print hedges in red
                        responses.add("\u001B[31m" + hedges.get(rand.nextInt(3)) + "\u001B[0m");
                        System.out.println("\u001B[31m" + hedges.get(rand.nextInt(3)) + "\u001B[0m");
                    }else if(makeCap){//print hedges in all cap
                        responses.add(hedges.get(rand.nextInt(3)).toUpperCase());
                        System.out.println(hedges.get(rand.nextInt(3)).toUpperCase());
                    }else if(makePig){//print hedge in pig latin
                        String pigLatinResp = pigLatin((hedges.get(rand.nextInt(3)).toLowerCase()));
                        responses.add(pigLatinResp);
                        System.out.println(pigLatinResp);
                    } else if(playGame){//play game
                        AdventureGame adv = new AdventureGame();
                        System.out.println(adv.playGame());
                        String keyboard1 = input.nextLine();
                        System.out.println(adv.playGame2(keyboard1));
                        String keyboard2 = input.nextLine();
                        System.out.println(adv.playGame3(keyboard2));
                        String keyboard3 = input.nextLine();
                        System.out.println(adv.playGame4(keyboard3));

                    } else{//print hedge in regular text
                        responses.add(hedges.get(rand.nextInt(3)));
                        System.out.println(hedges.get(rand.nextInt(3)));}
                    break;
            }

            System.out.println("Enter your response here or Q to quit: ");
        }
    }

    public static String pigLatin(String sentence){ //helper function for pig latin
        String [] stgarray = sentence.split(" ", -2);
        int p = 0;
        String word = "";
        String result = "";
        char ch;

        for( int k = 0; k < stgarray.length; k++){
            for(int j = 0; j < stgarray[k].length(); j++) {
                ch = stgarray[k].charAt(j);
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    p = j;
                    break;
                }
            }
                String pre = stgarray[k].substring(p, stgarray[k].length()); //shift the letters around
                String post = stgarray[k].substring(0, p);
                word = pre + post + "ay";
                result = result + " " + word; //append the words back to form a sentence
        }
        return result;
    }

}
