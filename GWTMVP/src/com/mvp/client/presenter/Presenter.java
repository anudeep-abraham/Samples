package com.mvp.client.presenter;

import com.google.gwt.user.client.ui.Panel;
import com.mvp.shared.dto.Resume;

public interface Presenter {
	void bind();

	void go(Panel panel);
	
}
