class student {
    student() {
        System.out.println("1. No parameter constructor");
    }
    student(int a, int b) {
        System.out.println("2. Avg: " + (a + b) / 2);
    }
    void volume(){
        System.out.println("method calling");
    }
    void volume(int a){
        System.out.println("method overloading : "+a);
    }
}
public class constructor_overload{

    public static void main(String arg[]){
        student c_o = new student();
        student c_o1 = new student(10,20);
        c_o.volume();
        c_o1.volume(5);


    }
}
