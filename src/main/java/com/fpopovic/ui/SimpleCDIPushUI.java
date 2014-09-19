package com.fpopovic.ui;

import com.fpopovic.broadcaster.Broadcaster;
import com.fpopovic.broadcaster.BroadcasterListener;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import com.vaadin.ui.Button.ClickEvent;

import javax.inject.Inject;

@Theme("mytheme")
@SuppressWarnings("serial")
@CDIUI
@Push
public class SimpleCDIPushUI extends UI implements BroadcasterListener
{

    @Inject
    private Broadcaster broadcaster;

    @Override
    protected void init(VaadinRequest request) {
        System.out.println("started");
        broadcaster.addListener(this);
        final VerticalLayout layout = new VerticalLayout();
        layout.setMargin(true);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
                broadcaster.sendMessage("group1","mess1");
            }
        });
        layout.addComponent(button);
    }


    @Override
    public void receiveMessage(String group, String message) {
            access(new Runnable() {
                @Override
                public void run() {
                    Notification.show("Notified: "+ UI.getCurrent().toString());
                }
            });
        }
}
