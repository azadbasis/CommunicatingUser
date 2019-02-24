package communicating.user.Dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;

public class SimpleDialogFragment extends DialogFragment {
    private final String TAG = "AUC_SIMPLE";

    private SimpleDialogListener mHost;
    // TODO: Implement an interface for hosts to get callbacks
    public interface SimpleDialogListener{
        public void onPositiveResult(DialogFragment dlg);
        public void onNegativeResult(DialogFragment dlg);
        public void onNeutralResult(DialogFragment dlg);

    }



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //TODO: Create an AlertDialog.Builder instance
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        //TODO: Set builder properties
          builder.setTitle("Peas Preference");
          builder.setMessage("Do you like sugar snap peas");
          builder.setPositiveButton("Sure!", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Log.d(TAG,"Positive Button click!");
                  mHost.onPositiveResult(SimpleDialogFragment.this);

              }
          });

          builder.setNegativeButton("No Way", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Log.d(TAG,"Negative Button click!");
                  mHost.onNegativeResult(SimpleDialogFragment.this);
              }
          });

          builder.setNeutralButton("Not sure", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Log.d(TAG,"Neutral Button click!");
                  mHost.onNeutralResult(SimpleDialogFragment.this);
              }
          });

        // TODO: return the created dialog
        return builder.create();
    }

    // TODO: Listen for cancel message by overriding onCancel

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(TAG,"Dialog cancelled!");
    }


    // TODO: Override onAttach to get Activity instance


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mHost=(SimpleDialogListener)context;
    }
}
