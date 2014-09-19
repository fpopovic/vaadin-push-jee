package com.fpopovic.ui;

import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

/**
 * Created by fp on 18.9.2014.
 */
public class SimpleCDIPushUIProvider extends UIProvider{
    @Override
    public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
        return SimpleCDIPushUI.class;
    }


}
