package com.example.custom.view.Widget.otp

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

const val CODE_TEMP = "202306"
 val textList = listOf(
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    ),
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    ),
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    ),
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    ),
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    ),
    mutableStateOf(
        TextFieldValue(
            text ="",
            selection = TextRange(0)
        )
    )
)
 val requestList = listOf(
    FocusRequester(),
    FocusRequester(),
    FocusRequester(),
    FocusRequester(),
    FocusRequester(),
    FocusRequester()
)

fun nextFocus(textList:List<MutableState<TextFieldValue>>, requesterList:List<FocusRequester>){
    for(indice in textList.indices){
        if(textList[indice].value.text == ""){
            if(indice < textList.size){
                requesterList[indice].requestFocus()
                break
            }
        }
    }
}

fun assemblageCode(textList: List<MutableState<TextFieldValue>>, onVerify:(status:Boolean)->Unit){
    var code :String = ""
    for (i in textList.indices){
        code += textList[i].value.text
    }
    if (code.length == 6){
        verificationCode(code = code, onSuccess = {
            onVerify?.let{
                it(true)
            }
        }, 
        onError = {
            onVerify?.let{
                it(false)
            }
        }
            )
    }
}

fun verificationCode(code:String,onSuccess: () -> Unit,onError:()->Unit){
    if (CODE_TEMP == code){
        onSuccess()
    }
    else{
        onError()
    }
}
