package exceptions;

public class StackTraceExample {
    public static void main(String[] args) {
        StackTraceExample example = new StackTraceExample();
        try{
            example.method3();
        }catch(RuntimeException r){
            r.printStackTrace();
        }



    }

    public void method1() {
        method2();
    }

    public void method2() {
        method3();
    }

    public void method3() {
        throw new RuntimeException("BUM! BUM! BUM!");
    }
}