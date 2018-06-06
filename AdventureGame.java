import java.util.Scanner;

/*
Game class
 */
public class AdventureGame {
    public AdventureGame(){}

    public String playGame() {
        return "You are in a creepy house!  Would you like to go \"upstairs\" or into the \"kitchen\"?";
    }
    public String playGame2(String keyboard1){
        if(keyboard1.toLowerCase().equals("upstairs")) {

            return "Upstairs you see a hallway.  At the end of the hallway is the master\n" +
                    "\"bedroom\".  There is also a \"bathroom\" off the hallway.  Where would you like\n" +
                    "to go?";
        }else if(keyboard1.toLowerCase().equals("kitchen")){
                    return "There is a long countertop with dirty dishes everywhere.  Off to one side\n" +
                            "there is, as you'd expect, a refrigerator. You may open the \"refrigerator\" or look in a \"cabinet\"";}
                            return "Enter valid words from the choices";
        }
        public String playGame3(String keyboard2) {
            if (keyboard2.toLowerCase().equals("bedroom")) {
                return "You are in a plush bedroom, with expensive-looking hardwood furniture.  The\n" +
                        "bed is unmade.  In the back of the room, the closet door is ajar.  Would you\n" +
                        "like to open the door? (\"yup\" or \"nope\")";
            } else if (keyboard2.toLowerCase().equals("bathroom")) {
                return "You have chosen bathroom. Would you like to shower? (\"yeah\" or \"nah\")";
            } else if(keyboard2.toLowerCase().equals("refrigerator")){
                    return "Inside the refrigerator you see food and stuff.  It looks pretty nasty.\n" +
                            "Would you like to eat some of the food? (\"yes\" or \"no\")";
            }else if(keyboard2.toLowerCase().equals("cabinet")){
            return "Inside the cabinet, you will find cooking utensils that you may need to wash. " +
                    "Would you like to open it? (\"y\" or \"n\")";}
                return "Enter valid words from the choices";
        }
        public String playGame4(String keyboard3) {
                if(keyboard3.toLowerCase().equals("yup")) {
                    return "You should be extremely happy for your prize";
                }else if(keyboard3.toLowerCase().equals("nope")) {
                    return "Well, then I guess you'll never know what was in there.  Thanks for playing,\n" +
                            "I'm tired of making nested if statements.";
                } else if(keyboard3.toLowerCase().equals("yeah")){
                    return "There you go. Find a towel and body splash in the drawer";
                } else if(keyboard3.toLowerCase().equals("nah")){
                    return "You never got to shower. You are gonna stink.";
                } else if(keyboard3.toLowerCase().equals("yes")){
                    return "Help yourself...";
                } else if(keyboard3.toLowerCase().equals("no")){
                    return "You die of starvation... eventually.";
                } else if(keyboard3.toLowerCase().equals("y")){
                    return "You are the man, cook your own food...";
                } else if(keyboard3.toLowerCase().equals("n")){
                    return "Lazy boy, you are starving.";}
                return "Enter valid words from the choices";

        }

}
