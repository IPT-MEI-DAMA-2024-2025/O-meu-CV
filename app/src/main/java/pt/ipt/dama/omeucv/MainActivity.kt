package pt.ipt.dama.omeucv

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.ScrollView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

/**
 * classe que irá conter o código Kotlin para a 'dinâmica' da app
 */
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

        // ************************************************
        // vamos manter o código autogerado (ver acima) e
        // adicionar o nosso próprio código

        // procurar o objeto 'botão', para lhe atribuir uma ação
        // preciso fazer a 'ponte' entre o ficheiro de código e a interface
        // vamos fazer pela forma mais simples
        findViewById<Button>(R.id.continue_button).setOnClickListener {
            showCV(it)
        }

    }

    /**
     * esconde o botão e mostra o CV do utilizador
     */
    private fun showCV(view: View) {
        // TODO("Not yet implemented")
        // se quiser posso apagar a instrução acima

        /* Algoritmo das tarefas a executar por esta função
         * 1- atribuir à textView do diminutivo (nickname_text) o conteúdo da textbox
         * 2- esconder o botão e a textbox
         * 3- mostrar o CV
         * 4- esconder o teclado
         */

        // 1-
        // o acesso aos objetos da interface é feito por 'ponteiros' que os referenciam
        val auxTxtNickname = findViewById<TextView>(R.id.nickname_text)
        val auxTextboxNickname = findViewById<EditText>(R.id.nickname_textBox)

        // atribuir valor à TextView
        auxTxtNickname.text = auxTextboxNickname.text
        // centrar o conteúdo da TextView
        auxTxtNickname.gravity = Gravity.CENTER


        // 2-
        // procurar o Botão
        val auxNicknameButton = findViewById<Button>(R.id.continue_button)

        // esconder o botão e a Textbox
        auxNicknameButton.visibility = View.GONE
        auxTextboxNickname.visibility = View.GONE

        // 3-
        // procurar a ScrollView
        val auxScrollView = findViewById<ScrollView>(R.id.scrollView)

        // mostrá-la
        auxScrollView.visibility = View.VISIBLE

        // 4- Esconder o teclado
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}