package fm.kirtsim.kharos.facebookapp;

import android.os.Bundle;
import android.view.View;

/**
 * Created by kharos on 13/10/2017
 */

public interface ViewMvc<ListenerType> {

    void registerListener(ListenerType listener);

    void unregisterListener(ListenerType listener);

    View getRootView();

    Bundle getState();

    void saveState(Bundle state);
}
