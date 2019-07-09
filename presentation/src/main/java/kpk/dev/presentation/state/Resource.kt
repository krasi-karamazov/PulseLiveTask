package kpk.dev.presentation.state

sealed class Resource<T>(val data: T?, val message: String? = null) {

    companion object{
        fun <T> success(data: T): Resource<T> = Success(data)
        fun <T> loading(data: T?): Resource<T> = Loading(data)
        fun <T> error(message: String?, data: T?): Resource<T> = Error(message, data)
    }

    class Success<T>(data: T): Resource<T>(data)
    class Loading<T>(data: T? = null): Resource<T>(data)
    class Error<T>(message: String?, data: T? = null): Resource<T>(data, message)

}