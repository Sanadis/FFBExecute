package com.mgatelabs.piper.server.actions;

import com.mgatelabs.piper.server.EditHolder;

import java.util.logging.Logger;

/**
 * Created by @mgatelabs (Michael Fuller) on 9/22/2018.
 */
public interface EditActionInterface {
    String execute(final String id, final String value, final EditHolder holder, Logger logger);
}
