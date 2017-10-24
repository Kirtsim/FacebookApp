package fm.kirtsim.kharos.facebookapp.facebook.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

import fm.kirtsim.kharos.facebookapp.BaseFragment;
import fm.kirtsim.kharos.facebookapp.FragmentChangeData;
import fm.kirtsim.kharos.facebookapp.facebook.profile.FBProfileFragment;

/**
 * Created by kharos on 10/10/2017
 */

public class FBLoginFragment extends BaseFragment implements LoginViewMvc.LoginListener {

    private LoginViewMvc viewMvc;
    private CallbackManager fbCallbackManager;
    private FacebookCallback<LoginResult> loginCallback;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fbCallbackManager = CallbackManager.Factory.create();
        loginCallback = new FBLoginCallback(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        viewMvc = new LoginViewMvcImpl(inflater, container, getResources());
        return viewMvc.getRootView();
    }

    @Override
    public void onStart() {
        super.onStart();
        viewMvc.registerListener(this);
        viewMvc.registerLoginCallback();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        viewMvc.unregisterListener(this);
        fbCallbackManager = null;
        loginCallback = null;
    }

    @Override
    public CallbackManager getCallbackManager() {
        return fbCallbackManager;
    }

    @Override
    public FacebookCallback<LoginResult> getFacebookLoginCallback() {
        return loginCallback;
    }

    @Override
    public void onProceedButtonClicked() {
        FragmentChangeData changeData = new FragmentChangeData();
        changeData.setAddToBackStack(true).setTag(FBProfileFragment.class.getSimpleName());
        changeData.setTxnName(FBProfileFragment.class.getSimpleName());
        startFragment(FBProfileFragment.class, changeData);
    }

    private void showSnackBar(String message) {
        Snackbar.make(viewMvc.getRootView(), message, Snackbar.LENGTH_SHORT).show();
    }

    private static class FBLoginCallback implements FacebookCallback<LoginResult> {
        private FBLoginFragment controller;

        FBLoginCallback(FBLoginFragment paController) {
            controller = paController;
        }

        @Override public void onSuccess(LoginResult loginResult) {
            controller.showSnackBar("Login success :)");
        }

        @Override public void onCancel() {
            controller.showSnackBar("Login cancelled :|");
        }

        @Override public void onError(FacebookException error) {
            controller.showSnackBar("Login error :(");
        }
    }
}
