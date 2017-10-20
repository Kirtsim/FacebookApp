package fm.kirtsim.kharos.facebookapp;

import android.content.Context;
import android.support.v4.app.Fragment;

/**
 * Created by kharos on 20/10/2017
 */

public abstract class BaseFragment extends Fragment {

    interface BaseFragmentListener {
        void startFragment(Class<? extends BaseFragment> clasz, FragmentChangeData changeData);
    }

    private BaseFragmentListener listener;

    protected void startFragment(Class<? extends BaseFragment> clasz,
                                 FragmentChangeData changeData) {
        listener.startFragment(clasz, changeData);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof BaseFragmentListener)
            listener = (BaseFragmentListener) context;
        else {
            throw new IllegalArgumentException("context must implement " +
                BaseFragmentListener.class.getSimpleName());
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}
