package hexlet.code.schemas;

public class StringSchema extends BaseSchema {

    private boolean requiredFlag;
    private Integer minLength;
    private String containsSubstring;

    public StringSchema() {
        this.requiredFlag = false;
        this.minLength = null;
        this.containsSubstring = null;
    }

    public StringSchema required() {
        this.requiredFlag = true;
        return this;
    }

    public StringSchema minLength(int length) {
        this.minLength = length;
        return this;
    }

    public StringSchema contains(String substring) {
        this.containsSubstring = substring;
        return this;
    }


    public boolean isValid(String data) {
        if (requiredFlag && (data == null || data.isEmpty())) {
            return false;
        }
        if (minLength != null && data.length() < minLength) {
            return false;
        }
        if (containsSubstring != null && !data.contains(containsSubstring)) {
            return false;
        }
        return true;
    }
}
