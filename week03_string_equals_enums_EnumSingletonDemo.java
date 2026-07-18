package enums;

/**
 * Enum singleton: thread-safe, serialization-safe, one instance guaranteed.
 * Common interview pattern.
 */
enum DatabaseConnection {
    INSTANCE;

    private boolean connected;

    public void connect() {
        if (!connected) {
            connected = true;
            System.out.println("Database connected (singleton enum)");
        }
    }

    public void disconnect() {
        connected = false;
        System.out.println("Database disconnected");
    }
}

public class EnumSingletonDemo {
    public static void main(String[] args) {
        DatabaseConnection c1 = DatabaseConnection.INSTANCE;
        DatabaseConnection c2 = DatabaseConnection.INSTANCE;

        c1.connect();
        System.out.println("Same instance? " + (c1 == c2));
    }
}
