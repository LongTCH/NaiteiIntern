//package bai6;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MyGenerics {
//
//    public class A {}
//
//    public class B extends A {}
//
//    public class C extends B {}
//
//    public class D extends  A {}
//
////    public void test(List<? extends A> myAlist) {
////        B b = new B();
////        D d = new D();
////        myAlist.add(b); // does not compile
////        myAlist.add(d); // does not compile
////        D a1 = (D)myAlist.get(0);
////    }
////
//    public void testUpperBound(List<? extends B> myBlist) {
//        B b = new B();
//        C c = new C();
//        myBlist.add(b); // does not compile
//        myBlist.add(c); // does not compile
//        A a = myBlist.get(1);
//    }
//
//    public void testLowerBound(List<? super B> myBlist) {
//        B b = new B();
//        C c = new C();
//        myBlist.add(b);
//        myBlist.add(c);
//        A a = myBlist.get(0); // does not compile
//        Object o = myBlist.get(0);
//    }
//
////    public void test2(B b){
////        A a = b;
////    }
//}