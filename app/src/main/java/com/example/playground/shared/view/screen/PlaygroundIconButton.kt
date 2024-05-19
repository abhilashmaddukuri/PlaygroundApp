package com.example.playground.shared.view.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.playground.R
import com.example.playground.shared.view.viewstate.PlaygroundIconButtonViewState

@Composable
fun PlaygroundIconButton(
    modifier: Modifier = Modifier,
    viewState: PlaygroundIconButtonViewState,
) {
    IconButton(
        modifier = modifier,
        enabled = viewState.isEnabled,
        onClick = viewState.onClick
    ) {
        Box{
            Icon(
                modifier = Modifier.alpha(if (viewState.isEnabled) 1f else 0.5f),
                painter = painterResource(id = viewState.icon),
                contentDescription = viewState.contentDescription,
            )
        }
    }
}

@Preview
@Composable
private fun PlaygroundIconButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        PlaygroundIconButton(
            viewState = PlaygroundIconButtonViewState(
                icon = R.drawable.ic_refresh,
                onClick = {}
            )
        )
    }
}