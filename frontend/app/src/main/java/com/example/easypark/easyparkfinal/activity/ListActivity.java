package com.example.easypark.easyparkfinal.activity;

        import android.app.FragmentManager;
        import android.content.Context;
        import android.content.Intent;
        import android.support.v4.app.FragmentTransaction;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;

        import com.example.easypark.easyparkfinal.R;

        import com.example.easypark.easyparkfinal.beans.PedidoListSerializable;
        import com.example.easypark.easyparkfinal.beans.PedidoListView;
        import com.example.easypark.easyparkfinal.beans.Truck;
        import com.example.easypark.easyparkfinal.beans.TruckListSerializable;
        import com.example.easypark.easyparkfinal.fragments.FoodTruckListFragment;
        import com.example.easypark.easyparkfinal.fragments.ListaPedidosFragments;
        import com.example.easypark.easyparkfinal.network.PedidoService;
        import com.example.easypark.easyparkfinal.network.TruckService;
        import com.example.easypark.easyparkfinal.session.ISession;
        import com.example.easypark.easyparkfinal.session.SessionManager;
        import com.example.easypark.easyparkfinal.utils.MessageBuilder;

        import java.util.List;

        import retrofit2.Call;
        import retrofit2.Callback;
        import retrofit2.Response;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        long mesaId = getIntent().getLongExtra("mesaId",1);
        if(savedInstanceState == null) {
            Call call = TruckService.listarTrcksPerto(mesaId);
            call.enqueue(new Callback<List<Truck>>() {

                @Override
                public void onResponse(Call<List<Truck>> call, Response<List<Truck>> response) {
                    List<Truck> foodTrucks = TruckService.converterParaTruck(response);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("trucks", new TruckListSerializable(foodTrucks));



                    FoodTruckListFragment fragment = new FoodTruckListFragment();
                    fragment.setArguments(bundle);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.main_container, fragment);
                    ft.addToBackStack("ListFragment");
                    ft.commit();

                }

                @Override
                public void onFailure(Call<List<Truck>> call, Throwable t) {

                }
            });
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        //super(outState);
        outState.putBoolean("currentInstance",true);
        super.onSaveInstanceState(outState);
    }
    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount() > 0){

            boolean done = getSupportFragmentManager().popBackStackImmediate();
        }
        else{
            super.onBackPressed();
        }

        /*
        int count = getSupportFragmentManager().getBackStackEntryCount();
        Log.d("Ch",");
        if (count == 0) {
            super.onBackPressed();
            //additional code
        } else {
            getFragmentManager().popBackStack();
        }*/

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.session_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itLogout:
                performLogout();
                return true;
            case R.id.itPedidos:
                listaPedidos();
                return true;
            default:
                return false;
        }
    }

    private void performLogout(){
        SessionManager.getInstance().getSession().invalidate();
        Intent myIntent = new Intent(this, LoginActivity.class);
        startActivity(myIntent);
    }
    private void listaPedidos(){

            Call call = PedidoService.listarMeusPedidos(SessionManager.getInstance().getSession().getId());
            call.enqueue(new Callback<List<PedidoListView>>() {

                @Override
                public void onResponse(Call<List<PedidoListView>> call, Response<List<PedidoListView>> response) {
                    changeFragment(PedidoService.converterParaPedidoListView(response));

                }

                @Override
                public void onFailure(Call<List<PedidoListView>> call, Throwable t) {
                    MessageBuilder.exibirMensagem("Erro ao cadastrar o seu pedido",getApplicationContext());

                }

            });

    }
    public void changeFragment(List<PedidoListView> pedidos){
        Bundle bundle = new Bundle();
        bundle.putSerializable("pedidos", new PedidoListSerializable(pedidos));

        ListaPedidosFragments fragment = new ListaPedidosFragments();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_container,
                fragment).commit();
        getSupportFragmentManager().executePendingTransactions();
    }

}
