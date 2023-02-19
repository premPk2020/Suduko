package com.orange.sudoku.ui.theme.activegame

import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.tween
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.orange.sudoku.ui.theme.components.AppToolBar


enum class ActiveGameScreenState {
    LOADING,
    ACTIVE,
    COMPLETE
}

@Composable
fun ActiveGameScreen(
    onEventHandler: (ActiveGameEvent) -> Unit,
    viewModel: ActiveGameViewModel
) {
    val contentTransitionState = remember {
        MutableTransitionState(
            ActiveGameScreenState.LOADING
        )
    }

    viewModel.subContentState = {
        contentTransitionState.targetState = it
    }
    val transition = updateTransition(targetState = contentTransitionState, label = "")
    val loadingAlpha by transition.animateFloat(
        transitionSpec = { tween(300) }, label = ""
    ) {
        if (it.equals(ActiveGameScreenState.LOADING)) 1f else 0f
    }

    val activeAlpha by transition.animateFloat(
        transitionSpec = { tween(300) }, label = ""
    ) {
        if (it.equals(ActiveGameScreenState.ACTIVE)) 1f else 0f
    }

    val completeAlpha by transition.animateFloat(
        transitionSpec = { tween(300) }, label = ""
    ) {
        if (it.equals(ActiveGameScreenState.COMPLETE)) 1f else 0f
    }
    Column(
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxHeight()
    ) {
        AppToolBar(
            modifier = Modifier.wrapContentHeight(),
            title = "Sudoku Puzzle"
        ) {
            NewGameIcon(onEventHandler = onEventHandler)
        }
    }
}

@Composable
fun NewGameIcon(onEventHandler: (ActiveGameEvent) -> Unit) {
    
}