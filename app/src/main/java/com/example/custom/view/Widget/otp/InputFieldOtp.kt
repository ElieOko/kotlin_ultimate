package com.example.custom.view.Widget.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun InputFieldOtp(
    value:TextFieldValue,
    onValueChange:(value: TextFieldValue)->Unit,
    focusRequester: FocusRequester
){
    BasicTextField(
        readOnly = false,
        value = value,
        onValueChange = onValueChange,
        modifier = Modifier
            .padding(horizontal = 2.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.Gray)
            .wrapContentSize()
            .focusRequester(focusRequester),
        maxLines =1,
        decorationBox ={innerTextField ->
            Box(
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ){
                innerTextField()
            }
        },
        cursorBrush= SolidColor(Color.White),
        textStyle= TextStyle(
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,imeAction = ImeAction.Done),
        keyboardActions = KeyboardActions(
            onDone = null
        )

    )
}