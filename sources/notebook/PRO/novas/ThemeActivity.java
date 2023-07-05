package notebook.PRO.novas;

import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.TextWatcher;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class ThemeActivity extends Activity {
    /* access modifiers changed from: private */
    public SharedPreferences all;
    /* access modifiers changed from: private */
    public TextView blue_value;
    private String convert = "";
    /* access modifiers changed from: private */
    public TextView green_value;
    /* access modifiers changed from: private */
    public TextView hash;
    /* access modifiers changed from: private */
    public EditText hexvalue;
    private LinearLayout linear2;
    private LinearLayout linear3;
    private LinearLayout linear4;
    private LinearLayout linear5;
    private LinearLayout linear6;
    private LinearLayout linear7;
    /* access modifiers changed from: private */
    public TextView red_value;
    /* access modifiers changed from: private */
    public SeekBar seekbar_blue;
    /* access modifiers changed from: private */
    public SeekBar seekbar_green;
    /* access modifiers changed from: private */
    public SeekBar seekbar_red;
    private Button setdefault;
    private TextView textview1;
    /* access modifiers changed from: private */
    public String themecolor = "";
    private ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0089R.layout.theme);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        this.vscroll1 = (ScrollView) findViewById(C0089R.C0090id.vscroll1);
        this.linear2 = (LinearLayout) findViewById(C0089R.C0090id.linear2);
        this.linear3 = (LinearLayout) findViewById(C0089R.C0090id.linear3);
        this.linear4 = (LinearLayout) findViewById(C0089R.C0090id.linear4);
        this.red_value = (TextView) findViewById(C0089R.C0090id.red_value);
        this.linear5 = (LinearLayout) findViewById(C0089R.C0090id.linear5);
        this.green_value = (TextView) findViewById(C0089R.C0090id.green_value);
        this.linear6 = (LinearLayout) findViewById(C0089R.C0090id.linear6);
        this.blue_value = (TextView) findViewById(C0089R.C0090id.blue_value);
        this.linear7 = (LinearLayout) findViewById(C0089R.C0090id.linear7);
        this.setdefault = (Button) findViewById(C0089R.C0090id.setdefault);
        this.textview1 = (TextView) findViewById(C0089R.C0090id.textview1);
        this.seekbar_red = (SeekBar) findViewById(C0089R.C0090id.seekbar_red);
        this.seekbar_green = (SeekBar) findViewById(C0089R.C0090id.seekbar_green);
        this.seekbar_blue = (SeekBar) findViewById(C0089R.C0090id.seekbar_blue);
        this.hash = (TextView) findViewById(C0089R.C0090id.hash);
        this.hexvalue = (EditText) findViewById(C0089R.C0090id.hexvalue);
        this.all = getSharedPreferences("property", 0);
        this.seekbar_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ThemeActivity.this._setColor();
                ThemeActivity.this.red_value.setText("Red: ".concat(String.valueOf((long) ThemeActivity.this.seekbar_red.getProgress())));
                ThemeActivity.this.all.edit().putString("red", String.valueOf((long) ThemeActivity.this.seekbar_red.getProgress())).commit();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.seekbar_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ThemeActivity.this._setColor();
                ThemeActivity.this.green_value.setText("Green: ".concat(String.valueOf((long) ThemeActivity.this.seekbar_green.getProgress())));
                ThemeActivity.this.all.edit().putString("green", String.valueOf((long) ThemeActivity.this.seekbar_green.getProgress())).commit();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.seekbar_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                ThemeActivity.this._setColor();
                ThemeActivity.this.blue_value.setText("Blue: ".concat(String.valueOf((long) ThemeActivity.this.seekbar_blue.getProgress())));
                ThemeActivity.this.all.edit().putString("blue", String.valueOf((long) ThemeActivity.this.seekbar_blue.getProgress())).commit();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.hexvalue.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                try {
                    String str = String.valueOf(ThemeActivity.this.hash.getText().toString()) + ThemeActivity.this.hexvalue.getText().toString();
                    int[] rgb = ThemeActivity.getRGB(str.replace("#", ""));
                    ThemeActivity.this.seekbar_red.setProgress(rgb[0]);
                    ThemeActivity.this.seekbar_green.setProgress(rgb[1]);
                    ThemeActivity.this.seekbar_blue.setProgress(rgb[2]);
                    ThemeActivity.this.red_value.setText("Red: " + Integer.toString(rgb[0]));
                    ThemeActivity.this.green_value.setText("Green: " + Integer.toString(rgb[1]));
                    ThemeActivity.this.blue_value.setText("Blue: " + Integer.toString(rgb[2]));
                    ThemeActivity.this.getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(str)));
                    ThemeActivity.this.hexvalue.setTextColor(-16777216);
                    ThemeActivity.this.hash.setTextColor(-16777216);
                } catch (Exception e) {
                    ThemeActivity.this.hexvalue.setTextColor(-769226);
                    ThemeActivity.this.hash.setTextColor(-769226);
                }
                ThemeActivity.this.all.edit().putString("theme", ThemeActivity.this.themecolor).commit();
            }

            public void afterTextChanged(Editable editable) {
            }
        });
        this.setdefault.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ThemeActivity.this._setDefaultColor();
            }
        });
    }

    private void initializeLogic() {
        this.seekbar_red.getProgressDrawable().setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_IN);
        this.seekbar_red.getThumb().setColorFilter(Color.parseColor("#FF0000"), PorterDuff.Mode.SRC_IN);
        this.seekbar_green.getProgressDrawable().setColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_IN);
        this.seekbar_green.getThumb().setColorFilter(Color.parseColor("#00FF00"), PorterDuff.Mode.SRC_IN);
        this.seekbar_blue.getProgressDrawable().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
        this.seekbar_blue.getThumb().setColorFilter(Color.parseColor("#0000FF"), PorterDuff.Mode.SRC_IN);
    }

    public static int[] getRGB(String str) {
        int[] iArr = new int[3];
        for (int i = 0; i < 3; i++) {
            iArr[i] = Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16);
        }
        return iArr;
    }

    public void onStart() {
        super.onStart();
        if (this.all.getString("theme", "").equals("")) {
            this.themecolor = "#926239";
        } else {
            this.themecolor = this.all.getString("theme", "");
        }
        if (this.all.getString("red", "").equals("")) {
            _setDefaultColor();
        } else {
            this.seekbar_red.setProgress((int) Double.parseDouble(this.all.getString("red", "")));
            this.red_value.setText("Red: ".concat(String.valueOf((long) this.seekbar_red.getProgress())));
        }
        if (this.all.getString("green", "").equals("")) {
            _setDefaultColor();
        } else {
            this.seekbar_green.setProgress((int) Double.parseDouble(this.all.getString("green", "")));
            this.green_value.setText("Green: ".concat(String.valueOf((long) this.seekbar_green.getProgress())));
        }
        if (this.all.getString("blue", "").equals("")) {
            _setDefaultColor();
        } else {
            this.seekbar_blue.setProgress((int) Double.parseDouble(this.all.getString("blue", "")));
            this.blue_value.setText("Blue: ".concat(String.valueOf((long) this.seekbar_blue.getProgress())));
        }
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
        this.hexvalue.setText(this.themecolor.replace("#", ""));
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > Double.parseDouble(this.all.getString("changing point", ""))) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Theme</font>"));
            return;
        }
        getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
        getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Theme</font>"));
    }

    /* access modifiers changed from: private */
    public void _setColor() {
        this.themecolor = String.format("#%02x%02x%02x", new Object[]{Integer.valueOf(this.seekbar_red.getProgress()), Integer.valueOf(this.seekbar_green.getProgress()), Integer.valueOf(this.seekbar_blue.getProgress())});
        this.hexvalue.setText(this.themecolor.replace("#", ""));
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
        this.all.edit().putString("theme", this.themecolor).commit();
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > 400.0d) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Theme</font>"));
            return;
        }
        getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
        getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Theme</font>"));
    }

    /* access modifiers changed from: private */
    public void _setDefaultColor() {
        this.seekbar_red.setProgress(146);
        this.seekbar_green.setProgress(98);
        this.seekbar_blue.setProgress(57);
        this.all.edit().putString("red", "146").commit();
        this.all.edit().putString("green", "98").commit();
        this.all.edit().putString("blue", "57").commit();
    }

    private void showMessage(String str) {
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
