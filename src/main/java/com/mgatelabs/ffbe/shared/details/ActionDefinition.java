package com.mgatelabs.ffbe.shared.details;

/**
 * Created by @mgatelabs (Michael Fuller) on 9/3/2017.
 */
public class ActionDefinition {
    private ActionType type;
    private String var;
    private String value;

    public ActionType getType() {
        return type;
    }

    public void setType(ActionType type) {
        this.type = type;
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        switch (type) {
            case SWIPE_LEFT: {
                return "Swipe Left: " + value;
            }
            case SWIPE_DOWN: {
                return "Swipe Down: " + value;
            }
            case SWIPE_UP: {
                return "Swipe Up: " + value;
            }
            case SWIPE_RIGHT: {
                return "Swipe Right: " + value;
            }
            case TAP: {
                return "Tap: " + value;
            }
            case ADD: {
                return "Add: " + value + " to Var: " + var;
            }
            case MSG: {
                return "Msg: " + value;
            }
            case POP: {
                return "Pop State";
            }
            case SET: {
                return "Set Var: " + var + " to: " + value;
            }
            case MOVE: {
                return "Move to state: " + value;
            }
            case PUSH: {
                return "Push state: " + value;
            }
            case STOP: {
                return "Stop";
            }
            case SWAP: {
                return "Swap to state: " + value;
            }
            case WAIT: {
                return "Wait: " + value + "ms";
            }
            case BATCH: {
                return "Batch";
            }
            case REPEAT: {
                return "Repeat";
            }
            case LAP: {
                return "Lap: " + value;
            }
            case EVENT:
                return "Event: " + value;
        }
        return "???";
    }
}
