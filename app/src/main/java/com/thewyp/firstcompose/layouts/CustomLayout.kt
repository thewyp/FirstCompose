package com.thewyp.firstcompose.layouts

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.Dp

fun Modifier.firstBaselineToTop(
    firstBaselineToTop: Dp
) = this.then(
    layout { measurable, constraints ->

        val placeable = measurable.measure(constraints)

        layout(0,0) {

        }
    }
)