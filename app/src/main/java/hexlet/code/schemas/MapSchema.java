package hexlet.code.schemas;

import hexlet.code.Validator;

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
        this.predicates.put("запрет на null", Objects::nonNull);
        return this;
    }

    public MapSchema sizeof(Integer size) {
        this.predicates.put("ограничение на размер Map", s -> s.size() == size);
        return this;
    }

    public MapSchema shape(Map<String, BaseSchema<String>> sch) {
        schemas = sch;
        return this;
    }

    @Override
    public boolean isValid(Map<String, String> value) {
        var v = new Validator();
        var schema = v.string();
        boolean result = true;
        if (super.isValid(value)) {
            for (Map.Entry<String, BaseSchema<String>> entry : schemas.entrySet()) {
                if (value.containsKey(entry.getKey())) {
                    if (value.containsValue(null)) {
                        return false;
                    }
                    schema = (StringSchema) entry.getValue();
                    result = schema.isValid(value.get(entry.getKey()));
                }
            }
        } else {
            result = false;
        }
        return result;
    }
}
