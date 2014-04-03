package com.ihm.project.app.client.presenter;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasHTML;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;
import com.ihm.project.app.client.service.ListenProfServiceAsync;

public class IndexPresenter implements Presenter {

	private final Display view;
	private final ListenProfServiceAsync listenProfService;
	private final EventBus eventBus;

	public static interface Display {
		public Widget getProfSpeechWidget();

		public HasHTML getProfSpeechText();

		public Widget asWidget();
	}

	public IndexPresenter(final Display view,
			final ListenProfServiceAsync listenProfService,
			final EventBus eventBus) {
		this.view = view;
		this.listenProfService = listenProfService;
		this.eventBus = eventBus;
	}

	@Override
	public void bind() {
		listen();
	}

	private void listen() {
		this.listenProfService.listen(new AsyncCallback<String>() {

			@Override
			public void onSuccess(final String arg0) {
				listen();
				IndexPresenter.this.view.getProfSpeechText().setHTML(
						IndexPresenter.this.view.getProfSpeechText().getText()
								+ arg0);
			}

			@Override
			public void onFailure(final Throwable arg0) {
				Window.alert(arg0.getMessage());
			}
		});
	}

	@Override
	public void go(final HasWidgets container) {
		bind();
		container.clear();
		container.add(this.view.asWidget());
	}

}