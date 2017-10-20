package fm.kirtsim.kharos.facebookapp;

import android.os.Bundle;

/**
 * Created by kharos on 20/10/2017
 */

public class FragmentChangeData {
    private Bundle args;
    private String tag;
    private String txnName;
    private Anim animation;
    private boolean addToBackStack;

    public Bundle getArgs() {
        return args;
    }

    public String getTag() {
        return tag;
    }

    public String getTxnName() {
        return txnName;
    }

    public Anim getAnimation() {
        return animation;
    }

    public boolean isAddToBackStack() {
        return addToBackStack;
    }

    public FragmentChangeData setArgs(Bundle args) {
        this.args = args;
        return this;
    }

    public FragmentChangeData setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public FragmentChangeData setTxnName(String txnName) {
        this.txnName = txnName;
        return this;
    }

    public FragmentChangeData setAnimation(Anim animation) {
        this.animation = animation;
        return this;
    }

    public FragmentChangeData setAddToBackStack(boolean addToBackStack) {
        this.addToBackStack = addToBackStack;
        return this;
    }
}
