package fm.kirtsim.kharos.facebookapp.facebook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fm.kirtsim.kharos.facebookapp.BaseFragment;

/**
 * Created by kharos on 10/10/2017
 */

public class FBLoginFragment extends BaseFragment {

    private LoginViewMvc viewMvc;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewMvc = new LoginViewMvcImpl(inflater, container, getResources());
        return viewMvc.getRootView();
    }
}
