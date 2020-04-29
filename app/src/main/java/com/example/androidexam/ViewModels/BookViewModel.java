package com.example.androidexam.ViewModels;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.androidexam.Model.BookModel;
import com.example.androidexam.Repository.BookRepository;

public class BookViewModel {

    private BookRepository repository;

    public BookViewModel(){
        repository = BookRepository.getInstance();
    }

    LiveData< BookModel > getBook() {
        return repository.getBook();
    }

    public void updateBook(String s) {
        repository.updateBook(s);
    }
}
