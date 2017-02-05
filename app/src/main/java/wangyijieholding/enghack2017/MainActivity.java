package wangyijieholding.enghack2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static int NEW_ALARM_REQUEST_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addAlarmButton = (Button)findViewById(R.id.add_alarm_button);
        addAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createNewAlarm();
            }
        });
    }

    public void createNewAlarm(){
        Intent newAlarmIntent = new Intent(this,AddAlarmActivity.class);
        this.startActivityForResult(newAlarmIntent,NEW_ALARM_REQUEST_CODE);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data){
        //Check the request code
        if (requestCode == NEW_ALARM_REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK){
                onResume();

            }
        }
    }
}
