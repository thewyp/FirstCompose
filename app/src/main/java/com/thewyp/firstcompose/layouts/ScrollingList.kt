package com.thewyp.firstcompose.layouts

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import kotlinx.coroutines.launch

@Composable
fun ScrollingList() {
    val scrollState = rememberLazyListState()
    val size = 100
    val coroutineScope = rememberCoroutineScope()
    Column {
        Row {
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(0)
                    }
                }
            ) {
                Text("Scroll to top")
            }
            Button(
                modifier = Modifier.weight(1f),
                onClick = {
                    coroutineScope.launch {
                        scrollState.animateScrollToItem(size - 1)
                    }
                }
            ) {
                Text("Scroll to bottom")
            }
        }

        LazyColumn(state = scrollState) {
            items(size) {
                ImageListItem(it)
            }
        }
    }
}

@Composable
fun ImageListItem(index: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(8.dp).fillMaxWidth()
    ) {
        Image(
            painter = rememberImagePainter(
                data = "https://img2.baidu.com/it/u=862704645,1557247143&fm=26&fmt=auto",
                builder = {
                    transformations(CircleCropTransformation())
                }
            ),
            contentDescription = null,
            modifier = Modifier.size(40.dp).clip(CircleShape)
        )
        Text(
            text = "Item #$index",
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}