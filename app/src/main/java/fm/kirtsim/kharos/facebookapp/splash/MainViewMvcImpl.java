package fm.kirtsim.kharos.facebookapp.splash;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import fm.kirtsim.kharos.facebookapp.R;
import fm.kirtsim.kharos.facebookapp.facebook.BaseViewMvc;

/**
 * Created by kharos on 20/10/2017
 */

public class MainViewMvcImpl extends BaseViewMvc implements MainViewMvc {

    public MainViewMvcImpl(LayoutInflater inflater, ViewGroup container) {
        setRootView(inflater.inflate(R.layout.layout_main, container, false));
    }

    @Override
    public void saveState(Bundle state) {
        // maybe not needed
    }

    @Override
    public int getFragmentContainerId() {
        return R.id.container;
    }
}
