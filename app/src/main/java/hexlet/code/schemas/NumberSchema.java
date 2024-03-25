package hexlet.code.schemas;



public class NumberSchema extends BaseSchema {
    private boolean requiredFlag;
    private boolean positiveFlag;
    private boolean rangeFlag;
    private Integer minRange;
    private Integer maxRange;

    public NumberSchema() {
        this.requiredFlag = false;
        this.positiveFlag = false;
        this.rangeFlag = false;
        this.minRange = null;
        this.maxRange = null;
    }

    public NumberSchema required() {
        this.requiredFlag = true;
        return this;
    }

    public NumberSchema positive() {
        this.positiveFlag = true;
        return  this;
    }

    public NumberSchema range(int min, int max) {
        this.rangeFlag = true;
        this.minRange = min;
        this.maxRange = max;
        return this;
    }


    public boolean isValid(Integer data) {
        if (requiredFlag && data == null) {
            return false;
        }
        if (positiveFlag) {
            if (!requiredFlag && data == null) {
                return true;
            }
            if (data <= 0) {
                return false;
            }
        }
        if (rangeFlag && (data < minRange || data > maxRange)) {
            return false;
        }
        return true;
    }
}
