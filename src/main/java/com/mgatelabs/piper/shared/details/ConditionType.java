package com.mgatelabs.piper.shared.details;

/**
 * Created by @mgatelabs (Michael Fuller) on 9/3/2017 for Phone-Piper
 */
public enum ConditionType {
    SCREEN(true),
    BOOLEAN(false),
    GREATER(false),
    LESS(false),
    EQUAL(false),
    CALL(false);

    private boolean splitValue;

    ConditionType(boolean splitValue) {
        this.splitValue = splitValue;
    }

    public boolean isSplitValue() {
        return splitValue;
    }
}
