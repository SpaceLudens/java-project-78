package hexlet.code.schemas;

import java.util.HashMap;
import java.util.Objects;

public class MapSchema extends BaseSchema<HashMap<String, String>> {
    public MapSchema() {
        super();
    }

    public MapSchema required() {
        this.predicates.put("запрет на null", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        this.predicates.put("ограничение на разме Map", s -> s.size() == size);
        return this;
    }
    @Override
    public boolean isValid(HashMap<String, String> value) {
        return super.isValid(value);
    }
}
