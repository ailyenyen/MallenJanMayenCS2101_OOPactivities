public class Escseq {
    public static void main(String[] args){

        for (int i = 1; i < 10; i++){
        int num = i * 7;
            if (i % 2 == 0){
                System.out.println("\t" + num);
            }
            else{
                System.out.println(num);
            }
        }
    }
}
