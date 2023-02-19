package com.orange.sudoku.ui.theme.activegame.buildlogic

import android.content.Context
import com.orange.sudoku.common.ProductionDispatcherProvider
import com.orange.sudoku.persistence.*
import com.orange.sudoku.persistence.settingDataStore
import com.orange.sudoku.ui.theme.activegame.ActiveGameContainer
import com.orange.sudoku.ui.theme.activegame.ActiveGameLogic
import com.orange.sudoku.ui.theme.activegame.ActiveGameViewModel

internal fun buildActiveGameLogic(
    container: ActiveGameContainer,
    viewModel: ActiveGameViewModel,
    context: Context
):ActiveGameLogic{
    return ActiveGameLogic(
        container,
        viewModel,
        GameRepositoryImpl(
            LocalGameStorageImpl(context.filesDir.path),
            LocalSettingsStorageImpl(context.settingDataStore)
        ),
        LocalStatisticsStorageImpl(
            context.statusDataStore
        ),
        ProductionDispatcherProvider

    )
}