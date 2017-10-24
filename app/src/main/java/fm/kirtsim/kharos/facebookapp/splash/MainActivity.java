package fm.kirtsim.kharos.facebookapp.splash;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fm.kirtsim.kharos.facebookapp.Anim;
import fm.kirtsim.kharos.facebookapp.BaseFragment;
import fm.kirtsim.kharos.facebookapp.FragmentChangeData;
import fm.kirtsim.kharos.facebookapp.facebook.login.FBLoginFragment;

public class MainActivity extends AppCompatActivity implements BaseFragment.BaseFragmentListener {

    private MainViewMvc viewMvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewMvc = new MainViewMvcImpl(getLayoutInflater(), null);
        setContentView(viewMvc.getRootView());
        startLoginFragment();
    }

    private void startLoginFragment() {
        FragmentChangeData txnData = new FragmentChangeData();
        txnData.setTxnName(FBLoginFragment.class.getSimpleName());
        txnData.setTag(FBLoginFragment.class.getSimpleName());
        txnData.setAddToBackStack(true);
        // TODO: also set arguments
        startFragment(FBLoginFragment.class, txnData);
    }

    @Override
    public void startFragment(Class<? extends BaseFragment> _class,
                              @NonNull FragmentChangeData changeData) {
        BaseFragment fragment = createFragmentInstance(_class);
        FragmentTransaction txn = createTransactionFromFragmentChangeData(changeData);
        if (fragment != null) {
            fragment.setArguments(changeData.getArgs());
            txn.replace(viewMvc.getFragmentContainerId(), fragment, changeData.getTag());
        }
        txn.commit();
    }

    @Override
    public void popFragment(String txnName, boolean inclusive) {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack(txnName, inclusive ? FragmentManager.POP_BACK_STACK_INCLUSIVE : 0);
    }

    private FragmentTransaction createTransactionFromFragmentChangeData(FragmentChangeData changeData) {
        FragmentTransaction txn = getSupportFragmentManager().beginTransaction();
        if (changeData.isAddToBackStack())
            txn.addToBackStack(changeData.getTxnName());
        if (changeData.getAnimation() != null)
            applyAnimationToTransaction(changeData.getAnimation(), txn);
        return txn;
    }

    private void applyAnimationToTransaction(Anim animation, FragmentTransaction txn) {
        // TODO: implement applying animations to transactions
    }

    private BaseFragment createFragmentInstance(Class<? extends BaseFragment> _class) {
        try {
            return _class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
