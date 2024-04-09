package hexlet.code.schemas;

public final class StringSchema extends BaseSchema<String> {
    public StringSchema required() {
        getPredicates().put("запрет на null", s -> s != null && !s.isEmpty());
        return this;
    }

    public StringSchema minLength(int length) {
        getPredicates().put("минимальная длина строки", s -> s.length() >= length);
        return this;
    }

    public StringSchema contains(String data) {
        getPredicates().put("строка содержит", s -> s.contains(data));
        return this;
    }

    public boolean isValid(String value) {
        return super.isValid(value);
    }
}
