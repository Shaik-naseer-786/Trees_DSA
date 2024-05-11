public class count {
    public static  int[] evenOddBit(int n) {
        int even=0;
        int odd=0;
        int k=(int) Math.sqrt(n);
        for(int i=0;i<=k;i++){
            if(i%2==0 && n%2==1){
                even+=1;
            }
            if(i%2==1 && n%2==1){
                odd+=1;
            }
            n=n/2;

        }
        return new int[]{even,odd};
    }
    
    public static void main(String[] args) {
        int[] arr=evenOddBit(2);
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}