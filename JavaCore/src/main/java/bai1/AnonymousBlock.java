package bai1;

public class AnonymousBlock {
    public AnonymousBlock(){
        System.out.println("default constructor");
    }
    public AnonymousBlock(int i){
        System.out.println("parameter constructor");
    }
    {
        System.out.println("anonymous block");
    }

    public static void main(String[] args) {
        AnonymousBlock a = new AnonymousBlock();
        AnonymousBlock b = new AnonymousBlock(2);
    }
}
