package com.example.projetoossystemasp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
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

    @SuppressLint("RestrictedApi")
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
      //  ((MenuBuilder)menu).setOptionalIconsVisible(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

            if(item.getItemId() == R.id.itHistorico){

                Intent intent;

                intent = new Intent(this,ListarHistorico.class);
                startActivity(intent);
            }
            else{
                finish();
            }


        return super.onOptionsItemSelected(item);
    }


}