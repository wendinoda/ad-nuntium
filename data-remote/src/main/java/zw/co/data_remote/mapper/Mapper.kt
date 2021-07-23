package zw.co.data_remote.mapper

interface Mapper<in R, out T> {

    fun mapFromEntity(type: R): T
}