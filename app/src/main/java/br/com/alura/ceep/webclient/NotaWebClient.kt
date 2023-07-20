package br.com.alura.ceep.webclient

import android.util.Log
import br.com.alura.ceep.model.Nota

private const val TAG = "NotaWebClient"

class NotaWebClient {

  private val notaService = RetrofitInicializador().notaService

  suspend fun buscaTodas(): List<Nota>? {
    return try {
      val notasResposta = notaService.buscaTodas()
      return notasResposta.map { notaResposta ->
        notaResposta.nota
      }
    } catch (e: Exception) {
      Log.e(TAG, "buscaTodas: ", e)
      null
    }
  }
}