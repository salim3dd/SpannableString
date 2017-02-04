package salim3dd.com.spannablestring;


import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textview);

        String TXT = "السلام عليكم ورحمة الله وبركاته";

        SpannableString sString = new SpannableString(TXT);

        ClickableSpan  clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.BLUE);
            }
        };

        ClickableSpan  clickableSpan2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Toast.makeText(MainActivity.this, "Clicked_2", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setUnderlineText(false);
                ds.setColor(Color.RED);
            }
        };
        
        sString.setSpan(clickableSpan,0,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        sString.setSpan(clickableSpan2,TXT.length()-7,TXT.length(),Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        textView.append("\n");
        textView.append(sString);
        textView.setMovementMethod(LinkMovementMethod.getInstance());

    }
}
