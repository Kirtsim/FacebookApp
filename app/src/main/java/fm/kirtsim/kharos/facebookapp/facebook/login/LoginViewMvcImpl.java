package fm.kirtsim.kharos.facebookapp.facebook.login;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.login.widget.LoginButton;
import com.facebook.login.widget.ProfilePictureView;

import fm.kirtsim.kharos.facebookapp.R;
import fm.kirtsim.kharos.facebookapp.facebook.BaseViewMvc;

/**
 * Created by kharos on 12/10/2017
 */

public class LoginViewMvcImpl extends BaseViewMvc<LoginViewMvc.LoginListener>
        implements LoginViewMvc {

    private ProfilePictureView profileImage;
    private LoginButton loginButton;
    private Button proceedButton;
    private TextView messageTV;
    private TextView firstNameTV;
    private TextView lastNameTV;


    public LoginViewMvcImpl(LayoutInflater inflater, ViewGroup container, Resources resources) {
        setRootView(inflater.inflate(R.layout.layout_fb_fragment, container, false));
        initViews();
    }

    private void initViews() {
        profileImage = findView(R.id.profile_image);
        loginButton = findView(R.id.fb_login_btn);
        proceedButton = findView(R.id.proceed_btn);
        messageTV = findView(R.id.message_tv);
        firstNameTV = findView(R.id.first_name_tv);
        lastNameTV = findView(R.id.last_name_tv);


    }

    @Override
    public void registerLoginCallback() {
        loginButton.registerCallback(listener.getCallbackManager(),
                                     listener.getFacebookLoginCallback());
    }

    @Override
    public void setProfileImage(Drawable image) {
        profileImage.setBackground(image);
    }

    @Override
    public void setMessage(String message) {
        messageTV.setText(message);
    }

    @Override
    public void setFirstName(String name) {
        firstNameTV.setText(name);
    }

    @Override
    public void setLastName(String name) {
        lastNameTV.setText(name);
    }

    @Override
    public void displayProceedButton(boolean display) {

    }

    @Override
    public void saveState(Bundle state) {
        // TODO: implement
    }
}
