package br.com.wagner.percistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import br.com.wagner.percistencia.database.BancoDeDados
import br.com.wagner.percistencia.mdoel.Game

class
ListaGameViewModel(application: Application): AndroidViewModel(application) {
    lateinit var games: LiveData<List<Game>>
    private val bd: BancoDeDados =
            BancoDeDados.getDatabase(application.applicationContext)!!
    init{
        carregarDados()
    }
    private fun carregarDados() {
//Carregar os dados da nossa Base de dados e armazenar no LiveData
        games = bd.gameDAO().lerGames()
    }
}