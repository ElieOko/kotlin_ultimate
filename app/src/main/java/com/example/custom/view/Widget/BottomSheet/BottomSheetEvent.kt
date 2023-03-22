package com.example.custom.view.Widget.BottomSheet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
@Preview
fun BottomSheetWithAnchor(){

    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)

    val sheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = sheetState
    )
    val scope = rememberCoroutineScope()

    BottomSheetScaffold(
        scaffoldState = sheetScaffoldState,
        sheetElevation = 0.dp,
        sheetBackgroundColor = Color.Transparent,
        sheetPeekHeight = 49.dp,
        sheetContent = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = {
                    scope.launch {
                        if(sheetState.isCollapsed){
                            sheetState.expand()
                        }
                        else if(sheetState.isExpanded){
                            sheetState.collapse()
                        }
                    }
                }) {
                    Icon(imageVector = if(sheetState.isExpanded){
                        Icons.Filled.KeyboardArrowDown
                    }
                    else{
                        Icons.Filled.KeyboardArrowUp
                    },
                        contentDescription = "Icon button")
                }
                BottomSheetContent()
            }
        }) {
//
    }
}