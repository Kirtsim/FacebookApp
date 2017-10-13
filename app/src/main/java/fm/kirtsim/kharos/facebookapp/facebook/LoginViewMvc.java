package fm.kirtsim.kharos.facebookapp.facebook;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;

import fm.kirtsim.kharos.facebookapp.ViewMvc;

/**
 * Created by kharos on 12/10/2017
 */

public interface LoginViewMvc extends ViewMvc<LoginViewMvc.LoginListener> {

    interface LoginListener {
        void onLoginSuccess();
        void onLoginCancel();
        void onLoginError();
        void onProceedButtonClicked();
    }

    void setProfileImage(Drawable drawable);

    void setMessage(String message);

    void setFirstName(String name);

    void setLastName(String name);

    void displayProceedButton(boolean display);
}
