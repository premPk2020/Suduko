package com.orange.sudoku.domain

import com.orange.sudoku.domain.Difficulty

data class Settings(
    val difficulty: Difficulty,
    val boundary:Int
)
