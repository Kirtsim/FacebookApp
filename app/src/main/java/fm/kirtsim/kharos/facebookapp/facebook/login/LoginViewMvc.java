package fm.kirtsim.kharos.facebookapp.facebook.login;

import android.graphics.drawable.Drawable;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

import fm.kirtsim.kharos.facebookapp.ViewMvc;

/**
 * Created by kharos on 12/10/2017
 */

public interface LoginViewMvc extends ViewMvc<LoginViewMvc.LoginListener> {

    interface LoginListener {
        CallbackManager getCallbackManager();
        FacebookCallback<LoginResult> getFacebookLoginCallback();
        void onProceedButtonClicked();
    }

    void registerLoginCallback();

    void setProfileImage(Drawable drawable);

    void setMessage(String message);

    void setFirstName(String name);

    void setLastName(String name);

    void displayProceedButton(boolean display);
}
