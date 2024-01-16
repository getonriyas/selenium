abstract class cricket{
     abstract void batting();
     abstract void fielding();
     abstract void umpiring();
     void bowling(){
         System.out.println("here how to do bowling...");
     }
}
abstract class teamIndia extends cricket{
    @Override
    void batting() {
        System.out.println("here how to do batting...");
    }
    @Override
    void fielding() {
        System.out.println("here is how to do fielding...");
    }
}
class teamIndiaUnder19Team extends teamIndia{

    @Override
    void umpiring() {
        System.out.println("here is how to do umpiring...");
    }
}
public class abstract_demo {
    public static void main(String args[]){
        cricket cric = new teamIndiaUnder19Team();
        cric.batting();
        cric.bowling();
        cric.fielding();
        cric.umpiring();
    }
}
