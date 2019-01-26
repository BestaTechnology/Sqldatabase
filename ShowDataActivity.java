package voice_to_text.sandy148101.com.sqldatabase;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {

    ListView listView;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        listView =(ListView)findViewById(R.id.listViewshowdata_id);
        db= new DatabaseHelper(this);
        Cursor cursor = db.allData();

        if(cursor.getCount()==0){

            Toast.makeText(getApplicationContext(),"Empty database",Toast.LENGTH_SHORT).show();
        }

        ArrayList<String> arrayList = new ArrayList<>();

        while ((cursor.moveToNext())){

            int id = cursor.getInt(0);
            String email = cursor.getString(1);
            String password = cursor.getString(2);

            arrayList.add("Id:" + id +"\n" +"Email"+ email+"\n"+"Password : "+ password+"\n");

           ArrayAdapter<String> adapter = new ArrayAdapter<>(ShowDataActivity.this,android.R.layout.simple_expandable_list_item_1,arrayList);

            listView.setAdapter(adapter);
        }


    }
}
