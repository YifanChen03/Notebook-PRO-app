package notebook.PRO.novas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ChangeActivity extends Activity {
    private String Mastercode = "";
    /* access modifiers changed from: private */
    public SharedPreferences all;
    /* access modifiers changed from: private */
    public AlertDialog.Builder allcode;
    private Button change_master;
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, String>> codes = new ArrayList<>();
    private ListView codes_listview;

    /* renamed from: lc */
    private Button f0lc;
    private LinearLayout linear1;
    private LinearLayout linear2;
    /* access modifiers changed from: private */
    public Intent next = new Intent();
    private SharedPreferences note;
    private double round = 0.0d;
    private TextView textview1;
    private String themecolor = "";
    private SharedPreferences total;
    /* access modifiers changed from: private */
    public boolean unlocked;
    private Button view;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0089R.layout.change);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        this.linear1 = (LinearLayout) findViewById(C0089R.C0090id.linear1);
        this.linear2 = (LinearLayout) findViewById(C0089R.C0090id.linear2);
        this.f0lc = (Button) findViewById(C0089R.C0090id.f9lc);
        this.change_master = (Button) findViewById(C0089R.C0090id.change_master);
        this.view = (Button) findViewById(C0089R.C0090id.view);
        this.codes_listview = (ListView) findViewById(C0089R.C0090id.codes_listview);
        this.textview1 = (TextView) findViewById(C0089R.C0090id.textview1);
        this.all = getSharedPreferences("property", 0);
        this.total = getSharedPreferences("number", 0);
        this.allcode = new AlertDialog.Builder(this);
        this.note = getSharedPreferences("mt", 0);
        this.f0lc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ChangeActivity.this.next.setClass(ChangeActivity.this.getApplicationContext(), MainActivity.class);
                ChangeActivity.this.all.edit().putString("change", "true").commit();
                ChangeActivity.this.startActivity(ChangeActivity.this.next);
            }
        });
        this.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ChangeActivity.this.all.getString("mastercode", "").equals("")) {
                    final EditText editText = new EditText(ChangeActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    editText.setHint("Enter your special code!");
                    editText.setLayoutParams(layoutParams);
                    ChangeActivity.this.allcode.setView(editText);
                    ChangeActivity.this.allcode.setTitle("Mastercode");
                    ChangeActivity.this.allcode.setMessage("Enter a mastercode that you can use when you forgot a password of a note. By entering this code later, exactly at this position, you can view all of your codes you used to lock the notes.");
                    ChangeActivity.this.allcode.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            String editable = editText.getText().toString();
                            ChangeActivity.this.showMessage(editable.concat(" set as your MASTERCODE!"));
                            ChangeActivity.this.all.edit().putString("mastercode", editable).commit();
                            ChangeActivity.this.unlocked = true;
                        }
                    });
                    ChangeActivity.this.allcode.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            ChangeActivity.this.unlocked = false;
                        }
                    });
                    ChangeActivity.this.allcode.create().show();
                    return;
                }
                final EditText editText2 = new EditText(ChangeActivity.this);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -1);
                editText2.setHint("Enter your special code!");
                editText2.setLayoutParams(layoutParams2);
                ChangeActivity.this.allcode.setView(editText2);
                ChangeActivity.this.allcode.setTitle("Mastercode");
                ChangeActivity.this.allcode.setMessage("Enter your mastercode to view all of the codes you used to lock your notes.");
                ChangeActivity.this.allcode.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editText2.getText().toString().equals(ChangeActivity.this.all.getString("mastercode", ""))) {
                            ChangeActivity.this._load_codeslist();
                            ChangeActivity.this.unlocked = true;
                            return;
                        }
                        ChangeActivity.this.showMessage("Wrong code! Try again!");
                    }
                });
                ChangeActivity.this.allcode.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ChangeActivity.this.unlocked = false;
                    }
                });
                ChangeActivity.this.allcode.create().show();
            }
        });
        this.change_master.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final EditText editText = new EditText(ChangeActivity.this);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                editText.setHint("Enter your special code!");
                editText.setLayoutParams(layoutParams);
                ChangeActivity.this.allcode.setView(editText);
                ChangeActivity.this.allcode.setTitle("Mastercode");
                ChangeActivity.this.allcode.setMessage("Enter your mastercode to be able to change it.");
                ChangeActivity.this.allcode.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (editText.getText().toString().equals(ChangeActivity.this.all.getString("mastercode", ""))) {
                            final EditText editText = new EditText(ChangeActivity.this);
                            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                            editText.setHint("Enter your special code!");
                            editText.setLayoutParams(layoutParams);
                            ChangeActivity.this.allcode.setView(editText);
                            ChangeActivity.this.allcode.setTitle("Mastercode");
                            ChangeActivity.this.allcode.setMessage("Enter a mastercode that you can use when you forgot a password of a note. By entering this code later, exactly at this position, you can view all of your codes you used to lock the notes.");
                            ChangeActivity.this.allcode.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String editable = editText.getText().toString();
                                    ChangeActivity.this.showMessage(editable.concat(" set as your MASTERCODE!"));
                                    ChangeActivity.this.all.edit().putString("mastercode", editable).commit();
                                }
                            });
                            ChangeActivity.this.allcode.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialogInterface, int i) {
                                }
                            });
                            ChangeActivity.this.allcode.create().show();
                            return;
                        }
                        ChangeActivity.this.showMessage("Wrong code! Try again!");
                    }
                });
                ChangeActivity.this.allcode.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                ChangeActivity.this.allcode.create().show();
            }
        });
    }

    private void initializeLogic() {
        this.unlocked = false;
    }

    public void onStart() {
        super.onStart();
        if (this.all.getString("theme", "").equals("")) {
            this.themecolor = "#926239";
        } else {
            this.themecolor = this.all.getString("theme", "");
        }
        this.round = 0.0d;
        this.unlocked = false;
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > Double.parseDouble(this.all.getString("changing point", ""))) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Codes</font>"));
        } else {
            getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Codes</font>"));
        }
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
    }

    /* access modifiers changed from: private */
    public void _load_codeslist() {
        this.round = 1.0d;
        if (!this.total.getString("total", "").equals("")) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < ((int) Double.parseDouble(this.total.getString("total", "")))) {
                    if (this.all.getString("locked".concat(String.valueOf((long) this.round)), "").equals("true")) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("titlecode", this.note.getString("title".concat(String.valueOf((long) this.round)), "").concat("\n".concat("\"".concat(this.all.getString("lock".concat(String.valueOf((long) this.round)), "").concat("\"")))));
                        this.codes.add(hashMap);
                        this.codes_listview.setAdapter(new Codes_listviewAdapter(this.codes));
                        ((BaseAdapter) this.codes_listview.getAdapter()).notifyDataSetChanged();
                    }
                    this.round += 1.0d;
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public class Codes_listviewAdapter extends BaseAdapter {
        ArrayList<HashMap<String, String>> _data;

        public Codes_listviewAdapter(ArrayList<HashMap<String, String>> arrayList) {
            this._data = arrayList;
        }

        public int getCount() {
            return this._data.size();
        }

        public HashMap<String, String> getItem(int i) {
            return this._data.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = (LayoutInflater) ChangeActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(C0089R.layout.codeslist, (ViewGroup) null);
            }
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0089R.C0090id.linear1);
            TextView textView = (TextView) view.findViewById(C0089R.C0090id.titlecode);
            if (ChangeActivity.this.unlocked) {
                textView.setText((CharSequence) ((HashMap) ChangeActivity.this.codes.get(i)).get("titlecode"));
            }
            return view;
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
