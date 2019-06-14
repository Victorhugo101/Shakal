package easypark.com.mobiletruck.activities


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.fragments.ListPedidosFragment
import easypark.com.mobiletruck.session.SessionManager

class TruckMainApp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(ListPedidosFragment.newInstance())
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

}
