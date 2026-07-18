package modernjava;

/**
 * Java 21 pattern matching for switch with sealed types.
 */
public class PatternMatchingDemo {

    public static void main(String[] args) {
        Payment payment = new UpiPayment(100);
        System.out.println(describe(payment));

        Object value = "Hello";
        System.out.println(parse(value));
        System.out.println(parse(42));
    }

    static String describe(Payment payment) {
        return switch (payment) {
            case CreditCardPayment cc -> "Card payment: " + cc.pay();
            case UpiPayment upi -> "UPI payment: " + upi.pay();
        };
    }

    static String parse(Object obj) {
        return switch (obj) {
            case String s -> "String of length " + s.length();
            case Integer i -> "Integer value " + i;
            case null -> "null";
            default -> "Unknown type";
        };
    }
}
