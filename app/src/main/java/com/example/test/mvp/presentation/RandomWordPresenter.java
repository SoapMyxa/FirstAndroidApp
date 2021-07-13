package com.example.test.mvp.presentation;

import android.widget.Toast;

import com.example.test.mvp.domain.RandomWordModel;
import com.example.test.mvp.domain.RandomWordPrint;
import com.example.test.mvp.domain.mapper.Mapper;
import com.example.test.mvp.domain.mapper.RandomAddWordMapper;
import com.example.test.mvp.domain.mapper.RandomGetWordMapper;
import com.example.test.mvp.entity.ICallback;
import com.example.test.mvp.entity.RandomWordDto;
import com.example.test.realm.Word;

import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import retrofit2.Response;

public class RandomWordPresenter {

    CompositeDisposable disposable = new CompositeDisposable();

    RandomWordActivity view; // ссылка на view
    RandomWordModel randomWordModel; // ссылка на model

    public RandomWordPresenter(RandomWordActivity view, RandomWordModel randomWordModel) {
        this.view = view;
        this.randomWordModel = randomWordModel;
    }

    /**
     * Событие при загрузке случайного слова
     * выводит на экран и сохраняет в БД
     */
    void onLoadRandomWord(){

        // визулизация ожидания ответа API
        view.waitForResponse();

        Mapper<RandomWordDto, RandomWordPrint> mapperForGet = new RandomGetWordMapper();
        Mapper<RandomWordDto, Word> mapperForAdd = new RandomAddWordMapper();

        // callback для ретрофита, который будет вызван после успешного ответа API
        ICallback<List<RandomWordDto>> callback = new ICallback<List<RandomWordDto>>() {

            @Override
            public void onLoad(Response<List<RandomWordDto>> response) {
                // вывести на экран
                view.showRandWord(mapperForGet.map(response.body().get(0)));
                // сохранить в БД
                randomWordModel.add(mapperForAdd.map(response.body().get(0)));
            }

            @Override
            public void onError(Throwable error) {

            }
        };

        // получение и сохранение случайного слова
        randomWordModel.get(callback);

    }

}
