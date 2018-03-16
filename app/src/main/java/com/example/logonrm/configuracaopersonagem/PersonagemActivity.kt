package com.example.logonrm.configuracaopersonagem

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.AdapterView
import android.widget.SeekBar
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_personagem.*

class PersonagemActivity : AppCompatActivity() {

    fun trocaImagem (idImagem: Int){
        ivClasse.setImageDrawable(
                ContextCompat.getDrawable(this,idImagem)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personagem)


        //essa parte é para o valor do SeekBar mudar conforme vc anda pela barra
        sbForca.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                //chamar pelo progresso, pois é uma progressão que o botão faz
                tvForca.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }
        })

        spClasse.onItemSelectedListener =
                (object : AdapterView.OnItemSelectedListener{
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val tipoPersonagem = TipoPersonagemEnum.from(position)
                        when (tipoPersonagem){
                            TipoPersonagemEnum.ANAO -> trocaImagem(R.drawable.anao)
                            TipoPersonagemEnum.ARQUEIRO -> trocaImagem(R.drawable.archer)
                            TipoPersonagemEnum.BARDO -> trocaImagem(R.drawable.bardo)
                            TipoPersonagemEnum.ELFO -> trocaImagem(R.drawable.elfo)
                            TipoPersonagemEnum.GUERREIRO -> trocaImagem(R.drawable.guerreiro)
                            TipoPersonagemEnum.MAGO -> trocaImagem(R.drawable.mago)
                        }
                    }
                })

            // classe Personagem(){ ------> classe
            //      fun andar(){ -----> metódo
            //          ações que acontecem (atributos)
            //      }
            // }



        btCriar.setOnClickListener{

            Toast.makeText(
                    this, "Usuário criado!", Toast.LENGTH_SHORT
            )
                    .show()

        }
    }
}
