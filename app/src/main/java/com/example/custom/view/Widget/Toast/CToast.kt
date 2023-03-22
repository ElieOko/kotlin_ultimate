package com.example.custom.view.Widget.Toast

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp


@Composable
fun CToast(msg:String){

}

@Composable
fun CustomToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    val context = LocalContext.current
    val toast = remember { Toast.makeText(context, text, duration) }
    DisposableEffect(toast) {
        toast.show()
        onDispose { toast.cancel() }
    }
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.Black.copy(alpha = 0.75f), RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            style = MaterialTheme.typography.body2
        )
    }
}

