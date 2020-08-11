package com.example.androidexam.ViewModels;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class Visa_ViewModelTest {


    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Before
    public void setUp() throws Exception {
        Visa_ViewModel viewModel = new Visa_ViewModel();



    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getVisa() {
    }
}