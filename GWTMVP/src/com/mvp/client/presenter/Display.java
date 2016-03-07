package com.mvp.client.presenter;

import com.google.gwt.user.client.ui.Widget;
import com.mvp.shared.dto.Resume;

public interface Display {
	public void clear();

	public void setName(Resume resume);
	
	public void addWidgets(Resume resume);

	public Widget asWidget();

	public void setPresenter(Presenter presenter);
}