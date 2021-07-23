package zw.co.data_cache.mapper

interface Mapper<T, V> {

    fun mapFromCached(type: T): V

    fun mapToCached(type: V): T

}