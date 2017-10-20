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

    public static FBLoginFragment newInstance(Bundle args) {
        FBLoginFragment fragment = new FBLoginFragment();
        if (args != null)
            fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
