import java.util.Scanner;

public class Vigenere {
    public static String encryptVigenere(String message, String key) {
        int cycle =0;
        String out = "";
        for(int i=0;i<message.length();i++){
        if(cycle==key.length()){
            cycle=0;
        }
        int shift = key.charAt(cycle)-65;
        if((message.charAt(i) <91-shift && message.charAt(i)>64) || (message.charAt(i) <123-shift && message.charAt(i)>96)){
            out+=(char) (message.charAt(i)+shift);
            cycle+=1;
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (65+(message.charAt(i)%(91-shift)));
            cycle+=1;
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (97+(message.charAt(i)%(123-shift)));
            cycle+=1;
        }else{
            out+=message.charAt(i);
        }
        }
        return out;
    }

    public static String decryptVigenere(String message, String key) {
        int cycle =0;
        String out = "";
        for(int i=0;i<message.length();i++){
        if(cycle==key.length()){
            cycle=0;
        }
        int shift = key.charAt(cycle)-65;
        if( message.charAt(i) <91 && message.charAt(i)>(64+shift) || message.charAt(i) <123 && message.charAt(i)>(96+shift) ){
            out+=(char) (message.charAt(i)-shift);
            cycle+=1;
        }else if(message.charAt(i)<91&&message.charAt(i)>64){
            out+=(char) (91-shift+(message.charAt(i)%65));
            cycle+=1;
        }else if(message.charAt(i)<123&&message.charAt(i)>96){
            out+=(char) (123-shift+(message.charAt(i)%97));
            cycle+=1;
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
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your encrypted message: ");
            System.out.println(encryptVigenere(message, key));
        }
        else if (command.equals("decrypt")) {
            System.out.println("Please enter your message to be decrypted: ");
            String message = scan.nextLine();
            System.out.println("Please enter the key for your message: ");
            String key = scan.nextLine().trim().toUpperCase();
            System.out.println("Here is your decrypted message: ");
            System.out.println(decryptVigenere(message, key));
        }
        else {
            System.out.println("Unknown command; please type either \"encrypt\" or \"decrypt\"");
        }

        scan.close();
    }
}
