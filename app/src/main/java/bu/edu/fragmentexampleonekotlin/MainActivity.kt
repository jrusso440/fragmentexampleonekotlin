package bu.edu.fragmentexampleonekotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var tv1 = findViewById<TextView>(R.id.fr1)
        var tv2 = findViewById<TextView>(R.id.fr2)
        tv1.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addFragment(FragmentOne(), false, "one")
            }
        })
        tv2.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                addFragment(FragmentTwo(), false, "two")
            }
        })
    }

    fun addFragment(fragment: Fragment?, addToBackStack: Boolean, tag: String?) {
        val manager: FragmentManager = getSupportFragmentManager()
        val ft: FragmentTransaction = manager.beginTransaction()
        if (addToBackStack) {
            ft.addToBackStack(tag)
        }
        if (fragment != null) {
            ft.replace(R.id.frame_container, fragment, tag)
        }
        ft.commitAllowingStateLoss()
    }
}

private fun TextView.setOnClickListener() {

}
