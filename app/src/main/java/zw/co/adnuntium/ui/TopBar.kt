package zw.co.adnuntium.ui

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import zw.co.adnuntium.R

@Composable
fun TopBar(
){
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },

    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TopBar()
}