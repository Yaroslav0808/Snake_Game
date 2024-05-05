package yaroslav.snake.domain.navigation

sealed class Screen(val route: String) {
    object Menu : Screen(route = "menu_screen")
    object HighScores : Screen(route = "high_scores_screen")
}
