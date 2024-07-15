package com.example.movie.navigation

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object MainScreen : BottomNavItem(MAINSCREEN_ROUTE, "메인", android.R.drawable.checkbox_on_background)
    data object ArticleScreen : BottomNavItem(COMMUNITYSCREEN_ROUTE, "게시글", android.R.drawable.ic_dialog_info)
    data object ChatScreen : BottomNavItem(SCREEN3_ROUTE, "채팅", android.R.drawable.ic_dialog_info)
}