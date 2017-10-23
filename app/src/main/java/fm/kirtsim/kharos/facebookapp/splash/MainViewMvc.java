package fm.kirtsim.kharos.facebookapp.splash;

import android.support.annotation.IdRes;

import fm.kirtsim.kharos.facebookapp.ViewMvc;

/**
 * Created by kharos on 20/10/2017
 */

public interface MainViewMvc extends ViewMvc {

    @IdRes int getFragmentContainerId();
}
