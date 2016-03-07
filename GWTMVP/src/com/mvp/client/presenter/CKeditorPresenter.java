package com.mvp.client.presenter;

import com.google.gwt.user.client.ui.Panel;
import com.mvp.shared.dto.Resume;

public class CKeditorPresenter implements Presenter {

	Display view;
	Resume resume;

	public CKeditorPresenter(Resume resume, Display view) {
		this.resume = resume;
		this.view = view;
		bind();
	}

	@Override
	public void bind() {
		view.setPresenter(this);
		view.clear();
		view.setName(resume);
	}

	public void showName() {
		view.setName(resume);
	}

	@Override
	public void go(Panel panel) {
		panel.add(view.asWidget());
	}
}
