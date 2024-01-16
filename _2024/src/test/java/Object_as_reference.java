class Box {
    int length;
    int breath;
    int height;

    public Box() {

    }

    void setdimension(int i, int i1, int i2) {
        length = i;
        breath = i1;
        height = i2;
        System.out.println("value from setdim : "+length+","+breath+","+height);
    }
    boolean isEqual(Box b){
        System.out.println("value from isequal, left : " + length + "," + breath + "," + height);
        System.out.println("value from isequal, right : " + b.length + "," + b.breath + "," + b.height);
        if(this.length == b.length && this.breath == b.breath && this.height == b.height) {
            return true;
        } else
        return false;
    }
    Box(int l, int b, int h){
        length = l;
        breath = b;
        height = h;
        System.out.println("value from Box constructor : "+length+","+breath+","+height);
    }
}
public class Object_as_reference{
    public static void main(String args[]){
        Box blackbox = new Box();
        blackbox.setdimension(35,4,3);

        Box b1 = new Box(15,4,3);
        System.out.println(blackbox.isEqual(b1));
    }
}
