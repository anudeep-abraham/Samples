package com.mvp.client;

import com.mvp.client.presenter.ResumePresenter;
import com.mvp.client.view.ResumeView;
import com.mvp.shared.FieldVerifier;
import com.mvp.shared.Person;
import com.mvp.shared.dto.Resume;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GWTMVP implements EntryPoint {
	LayoutPanel panel;
	TextBox textBox;
	Button button;
	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		Resume resume = new Resume();
		resume.setJobContent("Anudeep Job Content");
		resume.setResumeContent("Anudeep Resume content");
		ResumeView view = new ResumeView();
		ResumePresenter presenter = new ResumePresenter(resume, view);
		presenter.go(RootPanel.get("anudId"));

	}
}
