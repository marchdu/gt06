package br.com.pilovieira.gt06.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.pilovieira.gt06.R;
import br.com.pilovieira.gt06.persist.Prefs;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ParametersFragment extends Fragment {

    private Prefs prefs;

    @Bind(R.id.textTrackerNumber) EditText textTrackerNumber;
    @Bind(R.id.textPassword) EditText textPassword;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        prefs = new Prefs(getContext());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_parameters, container, false);
        ButterKnife.bind(this, view);

        setTextTrackerNumber();
        setTextPassword();

        return view;
    }

    private void setTextTrackerNumber() {
        textTrackerNumber.setText(prefs.getTrackerNumber());
        textTrackerNumber.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                prefs.setTrackerNumber(((EditText)view).getText().toString());
                return false;
            }
        });
    }

    private void setTextPassword() {
        textPassword.setText(prefs.getPassword());
        textPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                prefs.setPassword(((EditText)view).getText().toString());
                return false;
            }
        });
    }

}
