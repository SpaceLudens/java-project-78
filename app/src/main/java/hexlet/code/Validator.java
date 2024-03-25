package hexlet.code;

import hexlet.code.schemas.NumberSchema;
import hexlet.code.schemas.StringSchema;

public class Validator {
    StringSchema stringSchema;
    NumberSchema numberSchema;

    public StringSchema string() {
        this.stringSchema = new StringSchema();
        return this.stringSchema;
    }

    public NumberSchema number() {
        this.numberSchema = new NumberSchema();
        return this.numberSchema;
    }
}
