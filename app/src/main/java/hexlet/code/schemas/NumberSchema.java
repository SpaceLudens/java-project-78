package hexlet.code.schemas;

import java.util.Objects;
import java.util.function.Predicate;

public final class NumberSchema extends BaseSchema<Integer> {
    public NumberSchema required() {
        getPredicates().put("запрет на null", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        Predicate<Integer> notNull = Objects::isNull;
        Predicate<Integer> greaterThanZer0 = s -> s > 0;
        getPredicates().put("только положительное число", notNull.or(greaterThanZer0));
        return  this;
    }

    public NumberSchema range(int min, int max) {
        getPredicates().put("допустимый диапазон", s -> (s >= min && s <= max));
        return this;
    }

    public boolean isValid(Integer data) {
        return super.isValid(data);
    }
}
