package comparatorComparableEx;

public class Reference {

    public Integer value;

    public static int dosmth(final Reference ref) {
        ref.value=2;
        for (int i = 0; i <12 ; i++) {

        }
        ref.value=123;
        return 0;
    }
    public static void main(String[] args) {

        Reference reference = new Reference();
        reference.value=14;
        System.out.println(reference.value);
        dosmth(reference);
        System.out.println(reference.value);
    }
}
