/**
 * Practice 02 — Resilience patterns (concept — no Spring required)
 *
 * Circuit breaker states: CLOSED → OPEN (fail fast) → HALF_OPEN (probe)
 * Used in IBM microservice interviews: Resilience4j, bulkhead, rate limit.
 */
public class P02_MicroserviceResiliencePatternsDemo {

    enum State { CLOSED, OPEN, HALF_OPEN }

    static class SimpleCircuitBreaker {
        private State state = State.CLOSED;
        private int failureCount = 0;
        private final int threshold = 3;

        boolean allowRequest() {
            return state != State.OPEN;
        }

        void recordSuccess() {
            failureCount = 0;
            state = State.CLOSED;
        }

        void recordFailure() {
            failureCount++;
            if (failureCount >= threshold) {
                state = State.OPEN;
                System.out.println("Circuit OPEN — stop calling failing downstream");
            }
        }
    }

    public static void main(String[] args) {
        SimpleCircuitBreaker breaker = new SimpleCircuitBreaker();

        for (int i = 1; i <= 5; i++) {
            if (!breaker.allowRequest()) {
                System.out.println("Call " + i + ": rejected (fail fast)");
                continue;
            }
            System.out.println("Call " + i + ": downstream failed");
            breaker.recordFailure();
        }
    }
}
