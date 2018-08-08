package ca.hjtaki.criminal;

import android.app.Fragment;

/*
host a CrimeListFragmen
 */
public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CrimeListFragment();
    }
}
