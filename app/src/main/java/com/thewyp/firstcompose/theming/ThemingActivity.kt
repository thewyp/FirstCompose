package com.thewyp.firstcompose.theming

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.ui.ExperimentalComposeUiApi
import com.thewyp.firstcompose.animation.AnimationHome
import com.thewyp.firstcompose.musicknob.BodyMusicKnob

class ThemingActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface {
//                AnimationHome()
                BodyMusicKnob()
            }
        }
    }
}