import java.util.Scanner;

public class Caesar {
    public static String encryptCaesar(String message) {
        int shift = 3;
        String out = "";
        for(int i=0;i<message.length();i++){
        if((message.charAt(i) <91-shift && message.charAt(i)>64) || (message.charAt(i) <123-shift && message.charAt(i)>96)){
            out+=(char) (message.charAt(i)+shift);
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (65+(message.charAt(i)%(91-shift)));
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (97+(message.charAt(i)%(123-shift)));
        }else{
            out+=message.charAt(i);
        }
        }
        return out;
    }

    public static String decryptCaesar(String message) {
        int shift = 3;
        String out = "";
        for(int i=0;i<message.length();i++){
        if( message.charAt(i) <91 && message.charAt(i)>(64+shift) || message.charAt(i) <123 && message.charAt(i)>(96+shift) ){
            out+=(char) (message.charAt(i)-shift);
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (91-shift+(message.charAt(i)%65));
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (123-shift+(message.charAt(i)%97));
        }else{
            out+=message.charAt(i);
        }
        }
        return out;
    }

    public static String encryptCaesarKey(String message, int key) {
        int shift = key%26;
        String out = "";
        for(int i=0;i<message.length();i++){
        if((message.charAt(i) <91-shift && message.charAt(i)>64) || (message.charAt(i) <123-shift && message.charAt(i)>96)){
            out+=(char) (message.charAt(i)+shift);
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (65+(message.charAt(i)%(91-shift)));
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (97+(message.charAt(i)%(123-shift)));
        }else{
            out+=message.charAt(i);
        }
        }
        return out;
    }

    public static String decryptCaesarKey(String message, int key) {
        int shift = key%26;
        String out = "";
        for(int i=0;i<message.length();i++){
        if( message.charAt(i) <91 && message.charAt(i)>(64+shift) || message.charAt(i) <123 && message.charAt(i)>(96+shift) ){
            out+=(char) (message.charAt(i)-shift);
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (91-shift+(message.charAt(i)%65));
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (123-shift+(message.charAt(i)%97));
        }else{
            out+=message.charAt(i);
        }
        }
        return out;
        
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Would you like to \"encrypt\" or \"decrypt\" a message?");
        String command = scan.nextLine().trim().toLowerCase();

        if (command.equals("encrypt")) {
            System.out.println("Please enter your message to be encrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptCaesar(message));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptCaesar(message));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
