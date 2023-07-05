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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.Random;

public class SettingsActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public Intent f10aj = new Intent();
    /* access modifiers changed from: private */
    public SharedPreferences all;
    /* access modifiers changed from: private */
    public Switch cancelable;
    private Button change_code;
    private Button default_size;
    /* access modifiers changed from: private */
    public Spinner font_spinner;
    private ArrayList<String> fonts = new ArrayList<>();
    private LinearLayout linear2;
    private LinearLayout linear4;
    /* access modifiers changed from: private */
    public TextView nfs;
    /* access modifiers changed from: private */
    public SeekBar notefontsize;
    private Switch notification_switch;
    private TextView textview2;
    private TextView textview3;
    private TextView textview4;
    /* access modifiers changed from: private */
    public TextView tfs;
    private Button theme;
    private String themecolor = "";
    /* access modifiers changed from: private */
    public SeekBar titlefontsize;
    private ScrollView vscroll1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0089R.layout.settings);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        this.vscroll1 = (ScrollView) findViewById(C0089R.C0090id.vscroll1);
        this.linear2 = (LinearLayout) findViewById(C0089R.C0090id.linear2);
        this.textview2 = (TextView) findViewById(C0089R.C0090id.textview2);
        this.linear4 = (LinearLayout) findViewById(C0089R.C0090id.linear4);
        this.textview3 = (TextView) findViewById(C0089R.C0090id.textview3);
        this.font_spinner = (Spinner) findViewById(C0089R.C0090id.font_spinner);
        this.tfs = (TextView) findViewById(C0089R.C0090id.tfs);
        this.titlefontsize = (SeekBar) findViewById(C0089R.C0090id.titlefontsize);
        this.nfs = (TextView) findViewById(C0089R.C0090id.nfs);
        this.notefontsize = (SeekBar) findViewById(C0089R.C0090id.notefontsize);
        this.default_size = (Button) findViewById(C0089R.C0090id.default_size);
        this.textview4 = (TextView) findViewById(C0089R.C0090id.textview4);
        this.change_code = (Button) findViewById(C0089R.C0090id.change_code);
        this.theme = (Button) findViewById(C0089R.C0090id.theme);
        this.notification_switch = (Switch) findViewById(C0089R.C0090id.notification_switch);
        this.cancelable = (Switch) findViewById(C0089R.C0090id.cancelable);
        this.all = getSharedPreferences("property", 0);
        this.font_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
                if (i == 0) {
                    SettingsActivity.this.all.edit().putString("font", "default").commit();
                }
                if (i == 0) {
                    SettingsActivity.this.all.edit().putString("font", "default").commit();
                }
                if (i == 1) {
                    SettingsActivity.this.all.edit().putString("font", "monospace").commit();
                }
                if (i == 2) {
                    SettingsActivity.this.all.edit().putString("font", "sserif").commit();
                }
                if (i == 3) {
                    SettingsActivity.this.all.edit().putString("font", "serif").commit();
                }
                ((TextView) SettingsActivity.this.font_spinner.getChildAt(0)).setTextSize(20.0f);
            }

            public void onNothingSelected(AdapterView adapterView) {
            }
        });
        this.change_code.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingsActivity.this.f10aj.setClass(SettingsActivity.this.getApplicationContext(), ChangeActivity.class);
                SettingsActivity.this.startActivity(SettingsActivity.this.f10aj);
            }
        });
        this.titlefontsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                SettingsActivity.this.tfs.setTextSize((float) SettingsActivity.this.titlefontsize.getProgress());
                SettingsActivity.this.tfs.setText("Size of note title: ".concat(String.valueOf((long) i)));
                SettingsActivity.this.all.edit().putString("tfs", String.valueOf((long) i)).commit();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.notefontsize.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                SettingsActivity.this.nfs.setTextSize((float) SettingsActivity.this.notefontsize.getProgress());
                SettingsActivity.this.nfs.setText("Size of note: ".concat(String.valueOf((long) i)));
                SettingsActivity.this.all.edit().putString("nfs", String.valueOf((long) i)).commit();
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
        this.default_size.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingsActivity.this.titlefontsize.setProgress(18);
                SettingsActivity.this.notefontsize.setProgress(18);
            }
        });
        this.notification_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SettingsActivity.this.all.edit().putString("notifications", "on").commit();
                    SettingsActivity.this.cancelable.setVisibility(0);
                    return;
                }
                SettingsActivity.this.all.edit().putString("notifications", "off").commit();
                SettingsActivity.this.cancelable.setVisibility(8);
            }
        });
        this.cancelable.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                if (z) {
                    SettingsActivity.this.all.edit().putString("notification_cancel", "on").commit();
                } else {
                    SettingsActivity.this.all.edit().putString("notification_cancel", "off").commit();
                }
            }
        });
        this.theme.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SettingsActivity.this.f10aj.setClass(SettingsActivity.this.getApplicationContext(), ThemeActivity.class);
                SettingsActivity.this.startActivity(SettingsActivity.this.f10aj);
            }
        });
    }

    private void initializeLogic() {
        this.fonts.add("Font: Default ▼");
        this.fonts.add("Font: Monospace ▼");
        this.fonts.add("Font: Sans Serif ▼");
        this.fonts.add("Font: Serif ▼");
        this.font_spinner.setAdapter(new ArrayAdapter(getBaseContext(), 17367049, this.fonts));
        this.cancelable.setVisibility(4);
        if (this.all.getString("font", "").equals("")) {
            this.font_spinner.setSelection(0);
        }
        if (this.all.getString("font", "").equals("default")) {
            this.font_spinner.setSelection(0);
        }
        if (this.all.getString("font", "").equals("monospace")) {
            this.font_spinner.setSelection(1);
        }
        if (this.all.getString("font", "").equals("sserif")) {
            this.font_spinner.setSelection(2);
        }
        if (this.all.getString("font", "").equals("serif")) {
            this.font_spinner.setSelection(3);
        }
        if (this.all.getString("notifications", "").equals("on") || this.all.getString("notifications", "").equals("")) {
            this.notification_switch.setChecked(true);
            this.cancelable.setVisibility(0);
        }
        if (this.all.getString("notification_cancel", "").equals("on") || this.all.getString("notification_cancel", "").equals("")) {
            this.cancelable.setChecked(true);
        }
    }

    public void onStart() {
        super.onStart();
        if (this.all.getString("theme", "").equals("")) {
            this.themecolor = "#926239";
        } else {
            this.themecolor = this.all.getString("theme", "");
        }
        if (this.all.getString("tfs", "").equals("")) {
            this.all.edit().putString("tfs", "18").commit();
            this.titlefontsize.setProgress((int) Double.parseDouble(this.all.getString("tfs", "")));
        } else {
            this.titlefontsize.setProgress((int) Double.parseDouble(this.all.getString("tfs", "")));
        }
        if (this.all.getString("nfs", "").equals("")) {
            this.all.edit().putString("nfs", "18").commit();
            this.notefontsize.setProgress((int) Double.parseDouble(this.all.getString("nfs", "")));
        } else {
            this.notefontsize.setProgress((int) Double.parseDouble(this.all.getString("nfs", "")));
        }
        this.tfs.setTextSize((float) this.titlefontsize.getProgress());
        this.tfs.setText("Size of note title: ".concat(String.valueOf((long) Double.parseDouble(this.all.getString("tfs", "")))));
        this.nfs.setTextSize((float) this.notefontsize.getProgress());
        this.nfs.setText("Size of note: ".concat(String.valueOf((long) Double.parseDouble(this.all.getString("nfs", "")))));
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > Double.parseDouble(this.all.getString("changing point", ""))) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Settings</font>"));
        } else {
            getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Settings</font>"));
        }
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
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
