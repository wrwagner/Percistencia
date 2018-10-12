package br.com.wagner.percistencia.listaAdapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.wagner.percistencia.R
import br.com.wagner.percistencia.mdoel.Game

class GameAdapter(var games: List<Game>) :
        RecyclerView.Adapter<GameAdapter.GameViewHolder>() {
    override fun getItemCount(): Int {
        return games.size
    }
    fun setList(games: List<Game>) {
        this.games = games
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType:
    Int): GameViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_game, parent, false)
        return GameViewHolder(v)
    }
    override fun onBindViewHolder(holder: GameViewHolder, i: Int)
    {
        val game = games[i]
        holder.tvGame.text = game.nome
        holder.tvPlataforma.text = game.plataforma
    }
    class GameViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var tvGame: TextView = v.findViewById(R.id.tvGame)
        var tvPlataforma: TextView =
                v.findViewById(R.id.tvPlataforma)
    }
}