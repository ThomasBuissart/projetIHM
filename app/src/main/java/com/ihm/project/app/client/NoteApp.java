package com.ihm.project.app.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.SimpleEventBus;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class NoteApp implements EntryPoint {

  /**
   * This is the entry point method.
   */
	public void onModuleLoad() {
		EventBus eventBus = GWT.create(SimpleEventBus.class);
		
	}
}
