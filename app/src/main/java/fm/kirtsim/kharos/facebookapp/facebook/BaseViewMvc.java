package fm.kirtsim.kharos.facebookapp.facebook;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;

import fm.kirtsim.kharos.facebookapp.ViewMvc;

/**
 * Created by kharos on 13/10/2017
 */

public abstract class BaseViewMvc<ListenerType> implements ViewMvc<ListenerType> {

    protected View rootView;
    protected ListenerType listener;

    protected void setRootView(View view) {
        rootView = view;
    }

    protected <T extends View> T findView(@IdRes int id) {
        return (T) rootView.findViewById(id);
    }

    @Override
    public void registerListener(ListenerType listener) {
        this.listener = listener;
    }

    @Override
    public void unregisterListener(ListenerType listener) {
        this.listener = null;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public Bundle getState() {
        Bundle state = new Bundle();
        saveState(state);
        return state;
    }
}
