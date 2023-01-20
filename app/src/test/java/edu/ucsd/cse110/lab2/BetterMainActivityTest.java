package edu.ucsd.cse110.lab2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.*;

import android.widget.Button;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(RobolectricTestRunner.class)
public class BetterMainActivityTest {
    @Test
    public void test_three_plus_seven_equals_ten(){
        var scenario = ActivityScenario.launch(MainActivity.class);

        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.moveToState(Lifecycle.State.STARTED);

        scenario.onActivity(activity -> {
            Button three = activity.findViewById(R.id.btn_three);
            Button seven = activity.findViewById(R.id.btn_seven);
            Button plus = activity.findViewById(R.id.btn_plus);
            Button equal = activity.findViewById(R.id.btn_equals);

            three.performClick();
            plus.performClick();
            seven.performClick();
            equal.performClick();

            TextView result = activity.findViewById(R.id.display);
            assertEquals(result.getText().toString(), "10");
        });
//        assertEquals(3, 1 + 2);
    }
}