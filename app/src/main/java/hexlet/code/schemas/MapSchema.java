package hexlet.code.schemas;

import java.util.Map;
import java.util.Objects;

public final class MapSchema<T> extends BaseSchema<Map<String, T>> {
    public  MapSchema<T> required() {
        getPredicates().put("запрет на null", Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(Integer size) {
        getPredicates().put("ограничение на размер Map", s -> s.size() == size);
        return this;
    }

    public MapSchema<T> shape(Map<String, BaseSchema<T>> sch) {
        getPredicates().put("shape", map -> {
            return sch.entrySet().stream().allMatch(entry -> {
                String key = entry.getKey();
                BaseSchema<T> schema = entry.getValue();
                T s = map.get(key);
                return s != null && schema.isValid(s);
            });
        });
        return this;
    }

    public boolean isValid(Map<String, T> value) {
        return super.isValid(value);
    }
}
