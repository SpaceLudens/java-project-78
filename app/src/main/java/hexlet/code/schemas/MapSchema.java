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

    /**
     * Проверяет, соответствует ли переданная карта значений схеме, определенной для данного объекта MapSchema.
     * <p>
     * Метод сначала проверяет базовую валидацию, используя реализацию метода isValid() родительского класса. Затем он
     * проверяет каждую схему, определенную для объекта MapSchema, и проверяет, содержит ли переданная карта всех
     * необходимых ключей и соответствует ли каждое значение схеме для соответствующего ключа.
     * </p>
     *
     * @param value карта значений, которую необходимо проверить на соответствие схеме
     * @return true, если карта значений соответствует схеме; в противном случае - false
     */
    public boolean isValid(Map<String, String> value) {
        // Проверяем базовую валидацию
        if (!super.isValid(value)) {
            return false; // Ранний выход, если базовая валидация не прошла
        }

        // Проверяем соответствие структуре, если схема определена
        if (schemas != null) {
            // Проверяем каждую схему для ключей в схеме MapSchema
            return schemas.entrySet().stream()
                    .allMatch(entry -> {
                        String key = entry.getKey();
                        BaseSchema<String> schema = entry.getValue();

                        // Проверяем, содержит ли входное значение все необходимые ключи
                        if (!value.containsKey(key)) {
                            return false;
                        }

                        String val = value.get(key);

                        // Проверяем, что значение строки не равно null, прежде чем вызывать метод length()
                        return val != null && schema.isValid(val);
                    });
        }

        return true;
    }

}
