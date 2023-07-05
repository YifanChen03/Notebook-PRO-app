package notebook.PRO.novas;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends Activity {
    /* access modifiers changed from: private */
    public String PIN = "";
    private Timer _timer = new Timer();
    /* access modifiers changed from: private */
    public SharedPreferences all;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Intent byj = new Intent();
    private Calendar calendar = Calendar.getInstance();

    /* renamed from: cu */
    private boolean f1cu;
    private ImageView delete;
    private Button delete_pin;
    private Button hashtag;
    private LinearLayout linear10;
    private LinearLayout linear2;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    private LinearLayout linear9;
    /* access modifiers changed from: private */
    public boolean new_pin;
    /* access modifiers changed from: private */
    public Intent next = new Intent();
    /* access modifiers changed from: private */
    public TextView pin_txt;
    private String themecolor = "";
    private TimerTask timer;
    private Button zero;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0089R.layout.main);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        this.linear2 = (LinearLayout) findViewById(C0089R.C0090id.linear2);
        this.linear4 = (LinearLayout) findViewById(C0089R.C0090id.linear4);
        this.linear5 = (LinearLayout) findViewById(C0089R.C0090id.linear5);
        this.linear6 = (LinearLayout) findViewById(C0089R.C0090id.linear6);
        this.linear7 = (LinearLayout) findViewById(C0089R.C0090id.linear7);
        this.linear9 = (LinearLayout) findViewById(C0089R.C0090id.linear9);
        this.linear10 = (LinearLayout) findViewById(C0089R.C0090id.linear10);
        this.pin_txt = (TextView) findViewById(C0089R.C0090id.pin_txt);
        this.button1 = (Button) findViewById(C0089R.C0090id.button1);
        this.button2 = (Button) findViewById(C0089R.C0090id.button2);
        this.button3 = (Button) findViewById(C0089R.C0090id.button3);
        this.button4 = (Button) findViewById(C0089R.C0090id.button4);
        this.button5 = (Button) findViewById(C0089R.C0090id.button5);
        this.button6 = (Button) findViewById(C0089R.C0090id.button6);
        this.button7 = (Button) findViewById(C0089R.C0090id.button7);
        this.button8 = (Button) findViewById(C0089R.C0090id.button8);
        this.button9 = (Button) findViewById(C0089R.C0090id.button9);
        this.hashtag = (Button) findViewById(C0089R.C0090id.hashtag);
        this.zero = (Button) findViewById(C0089R.C0090id.zero);
        this.delete_pin = (Button) findViewById(C0089R.C0090id.delete_pin);
        this.delete = (ImageView) findViewById(C0089R.C0090id.delete);
        this.all = getSharedPreferences("property", 0);
        this.button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("1");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("2");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("3");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("4");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("5");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("6");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("7");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("8");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.button9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("9");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.new_pin) {
                    MainActivity.this.all.edit().putString("number", MainActivity.this.PIN).commit();
                    MainActivity.this.showMessage("Saved!");
                    MainActivity.this.next.setClass(MainActivity.this.getApplicationContext(), MenuActivity.class);
                    MainActivity.this.startActivity(MainActivity.this.next);
                    MainActivity.this.all.edit().putString("change", "").commit();
                    return;
                }
                MainActivity.this.PIN = "";
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
            }
        });
        this.hashtag.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("#");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.zero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.PIN = MainActivity.this.PIN.concat("0");
                MainActivity.this.pin_txt.setText(MainActivity.this.PIN);
                MainActivity.this._checkpin();
            }
        });
        this.delete_pin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MainActivity.this.pin_txt.getText().toString().length() > 0) {
                    MainActivity.this.pin_txt.setText(MainActivity.this.pin_txt.getText().toString().substring(0, MainActivity.this.pin_txt.getText().toString().length() - 1));
                    MainActivity.this.PIN = MainActivity.this.pin_txt.getText().toString();
                }
            }
        });
    }

    private void initializeLogic() {
        if (this.all.getString("first time", "").equals("")) {
            this.all.edit().putString("red", "146").commit();
            this.all.edit().putString("green", "98").commit();
            this.all.edit().putString("blue", "57").commit();
            this.all.edit().putString("changing point", "380").commit();
            this.all.edit().putString("first time", "false").commit();
        }
        if (this.all.getString("theme", "").equals("")) {
            this.themecolor = "#926239";
        } else {
            this.themecolor = this.all.getString("theme", "");
        }
        if (this.all.getString("number", "").equals("")) {
            this.delete.setImageResource(C0089R.drawable.ic_check_circle_white);
            this.new_pin = true;
        } else {
            this.new_pin = false;
        }
        this.f1cu = false;
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > Double.parseDouble(this.all.getString("changing point", ""))) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Lockscreen</font>"));
        } else {
            getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Lockscreen</font>"));
        }
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
    }

    public void onStop() {
        super.onStop();
        if (this.all.getString("change", "").equals("true")) {
            this.all.edit().putString("change", "").commit();
        }
        finish();
    }

    /* access modifiers changed from: private */
    public void _checkpin() {
        if (this.all.getString("change", "").equals("")) {
            if (this.PIN.equals(this.all.getString("number", ""))) {
                showMessage("Unlocked!");
                this.next.setClass(getApplicationContext(), MenuActivity.class);
                startActivity(this.next);
            }
        } else if (this.PIN.equals(this.all.getString("number", "")) && !this.f1cu && this.all.getString("change", "").equals("true")) {
            this.PIN = "";
            this.pin_txt.setText("");
            showMessage("Enter new PIN!");
            this.delete.setImageResource(C0089R.drawable.ic_check_circle_white);
            this.new_pin = true;
            this.f1cu = true;
        }
    }

    /* access modifiers changed from: private */
    public void showMessage(String str) {
        Toast.makeText(getApplicationContext(), str, 0).show();
    }

    private int getRandom(int i, int i2) {
        return new Random().nextInt((i2 - i) + 1) + i;
    }

    public ArrayList<Double> getCheckedItemPositionsToArray(ListView listView) {
        ArrayList<Double> arrayList = new ArrayList<>();
        SparseBooleanArray checkedItemPositions = listView.getCheckedItemPositions();
        for (int i = 0; i < checkedItemPositions.size(); i++) {
            if (checkedItemPositions.valueAt(i)) {
                arrayList.add(Double.valueOf((double) checkedItemPositions.keyAt(i)));
            }
        }
        return arrayList;
    }

    private float getDip(int i) {
        return TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    private int getDisplayWidthPixels() {
        return getResources().getDisplayMetrics().widthPixels;
    }

    private int getDisplayHeightPixels() {
        return getResources().getDisplayMetrics().heightPixels;
    }
}
