package com.mvp.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.TakesValue;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.TextArea;
import com.mvp.client.presenter.CKeditorPresenter;
import com.mvp.client.presenter.Display;
import com.mvp.client.presenter.Presenter;
import com.mvp.client.presenter.ResumePresenter;
import com.mvp.shared.dto.Resume;

public class CKeditorView extends Composite implements TakesValue<String>, Display {
	TextArea text = new TextArea();
	protected JavaScriptObject editor;
	CKeditorPresenter presenter;

	public CKeditorView(String id) {
		text.getElement().setId("anudck" + id);
		initWidget(text);
	}

	@Override
	protected void onAttach() {
		super.onAttach();
		GWT.log("inside onattach:" + text.getElement().getId());
		initCKEditor(text.getElement().getId());
	}

	private native void initCKEditor(String id) /*-{
		this.@com.mvp.client.view.CKeditorView::editor = $wnd.CKEDITOR
				.replace(id);
	}-*/;

	@Override
	public native void setValue(String value) /*-{
		this.@com.mvp.client.view.CKeditorView::editor.setData(value);
	}-*/;

	@Override
	public native String getValue() /*-{
		this.@com.mvp.client.view.CKeditorView::editor.setData(value);
	}-*/;

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setName(Resume resume) {
		if (text.getElement().getId().endsWith("1")) {
			text.setText(resume.getResumeContent());
		} else if (text.getElement().getId().endsWith("2")) {
			text.setText(resume.getJobContent());
		} else {
			text.setText("");
		}
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = (CKeditorPresenter) presenter;
	}

	@Override
	public void addWidgets(Resume resume) {
		// TODO Auto-generated method stub
		
	}
}