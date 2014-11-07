package com.yo2boy.arduinoledpattern;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
//import android.view.Menu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnCheckedChangeListener {

    //static final int check = 1111;
    int count = 0;
    ToggleButton bToggle;
    Boast b;

    // arr of switches
    private final static Integer[] ids = {R.id.switch1, R.id.switch2,
            R.id.switch3, R.id.switch4, R.id.switch5, R.id.switch6,
            R.id.switch7, R.id.switch8, R.id.switch9, R.id.switch10,
            R.id.switch11, R.id.switch12};


    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
                return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerLedChangeListener(ids);
        addListenerOnButton();
        b = new Boast(new Toast(this));

        b.makeText(this, "Press any switch and see the results!", Toast.LENGTH_LONG).show();

    }

    public void addListenerOnButton() {
        bToggle = (ToggleButton) findViewById(R.id.bToggle);

        bToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bToggle.getText().toString().equals("Turn OFF"))
                    on();
                else if (bToggle.getText().toString().equals("Turn ON"))
                    stop();
                }
        });
    }

    // register all onCheckedChangeListener for all switches
    private void registerLedChangeListener(Integer... ids) {
        for (Integer id : ids) {
            Switch led = (Switch) findViewById(id);
            led.setOnCheckedChangeListener(this);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Switch led;

        if (requestCode == 1 && resultCode == RESULT_OK) {
            ArrayList<String> results = data
                    .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

            Log.d("Input", results.get(0));

            if (results.get(0).equalsIgnoreCase("kriss kross"))
                sendString("0");
            else if (results.get(0).equalsIgnoreCase("random"))
                sendString("1");
            else if (results.get(0).equalsIgnoreCase("binary counter"))
                sendString("2");
            else if (results.get(0).equalsIgnoreCase("bouncing"))
                sendString("3");
            else if (results.get(0).equalsIgnoreCase("scanner"))
                sendString("4");
            else if (results.get(0).equalsIgnoreCase("knight rider"))
                sendString("5");
            else if ((results.get(0).equalsIgnoreCase("stop")) || (results.get(0).equalsIgnoreCase("clear")))
                sendString("Z");
            else if (results.get(0).equalsIgnoreCase("1")) {
                sendString("a");
                led = (Switch) findViewById(ids[0]);
                led.setOnClickListener(null);

                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("2")) {
                sendString("b");
                led = (Switch) findViewById(ids[1]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("3")) {
                sendString("c");
                led = (Switch) findViewById(ids[2]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("4")) {
                sendString("d");
                led = (Switch) findViewById(ids[3]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("5")) {
                sendString("e");
                led = (Switch) findViewById(ids[4]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("6")) {
                sendString("f");
                led = (Switch) findViewById(ids[5]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("7")) {
                sendString("g");
                led = (Switch) findViewById(ids[6]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("att") || results.get(0).equalsIgnoreCase("et") || results.get(0).equalsIgnoreCase("8")) {
                sendString("h");
                results.set(0, "8");
                led = (Switch) findViewById(ids[7]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("9")) {
                sendString("i");
                led = (Switch) findViewById(ids[8]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("10")) {
                sendString("j");
                led = (Switch) findViewById(ids[9]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("11")) {
                sendString("k");
                led = (Switch) findViewById(ids[10]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            } else if (results.get(0).equalsIgnoreCase("12")) {
                sendString("l");
                led = (Switch) findViewById(ids[11]);
                led.setOnClickListener(null);
                led.toggle();

                if(led.isChecked())
                    bToggle.setChecked(true);
                else
                    if(verifyAllOff())
                        bToggle.setChecked(false);

            }
            b.makeText(this, results.get(0), Toast.LENGTH_SHORT).show();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    public void loop(View v) {
        try {
            sendString(count + "");
            switch (count) {
                case 0:
                    b.makeText(this, "Criss Cross", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    b.makeText(this, "Random", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    b.makeText(this, "Binary Counter", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    b.makeText(this, "Bouncing", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    b.makeText(this, "Scanner", Toast.LENGTH_SHORT).show();
                    break;
                case 5:
                    b.makeText(this, "Knight Rider", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
            //loop through all patterns until button is pressed for the 6th time, which then resets back to 0
            count++;
            if (count == 6)
                count = 0;

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void stop() {
        try {
            b.cancel();
            b.makeText(this, "Stopping", Toast.LENGTH_SHORT).show();

            sendString("Z"); // Send "Z" to Arduino which stops the execution
            Switch led;

            //Toggle all enabled switches.
            for (Integer id : ids) {
                led = (Switch) findViewById(id);
                led.setOnClickListener(null);
                if (led.isChecked())
                    led.toggle();
            }
            count = 0;

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void on(){

        b.makeText(this, "Turning all LEDs on.", Toast.LENGTH_SHORT).show();
        Switch led;
        //Toggle all enabled switches.
        for (Integer id : ids) {
            led = (Switch) findViewById(id);
            led.setOnClickListener(null);
            if (!(led.isChecked()))
                led.toggle();
        }
    }

    //Implementing Speech Recognizer
    public void voice(View v) {
        try {
            Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                    RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Your wish is my command");
            startActivityForResult(i, 1);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

	//@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		switch (buttonView.getId()) {
		case R.id.switch1:
			if (isChecked) {
                sendString("a");
                bToggle.setChecked(true);
            }
			else{
				sendString("A");
                verifyAllOff();
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			return;
		case R.id.switch2:
			if (isChecked) {
                sendString("b");
                bToggle.setChecked(true);
            }
			else{
				sendString("B");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch3:
			if (isChecked){
				sendString("c");
            bToggle.setChecked(true);
            }
			else{
				sendString("C");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch4:
			if (isChecked){
				sendString("d");
                bToggle.setChecked(true);
            }
			else{
				sendString("D");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch5:
			if (isChecked){
				sendString("e");
                bToggle.setChecked(true);
            }
			else{
				sendString("E");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch6:
			if (isChecked){
				sendString("f");
                bToggle.setChecked(true);
            }
			else{
				sendString("F");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch7:
			if (isChecked){
				sendString("g");
                bToggle.setChecked(true);
            }
			else{
				sendString("G");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch8:
			if (isChecked){
				sendString("h");
                bToggle.setChecked(true);
            }
			else{
				sendString("H");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch9:
			if (isChecked){
				sendString("i");
                bToggle.setChecked(true);
            }
			else{
				sendString("I");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch10:
			if (isChecked){
				sendString("j");
                bToggle.setChecked(true);
            }
			else{
				sendString("J");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch11:
			if (isChecked){
				sendString("k");
                bToggle.setChecked(true);
            }
			else{
				sendString("K");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		case R.id.switch12:
			if (isChecked){
				sendString("l");
                bToggle.setChecked(true);
            }
			else{
				sendString("L");
                if(verifyAllOff())
                    bToggle.setChecked(false);
            }
			break;
		default:
			break;
		}
	}

    private boolean verifyAllOff() {
        Switch led;
        for (Integer id : ids) {
            led = (Switch) findViewById(id);

            if (led.isChecked()) {
                return false;
            }
        }
        return true;
    }

    // Send to Arduino
	private void sendString(String toSend) {
		Intent i = new Intent("primavera.arduino.intent.action.SEND_DATA");
		i.putExtra("primavera.arduino.intent.extra.DATA", toSend.getBytes());
		sendBroadcast(i);
	}
}