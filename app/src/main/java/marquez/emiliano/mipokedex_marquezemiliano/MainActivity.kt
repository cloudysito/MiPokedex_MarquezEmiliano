package marquez.emiliano.mipokedex_marquezemiliano

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val openDetail = {
            startActivity(Intent(this, DetalleActivity::class.java))
        }

        findViewById<Button>(R.id.btnGengar)?.setOnClickListener { openDetail() }
        findViewById<Button>(R.id.btnMew)?.setOnClickListener { openDetail() }
        findViewById<Button>(R.id.btnMimikyu)?.setOnClickListener { openDetail() }
        findViewById<Button>(R.id.btnJigglypuff)?.setOnClickListener { openDetail() }
    }
}
