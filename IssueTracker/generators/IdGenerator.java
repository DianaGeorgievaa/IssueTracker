package generators;

public class IdGenerator {
    private static int id;

    public static int generate() {
        return ++id;
    }
}
