package zw.co.data_cache.mapper

import zw.co.data.model.SourceDataModel
import zw.co.data_cache.model.SourceEntity
import javax.inject.Inject

class SourcesEntityMapper @Inject constructor() : Mapper<SourceEntity, SourceDataModel> {
    override fun mapFromCached(type: SourceEntity) = SourceDataModel(
        id = type.id,
        name = type.name,
        description = type.description,
        category = type.category,
        country = type.country,
        language = type.language,
        url = type.url
    )

    override fun mapToCached(type: SourceDataModel) = SourceEntity(
        id = type.id,
        name = type.name,
        description = type.description,
        category = type.category,
        country = type.country,
        language = type.language,
        url = type.url
    )
}