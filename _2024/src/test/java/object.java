public class object {

    int length;
    int breath;
    int height;

   // public object(object ob) {
   //     if()
   // }
   static void increment(int a){
        a++;

       System.out.println("from increment method: : "+a);

   }

    public static void main(String args[]){
    //    object o = new object(1,2,3);
    //    object o1 = new object(11,12,13);
        int a = 10;
        increment(a);

        System.out.println("from main: "+a);
    }
}
