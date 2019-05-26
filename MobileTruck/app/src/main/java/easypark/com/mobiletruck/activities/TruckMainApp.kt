package easypark.com.mobiletruck.activities


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import easypark.com.mobiletruck.R
import easypark.com.mobiletruck.fragments.ListPedidosFragment

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

}
