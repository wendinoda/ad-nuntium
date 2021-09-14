package zw.co.adnuntium.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ErrorMessage(
    errorMessage: String,
    errorImage: Int,
){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = errorImage),
            contentDescription = "",
            modifier = Modifier.size(width = 200.dp, height = 200.dp))
        Spacer(modifier = Modifier.size(8.dp))
        Text(text = errorMessage)
        Spacer(modifier = Modifier.size(8.dp))
        Button(
            onClick = {

            }
        ) { Text("Retry")}
    }
}