package com.fpopovic.ui;

import com.fpopovic.broadcaster.Broadcaster;
import com.fpopovic.broadcaster.BroadcasterListener;
import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.server.Responsive;
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

    @Inject
    private CDIViewProvider cdiViewProvider;


    @Override
    protected void init(VaadinRequest request) {
        System.out.println("started");
        broadcaster.addListener(this);

        final VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        Responsive.makeResponsive(layout);
        setContent(layout);
        
        Button button = new Button("Click Me");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                layout.addComponent(new Label("Thank you for clicking"));
                broadcaster.sendMessage("group1","mess1");
            }
        });
        //layout.addComponent(button);

        CssLayout cssLayout = new CssLayout();
        cssLayout.addStyleName("example-css-layout");
        cssLayout.setSizeFull();
        AbsoluteLayout absoluteLayout = new AbsoluteLayout();
        absoluteLayout.addStyleName("example-absolute-layout");
        absoluteLayout.setSizeFull();
        Responsive.makeResponsive(cssLayout);
        Responsive.makeResponsive(absoluteLayout);

        Label cssLabel = new Label("This is CssLayout Label");
        cssLabel.addStyleName("example-css-label");
        cssLabel.setSizeUndefined();
        Label absoluteLabel = new Label("This is Absolute Label");
        absoluteLabel.addStyleName("example-absolute-label");
        absoluteLabel.setSizeUndefined();
        Responsive.makeResponsive(cssLabel);
        Responsive.makeResponsive(absoluteLabel);

        cssLayout.addComponent(cssLabel);
        absoluteLayout.addComponent(absoluteLabel,"top:20px;right:50px;");

        layout.addComponent(cssLayout);
        layout.addComponent(absoluteLayout);
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
