package hexlet.code.schemas;

import java.util.Map;
import  java.util.HashMap;
import java.util.Objects;

public final class MapSchema extends BaseSchema<Map<String, String>> {
    private Map<String, BaseSchema<String>> schemas;
    public MapSchema() {
        super();
        schemas = new HashMap<>();
    }

    public  MapSchema required() {
        getPredicates().put("запрет на null", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        getPredicates().put("ограничение на размер Map", s -> s.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> sch) {
        schemas = sch;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> value) {
        if (!super.isValid(value)) {
            return false;
        }
        if (schemas != null) {
            return schemas.entrySet().stream()
                    .allMatch(entry -> {
                        String key = entry.getKey();
                        BaseSchema<String> schema = entry.getValue();
                        if (!value.containsKey(key)) {
                            return false;
                        }
                        String val = value.get(key);
                        return val != null && schema.isValid(val);
                    });
        }
        return true;
    }
}
