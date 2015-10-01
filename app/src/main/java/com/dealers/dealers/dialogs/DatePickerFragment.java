package com.dealers.dealers.dialogs;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Fragment;
import android.widget.DatePicker;

import com.dealers.dealers.R;

import java.util.Calendar;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link com.dealers.dealers.dialogs.DatePickerFragment.OnSelectDateListener} interface
 * to handle interaction events.
 * Use the {@link DatePickerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DatePickerFragment extends DialogFragment {
    private static final String DATE_YEAR = "year";
    private static final String DATE_MONTH = "month";
    private static final String DATE_DAY = "day";

    private int mYear;
    private int mMonth;
    private int mDay;

    private Calendar calendar;
    private boolean dateSelected = true;
    private OnSelectDateListener mListener;

    public static DatePickerFragment newInstance(Calendar newCalendar) {
        DatePickerFragment fragment = new DatePickerFragment();
        if (newCalendar == null) {
            newCalendar = Calendar.getInstance();
        }
        Bundle args = new Bundle();
        args.putInt(DATE_YEAR, newCalendar.get(Calendar.YEAR));
        args.putInt(DATE_MONTH, newCalendar.get(Calendar.MONTH));
        args.putInt(DATE_DAY, newCalendar.get(Calendar.DAY_OF_MONTH));
        fragment.setArguments(args);
        return fragment;
    }

    public DatePickerFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            setDateFromBundle(getArguments());
        }
        if (savedInstanceState != null) {
            setDateFromBundle(savedInstanceState);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(DATE_YEAR, mYear);
        outState.putInt(DATE_MONTH, mMonth);
        outState.putInt(DATE_DAY, mDay);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        DatePickerDialog datePicker=
                new DatePickerDialog(getActivity(),
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view,
                                                  int year, int monthOfYear, int dayOfMonth) {
                                if (mListener != null) {
                                    if (dateSelected) {
                                        Calendar calendar = Calendar.getInstance();
                                        calendar.set(year, monthOfYear, dayOfMonth);
                                        mListener.onSelectDate(calendar);
                                    }
                                    dateSelected = true;
                                }
                            }
                        },
                        mYear,mMonth,mDay);
        datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, getResources().getString(R.string.leave_blank), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dateSelected = false;
                mListener.onSelectDate(null);
            }
        });

        return datePicker;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnSelectDateListener) activity;
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

    public void setDateFromBundle (Bundle bundle) {
        mYear = bundle.getInt(DATE_YEAR);
        mMonth = bundle.getInt(DATE_MONTH);
        mDay = bundle.getInt(DATE_DAY);
    }

    public interface OnSelectDateListener {
        public void onSelectDate(Calendar calendar);
    }
}
