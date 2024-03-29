package hexlet.code;

public class App {
    public static void main(String[] args) {
        var v = new Validator();
        var schema = v.string();
        System.out.println(v);
        System.out.println(schema);
        System.out.println(schema.isValid("str"));
        System.out.println(schema.required());
    }
}
