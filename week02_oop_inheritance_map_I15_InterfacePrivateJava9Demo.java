/**
 * I15 — Q: private methods in interface (Java 9+) — example
 * A: Helpers for default/static only; NOT inherited, NOT overridable.
 */
public class I15_InterfacePrivateJava9Demo {

    interface PaymentService {
        void pay(double amount);

        default void payWithAudit(double amount) {
            validate(amount);       // private instance helper
            pay(amount);
            logSuccess(amount);
        }

        static String formatAmount(double amount) {
            return validateStatic(amount) + amount;
        }

        private void validate(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("amount must be > 0");
            }
        }

        private void logSuccess(double amount) {
            System.out.println("[AUDIT] paid " + amount);
        }

        private static String validateStatic(double amount) {
            if (amount <= 0) {
                throw new IllegalArgumentException("bad amount");
            }
            return "OK ";
        }
    }

    static class UpiPayment implements PaymentService {
        @Override
        public void pay(double amount) {
            System.out.println("UPI paid " + amount);
        }
        // validate(), logSuccess() — NOT visible here
    }

    public static void main(String[] args) {
        PaymentService ps = new UpiPayment();
        ps.payWithAudit(250);

        System.out.println(PaymentService.formatAmount(100));
    }
}
