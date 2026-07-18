package modernjava;

/**
 * Java 17+ sealed classes: restrict which classes can extend/implement.
 * Useful for type-safe domain modeling (Payment types, Shape types).
 */
sealed abstract class Payment permits CreditCardPayment, UpiPayment {
    protected final double amount;

    protected Payment(double amount) {
        this.amount = amount;
    }

    public abstract String pay();
}

final class CreditCardPayment extends Payment {
    CreditCardPayment(double amount) {
        super(amount);
    }

    @Override
    public String pay() {
        return "Paid " + amount + " via Credit Card";
    }
}

final class UpiPayment extends Payment {
    UpiPayment(double amount) {
        super(amount);
    }

    @Override
    public String pay() {
        return "Paid " + amount + " via UPI";
    }
}

public class SealedClassesDemo {
    public static void main(String[] args) {
        process(new CreditCardPayment(500));
        process(new UpiPayment(250));
    }

    static void process(Payment payment) {
        System.out.println(payment.pay());
    }
}
