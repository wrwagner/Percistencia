package br.com.wagner.percistencia

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import br.com.wagner.percistencia.listaAdapter.GameAdapter
import br.com.wagner.percistencia.mdoel.Game
import kotlinx.android.synthetic.main.activity_lista.*
import kotlinx.android.synthetic.main.content_lista_games.*

class ListaGameActivity : AppCompatActivity() {

    private var adapter: GameAdapter? = null
    private var games: List<Game> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_game)
        setSupportActionBar(toolbar)
        fab.setOnClickListener { view ->
            val dialog = NovoGameDialog()
            dialog.show(fragmentManager, "CriarJogo")
        }
        mostrarDados();
        rvGames.layoutManager = LinearLayoutManager(this)
        adapter = GameAdapter(games!!)
        rvGames.adapter = adapter
    }
    private fun mostrarDados() {
//of() — indica a activity ou Fragment em que o ViewModel será utilizado
//get() — indica o ViewModel que será utilizado.
                ViewModelProviders.of(this)
                        .get(ListaGameViewModel::class.java)
                        .games
                        .observe(this, Observer<List<Game>> { games ->
                            adapter?.setList(games!!)
                            rvGames.adapter.notifyDataSetChanged()
                        })

    }
}
