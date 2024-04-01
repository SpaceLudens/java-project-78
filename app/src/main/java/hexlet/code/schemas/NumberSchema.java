package hexlet.code.schemas;


import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema() {
        super();
    }

    public NumberSchema required() {
        this.predicates.put("запрет на null", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> notNull = Objects::isNull;
        Predicate<Integer> greaterThanZer0 = s -> s > 0;
        this.predicates.put("только положительное число", notNull.or(greaterThanZer0));
        return  this;
    }

    public NumberSchema range(int min, int max) {
        this.predicates.put("допустимый диапазон", s -> (s >= min && s <= max));
        return this;
    }

    public boolean isValid(Integer data) {
        Collection<Predicate<Integer>> values = predicates.values();
        return values.stream().allMatch(p -> p.test(data));
    }
}
