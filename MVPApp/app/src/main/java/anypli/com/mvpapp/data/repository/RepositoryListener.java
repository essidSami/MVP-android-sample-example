package anypli.com.mvpapp.data.repository;

/**
 * Created by macbook on 15/10/2017.
 */

public interface RepositoryListener<T> {

    void onFetchComplete(T data);

    void onFetchFail(FailType type);


    enum FailType {

         NETWORK, SERVER ;
    }
}
