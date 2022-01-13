package com.example.mowater.ui.fragment.Agency.AgencyCarClasses;

import androidx.lifecycle.ViewModel;

public class AgencyCarClassesViewModel extends ViewModel {
    AgencyCarClassesContract.View view;

    void setContrct(AgencyCarClassesContract.View mView) {
        this.view = mView;
    }

    public void start() {
        if (view != null) {
            view.initUi();
            view.initRvCarClasses();
        }
    }
}
