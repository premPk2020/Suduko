package com.orange.sudoku

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.orange.sudoku.common.makeToast
import com.orange.sudoku.ui.theme.SudokuTheme
import com.orange.sudoku.ui.theme.activegame.ActiveGameContainer
import com.orange.sudoku.ui.theme.activegame.ActiveGameEvent
import com.orange.sudoku.ui.theme.activegame.ActiveGameLogic
import com.orange.sudoku.ui.theme.activegame.ActiveGameViewModel

class MainActivity : ComponentActivity(), ActiveGameContainer {
    private lateinit var logic: ActiveGameLogic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ActiveGameViewModel()
        setContent {
            SudokuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ActiveGameScreen(
                        onEventHandler = logic::onEvent,
                        viewModel
                    )
                }
            }
        }
        logic = buildActiveGameLogic(this, viewModel, applicationContext)
    }

    override fun onStart() {
        super.onStart()
        logic.onEvent(ActiveGameEvent.OnStart)
    }

    override fun onStop() {
        super.onStop()
        logic.onEvent(ActiveGameEvent.OnStop)
    }

    override fun showError() {
        makeToast("error")
    }

    override fun onNewGameClick() {
        startActivity(
            Intent(
                this,
                NewGameActivity::class.java
            )
        )
    }
}

