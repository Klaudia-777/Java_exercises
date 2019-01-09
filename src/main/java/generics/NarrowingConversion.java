package generics;

public class NarrowingConversion {
    public static void main(String[] args) {
        NarrowingConversion conversion = new NarrowingConversion();
        int intVariable = Integer.MAX_VALUE;
        long longVariable = Long.MAX_VALUE;
        long longVariableWithoutLoosingInformation = Integer.MAX_VALUE; // automatic conversion from int to long

        conversion.methodIntArgument(intVariable);
        conversion.methodIntArgument((int) longVariable);
        conversion.methodIntArgument((int) longVariableWithoutLoosingInformation);

        Object str="klaudia";
        System.out.println(((String) str).length());


    }

    public void methodIntArgument(int argument) {
        System.out.println(argument);
    }
}