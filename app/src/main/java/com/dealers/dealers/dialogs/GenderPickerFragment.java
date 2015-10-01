package com.dealers.dealers.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.dealers.dealers.R;

public class GenderPickerFragment extends DialogFragment {

    private OnSelectGenderListener mListener;

    public GenderPickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog genderDialog = new AlertDialog.Builder(getActivity())
                .setTitle(getResources().getString(R.string.select_gender))
                .setItems(new CharSequence[] {
                        getResources().getString(R.string.male), getResources().getString(R.string.female), getResources().getString(R.string.leave_blank)
                }, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                mListener.onSelectGender(getResources().getString(R.string.male));
                                break;
                            case 1:
                                mListener.onSelectGender(getResources().getString(R.string.female));
                                break;
                            case 2:
                                mListener.onSelectGender(null);
                                break;
                        }
                    }
                })
                .create();
        return genderDialog;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSelectGenderListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnSelectGenderListener {
        public void onSelectGender(String gender);
    }

}
