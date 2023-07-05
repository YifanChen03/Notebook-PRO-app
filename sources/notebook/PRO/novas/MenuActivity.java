package notebook.PRO.novas;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.text.Html;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RemoteViews;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends Activity {
    private final int REQ_CODE_SPEECH_INPUT = 100;
    /* access modifiers changed from: private */
    public Timer _timer = new Timer();

    /* renamed from: a */
    private String f2a = "";
    /* access modifiers changed from: private */
    public ImageView add;
    /* access modifiers changed from: private */
    public SharedPreferences all;
    /* access modifiers changed from: private */
    public ListView all_notes;
    /* access modifiers changed from: private */
    public LinearLayout allnotes_window;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f3b = "";
    /* access modifiers changed from: private */
    public AlertDialog.Builder bsbs;
    /* access modifiers changed from: private */
    public Intent byj = new Intent();
    private double chosen_number = 0.0d;
    private ImageView clear;
    /* access modifiers changed from: private */
    public TextView clipboardtxt;
    private boolean connected;
    private ImageView copy;
    /* access modifiers changed from: private */
    public TextView datetimeshow;
    private ImageView delete;
    private ImageView edit;
    /* access modifiers changed from: private */
    public boolean editing;
    private ArrayList<String> extrapos = new ArrayList<>();

    /* renamed from: f */
    private double f4f = 0.0d;
    /* access modifiers changed from: private */
    public ImageView fab;
    /* access modifiers changed from: private */
    public LinearLayout fab_linear;
    /* access modifiers changed from: private */
    public LinearLayout functionsbox;
    /* access modifiers changed from: private */
    public ImageView go_down;
    /* access modifiers changed from: private */
    public ImageView go_up;
    private double gotopos = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: js */
    public Calendar f5js = Calendar.getInstance();
    private LinearLayout linear20;
    private LinearLayout linear21;
    private LinearLayout linear22;
    private LinearLayout linear23;
    private LinearLayout linear24;
    private LinearLayout linear25;
    private LinearLayout linear26;
    /* access modifiers changed from: private */
    public LinearLayout linear27;
    /* access modifiers changed from: private */
    public AlertDialog.Builder lock;
    /* access modifiers changed from: private */
    public ImageView locked;
    private double nfs = 0.0d;
    /* access modifiers changed from: private */
    public SharedPreferences note;
    /* access modifiers changed from: private */
    public EditText note_message;
    /* access modifiers changed from: private */
    public double note_number = 0.0d;
    /* access modifiers changed from: private */
    public ScrollView note_window;
    /* access modifiers changed from: private */
    public ArrayList<HashMap<String, String>> notes = new ArrayList<>();
    /* access modifiers changed from: private */
    public boolean notewindow_open;
    /* access modifiers changed from: private */
    public String password_lock = "";
    private ImageView paste;
    /* access modifiers changed from: private */
    public double pos = 0.0d;
    private AlertDialog.Builder position;
    /* access modifiers changed from: private */
    public boolean pressed;
    /* access modifiers changed from: private */
    public ImageView readout;
    /* access modifiers changed from: private */

    /* renamed from: ro */
    public ObjectAnimator f6ro = new ObjectAnimator();
    /* access modifiers changed from: private */
    public double round = 0.0d;
    private ImageView save;
    private ImageView scrolldown;
    private ImageView scrollup;
    private boolean searchbox_visible;
    private ObjectAnimator searchboxalpha = new ObjectAnimator();
    private double setpos = 0.0d;
    private ImageView settings;
    /* access modifiers changed from: private */
    public ImageView share;
    private AlertDialog.Builder shower;
    /* access modifiers changed from: private */

    /* renamed from: sj */
    public TimerTask f7sj;
    /* access modifiers changed from: private */
    public boolean special;
    /* access modifiers changed from: private */
    public double speedfab = 0.0d;
    /* access modifiers changed from: private */
    public ImageView stt;
    private AlertDialog.Builder sttdialog;
    /* access modifiers changed from: private */
    public String stttext = "";
    /* access modifiers changed from: private */
    public double symbol = 0.0d;

    /* renamed from: t */
    private double f8t = 0.0d;
    /* access modifiers changed from: private */
    public String texttoshare = "";
    /* access modifiers changed from: private */
    public double tfs = 0.0d;
    /* access modifiers changed from: private */
    public String themecolor = "";
    /* access modifiers changed from: private */
    public EditText title;
    /* access modifiers changed from: private */
    public SharedPreferences total;
    /* access modifiers changed from: private */
    public double total_notes = 0.0d;
    /* access modifiers changed from: private */
    public boolean visible;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0089R.layout.menu);
        initialize();
        initializeLogic();
    }

    private void initialize() {
        this.functionsbox = (LinearLayout) findViewById(C0089R.C0090id.functionsbox);
        this.allnotes_window = (LinearLayout) findViewById(C0089R.C0090id.allnotes_window);
        this.note_window = (ScrollView) findViewById(C0089R.C0090id.note_window);
        this.fab_linear = (LinearLayout) findViewById(C0089R.C0090id.fab_linear);
        this.clipboardtxt = (TextView) findViewById(C0089R.C0090id.clipboardtxt);
        this.settings = (ImageView) findViewById(C0089R.C0090id.settings);
        this.add = (ImageView) findViewById(C0089R.C0090id.add);
        this.clear = (ImageView) findViewById(C0089R.C0090id.clear);
        this.scrolldown = (ImageView) findViewById(C0089R.C0090id.scrolldown);
        this.scrollup = (ImageView) findViewById(C0089R.C0090id.scrollup);
        this.copy = (ImageView) findViewById(C0089R.C0090id.copy);
        this.all_notes = (ListView) findViewById(C0089R.C0090id.all_notes);
        this.linear20 = (LinearLayout) findViewById(C0089R.C0090id.linear20);
        this.linear23 = (LinearLayout) findViewById(C0089R.C0090id.linear23);
        this.linear21 = (LinearLayout) findViewById(C0089R.C0090id.linear21);
        this.linear27 = (LinearLayout) findViewById(C0089R.C0090id.linear27);
        this.linear24 = (LinearLayout) findViewById(C0089R.C0090id.linear24);
        this.linear26 = (LinearLayout) findViewById(C0089R.C0090id.linear26);
        this.linear22 = (LinearLayout) findViewById(C0089R.C0090id.linear22);
        this.delete = (ImageView) findViewById(C0089R.C0090id.delete);
        this.stt = (ImageView) findViewById(C0089R.C0090id.stt);
        this.paste = (ImageView) findViewById(C0089R.C0090id.paste);
        this.linear25 = (LinearLayout) findViewById(C0089R.C0090id.linear25);
        this.edit = (ImageView) findViewById(C0089R.C0090id.edit);
        this.save = (ImageView) findViewById(C0089R.C0090id.save);
        this.title = (EditText) findViewById(C0089R.C0090id.title);
        this.datetimeshow = (TextView) findViewById(C0089R.C0090id.datetimeshow);
        this.note_message = (EditText) findViewById(C0089R.C0090id.note_message);
        this.fab = (ImageView) findViewById(C0089R.C0090id.fab);
        this.share = (ImageView) findViewById(C0089R.C0090id.share);
        this.locked = (ImageView) findViewById(C0089R.C0090id.locked);
        this.go_up = (ImageView) findViewById(C0089R.C0090id.go_up);
        this.go_down = (ImageView) findViewById(C0089R.C0090id.go_down);
        this.readout = (ImageView) findViewById(C0089R.C0090id.readout);
        this.total = getSharedPreferences("number", 0);
        this.note = getSharedPreferences("mt", 0);
        this.bsbs = new AlertDialog.Builder(this);
        this.shower = new AlertDialog.Builder(this);
        this.all = getSharedPreferences("property", 0);
        this.position = new AlertDialog.Builder(this);
        this.lock = new AlertDialog.Builder(this);
        this.sttdialog = new AlertDialog.Builder(this);
        this.save.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this._savenote();
            }
        });
        this.delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuActivity.this.total_notes > 0.0d) {
                    MenuActivity.this._deleteblock();
                } else {
                    MenuActivity.this.showMessage("No notes to delete!");
                }
            }
        });
        this.settings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.byj.setClass(MenuActivity.this.getApplicationContext(), SettingsActivity.class);
                MenuActivity.this.startActivity(MenuActivity.this.byj);
            }
        });
        this.add.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.go_up.setEnabled(true);
                MenuActivity.this.go_down.setEnabled(true);
                MenuActivity.this.note_window.setVisibility(0);
                MenuActivity.this.fab_linear.setVisibility(0);
                MenuActivity.this.allnotes_window.setVisibility(8);
                MenuActivity.this.title.setText("");
                MenuActivity.this.note_message.setText("");
                MenuActivity.this.f7sj = new TimerTask() {
                    public void run() {
                        MenuActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                MenuActivity.this.f5js = Calendar.getInstance();
                                MenuActivity.this.datetimeshow.setText(new SimpleDateFormat("E dd.MM.yyyy  HH:mm").format(MenuActivity.this.f5js.getTime()));
                            }
                        });
                    }
                };
                MenuActivity.this._timer.scheduleAtFixedRate(MenuActivity.this.f7sj, 0, 60000);
                MenuActivity.this.add.setEnabled(false);
                MenuActivity.this.special = false;
                MenuActivity.this.editing = true;
                MenuActivity.this.title.setEnabled(true);
                MenuActivity.this.note_message.setEnabled(true);
                MenuActivity.this.notewindow_open = true;
                MenuActivity.this.note_number = MenuActivity.this.total_notes;
                MenuActivity.this.symbol = 2.0d;
                MenuActivity.this._loadsymbols();
                MenuActivity.this.stt.setVisibility(0);
            }
        });
        this.all_notes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView adapterView, View view, int i, long j) {
                MenuActivity.this.allnotes_window.setVisibility(8);
                MenuActivity.this.note_window.setVisibility(0);
                MenuActivity.this.title.setVisibility(0);
                MenuActivity.this.note_message.setVisibility(0);
                MenuActivity.this.note_message.setVisibility(0);
                MenuActivity.this.fab_linear.setVisibility(0);
                MenuActivity.this.title.setEnabled(false);
                MenuActivity.this.note_message.setEnabled(false);
                MenuActivity.this.go_up.setEnabled(true);
                MenuActivity.this.go_down.setEnabled(true);
                MenuActivity.this.notewindow_open = true;
                MenuActivity.this.note_number = (double) (i + 1);
                MenuActivity.this.pos = (double) (i + 1);
                MenuActivity.this.symbol = 1.0d;
                MenuActivity.this.title.setText(MenuActivity.this.note.getString("title".concat(String.valueOf((long) (i + 1))), ""));
                MenuActivity.this.note_message.setText(MenuActivity.this.note.getString("message".concat(String.valueOf((long) (i + 1))), ""));
                MenuActivity.this.datetimeshow.setText(MenuActivity.this.note.getString("date".concat(String.valueOf((long) (i + 1))), ""));
                MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_open_black);
                if (MenuActivity.this.all.getString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "").equals("true")) {
                    MenuActivity.this.note_window.setBackgroundColor(-16777216);
                    MenuActivity.this.linear27.setBackgroundColor(-16777216);
                    MenuActivity.this.functionsbox.setBackgroundColor(-16777216);
                    MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_outline_black);
                    MenuActivity.this.note_message.setVisibility(8);
                    MenuActivity.this.lock.setCancelable(false);
                    MenuActivity.this.lock.setTitle("Lock");
                    MenuActivity.this.lock.setMessage("Enter password to open note!");
                    final EditText editText = new EditText(MenuActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    editText.setHint("Enter password!");
                    editText.setLayoutParams(layoutParams);
                    MenuActivity.this.lock.setView(editText);
                    MenuActivity.this.lock.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.password_lock = editText.getText().toString();
                            if (MenuActivity.this.password_lock.equals(MenuActivity.this.all.getString("lock".concat(String.valueOf((long) MenuActivity.this.note_number)), ""))) {
                                MenuActivity.this.note_message.setVisibility(0);
                                MenuActivity.this.note_window.setBackgroundColor(-1);
                                MenuActivity.this.linear27.setBackgroundColor(-16731905);
                                MenuActivity.this.functionsbox.setBackgroundColor(-1);
                                MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "false").commit();
                                return;
                            }
                            MenuActivity.this.showMessage("Wrong password!");
                            MenuActivity.this._leave();
                        }
                    });
                    MenuActivity.this.lock.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this._leave();
                        }
                    });
                    MenuActivity.this.lock.create().show();
                }
                MenuActivity.this._loadsymbols();
            }
        });
        this.clear.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.bsbs.setTitle("Clear all");
                MenuActivity.this.bsbs.setMessage("Do you really want to delete ALL notes?");
                MenuActivity.this.bsbs.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MenuActivity.this.bsbs.setMessage("Are you sure?");
                        MenuActivity.this.bsbs.setPositiveButton("yes!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int i) {
                                MenuActivity.this.round = 0.0d;
                                for (int i2 = 0; i2 < ((int) MenuActivity.this.total_notes); i2++) {
                                    MenuActivity.this.note.edit().remove("title".concat(String.valueOf((long) MenuActivity.this.round))).commit();
                                    MenuActivity.this.note.edit().remove("message".concat(String.valueOf((long) MenuActivity.this.round))).commit();
                                    MenuActivity.this.note.edit().remove("date".concat(String.valueOf((long) MenuActivity.this.round))).commit();
                                    MenuActivity.this.all.edit().remove("locked".concat(String.valueOf((long) MenuActivity.this.round))).commit();
                                    MenuActivity.this.all.edit().remove("lock".concat(String.valueOf((long) MenuActivity.this.round))).commit();
                                    MenuActivity access$0 = MenuActivity.this;
                                    access$0.round = access$0.round + 1.0d;
                                }
                                MenuActivity.this.note_number = 0.0d;
                                MenuActivity.this.total_notes = 0.0d;
                                MenuActivity.this.total.edit().putString("total", "0").commit();
                                MenuActivity.this.notes.clear();
                                ((BaseAdapter) MenuActivity.this.all_notes.getAdapter()).notifyDataSetChanged();
                                MenuActivity.this.showMessage("All notes deleted!");
                            }
                        });
                        MenuActivity.this.bsbs.create().show();
                    }
                });
                MenuActivity.this.bsbs.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                MenuActivity.this.bsbs.create().show();
            }
        });
        this.edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.title.setEnabled(true);
                MenuActivity.this.note_message.setEnabled(true);
                MenuActivity.this.special = true;
                MenuActivity.this.editing = true;
                MenuActivity.this.symbol = 3.0d;
                MenuActivity.this._loadsymbols();
            }
        });
        this.all_notes.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                MenuActivity.this.pos = (double) (i + 1);
                return false;
            }
        });
        this.share.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.texttoshare = MenuActivity.this.note.getString("title".concat(String.valueOf((long) MenuActivity.this.pos)), "").concat("\n\n".concat(MenuActivity.this.note.getString("message".concat(String.valueOf((long) MenuActivity.this.pos)), "")));
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", MenuActivity.this.f3b);
                intent.putExtra("android.intent.extra.TEXT", MenuActivity.this.texttoshare);
                MenuActivity.this.startActivity(Intent.createChooser(intent, "Share using"));
            }
        });
        this.go_up.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.note_window.fullScroll(33);
                MenuActivity.this.showMessage("Beginning of page");
            }
        });
        this.go_down.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.note_window.fullScroll(130);
                MenuActivity.this.showMessage("Ending of page");
            }
        });
        this.fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.fab.setEnabled(false);
                if (MenuActivity.this.visible) {
                    MenuActivity.this.f6ro.setTarget(MenuActivity.this.fab);
                    MenuActivity.this.f6ro.setPropertyName("rotation");
                    MenuActivity.this.f6ro.setFloatValues(new float[]{-135.0f, 0.0f});
                    MenuActivity.this.f6ro.setInterpolator(new AccelerateInterpolator());
                    MenuActivity.this.f6ro.setDuration(150);
                    MenuActivity.this.f6ro.start();
                    MenuActivity.this.visible = false;
                    MenuActivity.this.readout.setVisibility(4);
                    MenuActivity.this.f7sj = new TimerTask() {
                        public void run() {
                            MenuActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    MenuActivity.this.go_up.setVisibility(4);
                                    MenuActivity.this.go_down.setVisibility(4);
                                    MenuActivity.this.f7sj = new TimerTask() {
                                        public void run() {
                                            MenuActivity.this.runOnUiThread(new Runnable() {
                                                public void run() {
                                                    MenuActivity.this.locked.setVisibility(4);
                                                    MenuActivity.this.f7sj = new TimerTask() {
                                                        public void run() {
                                                            MenuActivity.this.runOnUiThread(new Runnable() {
                                                                public void run() {
                                                                    MenuActivity.this.share.setVisibility(4);
                                                                    MenuActivity.this.fab.setEnabled(true);
                                                                }
                                                            });
                                                        }
                                                    };
                                                    MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
                                                }
                                            });
                                        }
                                    };
                                    MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
                                }
                            });
                        }
                    };
                    MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
                    return;
                }
                MenuActivity.this.f6ro.setTarget(MenuActivity.this.fab);
                MenuActivity.this.f6ro.setPropertyName("rotation");
                MenuActivity.this.f6ro.setFloatValues(new float[]{0.0f, -135.0f});
                MenuActivity.this.f6ro.setInterpolator(new AccelerateInterpolator());
                MenuActivity.this.f6ro.setDuration(150);
                MenuActivity.this.f6ro.start();
                MenuActivity.this.visible = true;
                MenuActivity.this.share.setVisibility(0);
                MenuActivity.this.f7sj = new TimerTask() {
                    public void run() {
                        MenuActivity.this.runOnUiThread(new Runnable() {
                            public void run() {
                                MenuActivity.this.locked.setVisibility(0);
                                MenuActivity.this.f7sj = new TimerTask() {
                                    public void run() {
                                        MenuActivity.this.runOnUiThread(new Runnable() {
                                            public void run() {
                                                MenuActivity.this.go_down.setVisibility(0);
                                                MenuActivity.this.go_up.setVisibility(0);
                                                MenuActivity.this.f7sj = new TimerTask() {
                                                    public void run() {
                                                        MenuActivity.this.runOnUiThread(new Runnable() {
                                                            public void run() {
                                                                MenuActivity.this.readout.setVisibility(0);
                                                                MenuActivity.this.fab.setEnabled(true);
                                                            }
                                                        });
                                                    }
                                                };
                                                MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
                                            }
                                        });
                                    }
                                };
                                MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
                            }
                        });
                    }
                };
                MenuActivity.this._timer.schedule(MenuActivity.this.f7sj, (long) ((int) MenuActivity.this.speedfab));
            }
        });
        this.locked.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this._locker();
            }
        });
        this.stt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuActivity.this.editing) {
                    MenuActivity.this._speech();
                } else {
                    MenuActivity.this.showMessage("Open editing mode to use feature!");
                }
            }
        });
        this.scrolldown.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.all_notes.smoothScrollToPosition(MenuActivity.this.notes.size());
            }
        });
        this.scrollup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuActivity.this.all_notes.smoothScrollToPosition(0);
            }
        });
        this.copy.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuActivity.this.notewindow_open) {
                    MenuActivity menuActivity = MenuActivity.this;
                    MenuActivity.this.getApplicationContext();
                    ((ClipboardManager) menuActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("clipboard", MenuActivity.this.note.getString("title".concat(String.valueOf((long) MenuActivity.this.pos)), "").concat("\n".concat(MenuActivity.this.note.getString("message".concat(String.valueOf((long) MenuActivity.this.pos)), "")))));
                    MenuActivity.this.showMessage(MenuActivity.this.note.getString("title".concat(String.valueOf((long) MenuActivity.this.pos)), "").concat("\n".concat(MenuActivity.this.note.getString("message".concat(String.valueOf((long) MenuActivity.this.pos)), ""))).concat("\n\ncopied to clipboard!"));
                }
            }
        });
        this.paste.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MenuActivity.this.editing) {
                    MenuActivity.this.clipboardtxt.setText(((ClipboardManager) MenuActivity.this.getSystemService("clipboard")).getText());
                    MenuActivity.this.bsbs.setTitle("Paste");
                    MenuActivity.this.bsbs.setMessage("Do you want to add \n\n\"".concat(MenuActivity.this.clipboardtxt.getText().toString().concat("\" \n\nfrom your clipboard to the note?")));
                    MenuActivity.this.bsbs.setPositiveButton("Add to note", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.note_message.setText(MenuActivity.this.note_message.getText().toString().concat(" ".concat(MenuActivity.this.clipboardtxt.getText().toString())));
                        }
                    });
                    MenuActivity.this.bsbs.setNegativeButton("Don't add", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                        }
                    });
                    MenuActivity.this.bsbs.create().show();
                    return;
                }
                MenuActivity.this.showMessage("Open editing mode to use feature!");
            }
        });
    }

    private void initializeLogic() {
        this.speedfab = 45.0d;
        this.symbol = 1.0d;
        this.note_window.setVisibility(8);
        this.readout.setVisibility(4);
        this.go_down.setVisibility(4);
        this.go_up.setVisibility(4);
        this.locked.setVisibility(4);
        this.share.setVisibility(4);
        this.fab_linear.setVisibility(4);
        this.go_up.setEnabled(false);
        this.go_down.setEnabled(false);
        this.editing = false;
        this.pressed = false;
        this.notewindow_open = false;
        this.connected = true;
        if (this.total.getString("total", "").equals("")) {
            this.total_notes = 0.0d;
            this.note_number = 0.0d;
        } else {
            this.total_notes = Double.parseDouble(this.total.getString("total", ""));
            this.note_number = Double.parseDouble(this.total.getString("total", ""));
        }
        _loadnotes();
        _loadsymbols();
        _set_font();
        _createcontextmenu();
        getWindow().addFlags(524288);
        final TextToSpeech textToSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            public void onInit(int i) {
                if (i == -1) {
                    Toast.makeText(MenuActivity.this.getApplicationContext(), "Error", 0).show();
                }
            }
        });
        textToSpeech.setLanguage(Locale.ENGLISH);
        this.readout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textToSpeech.speak(String.valueOf(MenuActivity.this.title.getText().toString()) + MenuActivity.this.note_message.getText().toString(), 0, (HashMap) null);
            }
        });
    }

    private void sowhat() {
    }

    public void onStart() {
        super.onStart();
        this.go_up.setEnabled(false);
        this.go_down.setEnabled(false);
        if (this.all.getString("theme", "").equals("")) {
            this.themecolor = "#926239";
        } else {
            this.themecolor = this.all.getString("theme", "");
        }
        if (this.all.getString("tfs", "").equals("")) {
            this.all.edit().putString("tfs", "18").commit();
            this.tfs = 18.0d;
        } else {
            this.tfs = Double.parseDouble(this.all.getString("tfs", ""));
        }
        if (this.all.getString("nfs", "").equals("")) {
            this.all.edit().putString("nfs", "18").commit();
            this.nfs = 18.0d;
        } else {
            this.nfs = Double.parseDouble(this.all.getString("nfs", ""));
        }
        this.note_message.setTextSize((float) this.nfs);
        this.title.setTextSize(((float) this.tfs) + 7.0f);
        Window window = getWindow();
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(Color.parseColor(this.themecolor));
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor(this.themecolor)));
        if (Double.parseDouble(this.all.getString("red", "")) + Double.parseDouble(this.all.getString("green", "")) + Double.parseDouble(this.all.getString("blue", "")) > Double.parseDouble(this.all.getString("changing point", ""))) {
            getActionBar().setTitle(Html.fromHtml("<font color='#000000'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#000000'>Notes</font>"));
        } else {
            getActionBar().setTitle(Html.fromHtml("<font color='#FFFFFF'>Notebook Pro</font>"));
            getActionBar().setSubtitle(Html.fromHtml("<font color='#FFFFFF'>Notes</font>"));
        }
        _loadnotes();
        _set_font();
    }

    public void onBackPressed() {
        _leave();
    }

    public void onStop() {
        super.onStop();
        if (!this.all.getString("notifications", "").equals("on") && !this.all.getString("notifications", "").equals("")) {
            ((NotificationManager) getSystemService("notification")).cancelAll();
        } else if (this.all.getString("notification_cancel", "").equals("on") || this.all.getString("notification_cancel", "").equals("")) {
            ((NotificationManager) getSystemService("notification")).cancelAll();
            RemoteViews remoteViews = new RemoteViews(getPackageName(), C0089R.layout.custom_notification);
            Notification.Builder builder = new Notification.Builder(this);
            builder.setSmallIcon(C0089R.drawable.app_icon);
            builder.setContent(remoteViews);
            builder.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), MenuActivity.class), 268435456)).setAutoCancel(true);
            ((NotificationManager) getSystemService("notification")).notify(1, builder.build());
        } else {
            ((NotificationManager) getSystemService("notification")).cancelAll();
            RemoteViews remoteViews2 = new RemoteViews(getPackageName(), C0089R.layout.custom_notification);
            Notification.Builder builder2 = new Notification.Builder(this);
            builder2.setSmallIcon(C0089R.drawable.app_icon);
            builder2.setContent(remoteViews2);
            builder2.setContentIntent(PendingIntent.getActivity(getApplicationContext(), 0, new Intent(getApplicationContext(), MenuActivity.class), 268435456)).setAutoCancel(false);
            builder2.setOngoing(true);
            ((NotificationManager) getSystemService("notification")).notify(2, builder2.build());
        }
        this.round = 1.0d;
        for (int i = 0; i < ((int) this.total_notes); i++) {
            if (this.all.getString("locked".concat(String.valueOf((long) this.round)), "").equals("")) {
                this.all.edit().putString("locked".concat(String.valueOf((long) this.round)), "").commit();
            } else {
                this.all.edit().putString("locked".concat(String.valueOf((long) this.round)), "true").commit();
            }
            this.round += 1.0d;
        }
    }

    /* access modifiers changed from: private */
    public void _deleteblock() {
        this.bsbs.setTitle("Delete");
        this.bsbs.setMessage("Do you really want to delete the note?");
        this.bsbs.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MenuActivity.this.round = MenuActivity.this.pos;
                for (int i2 = 0; i2 < ((int) (MenuActivity.this.total_notes - (MenuActivity.this.pos - 4.0d))); i2++) {
                    MenuActivity.this.note.edit().putString("title".concat(String.valueOf((long) MenuActivity.this.round)), MenuActivity.this.note.getString("title".concat(String.valueOf((long) (MenuActivity.this.round + 1.0d))), "")).commit();
                    MenuActivity.this.note.edit().putString("message".concat(String.valueOf((long) MenuActivity.this.round)), MenuActivity.this.note.getString("message".concat(String.valueOf((long) (MenuActivity.this.round + 1.0d))), "")).commit();
                    MenuActivity.this.note.edit().putString("date".concat(String.valueOf((long) MenuActivity.this.round)), MenuActivity.this.note.getString("date".concat(String.valueOf((long) (MenuActivity.this.round + 1.0d))), "")).commit();
                    MenuActivity.this.all.edit().putString("lock".concat(String.valueOf((long) MenuActivity.this.round)), MenuActivity.this.all.getString("lock".concat(String.valueOf((long) (MenuActivity.this.round + 1.0d))), "")).commit();
                    MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.round)), MenuActivity.this.all.getString("locked".concat(String.valueOf((long) (MenuActivity.this.round + 1.0d))), "")).commit();
                    MenuActivity menuActivity = MenuActivity.this;
                    menuActivity.round = menuActivity.round + 1.0d;
                }
                MenuActivity menuActivity2 = MenuActivity.this;
                menuActivity2.total_notes = menuActivity2.total_notes - 1.0d;
                MenuActivity.this.total.edit().putString("total", String.valueOf((long) MenuActivity.this.total_notes)).commit();
                MenuActivity.this.note_number = Double.parseDouble(MenuActivity.this.total.getString("total", ""));
                MenuActivity.this.note_window.setVisibility(8);
                MenuActivity.this.allnotes_window.setVisibility(0);
                MenuActivity.this.fab_linear.setVisibility(4);
                MenuActivity.this.stt.setVisibility(8);
                MenuActivity.this.showMessage("Note deleted!");
                MenuActivity.this.notewindow_open = false;
                MenuActivity.this._loadnotes();
            }
        });
        this.bsbs.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        this.bsbs.create().show();
    }

    /* access modifiers changed from: private */
    public void _loadnotes() {
        this.notes.clear();
        this.round = 1.0d;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < ((int) this.total_notes)) {
                HashMap hashMap = new HashMap();
                hashMap.put("note", this.note.getString("title".concat(String.valueOf((long) this.round)), ""));
                this.notes.add(hashMap);
                this.notes.get(((int) this.round) - 1).put("number", String.valueOf((long) this.round));
                this.notes.get(((int) this.round) - 1).put("datetime", this.note.getString("date".concat(String.valueOf((long) this.round)), ""));
                this.round += 1.0d;
                this.all_notes.setAdapter(new All_notesAdapter(this.notes));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public void _loadsymbols() {
        if (this.symbol == 1.0d) {
            this.delete.setVisibility(0);
            this.save.setVisibility(8);
            this.edit.setVisibility(0);
        }
        if (this.symbol == 2.0d) {
            this.delete.setVisibility(8);
            this.save.setVisibility(0);
            this.edit.setVisibility(8);
        }
        if (this.symbol == 3.0d) {
            this.delete.setVisibility(0);
            this.save.setVisibility(0);
            this.edit.setVisibility(8);
        }
        if (this.symbol == 4.0d) {
            this.delete.setVisibility(0);
            this.save.setVisibility(8);
            this.edit.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public void _savenote() {
        if (this.title.getText().toString().equals("")) {
            showMessage("Title required!");
            return;
        }
        if (this.special) {
            this.note.edit().putString("title".concat(String.valueOf((long) this.note_number)), this.title.getText().toString()).commit();
            this.note.edit().putString("message".concat(String.valueOf((long) this.note_number)), this.note_message.getText().toString()).commit();
            this.f5js = Calendar.getInstance();
            this.note.edit().putString("date".concat(String.valueOf((long) this.note_number)), new SimpleDateFormat("E dd.MM.yyyy  HH:mm").format(this.f5js.getTime())).commit();
            showMessage("Note saved!");
            this.title.setText(this.note.getString("title".concat(String.valueOf((long) this.note_number)), ""));
            this.note_message.setText(this.note.getString("message".concat(String.valueOf((long) this.note_number)), ""));
            this.datetimeshow.setText(this.note.getString("date".concat(String.valueOf((long) this.note_number)), ""));
        } else {
            this.note_number += 1.0d;
            this.total_notes += 1.0d;
            this.total.edit().putString("total", String.valueOf((long) this.total_notes)).commit();
            this.note.edit().putString("title".concat(String.valueOf((long) this.note_number)), this.title.getText().toString()).commit();
            this.note.edit().putString("message".concat(String.valueOf((long) this.note_number)), this.note_message.getText().toString()).commit();
            this.f5js = Calendar.getInstance();
            this.note.edit().putString("date".concat(String.valueOf((long) this.note_number)), new SimpleDateFormat("E dd.MM.yyyy  HH:mm").format(this.f5js.getTime())).commit();
            showMessage("Note saved!");
            this.datetimeshow.setText(this.note.getString("date".concat(String.valueOf((long) this.note_number)), ""));
            HashMap hashMap = new HashMap();
            hashMap.put("note", this.note.getString("title".concat(String.valueOf((long) this.note_number)), ""));
            this.notes.add(hashMap);
            this.notes.get(((int) this.note_number) - 1).put("number", String.valueOf((long) this.note_number));
            this.notes.get(((int) this.note_number) - 1).put("datetime", this.note.getString("date".concat(String.valueOf((long) this.note_number)), ""));
            this.note_number = Double.parseDouble(this.total.getString("total", ""));
        }
        this.all_notes.setAdapter(new All_notesAdapter(this.notes));
        this.title.setEnabled(false);
        this.note_message.setEnabled(false);
        this.special = false;
        this.editing = false;
        this.symbol = 4.0d;
        _loadsymbols();
    }

    private void _set_font() {
        if (this.all.getString("font", "").equals("")) {
            this.title.setTypeface(Typeface.DEFAULT, 1);
            this.note_message.setTypeface(Typeface.DEFAULT);
        }
        if (this.all.getString("font", "").equals("default")) {
            this.title.setTypeface(Typeface.DEFAULT, 1);
            this.note_message.setTypeface(Typeface.DEFAULT);
        }
        if (this.all.getString("font", "").equals("monospace")) {
            this.title.setTypeface(Typeface.MONOSPACE, 1);
            this.note_message.setTypeface(Typeface.MONOSPACE);
        }
        if (this.all.getString("font", "").equals("sserif")) {
            this.title.setTypeface(Typeface.SANS_SERIF, 1);
            this.note_message.setTypeface(Typeface.SANS_SERIF);
        }
        if (this.all.getString("font", "").equals("serif")) {
            this.title.setTypeface(Typeface.SERIF, 1);
            this.note_message.setTypeface(Typeface.SERIF);
        }
    }

    /* access modifiers changed from: private */
    public void _locker() {
        if (this.all.getString("locked".concat(String.valueOf((long) this.note_number)), "").equals("true")) {
            this.note_window.setBackgroundColor(-16777216);
            this.functionsbox.setBackgroundColor(-16777216);
            this.locked.setImageResource(C0089R.drawable.ic_lock_outline_black);
            this.note_message.setVisibility(8);
            this.lock.setCancelable(false);
            this.lock.setTitle("Lock");
            this.lock.setMessage("Enter password to open note!");
            final EditText editText = new EditText(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            editText.setHint("Enter password!");
            editText.setLayoutParams(layoutParams);
            this.lock.setView(editText);
            this.lock.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MenuActivity.this.password_lock = editText.getText().toString();
                    if (MenuActivity.this.password_lock.equals(MenuActivity.this.all.getString("lock".concat(String.valueOf((long) MenuActivity.this.note_number)), ""))) {
                        MenuActivity.this.note_message.setVisibility(0);
                        MenuActivity.this.note_window.setBackgroundColor(-1);
                        MenuActivity.this.functionsbox.setBackgroundColor(-1);
                        MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "false").commit();
                        return;
                    }
                    MenuActivity.this.showMessage("Wrong password!");
                    MenuActivity.this._leave();
                }
            });
            this.lock.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MenuActivity.this._leave();
                }
            });
            this.lock.create().show();
        } else if (this.all.getString("locked".concat(String.valueOf((long) this.note_number)), "").equals("false")) {
            this.locked.setImageResource(C0089R.drawable.ic_lock_outline_black);
            this.bsbs.setTitle("Lock");
            this.bsbs.setMessage("Do you want to change code of this note?");
            this.bsbs.setPositiveButton("Yes change the code", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MenuActivity.this.lock.setTitle("Lock");
                    MenuActivity.this.lock.setMessage("Enter password to be changed to!");
                    final EditText editText = new EditText(MenuActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    editText.setHint("Enter password!");
                    editText.setLayoutParams(layoutParams);
                    MenuActivity.this.lock.setView(editText);
                    MenuActivity.this.lock.setPositiveButton("Set password", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.password_lock = editText.getText().toString();
                            MenuActivity.this.showMessage(MenuActivity.this.password_lock.concat(" set as new password!"));
                            MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "true").commit();
                            MenuActivity.this.all.edit().putString("lock".concat(String.valueOf((long) MenuActivity.this.note_number)), MenuActivity.this.password_lock).commit();
                            MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_outline_black);
                        }
                    });
                    MenuActivity.this.lock.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_open_black);
                        }
                    });
                    MenuActivity.this.lock.setNeutralButton("Remove password", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "").commit();
                            MenuActivity.this.note_message.setVisibility(0);
                            MenuActivity.this.note_window.setBackgroundColor(-1);
                            MenuActivity.this.functionsbox.setBackgroundColor(-1);
                            MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_open_black);
                        }
                    });
                    MenuActivity.this.lock.create().show();
                }
            });
            this.bsbs.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.bsbs.create().show();
        } else {
            this.locked.setImageResource(C0089R.drawable.ic_lock_open_black);
            this.bsbs.setTitle("Lock");
            this.bsbs.setMessage("Do you want to lock this note?");
            this.bsbs.setPositiveButton("Yes lock the note", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    MenuActivity.this.lock.setTitle("Lock");
                    MenuActivity.this.lock.setMessage("Enter password to lock this note!");
                    final EditText editText = new EditText(MenuActivity.this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
                    editText.setHint("Enter password!");
                    editText.setLayoutParams(layoutParams);
                    MenuActivity.this.lock.setView(editText);
                    MenuActivity.this.lock.setPositiveButton("Set password", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.password_lock = editText.getText().toString();
                            MenuActivity.this.showMessage(MenuActivity.this.password_lock.concat(" set as new password!"));
                            MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.note_number)), "true").commit();
                            MenuActivity.this.all.edit().putString("lock".concat(String.valueOf((long) MenuActivity.this.note_number)), MenuActivity.this.password_lock).commit();
                            MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_outline_black);
                        }
                    });
                    MenuActivity.this.lock.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            MenuActivity.this.locked.setImageResource(C0089R.drawable.ic_lock_open_black);
                        }
                    });
                    MenuActivity.this.lock.create().show();
                }
            });
            this.bsbs.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.bsbs.create().show();
        }
    }

    /* access modifiers changed from: private */
    public void _speech() {
        Intent intent = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "free_form");
        intent.putExtra("android.speech.extra.LANGUAGE", Locale.getDefault());
        intent.putExtra("android.speech.extra.PROMPT", "Say something");
        try {
            startActivityForResult(intent, 100);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(getApplicationContext(), "Your device doesn't support speech input", 0).show();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 100:
                if (i2 == -1 && intent != null) {
                    this.stttext = intent.getStringArrayListExtra("android.speech.extra.RESULTS").get(0);
                    break;
                }
        }
        this.sttdialog.setTitle("SpeechToText");
        this.sttdialog.setMessage("This is the text recognized:\n\n".concat(this.stttext.concat("\n\nDo you want to add it to your note?")));
        this.sttdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MenuActivity.this.note_message.setText(MenuActivity.this.note_message.getText().toString().concat(" ".concat(MenuActivity.this.stttext)));
                MenuActivity.this.note_window.fullScroll(130);
            }
        });
        this.sttdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                MenuActivity.this.stttext = "";
            }
        });
        this.sttdialog.create().show();
    }

    private void _createcontextmenu() {
        registerForContextMenu(this.all_notes);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        super.onCreateContextMenu(contextMenu, view, contextMenuInfo);
        contextMenu.setHeaderTitle("What do you want to do?");
        contextMenu.add(0, view.getId(), 0, "Delete");
        contextMenu.add(0, view.getId(), 0, "Share");
        contextMenu.add(0, view.getId(), 0, "Set position");
        contextMenu.add(0, view.getId(), 0, "Clone");
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        if (menuItem.getTitle() == "Delete") {
            _deleteblock();
            return true;
        } else if (menuItem.getTitle() == "Share") {
            if (this.all.getString("locked".concat(String.valueOf((long) this.pos)), "").equals("true")) {
                showMessage("First unlock the note!");
                return true;
            }
            this.texttoshare = this.note.getString("title".concat(String.valueOf((long) this.pos)), "").concat("\n\n".concat(this.note.getString("message".concat(String.valueOf((long) this.pos)), "")));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", this.f3b);
            intent.putExtra("android.intent.extra.TEXT", this.texttoshare);
            startActivity(Intent.createChooser(intent, "Share using"));
            return true;
        } else if (menuItem.getTitle() == "Set position") {
            this.position.setTitle("Set Position");
            this.position.setMessage("Enter the number where you want the note to be shown! Lowest number is \"1\". Biggest number is \"".concat(String.valueOf((long) this.total_notes).concat("\".\n\nCurrent position: \"").concat(String.valueOf((long) this.pos).concat("\""))));
            final EditText editText = new EditText(this);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            editText.setHint("Enter position!");
            editText.setLayoutParams(layoutParams);
            this.position.setView(editText);
            this.position.setPositiveButton("Set position", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    double parseDouble = Double.parseDouble(new StringBuilder().append(editText.getText()).toString());
                    MenuActivity.this.all.edit().remove("extrastitle").commit();
                    MenuActivity.this.all.edit().remove("extrasmessage").commit();
                    if (parseDouble > 0.0d && parseDouble < MenuActivity.this.total_notes + 1.0d) {
                        MenuActivity.this.showMessage(String.valueOf((long) parseDouble).concat(" set as position!"));
                        MenuActivity.this.all.edit().putString("extrastitle", MenuActivity.this.note.getString("title".concat(String.valueOf((long) parseDouble)), "")).commit();
                        MenuActivity.this.all.edit().putString("extrasmessage", MenuActivity.this.note.getString("message".concat(String.valueOf((long) parseDouble)), "")).commit();
                        MenuActivity.this.all.edit().putString("extrasdate", MenuActivity.this.note.getString("date".concat(String.valueOf((long) parseDouble)), "")).commit();
                        MenuActivity.this.note.edit().putString("title".concat(String.valueOf((long) parseDouble)), MenuActivity.this.note.getString("title".concat(String.valueOf((long) MenuActivity.this.pos)), "")).commit();
                        MenuActivity.this.note.edit().putString("message".concat(String.valueOf((long) parseDouble)), MenuActivity.this.note.getString("message".concat(String.valueOf((long) MenuActivity.this.pos)), "")).commit();
                        MenuActivity.this.note.edit().putString("date".concat(String.valueOf((long) parseDouble)), MenuActivity.this.note.getString("date".concat(String.valueOf((long) MenuActivity.this.pos)), "")).commit();
                        MenuActivity.this.note.edit().putString("title".concat(String.valueOf((long) MenuActivity.this.pos)), MenuActivity.this.all.getString("extrastitle", "")).commit();
                        MenuActivity.this.note.edit().putString("message".concat(String.valueOf((long) MenuActivity.this.pos)), MenuActivity.this.all.getString("extrasmessage", "")).commit();
                        MenuActivity.this.note.edit().putString("date".concat(String.valueOf((long) MenuActivity.this.pos)), MenuActivity.this.all.getString("extrasdate", "")).commit();
                        MenuActivity.this._loadnotes();
                        if (MenuActivity.this.all.getString("locked".concat(String.valueOf((long) MenuActivity.this.pos)), "").equals("true")) {
                            MenuActivity.this.all.edit().putString("extralocked", MenuActivity.this.all.getString("locked".concat(String.valueOf((long) parseDouble)), "")).commit();
                            MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) parseDouble)), "true").commit();
                            MenuActivity.this.all.edit().putString("locked".concat(String.valueOf((long) MenuActivity.this.pos)), MenuActivity.this.all.getString("extralocked", "")).commit();
                            MenuActivity.this.all.edit().putString("extralock", MenuActivity.this.all.getString("lock".concat(String.valueOf((long) parseDouble)), "")).commit();
                            MenuActivity.this.all.edit().putString("lock".concat(String.valueOf((long) parseDouble)), MenuActivity.this.all.getString("lock".concat(String.valueOf((long) MenuActivity.this.pos)), "")).commit();
                            MenuActivity.this.all.edit().putString("lock".concat(String.valueOf((long) MenuActivity.this.pos)), MenuActivity.this.all.getString("extralock", "")).commit();
                        }
                    } else if (parseDouble <= 0.0d) {
                        MenuActivity.this.showMessage("Number too small! Insert a number bigger than one!");
                    } else if (parseDouble >= MenuActivity.this.total_notes + 1.0d) {
                        MenuActivity.this.showMessage("Number too big! Biggest number is ".concat(String.valueOf((long) MenuActivity.this.total_notes).concat("!")));
                    }
                }
            });
            this.position.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            this.position.create().show();
            return true;
        } else if (menuItem.getTitle() != "Clone") {
            return true;
        } else {
            if (this.all.getString("locked".concat(String.valueOf((long) this.pos)), "").equals("true")) {
                showMessage("First unlock the note!");
                return true;
            }
            this.note_number = Double.parseDouble(this.total.getString("total", ""));
            this.note_number += 1.0d;
            this.total_notes += 1.0d;
            this.total.edit().putString("total", String.valueOf((long) this.total_notes)).commit();
            this.note.edit().putString("title".concat(String.valueOf((long) this.note_number)), this.note.getString("title".concat(String.valueOf((long) this.pos)), "")).commit();
            this.note.edit().putString("message".concat(String.valueOf((long) this.note_number)), this.note.getString("message".concat(String.valueOf((long) this.pos)), "")).commit();
            this.f5js = Calendar.getInstance();
            this.note.edit().putString("date".concat(String.valueOf((long) this.note_number)), new SimpleDateFormat("E dd.MM.yyyy  HH:mm").format(this.f5js.getTime())).commit();
            showMessage("Note cloned!");
            HashMap hashMap = new HashMap();
            hashMap.put("note", this.note.getString("title".concat(String.valueOf((long) this.note_number)), ""));
            this.notes.add(hashMap);
            this.notes.get(((int) this.note_number) - 1).put("number", String.valueOf((long) this.note_number));
            this.notes.get(((int) this.note_number) - 1).put("datetime", this.note.getString("date".concat(String.valueOf((long) this.note_number)), ""));
            _loadnotes();
            this.f7sj = new TimerTask() {
                public void run() {
                    MenuActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            MenuActivity.this.all_notes.setSelection(MenuActivity.this.notes.size());
                        }
                    });
                }
            };
            this._timer.schedule(this.f7sj, 0);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public void _leave() {
        if (this.notewindow_open) {
            this.linear27.setBackgroundColor(-16731905);
            this.functionsbox.setBackgroundColor(-1);
            this.note_window.setBackgroundColor(-1);
            if (this.editing) {
                this.bsbs.setTitle("Exit?");
                this.bsbs.setMessage("Do you really want to leave? You will lose all changes!");
                this.bsbs.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MenuActivity.this.allnotes_window.setVisibility(0);
                        MenuActivity.this.note_window.setVisibility(8);
                        MenuActivity.this.add.setEnabled(true);
                        MenuActivity.this.go_up.setEnabled(false);
                        MenuActivity.this.go_down.setEnabled(false);
                        MenuActivity.this.notewindow_open = false;
                        MenuActivity.this.editing = false;
                        MenuActivity.this._loadnotes();
                        MenuActivity.this.note_window.fullScroll(33);
                        MenuActivity.this.fab_linear.setVisibility(4);
                        MenuActivity.this.visible = false;
                        MenuActivity.this.readout.setVisibility(4);
                        MenuActivity.this.go_up.setVisibility(4);
                        MenuActivity.this.go_down.setVisibility(4);
                        MenuActivity.this.locked.setVisibility(4);
                        MenuActivity.this.share.setVisibility(4);
                    }
                });
                this.bsbs.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                this.bsbs.create().show();
            } else {
                this.allnotes_window.setVisibility(0);
                this.note_window.setVisibility(8);
                this.add.setEnabled(true);
                this.go_up.setEnabled(false);
                this.go_down.setEnabled(false);
                this.notewindow_open = false;
                this.editing = false;
                _loadnotes();
                this.note_window.fullScroll(33);
                this.fab_linear.setVisibility(4);
                this.visible = false;
                this.readout.setVisibility(4);
                this.go_up.setVisibility(4);
                this.go_down.setVisibility(4);
                this.locked.setVisibility(4);
                this.share.setVisibility(4);
            }
            if (this.all.getString("locked".concat(String.valueOf((long) this.note_number)), "").equals("")) {
                this.all.edit().putString("locked".concat(String.valueOf((long) this.note_number)), "").commit();
            } else {
                this.all.edit().putString("locked".concat(String.valueOf((long) this.note_number)), "true").commit();
            }
            this.fab.setRotation(0.0f);
        } else if (this.pressed) {
            Intent intent = new Intent("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            intent.setFlags(268435456);
            startActivity(intent);
        } else {
            showMessage("Press again to exit!");
            this.pressed = true;
            this.f7sj = new TimerTask() {
                public void run() {
                    MenuActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            MenuActivity.this.pressed = false;
                        }
                    });
                }
            };
            this._timer.schedule(this.f7sj, 1000);
        }
    }

    public class All_notesAdapter extends BaseAdapter {
        ArrayList<HashMap<String, String>> _data;

        public All_notesAdapter(ArrayList<HashMap<String, String>> arrayList) {
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
            LayoutInflater layoutInflater = (LayoutInflater) MenuActivity.this.getBaseContext().getSystemService("layout_inflater");
            if (view == null) {
                view = layoutInflater.inflate(C0089R.layout.customnote, (ViewGroup) null);
            }
            TextView textView = (TextView) view.findViewById(C0089R.C0090id.number);
            TextView textView2 = (TextView) view.findViewById(C0089R.C0090id.title);
            LinearLayout linearLayout = (LinearLayout) view.findViewById(C0089R.C0090id.linear2);
            TextView textView3 = (TextView) view.findViewById(C0089R.C0090id.date);
            ((LinearLayout) view.findViewById(C0089R.C0090id.linear1)).setBackgroundColor(-1);
            textView2.setText((CharSequence) ((HashMap) MenuActivity.this.notes.get(i)).get("note"));
            textView.setText(((String) ((HashMap) MenuActivity.this.notes.get(i)).get("note")).substring(0, 1).toUpperCase());
            textView3.setText(((String) ((HashMap) MenuActivity.this.notes.get(i)).get("datetime")).substring(0, 12));
            if (Double.parseDouble(MenuActivity.this.all.getString("red", "")) + Double.parseDouble(MenuActivity.this.all.getString("green", "")) + Double.parseDouble(MenuActivity.this.all.getString("blue", "")) > 400.0d) {
                textView.setTextColor(-16777216);
            } else {
                textView.setTextColor(-1);
            }
            if (MenuActivity.this.all.getString("font", "").equals("")) {
                textView2.setTypeface(Typeface.DEFAULT);
                textView.setTypeface(Typeface.DEFAULT, 1);
                textView3.setTypeface(Typeface.DEFAULT);
            }
            if (MenuActivity.this.all.getString("font", "").equals("default")) {
                textView2.setTypeface(Typeface.DEFAULT);
                textView.setTypeface(Typeface.DEFAULT, 1);
                textView3.setTypeface(Typeface.DEFAULT);
            }
            if (MenuActivity.this.all.getString("font", "").equals("monospace")) {
                textView2.setTypeface(Typeface.MONOSPACE);
                textView.setTypeface(Typeface.MONOSPACE, 1);
                textView3.setTypeface(Typeface.MONOSPACE);
            }
            if (MenuActivity.this.all.getString("font", "").equals("sserif")) {
                textView2.setTypeface(Typeface.SANS_SERIF);
                textView.setTypeface(Typeface.SANS_SERIF, 1);
                textView3.setTypeface(Typeface.SANS_SERIF);
            }
            if (MenuActivity.this.all.getString("font", "").equals("serif")) {
                textView2.setTypeface(Typeface.SERIF);
                textView.setTypeface(Typeface.SERIF, 1);
                textView3.setTypeface(Typeface.SERIF);
            }
            textView.setBackgroundColor(Color.parseColor(MenuActivity.this.themecolor));
            textView2.setTextSize((float) MenuActivity.this.tfs);
            textView.setTextSize(((float) MenuActivity.this.tfs) + 7.0f);
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
