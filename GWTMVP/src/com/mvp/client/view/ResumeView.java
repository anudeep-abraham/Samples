package com.mvp.client.view;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.event.dom.client.BlurEvent;
import com.google.gwt.event.dom.client.BlurHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DecoratedPopupPanel;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DockLayoutPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.mvp.client.presenter.CKeditorPresenter;
import com.mvp.client.presenter.Display;
import com.mvp.client.presenter.Presenter;
import com.mvp.client.presenter.ResumePresenter;
import com.mvp.shared.dto.Resume;

public class ResumeView extends Composite implements Display {
	private final static String description_head = "<div><span class=\"descripton-html-head\"> <b>Optimize your resume using keywords matcher.</b></span>";
	private final static String description = "<div><span class=\"descripton-html\"> <br><b>A</b>pplying to a job online almost always means that resume screening software stands between you and a job interview. To land an interview, you need to know what the resume screener is looking for. Jobscan does.<br>Our tool will analyze your resume and tell you whether it's a good match for the job you want.<br>Just paste in your resume and the job description and you'll get instant feedback telling you what to prioritize, what you might be missing, and what changes you can make to get past the resume screeners.\n <br> <b>Try it now !!!</b></div><br></span>";
	final DecoratedPopupPanel simplePopup = new DecoratedPopupPanel(true);
	private VerticalPanel mainPanel = new VerticalPanel();
	private HorizontalPanel addPanelLeft = new HorizontalPanel();
	private HorizontalPanel addPanel = new HorizontalPanel();
	private HorizontalPanel uploadPanel = new HorizontalPanel();
	private HorizontalPanel addPanelButton = new HorizontalPanel();
	private TextArea textAreaResume;
	private TextArea textAreaDescription;
	private Button button;
	CKeditorView ckEditorResume = new CKeditorView("-1");
	CKeditorView ckEditorJob = new CKeditorView("-2");
	CKeditorPresenter presenterResume;
	CKeditorPresenter presenterJob;

	ResumePresenter presenter;

	public ResumeView() {
		buildView();
		initWidget(mainPanel);
	}

	public ResumeView(String firstName) {

	}

	@Override
	public void clear() {
		textAreaDescription.setText("");
		textAreaResume.setText("");
	}

	@Override
	public void setName(Resume resume) {
		
	}
	@Override
	public void addWidgets(Resume resume) {
		presenterResume = new CKeditorPresenter(resume, ckEditorResume);
		presenterResume.go(addPanel);

		presenterJob = new CKeditorPresenter(resume, ckEditorJob);
		presenterJob.go(addPanel);
	}
	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = (ResumePresenter) presenter;
	}

	private void buildView() {
		initTextAreas();

		button = new Button("Scan");
		button.setStyleName("button-scan");

		// addPanelLeft.add(new HTML(description_head));
		addPanelLeft.add(getStackPanel());

		// addPanel.add(getStackPanel());
		addPanel.add(ckEditorResume.asWidget());
		addPanel.add(ckEditorJob.asWidget());

		uploadPanel.add(new FileUploaderMoxiView().asWidget());
		// addPanel.add(textAreaResume);
		// addPanel.add(textAreaDescription);
		addPanelButton.add(getClearResumeButton());
		addPanelButton.add(button);
		addPanelButton.add(getClearDescriptionButton());

		mainPanel.add(addPanelLeft);
		mainPanel.add(uploadPanel);
		mainPanel.add(addPanel);
		mainPanel.add(addPanelButton);

		button.addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				clear();
			}
		});

	}

	private StackPanel getStackPanel() {
		StackPanel sPanel = new StackPanel();
		/// sPanel.add(new HTML(description_head));
		sPanel.add(new HTML(description_head + description));
		sPanel.setStyleName("panel sPanel");
		return sPanel;
	}

	private void initTextAreas() {
		textAreaResume = new TextArea();
		textAreaDescription = new TextArea();
		textAreaDescription.setStyleName("textArea");
		textAreaResume.setStyleName("textArea");
		textAreaResume.getElement().setPropertyString("placeholder", "Paste your resume...");
		textAreaDescription.getElement().setPropertyString("placeholder", "Paste the job description...");
	}

	private Button getClearResumeButton() {
		Button clearResume = new Button("Clear resume content !!!");
		clearResume.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				textAreaResume.setText("");
			}
		});
		clearResume.setStyleName("clearButtonResume");
		clearResume.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				Widget source = (Widget) event.getSource();
				showMessageBox("Clicking on this button will clear all the contents from the resume description box!!!",
						source);
			}
		});
		clearResume.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePopup.hide();
			}
		});
		return clearResume;
	}

	private Button getClearDescriptionButton() {
		Button clearDescription = new Button("Clear job description content !!!");
		clearDescription.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				textAreaDescription.setText("");
			}
		});
		clearDescription.setStyleName("clearButtonDescription");
		clearDescription.addMouseOverHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				Widget source = (Widget) event.getSource();
				showMessageBox("Clicking on this button will clear all the contents from the job description box!!!",
						source);
			}
		});
		clearDescription.addMouseOutHandler(new MouseOutHandler() {
			@Override
			public void onMouseOut(MouseOutEvent event) {
				simplePopup.hide();
			}
		});

		return clearDescription;
	}

	private void showMessageBox(String message, Widget source) {
		int left = source.getAbsoluteLeft() + 20;
		int top = source.getAbsoluteTop() + 30;
		GWT.log("left:" + left);
		GWT.log("top:" + top);
		simplePopup.setStyleName("decorator-popupPanelGlass");
		simplePopup.setWidth("150px");
		simplePopup.setWidget(new HTML(message));
		// simplePopup.addStyleName("popup");
		simplePopup.setPopupPosition(left, top);
		simplePopup.show();
	}

	
}
