package com.example.projetoossystemasp;

import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projetoossystemasp.models.OrdemServico;
import com.example.projetoossystemasp.models.Singleton;
import com.example.projetoossystemasp.utils.OrdemServicosAdapter;

public class ListarHistorico extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listarhistorico);
        listView=findViewById(R.id.listView);
        // retirar o ActionBar
      //  getSupportActionBar().hide();


        OrdemServicosAdapter adapter=new OrdemServicosAdapter(this,
                R.layout.item_listview, Singleton.listOSs);
        ViewGroup header=(ViewGroup)getLayoutInflater()
                .inflate(R.layout.header_listview,listView,false);
        //listView.addHeaderView(header);
        listView.setAdapter(adapter);
    }
}