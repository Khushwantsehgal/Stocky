package in.sehgal.stocky;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;


public class MainActivity extends Activity {


    EditText Stock,Company;
    AutoCompleteTextView StockTrader, Bank;
    TextView FinalAmount, CurrencyCode;
    Double StockTradingAt = 73.21, LocalCurrencyExchangeRate=62.55,AmountInLocalCurrency;
    int StockValue;
    DecimalFormat df = new DecimalFormat("#.###");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stock = (EditText) findViewById(R.id.stock_editText);
        FinalAmount = (TextView) findViewById(R.id.FinalAmount_textview);
        Stock.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_UP)) {
                    try {
                        StockValue = Integer.parseInt(Stock.getText().toString());
                        AmountInLocalCurrency = ((double) StockValue * StockTradingAt) * LocalCurrencyExchangeRate;

                        FinalAmount.setText((df.format(AmountInLocalCurrency)).toString());

                    } catch (Exception e) {


                    } finally {
                        Toast.makeText(getBaseContext(), "There was an error in execution", Toast.LENGTH_LONG);
                    }


                }

                return false;
            }
        });

        CurrencyCode = (TextView) findViewById(R.id.CurrencyCode);
        CurrencyCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent(MainActivity.this, MainSecond.class);
                    startActivityForResult(intent, 2);
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    Toast.makeText(getBaseContext(),"Finally Reached", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
        protected void  onActivityResult(int requestCode, int resultCode, Intent data){
            Intent intent=getIntent();

            super.onActivityResult(requestCode, resultCode, data);
            if(requestCode==2){
               String message=data.getStringExtra("MESSAGE");
               CurrencyCode.setText(message);
            }
        }


    }


