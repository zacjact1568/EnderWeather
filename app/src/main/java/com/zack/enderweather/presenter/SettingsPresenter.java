package com.zack.enderweather.presenter;

import com.zack.enderweather.location.LocationHelper;
import com.zack.enderweather.view.SettingsView;

public class SettingsPresenter implements Presenter<SettingsView> {

    private SettingsView settingsView;
    private LocationHelper.PermissionDelegate mPermissionDelegate;

    public SettingsPresenter(SettingsView settingsView) {
        attachView(settingsView);
    }

    @Override
    public void attachView(SettingsView view) {
        settingsView = view;
    }

    @Override
    public void detachView() {
        settingsView = null;
    }

    public void setInitialView() {
        settingsView.showInitialView();
    }

    public void setPermissionDelegate(LocationHelper.PermissionDelegate delegate) {
        mPermissionDelegate = delegate;
    }
}