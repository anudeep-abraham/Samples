package com.mvp.client.view;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FileUploadView extends Composite {

	Label maxUpload = new Label();
	final FormPanel form = new FormPanel();

	public FileUploadView() {
		fileUpload();
		initWidget(form);
	}

	public void fileUpload() {

		VerticalPanel vPanel = new VerticalPanel();
		form.setMethod(FormPanel.METHOD_POST);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setAction("/FileUploadGreeting");
		form.setWidget(vPanel);
		FileUpload fileUpload = new FileUpload();
		fileUpload.setName("uploader");
		vPanel.add(fileUpload);

		maxUpload = new Label();
		maxUpload.setText("Maximum upload file size: 1MB");
		vPanel.add(maxUpload);

		vPanel.add(new Button("Submit", new ClickHandler() {
			public void onClick(ClickEvent event) {
				form.submit();
			}
		}));
		form.addSubmitCompleteHandler(new SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {

				maxUpload.setText("Succ:" + event.getResults());
			}
		});

	}
}
