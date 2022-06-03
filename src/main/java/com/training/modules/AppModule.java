package com.training.modules;

import com.google.inject.AbstractModule;
import com.training.DAO.AuthorDAO;
import com.training.DAO.AuthorDAOJpaImpl;
import com.training.DAO.BookDAO;
import com.training.DAO.BookDAOJpaImpl;
import com.training.service_layer.ServiceLayer;
import com.training.service_layer.ServiceLayerImpl;

public class AppModule extends AbstractModule {
    @Override
    protected void configure() {
        try {
            bind(ServiceLayer.class).to(ServiceLayerImpl.class);
            bind(AuthorDAO.class).to(AuthorDAOJpaImpl.class);
            bind(BookDAO.class).to(BookDAOJpaImpl.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
