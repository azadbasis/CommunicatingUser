package communicating.user;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.marcoscg.materialtoast.MaterialToast;

public class ToastActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        findViewById(R.id.btnShowToast).setOnClickListener(this);
        findViewById(R.id.btnShowCustomToast).setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnShowToast:
                showToast();
                break;
            case R.id.btnShowCustomToast:
                showCustomToast();
                break;
        }
    }

    private void showToast() {
        int toastDuration;
        RadioButton rbShort = (RadioButton) findViewById(R.id.rbShort);
        if (rbShort.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;

        // TODO: Create and show the toast message
        Toast toast = Toast.makeText(this, "This is a toast", toastDuration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

    }

    private void showCustomToast() {
        int toastDuration;
        RadioButton rbShort = (RadioButton) findViewById(R.id.rbShort);
        if (rbShort.isChecked())
            toastDuration = Toast.LENGTH_SHORT;
        else
            toastDuration = Toast.LENGTH_LONG;


        LayoutInflater inflater = LayoutInflater.from(this);
        View view = inflater.inflate(R.layout.custom_toast_layout, (ViewGroup) findViewById(R.id.customToastLayout));
        TextView tv = (TextView) view.findViewById(R.id.textContent);
        tv.setText("This is a toast");

        // TODO: Get the custom layout and inflate it

        Toast toast = new Toast(this);
        toast.setDuration(toastDuration);
        toast.setGravity(Gravity.BOTTOM | Gravity.LEFT, 100, 100);
        toast.setView(view);
        toast.show();


        // TODO: Build a toast message that uses the custom layout

    }


    public void toastDef(View v) {
        Toast.makeText(this, "Hello, I'm a default toast!", Toast.LENGTH_SHORT).show();
    }

    public void toastMat(View v) {
        MaterialToast.makeText(this, "Hello, I'm a material toast!", R.drawable.ic_warning_black_24dp, Toast.LENGTH_SHORT).show();
    }

    public void toastMatCol(View v) {
//        MaterialToast.makeText(this, "Hello, I'm a material toast!",
//                R.mipmap.ic_launcher, Toast.LENGTH_SHORT).setBackgroundColor(Color.RED).show();

        new MaterialToast(this)
                .setMessage("Hello, I'm a material toast!")
                .setIcon(R.drawable.ic_warning_black_24dp)
                .setDuration(Toast.LENGTH_SHORT)
                .setBackgroundColor(Color.RED)
                .show();
    }
}
