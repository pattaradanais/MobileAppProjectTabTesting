package kku.sukruam.pattaradanai.tabtest;



import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    List<bake> bakes = new ArrayList<>();
    int dataSize;
    public bake listBake = new bake();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();


    }

    private void initInstances() {

        prepareData();

        ListAdapter adapter = new ListAdapter(MainActivity.this, listBake);
        listView = (ListView) findViewById(R.id.list_item);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(listViewClickListener);

    }

    private void prepareData() {

        int resId[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4
                , R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8, R.drawable.food9,
                R.drawable.food10, R.drawable.food11, R.drawable.food12, R.drawable.food13, R.drawable.food14
                , R.drawable.food15,  R.drawable.food17, R.drawable.food18, R.drawable.food19,
                R.drawable.food20, R.drawable.food22,};

        String bakegrill[] = {"หมูโสร่ง", "ทอดมันปลากรายข้าวเหนียว", "ซี่โครงหมูสามรส", "ปีกไก่ทอดน้ำแดง",
                "ปีกไก่ทอดตะไคร้", "กุ้งพันอ้อย", "กุ้งพันตะไคร้", "กุ้งกระเบื้อง", "ปีกไก่ยัดไส้",
                "ไข่ลูกเขย", "ยำปลาดุกฟู", "ปลาช่อนลุยสวน", "ไข่เจียวใส่ไข่มดแดง", "ปลากระพงทอดน้ำปลา",
                "ปลาเนื้ออ่อนราดพริก",  "ไก่ทอดกระเทียมพริกไทย", "ไก่ทอดหาดใหญ่", "ปลาหมึกทอดราดพริก",
                "กบทอดกระเทียมพริกไทย", "ปลาราดพริก"};

       /* String description[] = {getString(R.string.menu1), getString(R.string.menu2), getString(R.string.menu3), getString(R.string.menu4)
                , getString(R.string.menu5), getString(R.string.menu6), getString(R.string.menu6), getString(R.string.menu7), getString(R.string.menu8)
                , getString(R.string.menu10), getString(R.string.menu11), getString(R.string.menu12), getString(R.string.menu14), getString(R.string.menu15)
                , getString(R.string.menu17), getString(R.string.menu18), getString(R.string.menu19), getString(R.string.menu19)
                , getString(R.string.menu20), getString(R.string.menu21),};

       */
        dataSize = resId.length;


        Log.d("khem", "dataSize " + resId.length);
        Log.d("khem", "bakegrill" + resId.length);
        Log.d("khem", "description " + resId.length);



        for (int i = 0; i < dataSize; i++) {
            Log.d("khem", " " + i);
            bake bake = new bake(resId[i], bakegrill[i]); //description[i]);
            bakes.add(bake);
        }

        listBake.setBakes(bakes);

        //Log.d("khem",listBake);
    }

    /*************************
     * Listener
     ***************************/

    AdapterView.OnItemClickListener listViewClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Toast.makeText(MainActivity.this, "POSITION:= " + position,
                    Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(MainActivity.this,ShowDetailActivity.class);
            intent.putExtra("resId", listBake.getBakes().get(position).getResId());
            intent.putExtra("breed", listBake.getBakes().get(position).getBakegrill());
            intent.putExtra("desc", listBake.getBakes().get(position).getDescription());

            startActivity(intent);
        }
    };

}

