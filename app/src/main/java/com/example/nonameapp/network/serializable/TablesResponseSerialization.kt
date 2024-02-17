import com.example.nonameapp.network.UUIDSerializer
import com.example.nonameapp.ui.reservation.components.TableUIModel
import kotlinx.serialization.Serializable
import java.util.UUID

@Serializable
data class TablesResponseSerialization(
    val id: @Serializable(with = UUIDSerializer::class) UUID,
    val restaurant_id: @Serializable(with = UUIDSerializer::class) UUID,
    val is_free: Boolean,
    val x: Int,
    val y: Int,
    val width_tiles: Int,
    val height_tiles: Int
){
    fun convertToTableUIModel() = TableUIModel(
        id = id,
        isFree = is_free,
        x = x,
        y = y,
        widthTiles = width_tiles,
        heightTiles = height_tiles
    )
}