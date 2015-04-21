package in.sehgal.stocky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;
import java.util.Set;

/**
 * Created by khsingh on 4/21/2015.
 */
public class MainSecond extends Activity {

    ListView CurrencySymbol;
    Set<Currency> availableCurrenciesSet;
    List<Currency> availableCurrenciesList;
    ArrayAdapter<Currency> adapter;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_main);
        CurrencySymbol = (ListView) findViewById(R.id.CurrencySymbol_ListView);

        availableCurrenciesSet = Currency.getAvailableCurrencies();
        availableCurrenciesList = new ArrayList<Currency>(availableCurrenciesSet);
        adapter = new ArrayAdapter<Currency>(this,
                android.R.layout.simple_list_item_1,
                availableCurrenciesList);
        CurrencySymbol.setAdapter(adapter);

        CurrencySymbol.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String message =(String) (CurrencySymbol.getItemAtPosition(position));
                Toast.makeText(getApplication(),message,1000).show();
               // String message = CurrencySymbol.getSelectedItem().toString();
                //Intent intent = new Intent(MainSecond.this, MainActivity.class);
                //intent.putExtra("MESSAGE", message);
                //setResult(2, intent);
                //finish();

            }


        });


    }
}