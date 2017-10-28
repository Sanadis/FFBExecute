package com.mgatelabs.ffbe.shared.details;

/**
 * Created by @mgatelabs (Michael Fuller) on 9/3/2017.
 */
public enum ActionType {
    TAP(ActionValueType.COMPONENT_ID, false), // Screen Tap
    BATCH(ActionValueType.START_STOP, false), // Screen Tap
    SWIPE_UP(ActionValueType.COMPONENT_ID, false), // Swipe
    SWIPE_RIGHT(ActionValueType.COMPONENT_ID, false), // Swipe
    SWIPE_DOWN(ActionValueType.COMPONENT_ID, false), // Swipe
    SWIPE_LEFT(ActionValueType.COMPONENT_ID, false), // Swipe
    REPEAT(ActionValueType.NONE, false),
    SWAP(ActionValueType.STATE_ID, false), // Move to a new state, without taking a new image
    MOVE(ActionValueType.STATE_ID, false), // Move to a new state
    PUSH(ActionValueType.STATE_ID, false), // Start a new state, but still leave old state alone
    POP(ActionValueType.STATE_ID, false), // Don't with this bubble
    WAIT(ActionValueType.INT, false), // Wait a few MS
    MSG(ActionValueType.STRING, false), // Show a message
    STOP(ActionValueType.NONE, false), // Stop execution
    SET(ActionValueType.INT, true), // Zero a variable
    ADD(ActionValueType.INT, true), // Increment a variable
    TIMER(ActionValueType.ID, false); // TIMER EVENT

    private final ActionValueType valueType;

    private final boolean varNameRequired;

    ActionType(ActionValueType valueType, boolean varNameRequired) {
        this.valueType = valueType;
        this.varNameRequired = false;
    }

    public ActionValueType getValueType() {
        return valueType;
    }

    public boolean isVarNameRequired() {
        return varNameRequired;
    }
}
