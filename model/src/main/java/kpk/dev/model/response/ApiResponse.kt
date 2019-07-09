package kpk.dev.model.response

import retrofit2.Response

sealed class ApiResponse<T> {
    companion object{
        fun <T> create(error: Throwable) = ApiErrorResponse<T>(error.message)
        fun <T> create(response: Response<T>): ApiResponse<T> {
            if(response.isSuccessful) {
                val body = response.body()
                return if(body != null) {
                    ApiSuccessResponse(body)
                }else{
                    ApiEmptyResponse()
                }
            }else{
                val errorMessage = response.errorBody()?.string()
                val message = if (errorMessage.isNullOrEmpty()){
                    response.message()
                }else{
                    errorMessage
                }
                return ApiErrorResponse(message)
            }
        }
    }
}

class ApiEmptyResponse<T>: ApiResponse<T>()

data class ApiErrorResponse<T>(val errorMsg: String?): ApiResponse<T>()

data class ApiSuccessResponse<T>(val body: T): ApiResponse<T>()
