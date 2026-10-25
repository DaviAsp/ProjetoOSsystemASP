package com.example.projetoossystemasp;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private Button btHome, btChamados, btContato;
    private Fragment homeFragment,chamadosFragment,contatoFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btHome=findViewById(R.id.btHome);
        btChamados=findViewById(R.id.btChamados);
        btContato=findViewById(R.id.btContato);

        // instanciar os fragmentos
        homeFragment=new HomeFragment();
        chamadosFragment=new ChamadosFragment();
        contatoFragment=new ContatoFragment();

        fragmentManager = getSupportFragmentManager();
        //adicionando o primeiro fragmento
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout,new HomeFragment());
        fragmentTransaction.commit();

        btHome.setOnClickListener(e->{trocarFragment(homeFragment);});
        btChamados.setOnClickListener(e->{trocarFragment(chamadosFragment);});
        btContato.setOnClickListener(e->{trocarFragment(contatoFragment);});

    }


    private void trocarFragment(Fragment novoFragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,novoFragment);
        fragmentTransaction.commit();
    }
}