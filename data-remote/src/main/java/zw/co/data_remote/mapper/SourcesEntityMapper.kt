package zw.co.data_remote.mapper

import zw.co.data.model.SourceDataModel
import zw.co.data.model.SourcesSuccessDataModel
import zw.co.data_remote.model.SourcesSuccessEntity
import zw.co.data_remote.model.SourceEntity
import javax.inject.Inject

open class SourcesEntityMapper @Inject constructor() :
    Mapper<SourcesSuccessEntity, SourcesSuccessDataModel> {

    override fun mapFromEntity(type: SourcesSuccessEntity): SourcesSuccessDataModel {
        return SourcesSuccessDataModel(
            status = type.status,
            sources = type.sources.map { mapFromEntity(it) }
        )
    }

    private fun mapFromEntity(type: SourceEntity): SourceDataModel {
        return SourceDataModel(
            id = type.id,
            name = type.name,
            description = type.description,
            category = type.category,
            country = type.country,
            language = type.language,
            url = type.url,
        )
    }
}