package hexlet.code.schemas;

public class StringSchema extends BaseSchema<String> {
    public StringSchema() {
        super();
    }

    public StringSchema required() {
        this.predicates.put("запрет на пустую строку", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        this.predicates.put("минимальная длина строки", s -> s.length() >= length);
        return this;
    }

    public StringSchema contains(String data) {
        this.predicates.put("строка содержит", s -> s.contains(data));
        return this;
    }

    @Override
    public boolean isValid(String value) {
        return super.isValid(value);
    }
}
