package in.christuniversity.cunavigator;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Calendar;

public class TeacherProfile extends AppCompatActivity {
    private Button date, time,call,message;
    String x = "Hi, Welcome";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_profile);

        date = findViewById(R.id.meet_date);
        time = findViewById(R.id.meet_time);
        call = findViewById(R.id.call_btn);
        message = findViewById(R.id.chat_btn);

        Calendar cal = Calendar.getInstance();

        findViewById(R.id.meet_date)
                .setOnClickListener(view -> {
                            /*DatePickerDialog
                                    .newInstance(null, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE))
                                    .show(getFragmentManager(), null);*/
                            DatePickerDialog dpd = new DatePickerDialog(TeacherProfile.this, (view1, year, month, dayOfMonth) -> {
                                date.setText(String.format("%d", year) + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", dayOfMonth));
                                Toast.makeText(TeacherProfile.this, String.format("%d", year) + "-" + String.format("%02d", month + 1) + "-" + String.format("%02d", dayOfMonth), Toast.LENGTH_SHORT).show();
                            }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE));
                            dpd.show();
                            long now = System.currentTimeMillis() - 1000;
                            dpd.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                            dpd.getDatePicker().setMaxDate(now+(1000*60*60*24*7));


                        }
                );

        findViewById(R.id.meet_time)
                .setOnClickListener(view -> {
                        /*TimePickerDialog
                        .newInstance(null, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true)
                        .show(getFragmentManager(), null);*/
                            TimePickerDialog tpd = new TimePickerDialog(TeacherProfile.this, (view1, hourOfDay, minute) -> {
                                time.setText(String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute));
                                Toast.makeText(TeacherProfile.this, String.format("%02d", hourOfDay) + ":" + String.format("%02d", minute), Toast.LENGTH_SHORT).show();
                            }, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), DateFormat.is24HourFormat(TeacherProfile.this));
                            tpd.show();
                        }
                );

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:9731417095"));
                startActivity(intent);
            }
        });

        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                sendIntent.setData(Uri.parse("sms:"));
//                You can add extras to populate your own message and such like this

                sendIntent.putExtra("sms_body", x);
//                then just startActivity with the intent.

                startActivity(sendIntent);
            }
        });
    }
}