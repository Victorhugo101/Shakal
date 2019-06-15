package easypark.com.mobiletruck.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.fragments.ListPedidosFragment
import easypark.com.mobiletruck.model.PedidoOverviewDTO
import easypark.com.mobiletruck.model.Token
import easypark.com.mobiletruck.network.PedidoService
import easypark.com.mobiletruck.network.UsuarioService
import easypark.com.mobiletruck.parcelables.ListPedidosOverviewDTO
import easypark.com.mobiletruck.session.SessionManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TruckMainApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        this.loadFragment()
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.main_container, fragment)
        fragmentTransaction.commit()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.session_menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.itLogout -> {
                performLogout()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
    private fun performLogout() {
        SessionManager.instance.session.invalidate()
        val myIntent = Intent(this, LoginActivity::class.java)
        startActivity(myIntent)
    }
    fun loadFragment(){
        val call = PedidoService.newInstance().listarPedidos(SessionManager.instance.session.getId())
        call.enqueue(object : Callback<List<PedidoOverviewDTO>> {
            override fun onResponse(call: Call<List<PedidoOverviewDTO>?>?,
                                    response: Response<List<PedidoOverviewDTO>?>?) {
                var fragment = ListPedidosFragment.newInstance()

                val args = Bundle()
                val lista = ListPedidosOverviewDTO(response!!.body().orEmpty())
                args.putParcelable("pedidos",lista)

                fragment.arguments = args
                replaceFragment(fragment)

            }

            override fun onFailure(call: Call<List<PedidoOverviewDTO>?>?,
                                   t: Throwable?) {
            }


        })
    }

}
