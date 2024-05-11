import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String n1=sc.nextLine();
        
        StringBuilder sb=new StringBuilder();
        //String n1=String.valueOf(n);
        
        for(int i=n1.length()-1;i>=0;i--){
            sb.append(n1.charAt(i));
        }
        // while(n!=0){
        //     int rem=n
        // }
        System.out.println(sb.toString());
        sc.close();
    }
}
